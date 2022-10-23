package paprika.controller;

import java.sql.SQLException;

import paprika.dto.productDTO;
import paprika.exception.NotExistException;
import paprika.service.customerService;
import paprika.service.productService;
import paprika.service.purchaseService;
import paprika.view.managerEndview;

public class managerController {
	private static managerController instance = new managerController();
	private productService proservice = productService.getInstance();
	private customerService cusService = customerService.getInstance();
	private purchaseService purService = purchaseService.getInstance();
	
	private managerController() {}
	public static managerController getInstance() {
		return instance;
	}
	
	//  <고객 관리>
	// 고객 전체 검색 (계진)
	public void allCustomer(){      
	  try{
	     managerEndview.allListView(cusService.getAllCustomers());
	  }catch(SQLException s){
	     s.printStackTrace();
	     managerEndview.showError("모든 고객 검색시 에러 발생");
	  }
	}

	// 고객 한명 검색 (계진)
	public void OneCustomer(String customerId) throws NotExistException{
	  try{
	     managerEndview.customerList(cusService.getCustomer(customerId));
	  }catch(SQLException s){
	     s.printStackTrace();
	     managerEndview.showError("프로젝트 검색시 에러 발생");
	  }
	}
	
	// 고객 등급변경 (계진)
	public void customergrade() throws NotExistException{
	  try{
	     cusService.updatecustomerGrade();
	  }catch(SQLException s){
	     s.printStackTrace();
	     managerEndview.showError("프로젝트 검색시 에러 발생");
	  }
	}
	
	// 특정 고객 모든 구매 내역 검색 (륜경)
	public void getCustomerHistory(String customerID) {
		try {
			managerEndview.allListView(purService.getAllPurchase(customerID));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	
//	   <품목 관리>	
	// 모든 품목 정보 검색 (우성)
	public void allProduct() {
		try {
			managerEndview.productListView(proservice.getAllProduct());
		} catch (SQLException e) {
			e.printStackTrace();
			managerEndview.showError("상품 조회 중 오류가 발생하였습니다.");
		}
	}
	
	// 특정 품목 정보 검색 (우성)
	public void getProduct(String productName) {
		try {
			managerEndview.productListView(proservice.getProductName(productName));
		} catch (SQLException | NotExistException e) {
			e.printStackTrace();
			managerEndview.showError("상품 조회 중 오류가 발생하였습니다.");
		}
	}
	
	// 새로운 품목 등록 (우성)
	public void adddProduct(int proID, String storeID, String proName, String proCategory, int proPrice, int proCnt) {
		try {
			if(proservice.addproduct(proID, storeID, proName, proCategory, proPrice, proCnt) == true) {
				productDTO addproduct = new productDTO(proID, storeID, proName, proCategory, proPrice, proCnt);
				managerEndview.checkAddProdcut(addproduct);			
			}
		} catch (SQLException | NotExistException e) {
			e.printStackTrace();
		}
	}
	
	// 특정 품목 가격 수정 (우성)
	public void updatePrice(int productId, int productPrice) {
		try {
			if(proservice.updatePrice(productId, productPrice) == true) {
				String getProductName = proservice.callProduct(productId).getProName();
				managerEndview.checkUpdatePrice(getProductName, productId, productPrice);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 특정 품목 삭제 (우성)
	public void deleteProduct(String productName) {
		try {
			if(proservice.deleteProduct(productName) == true) {
				managerEndview.checkDeleteProduct(productName);
			}
		} catch (SQLException | NotExistException e) {
			e.printStackTrace();
		}
	}
	
	// 특정 품목 판매 이력 검색 (륜경)
	public void getProductHistory(int productID) {
		try {
			managerEndview.allListView(purService.getAllPurchaseByPID(productID));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
