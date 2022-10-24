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
   
   // 고객 등급변경 (계진)
   public boolean updatecustomerGrade() throws SQLException, NotExistException{
	   return customerDAO.updatecustomerGrade();
   }
   
   // 개인정보 삭제 (계진)
   public boolean deleteCustomer(String customerId, String customerPW) throws SQLException, NotExistException{
      customerDTO customer = customerDAO.getCustomer(customerId);
      if(customer == null){
         throw new NotExistException("존재하지 않는 아이디입니다.");
      }
      NotExistException(customerId);
      return customerDAO.deleteCustomer(customerId, customerPW);
   }
   
   // 로그인 (계진)
   public customerDTO login(String customerId, String customerPW) throws SQLException, NotExistException{
      NotExistException(customerId);
      return customerDAO.login(customerId, customerPW);
   }
   
// [우성] id 확인------------------------------------------------------------------
   public boolean checkId(String customerId) {
	   customerDTO customerCheck = null;
	   try {
		   customerCheck = customerDAO.getCustomer(customerId);
	   } catch (SQLException e) {
		   e.printStackTrace();
	   }
	   if(customerCheck != null) {
		   return true;
	   }
	   return false;
   }
   //---------------------------------------------------------------------------------
   
   
   // [우성] pw 확인------------------------------------------------------------------
   public boolean checkPw(String customerId, String customerPw) {
	   String customerCheck = null;
	   try {
		   customerCheck = customerDAO.checkPw(customerId);
	   } catch (SQLException e) {
		   e.printStackTrace();
	   }
	   if(customerCheck != null) {
		   return true;
	   }
	   return false;
   }
   //---------------------------------------------------------------------------------
   
   
   // [우성] 관리자/회원 구분 --------------------------------------------------------------
   public boolean checkManager(String customerId) {
	   int cusRank = 1;
	   try {
		   cusRank = customerDAO.getCustomer(customerId).getCusRank();
	   } catch (SQLException e) {
		   e.printStackTrace();
	   }
	   if(cusRank == 0) {
		   return true;
	   }
	   return false;
   }
   //---------------------------------------------------------------------------------
}