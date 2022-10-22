package paprika.view;

import paprika.controller.customerController;
import paprika.controller.managerController;

public class startView {

	public static void main(String[] args) {
//		managerController mController = managerController.getInstance();
		customerController cusController = customerController.getInstance();
		
	// 고객용 -----------------------------------------------------------------------------------

		String productName2 = "사과";
		System.out.println(productName2 + " 정보를 검색합니다.");
		cusController.getProductName(productName2);
//		
//		String productCategory = "과일";
//		System.out.println(productCategory + " 카테고리로 정보를 검색합니다.");
//		cusController.getProductCategory(productCategory);
//		
//		int minPrice = 500;
//		int maxPrice = 2000;
//		System.out.println(minPrice + "원부터 " + maxPrice + "원 사이의 상품을 검색합니다.");
//		cusController.getProductPrice(minPrice, maxPrice);
		
		
		
		//		System.out.println("---모든 구매 내역 확인---");
//		cusController.getAllPurchase("a123");
		
		System.out.println("---특정 구매 내역 확인---");
//		cus_id로 구매한 이력 찾기
		cusController.getPurchaseInfo("cus_id", "lois");
		
//		System.out.println("---제품 구매---");
//		cusController.newPurchase(productID, customerID);

	}
}
