package paprika.controller;

import java.sql.SQLException;
import paprika.service.customerService;
import paprika.service.productService;
import paprika.service.purchaseService;
import paprika.service.storeService;
import paprika.dto.customerDTO;
import paprika.exception.NotExistException;
import paprika.view.customerEndview;

public class customerController {
	private static customerController instance = new customerController();
	
	private purchaseService purService = purchaseService.getInstance();
	private storeService stoService = storeService.getInstance();
	private productService proService = productService.getInstance();
	private customerService cusService = customerService.getInstance();
	
	private customerController() {}
	public static customerController getInstance() {
		return instance;
	}
	
//	------------customer (계진)--------------
	// 비밀번호 변경
	public void updatepassword(String customerId, String customerPassword) throws NotExistException{
		try{
			cusService.updatePassword(customerId, customerPassword);
		}catch(SQLException s){
			s.printStackTrace();
			customerEndview.showError("고객 검색시 에러 발생");
		}
	}
	
	// 주소 변경 
	public void updateAddress(String customerId, String customerAddress) throws NotExistException{
		try{
			cusService.updateAddress(customerId, customerAddress);
		}catch(SQLException s){
			s.printStackTrace();
			customerEndview.showError("고객 검색시 에러 발생");
		}
	}
	
	// 핸드폰 번호 변경
	public void updatePhone(String customerId, String phoneNumber) throws NotExistException{
		try{
			cusService.updatePhonenumber(customerId, phoneNumber);
		}catch(SQLException s){
			s.printStackTrace();
			customerEndview.showError("고객 검색시 에러 발생");
		}
	}

	// 회원 탈퇴
	public void deleteCustomer(String customerId) throws NotExistException {
		try {
			cusService.deleteCustomer(customerId);
		}catch(SQLException | NotExistException e) {
			e.printStackTrace();
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
	
	
//	--------------product (우성)--------------
	// 이름으로 물건 검색
	public void getProductName(String productName) {
		try {
			customerEndview.productListView(proService.getProductName(productName));
		} catch (SQLException | NotExistException e) {
			e.printStackTrace();
			customerEndview.showError("상품 조회 중 오류가 발생하였습니다.");
		}
	}
	
	// 카테고리별로 물건 검색
	public void getProductCategory(String productCategory) {
		try {
			customerEndview.productListView(proService.getProductCategory(productCategory));
		} catch (SQLException | NotExistException e) {
			e.printStackTrace();
			customerEndview.showError("상품 조회 중 오류가 발생하였습니다.");
		}
	}
	
	// 가격으로 물건검색
	public void getProductPrice(int minPrice, int maxPrice) {
		try {
			customerEndview.productListView(proService.getProductPrice(minPrice, maxPrice));
		} catch (SQLException | NotExistException e) {
			e.printStackTrace();
			customerEndview.showError("상품 조회 중 오류가 발생하였습니다.");
		}
	}
	
	
//	--------------purchase (륜경)----------------
	// 모든 구매 내역 확인
	public void getAllPurchase(String cusID) {
		try {
			customerEndview.purchaseListView(purService.getAllPurchase(cusID));
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
			customerEndview.purchaseCheck(purService.purchaseHistory(productID, customerID, count));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 장바구니 담기 (륜경)
//	public void addCart(int productID, String customerID, int count) {
//		try {
//			customerEndview.purchaseCheck(proService.addCart(productID, customerID, count));
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
	
	// 구매 내역 수정 (order_status : 주문접수 인 경우에만 수정할 수 있는 메소드)
	public void editPurchase(int orderID, int productID, int changeCnt) {
		try {
			customerEndview.purchaseCheck(purService.editPurchaseCnt(orderID, productID, changeCnt));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
}
