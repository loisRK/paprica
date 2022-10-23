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
	// 새로운 가게 추가
	public boolean addStore(storeDTO store) throws SQLException{
		storeDAO.addStore(store);
		return true;
	}
	
	// 가게 정보 불러오기
	public storeDTO getStore(String storeName) throws SQLException, NotExistException{
		return storeDAO.getStore(storeName);
	}
	
	// 가게 주소 변경
	public boolean updateStoreAddress(String storeName, String storeAddress) throws SQLException, NotExistException{
		return storeDAO.updateAddress(storeName,storeAddress);
	}

	// 가게 번호 변경
	public boolean updatephoneNumber(String storeName, String storenumber) throws SQLException, NotExistException{
		return storeDAO.updateAddress(storeName,storenumber);
	}
	
	// 가게 정보 삭제
	public boolean deleteStore(String storeName) throws SQLException, NotExistException{
		return storeDAO.deleteStore(storeName);
	}	
	
	

}
