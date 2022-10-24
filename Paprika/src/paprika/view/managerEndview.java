package paprika.view;

import java.util.ArrayList;

import paprika.dto.customerDTO;
import paprika.dto.productDTO;

public class managerEndview {

//	-----------product 관련---------------
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
	
	// 상품 등록 성공 여부
	public static void checkAddProdcut(productDTO addProduct) {
		String productName = addProduct.getProName();
		System.out.println(productName + "이 정상적으로 등록되었습니다.");
		addProduct.toString();
	}
	
	// 상품 가격 변경 성공여부
	public static void checkUpdatePrice(String productName,int productId, int productPrice) {
		System.out.println(productName + "[" + productId + "]의 가격이 " + productPrice + "으로 변동되었습니다.");
	}
	
	// 상품 개수 변경 성공 여부
	public static void checkUpdateCount(String productName,int productId, int productCnt) {
		System.out.println(productName + "[" + productId + "]의 개수가 " + productCnt + "으로 변동되었습니다.");
	}
	
	// 상품 삭제 성공 여부
	public static void checkDeleteProduct(String productName) {
		System.out.println(productName + "이 삭제되었습니다.");
	}
	
	
	// 예외 상황 출력
	public static void showError(String msg) {
		System.out.println(msg);
	}
	
	
//	-----------customer 관련---------------
	public static void allListView(ArrayList allOrder){
		int length = allOrder.size();
		if( length != 0 ){
			for(int index = 0; index < length; index++){         
				System.out.println("검색정보 " + (index+1) + " - " + allOrder.get(index));
			}
		}
	}
   
	public static void customerList(customerDTO oneOrder){
		System.out.println(oneOrder);      
	}
	
	
	
	
	
	
}
