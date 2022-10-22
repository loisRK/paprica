package paprika.view;

import paprika.controller.customerController;

public class startView {

	public static void main(String[] args) {
		customerController cusController = customerController.getInstance();
		
//		System.out.println("---모든 구매 내역 확인---");
//		cusController.getAllPurchase("a123");
		
		System.out.println("---특정 구매 내역 확인---");
//		cus_id로 구매한 이력 찾기
		cusController.getPurchaseInfo("cus_id", "lois");
		
//		System.out.println("---제품 구매---");
//		cusController.newPurchase(productID, customerID);

	}
}
