package paprika.view;

import java.util.ArrayList;

import paprika.dto.productDTO;
import paprika.dto.purchaseDTO;

public class customerEndview {
	
	// 상품 출력
		public static void productListView(ArrayList<productDTO> allProduct) {
			int length = allProduct.size();
			System.out.println("[검색 결과] 총 " + length + "개의 상품이 검색되었습니다.");
			if (length != 0) {
				for(int i = 0; i<length; i++) {
					System.out.println(i +  ". " + allProduct.get(i));
				}
			}
		}

	//모든 프로젝트 출력
	public static void allPurshase(ArrayList allOrder){
		int length = allOrder.size();
		if( length != 0 ){
			for(int index = 0; index < length; index++){			
				System.out.println("검색정보 " + (index+1) + " - " + allOrder.get(index));
			}
		}
	}
		
	//특정 프로젝트 출력 
	public static void purchaseCheck(purchaseDTO oneOrder){
		System.out.println(oneOrder);		
	}
	
	// 모든 DTO 정보 출력하는 메소드
	public static void allView(Object object){
		System.out.println(object);
	}
	
	//예외 상황 출력
	public static void showError(String message){
		System.out.println(message);		
	}
}
