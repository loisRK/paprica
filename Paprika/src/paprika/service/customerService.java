package paprika.service;

import java.sql.SQLException;
import java.util.ArrayList;
import paprika.dto.customerDTO;
import paprika.dto.storeDTO;
import paprika.exception.NotExistException;
import paprika.model.customerDAO;
import paprika.model.storeDAO;

public class customerService {
	private static customerService instance = new customerService();
	
	private customerService() {}
	
	public static customerService getInstance() {
		return instance;
	}
	
	public void NotExistException(String customerID) throws NotExistException, SQLException{
		customerDTO customer = customerDAO.getCustomer(customerID);
		if(customer == null){
			throw new NotExistException("아이디가 존재하지 않습니다.");
		}
	}
	
	// customer - CRUD
	// 모든 고객 정보 반환
	public ArrayList<customerDTO> getAllCustomers() throws SQLException{
		return customerDAO.getAllCustomers();
	}
	
	// 개인정보 등록
	public boolean addCustomer(customerDTO customer) throws SQLException{
		customerDAO.addCustomer(customer);
		return true;
	}
	// 개인정보 조회
	public customerDTO getCustomer(String customerId) throws SQLException, NotExistException{
		NotExistException(customerId);
		return customerDAO.getCustomer(customerId);
	}
	// 개인정보 수정
	public boolean updateAddress(String customerId,String address) throws SQLException, NotExistException{
		NotExistException(customerId);
	return customerDAO.updateAddress(customerId, address);
	}
	
	public boolean updatePassword(String customerId,String customerPassword) throws SQLException, NotExistException{
		NotExistException(customerId);
	return customerDAO.updatePassword(customerId, customerPassword);
	}
	
	public boolean updatePhonenumber(String customerId, String phoneNumber) throws SQLException, NotExistException{
		NotExistException(customerId);
		return customerDAO.updatephoneNumber(customerId, phoneNumber);
	}
	
	// 개인정보 삭제
	public boolean deleteCustomer(String customerId) throws SQLException, NotExistException{
		NotExistException(customerId);
	return customerDAO.deleteCustomer(customerId);
	}
	
	
	// Buying - 제품 구매 및 정보 확인 구매 내역 확인 및 주문 정보 수정
	// 구매하기
	
	// 구매내역 확인하기
	
	// 구매 취소하기

	
}
