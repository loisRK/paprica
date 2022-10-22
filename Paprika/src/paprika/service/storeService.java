package paprika.service;

import java.sql.SQLException;
import paprika.dto.storeDTO;
import paprika.exception.NotExistException;
import paprika.model.storeDAO;

public class storeService {
	
	private static storeService instance = new storeService();
	
	private storeService() {}
	
	public static storeService getInstance() {
		return instance;
	}
	
	// customer - CRUD
	// ����� ���
	public boolean addStore(storeDTO store) throws SQLException{
		storeDAO.addStore(store);
		return true;
	}
	// ����� ��ȣ�� ����� ��ȸ ��ȸ
	public storeDTO getStore(String storeName) throws SQLException, NotExistException{
		return storeDAO.getStore(storeName);
	}
	// id�� ���� ����� �ּ� ���� �����ϱ�
	public boolean updateStoreAddress(String storeName,String storeAddress) throws SQLException, NotExistException{
		return storeDAO.updateAddress(storeName,storeAddress);
	}

	
	// id�� ���� ����� ��ȭ��ȣ �����ϱ�
	public boolean updatephoneNumber(String storeName,String storenumber) throws SQLException, NotExistException{
		return storeDAO.updateAddress(storeName,storenumber);
	}	
	// �������� ����
	public boolean deleteStore(String storeName) throws SQLException, NotExistException{
		return storeDAO.deleteStore(storeName);
	}	
	
	

}
