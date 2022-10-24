package paprika.view;

import paprika.controller.customerController;
import paprika.controller.managerController;
import paprika.dto.customerDTO;
import paprika.exception.NotExistException;

public class stratView {
	public static void main(String[] args) throws NotExistException {
		customerController cusController = customerController.getInstance();
		managerController manController = managerController.getInstance();

//		customer 관련 실행 예시 ----------------------------------------------------------------------------------
//		System.out.println("---회원가입---");
//	    cusController.insertCustomer(new customerDTO("dd123", "A123",  "정계진", "수원시 팔달구 고등동", 2, "010-2352-2222", "a123@daum.com"));
//		manController.allCustomer();
//		
//		System.out.println("---회원삭제---");
//		try {
//			cusController.deleteCustomer("dd123");
//		} catch (NotExistException e) {
//			e.printStackTrace();
//		}
//		manController.allCustomer();
		
//		cusController.updatepassword("b123", "1456");
//	    cusController.updateAddress("b123", "지구");
//	    cusController.updatePhone("b123", "454-78787");
	    
	    manController.customergrade();
//		
//		product 관련 실행 예시 -----------------------------------------------------------------------------------
//		String productName2 = "사과";
//		System.out.println(productName2 + " 정보를 검색합니다.");
//		cusController.getProductName(productName2);
//		
//		String productCategory = "과일";
//		System.out.println(productCategory + " 카테고리로 정보를 검색합니다.");
//		cusController.getProductCategory(productCategory);
//		
//		int minPrice = 500;
//		int maxPrice = 2000;
//		System.out.println(minPrice + "원부터 " + maxPrice + "원 사이의 상품을 검색합니다.");
//		cusController.getProductPrice(minPrice, maxPrice);
		
		
		
//		purchase 관련 실행 예시 -----------------------------------------------------------------------------------
//		System.out.println("---모든 구매 내역 확인---");
//		cusController.getAllPurchase("a123");
		
//		System.out.println("---특정 구매 내역 확인---");
//		cusController.getPurchaseInfo("cus_id", "lois");	// cus_id로 구매한 이력 찾기
		
//		System.out.println("---제품 구매(한 품목)---");
//		cusController.newPurchase(4001, "D123", 20);
//		cusController.newPurchase(1002, "D123", 40);
//		cusController.newPurchase(1001, "lois", 8);
//		cusController.newPurchase(1002, "lois", 8);
//		cusController.newPurchase(1003, "lois", 8);
//		cusController.newPurchase(4001, "lois", 8);
//		cusController.newPurchase(2001, "A123", 8);
		
//		System.out.println("---주문 수정---");
		cusController.editPurchase(8, 4001, 3);
	    
//	    System.out.println("---특정 구매 내역 조회---");
//	    cusController.getPurchaseInfo("cus_id", "lois");
		
//		System.out.println("---품목별 판매 이력 검색---");
//		manController.getProductHistory("4001");
		
//		System.out.println("---고객별 구매 이력 검색---");
//		manController.getCustomerHistory("d123");
	    
//		여러 품목 - 카트에 추가
//		cusController.addCart(1002,"lois",2);
	}
}
