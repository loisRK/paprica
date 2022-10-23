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
//	private customerService cService = customerService.getInstance();
	private purchaseService purService = purchaseService.getInstance();
	private storeService sService = storeService.getInstance();
	private productService proservice = productService.getInstance();
	private customerService service = customerService.getInstance();
	
	private customerController() {}
	
	public static customerController getInstance() {
		return instance;
	}
	
	// 전체 고객 검색
	public void allCustomer(){
		try{
			customerEndview.customerListView(service.getAllCustomers());
		}catch(SQLException s){
			s.printStackTrace();
			customerEndview.showError("모든 고객 검색시 에러 발생");
		}
	}
	
	// 고객 한명 검색
	public void OneCustomer(String customerId) throws NotExistException{
		try{
			customerEndview.customerList(service.getCustomer(customerId));
		}catch(SQLException s){
			s.printStackTrace();
			customerEndview.showError("프로젝트 검색시 에러 발생");
		}
	
	}
	
	// 이름으로 물건 검색
	public void getProductName(String productName) {
		try {
			customerEndview.productListView(proservice.getProductName(productName));
		} catch (SQLException | NotExistException e) {
			e.printStackTrace();
			customerEndview.showError("상품 조회 중 오류가 발생하였습니다.");
		}
	}
	
	// 카테고리별로 물건 검색
	public void getProductCategory(String productCategory) {
		try {
			customerEndview.productListView(proservice.getProductCategory(productCategory));
		} catch (SQLException | NotExistException e) {
			e.printStackTrace();
			customerEndview.showError("상품 조회 중 오류가 발생하였습니다.");
		}
	}
	
	// 가격으로 물건검색
	public void getProductPrice(int minPrice, int maxPrice) {
		try {
			customerEndview.productListView(proservice.getProductPrice(minPrice, maxPrice));
		} catch (SQLException | NotExistException e) {
			e.printStackTrace();
			customerEndview.showError("상품 조회 중 오류가 발생하였습니다.");
		}
	}
	
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
	public void newPurchase(String productID, String customerID) {
		try {
			customerEndview.purchaseCheck(purService.purchaseHistory(productID, customerID));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 비밀번호 변경
	public void updatepassword(String customerId, String customerPassword) throws NotExistException{
		try{
			service.updatePassword(customerId, customerPassword);
		}catch(SQLException s){
			s.printStackTrace();
			customerEndview.showError("고객 검색시 에러 발생");
		}
	}
	
	// 주소 변경 
	public void updateAddress(String customerId, String customerAddress) throws NotExistException{
		try{
			service.updateAddress(customerId, customerAddress);
		}catch(SQLException s){
			s.printStackTrace();
			customerEndview.showError("고객 검색시 에러 발생");
		}
	
	}
	
	// 핸드폰 번호 변경
	public void updatePhone(String customerId, String phoneNumber) throws NotExistException{
		try{
			service.updatePhonenumber(customerId, phoneNumber);
		}catch(SQLException s){
			s.printStackTrace();
			customerEndview.showError("고객 검색시 에러 발생");
		}
	
	}

	
	// 회원 탈퇴
	public void deleteCustomer(String customerId) throws NotExistException {
		try {
			service.deleteCustomer(customerId);
		}catch(SQLException e) {
		}
		
	}

	
	// 회원 가입
	public void insertCustomer(customerDTO customer) {
		try {
			service.addCustomer(customer);
		} catch (SQLException e) {
		}
	}
	
	
}
