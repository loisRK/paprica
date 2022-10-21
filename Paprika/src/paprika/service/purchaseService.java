package paprika.service;

import java.sql.SQLException;
import java.util.ArrayList;

import paprika.dto.purchaseDTO;
import paprika.exception.NotExistException;
import paprika.model.purchaseDAO;

public class purchaseService {
	private static purchaseService instance = new purchaseService();
	
	private purchaseService() {}
	
	public static purchaseService getInstance() {
		return instance;
	}
	
	// purchase - CRUD
	// notExistProduct
	
	// 모든 구매 정보 반환
	public ArrayList<purchaseDTO> getAllPurchase(String cusID) throws SQLException {
		return purchaseDAO.getAllPurchase();
	}
	
	// 특정 구매 정보 반환
	
	// 새로운 구매 이력 저장
	
	// 특정 품목 삭제

}
