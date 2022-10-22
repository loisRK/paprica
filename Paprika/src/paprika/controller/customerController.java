package paprika.controller;

import java.sql.SQLException;

import paprika.exception.NotExistException;
import paprika.service.customerService;
import paprika.service.productService;
import paprika.service.purchaseService;
import paprika.service.storeService;
import paprika.view.customerEndview;

public class customerController {
	private static customerController instance = new customerController();
//	private customerService cService = customerService.getInstance();
	private purchaseService purService = purchaseService.getInstance();
	private storeService sService = storeService.getInstance();
	private productService proservice = productService.getInstance();
	
	private customerController() {}
	public static customerController getInstance() {
		return instance;
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
			customerEndview.allPurshase(purService.getAllPurchase(cusID));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// 특정 구매 내역 정보 확인 (상태, 배송일, )
	public void getPurchaseInfo(String colName, String colValue) {
		try {
			customerEndview.allPurshase(purService.getPurchaseHistory(colName, colValue));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 제품 구매
	public void newPurchase() {
//		try {
//			customerEndview.purchaseCheck(purService.);
//		}
	}
	
	// 구매 내역 변경하기(취소 후 재구매)
	public void editPurchase() {
		
	}
	
	
	// 개인정보 변경
	
	
	// 회원 탈퇴
	
	
	// 회원 가입
	
	
}
