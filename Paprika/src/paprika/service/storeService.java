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
	// 사업자 등록
	public boolean addStore(storeDTO store) throws SQLException{
		storeDAO.addStore(store);
		return true;
	}
	// 사업자 번호로 사업자 조회 조회
	public storeDTO getStore(String storeName) throws SQLException, NotExistException{
		return storeDAO.getStore(storeName);
	}
	// id를 통한 사업장 주소 정보 변경하기
	public boolean updateStoreAddress(String storeName,String storeAddress) throws SQLException, NotExistException{
	return storeDAO.updateAddress(storeName,storeAddress);
	}

	
	// id를 통한 사업장 전화번호 변경하기
	public boolean updatephoneNumber(String storeName,String storenumber) throws SQLException, NotExistException{
	return storeDAO.updateAddress(storeName,storenumber);
	}	
	// 개인정보 삭제
	public boolean deleteStore(String storeName) throws SQLException, NotExistException{
		return storeDAO.deleteStore(storeName);
	}	
	
	

}
