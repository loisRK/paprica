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
			throw new NotExistException("���̵� �������� �ʽ��ϴ�.");
		}
	}
	
	// customer - CRUD
	// ��� �� ���� ��ȯ
	public ArrayList<customerDTO> getAllCustomers() throws SQLException{
		return customerDAO.getAllCustomers();
	}
	
	// �������� ���
	public boolean addCustomer(customerDTO customer) throws SQLException{
		customerDAO.addCustomer(customer);
		return true;
	}
	// �������� ��ȸ
	public customerDTO getCustomer(String customerId) throws SQLException, NotExistException{
		NotExistException(customerId);
		return customerDAO.getCustomer(customerId);
	}
	// �������� ����
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
	
	// �������� ����
	public boolean deleteCustomer(String customerId) throws SQLException, NotExistException{
		NotExistException(customerId);
	return customerDAO.deleteCustomer(customerId);
	}
	
	
	// Buying - ��ǰ ���� �� ���� Ȯ�� ���� ���� Ȯ�� �� �ֹ� ���� ����
	// �����ϱ�
	
	// ���ų��� Ȯ���ϱ�
	
	// ���� ����ϱ�

	
}
