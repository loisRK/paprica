package paprika.view;

import java.util.ArrayList;

import paprika.dto.customerDTO;
import paprika.dto.purchaseDTO;

public class customerEndview {

	//��� ������Ʈ ���
	public static void customerListView(ArrayList allOrder){
		int length = allOrder.size();
		if( length != 0 ){
			for(int index = 0; index < length; index++){			
				System.out.println("�˻����� " + (index+1) + " - " + allOrder.get(index));
			}
		}
	}
		
	//Ư�� ������Ʈ ��� 
	public static void customerList(customerDTO oneOrder){
		System.out.println(oneOrder);		
	}
	
	// ��� DTO ���� ����ϴ� �޼ҵ�
	public static void allView(Object object){
		System.out.println(object);
	}
	
	
	//���� ��Ȳ ���
	public static void showError(String message){
		System.out.println(message);		
	}
}
