package paprika.service;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import paprika.dto.customerDTO;
import paprika.dto.productDTO;
import paprika.dto.purchaseDTO;
import paprika.exception.NotExistException;
import paprika.model.customerDAO;
import paprika.model.productDAO;
import paprika.model.purchaseDAO;

public class purchaseService {
	private static purchaseService instance = new purchaseService();
	
	private purchaseService() {}
	
	public static purchaseService getInstance() {
		return instance;
	}
	
	// purchase - CRUD
	// notExistProduct
	public void notExistPurchase(int orderID) throws NotExistException, SQLException {
		purchaseDTO purchase = purchaseDAO.getOnePurchase(orderID);
		if(purchase == null) {
			throw new NotExistException("해당 구매이력이 없습니다.");
		}
	}
	
	// 품번으로 해당 품목 구매이력 모두 조회하기
	public ArrayList<purchaseDTO> getAllPurchaseByPID(int productID) throws SQLException {
		return purchaseDAO.getAllPurchaseByPID(productID);
	}

	// 고객 아이디로 구매한 모든 이력 반환
	public ArrayList<purchaseDTO> getAllPurchase(String cusID) throws SQLException {
		return purchaseDAO.getAllPurchase();
	}
	
	// productID, customerID, orderID 중 지정한 정보로 해당하는 구매 이력 반환
	public ArrayList<purchaseDTO> getPurchaseHistory(String colName, String colValue) throws SQLException {
		return purchaseDAO.getSomePurchase(colName, colValue);
	}
		
	// 제품 구매 - 새로운 구매 이력 저장 및 구매 내역확인(출력)
	public purchaseDTO purchaseHistory(int productID, String customerID, int count) throws SQLException{
		Date date = new Date();
		SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String orderDate = dFormat.format(date);	// 주문 시점 날짜 string 타입으로 생성
		
		productDTO pInfo = productDAO.getProductId(productID);		// 주문품목 정보 불러오기
		customerDTO cInfo = customerDAO.getCustomer(customerID);	// 주문자 정보 불러오기
		int orderCount = purchaseDAO.getOrderCount()+1;
		// 새로운 구매 객체 생성
		purchaseDTO newOrder = new purchaseDTO(orderCount,
												pInfo.getProID(),
												cInfo.getCusID(),
												count,
												cInfo.getCusName(),
												cInfo.getCusAdd(),
												cInfo.getCusPhone(),
												"주문접수",
												orderDate,
												"무료배송");
		// auto-increment test - addPurchaseTest
		purchaseDAO.addPurchase(newOrder);
		return purchaseDAO.getOnePurchase(orderCount);
	}
	
	// 구매수량 변경
	public purchaseDTO editPurchaseCnt(int orderID, int productID, int changeCnt) throws SQLException{
		purchaseDTO pInfo = purchaseDAO.getOnePurchase(orderID);
		if(pInfo.getOrderStatus().equals("주문접수")) {
			// 재고수량확인해서 변경가능한지 여부 확인할 수 있음
			purchaseDAO.updateOrderCnt(changeCnt, orderID);
			return purchaseDAO.getOnePurchase(orderID);
		}
		return null;
	}
	

}
