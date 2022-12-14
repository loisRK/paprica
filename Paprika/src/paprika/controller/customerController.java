package paprika.controller;

import java.sql.SQLException;

import paprika.dto.customerDTO;
import paprika.exception.NotExistException;
import paprika.service.customerService;
import paprika.service.productService;
import paprika.service.purchaseService;
import paprika.view.customerEndview;

public class customerController {
	private static customerController instance = new customerController();
	private productService proservice = productService.getInstance();
	private purchaseService purService = purchaseService.getInstance();
	private customerService cusService = customerService.getInstance();
	
	private customerController() {}
	public static customerController getInstance() {
		return instance;
	}
	
//	--------------product (우성)--------------
	// 모든 상품 검색
	public void getAllProduct() {
		try {
			customerEndview.productListView(proservice.getAllProduct());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 이름으로 상품 검색
	public void getProductName(String productName) {
		try {
			customerEndview.productListView(proservice.getProductName(productName));
		} catch (SQLException | NotExistException e) {
			e.printStackTrace();
			customerEndview.showError("상품 조회 중 오류가 발생하였습니다.");
		}
	}
	
	// 카테고리별로 상품 검색
	public void getProductCategory(String productCategory) {
		try {
			customerEndview.productListView(proservice.getProductCategory(productCategory));
		} catch (SQLException | NotExistException e) {
			e.printStackTrace();
			customerEndview.showError("상품 조회 중 오류가 발생하였습니다.");
		}
	}
	
	// 가격으로 상품 검색
	public void getProductPrice(int minPrice, int maxPrice) {
		try {
			customerEndview.productListView(proservice.getProductPrice(minPrice, maxPrice));
		} catch (SQLException | NotExistException e) {
			e.printStackTrace();
			customerEndview.showError("상품 조회 중 오류가 발생하였습니다.");
		}
	}
// -----------------------------------------------------------------------------------------------------

//	--------------purchase (륜경)----------------
	// 모든 구매 내역 확인
	public void getAllPurchase(String cusID) {
		try {
			customerEndview.purchaseListView(purService.getPurchaseHistory("cus_id", cusID));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// 특정 구매 내역 정보 확인 (상태, 배송일, )
	public void getPurchaseInfo(String colName, String colValue) {
		try {
			customerEndview.purchaseListView(purService.getPurchaseHistory(colName, colValue));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 제품 구매
	public void newPurchase(int productID, String customerID, int count) {
		try {
			customerEndview.purchaseCheck(purService.purchaseProduct(productID, customerID, count));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 수정 가능한 내역 보여주기
	public void getEditInfo(String colName, String colValue) {
		try {
			customerEndview.purchaseListView(purService.getEditList(colValue));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// 구매 내역 수정 (order_status : 주문접수 인 경우에만 수정할 수 있는 메소드)
	public void editPurchase(int orderID, int changeCnt) {
		try {
			customerEndview.purchaseCheck(purService.editPurchaseCnt(orderID, changeCnt));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
// -----------------------------------------------------------------------------------------------------

//	------------customer (계진)--------------
	// 비밀번호 변경
		public void updatepassword(String customerId, String customerPassword) {
			try{
				cusService.updatePassword(customerId, customerPassword);
			}catch(SQLException | NotExistException s){
				s.printStackTrace();
				customerEndview.showError("고객 검색시 에러 발생");
			}
		}
		
		// 주소 변경 
		public void updateAddress(String customerId, String customerAddress) {
			try{
				cusService.updateAddress(customerId, customerAddress);
			}catch(SQLException | NotExistException s){
				s.printStackTrace();
				customerEndview.showError("고객 검색시 에러 발생");
			}
		}
		
		// 핸드폰 번호 변경
		public void updatePhone(String customerId, String phoneNumber) {
			try{
				cusService.updatePhonenumber(customerId, phoneNumber);
			}catch(SQLException | NotExistException s){
				s.printStackTrace();
				customerEndview.showError("고객 검색시 에러 발생");
			}
		}

		// 회원 가입
		public void insertCustomer(customerDTO customer) {
			try {
				cusService.addCustomer(customer);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	   // 회원 탈퇴 ----------------계진
	   public void deleteCustomer(String customerId, String customerPW) {
	      try {
	         cusService.deleteCustomer(customerId, customerPW);
	      }catch(SQLException | NotExistException e) {
	    	  e.printStackTrace();
	    	  customerEndview.showError("잘못 입력하셨습니다.");
	      }
	   }
// -----------------------------------------------------------------------------------------------------
	
	
	// [우성] ID유무 확인 ------------------------------------------------------------------
	public boolean checkId(String customerId) {
		return cusService.checkId(customerId);
	}
	//---------------------------------------------------------------------------------
	
	// [우성] ID유무 확인 ------------------------------------------------------------------
	public boolean checkPw(String customerId, String customerPw) {
		return cusService.checkPw(customerId, customerPw);
	}
	//---------------------------------------------------------------------------------
	
	// [우성] 회원/관리자 구분 ------------------------------------------------------------
	public boolean checkManager(String customerId) {
		return cusService.checkManager(customerId);
	}
	//---------------------------------------------------------------------------------
}
