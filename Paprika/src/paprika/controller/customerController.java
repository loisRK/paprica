package paprika.controller;

import paprika.service.customerService;
import paprika.service.purchaseService;
import paprika.service.storeService;
import paprika.view.customerEndview;

public class customerController {
	private static customerController instance = new customerController();
//	private customerService cService = customerService.getInstance();
	private purchaseService purService = purchaseService.getInstance();
	private storeService sService = storeService.getInstance();
	
	private customerController() {}
	public static customerController getInstance() {
		return instance;
	}
	
	// 이름으로 물건 검색
	
	
	// 카테고리별로 물건 검색
	
	
	// 가격으로 물건검색
	
	
	// 모든 구매 내역 확인
	public void getAllPurchase(String cusID) {
		try {
			customerEndview.allPurshase(purService.getAllPurchase(cusID));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// 특정 구매 내역 정보 확인 (상태, 배송일, )
	public void getPurchaseInfo() {
		
	}
	
	// 제품 구매
//	public void newPurchase() {
//		try {
//			customerEndview.purchaseCheck(purService.);
//		}
//	}
	
	// 구매 내역 변경하기(취소 후 재구매)
	
	
	// 개인정보 변경
	
	
	// 회원 탈퇴
	
	
	// 회원 가입
	
	
}
