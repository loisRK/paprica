package paprika.controller;

import java.sql.SQLException;
import paprika.service.customerService;
import paprika.dto.customerDTO;
import paprika.exception.NotExistException;
import paprika.view.customerEndview;




public class customerController {
	private static customerController instance = new customerController();
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
//	public void projectView(String projectName) throws NotExistException{
//		try{
//			customerEndview.projectView(service.getBTProject(projectName));
//		}catch(SQLException s){
//			s.printStackTrace();
//			customerEndview.showError("검색시 에러 발생");
//		}
//	
//	}

	
	
//	// 카테고리별로 물건 검색
//	
//	
//	// 가격으로 물건검색
//	
//	
//	// 특정 구매 내역 정보 확인 (상태, 배송일, )
//	
//	
//	// 모든 구매 내역 확인
	
	
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
	
	// 제품 구매

	
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
	
	
////	 구매 내역 변경하기(취소 후 재구매)
	
}
