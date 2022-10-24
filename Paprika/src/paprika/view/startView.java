package paprika.view;

import java.util.Scanner;

import paprika.controller.customerController;
import paprika.controller.managerController;
import paprika.dto.customerDTO;

public class startView {
	private static startView instance = new startView();
	static managerController manController = managerController.getInstance();
	static customerController cusController = customerController.getInstance();
	static Scanner in = new Scanner(System.in);
	
	private startView() {};
	public startView getInstance() {
		return instance;
	}
	
	// [우성] 관리자/회원 확인 ---------------------------------------------------------------------------------------
	public static boolean checkManager(String customerId) {
		return cusController.checkManager(customerId);
	}
	// --------------------------------------------------------------------------------------------------------
	
	
	
	// [우성] 관리자로 로그인 했을 때 ------------------------------------------------------------------------------------
	public static void managerLogin(String id, String pw) {
		System.out.println("관리자로 로그인되었습니다.");
		System.out.println("원하시는 작업을 입력해주세요.");
		System.out.println("1 : 고객관리\n2 : 상품관리");
		// 첫번째 버튼 입력
		System.out.print("[입력값] : ");
		int nButton = in.nextInt();
		// 고객관리 part 접속 --------------------------------
		if(nButton == 1) {
			System.out.println("고객관리를 선택하였습니다.");
			System.out.println("고객관리 중 원하시는 작업을 입력해주세요.");
			System.out.println("1 : 모든 고객 조회\n2 : 특정 고객 조회\n3 : 특정 고객 구매 내역 확인\n4 : 고객 등급 수정");
			// 두번째 버튼 입력
			System.out.print("[입력값] : ");
			int mButton = in.nextInt();
			// [계진] 모든 고객 검색
			if(mButton == 1) {
				System.out.println("모든 고객을 조회합니다.");
		        manController.allCustomer();

			} // [계진] 특정 고객 정보 검색
			 else if (mButton == 2) {
				System.out.println("검색하고자 하는 고객의 아이디를 입력해주세요.");
	            System.out.print("[고객 ID] : ");    
	            String customerID = in.next();
	            manController.OneCustomer(customerID);
		
			} // [륜경] 특정 고객 모든 구매내역 검색
			 else if (mButton == 3) {
				System.out.println("특정 고객의 구매내역을 검색합니다.");
				System.out.print("[고객 ID] : "); 
				String customerID = in.next();
		        manController.getCustomerHistory(customerID);  
			} // [계진] 고객 등급 업데이트
			 else if (mButton == 4) {
				 System.out.println("고객의 등급을 업데이트합니다.");
		            manController.customergrade();
			}else {
				System.out.println("번호를 잘못 입력하셨습니다.");
			}
		}
		
		// 상품관리 part 접속 -------------------------------
		else if (nButton == 2) {
			System.out.println("상품관리를 선택하였습니다.");
			System.out.println("상품관리 중 원하시는 작업을 선택해주세요.");
			System.out.println("1 : 모든 상품 조회\n2 : 특정 상품 정보 검색\n3 : 새로운 상품 추가");
			System.out.println("4 : 특정 상품 가격 변경\n5 : 특정 상품 수량 변경\n6 : 특정 상품 삭제\n7 : 특정 상품 판매이력 검색");
			// 두번째 버튼 입력
			System.out.print("[입력값] : ");
			int mButton = in.nextInt();
			// [우성] 모든 상품 조회하기
			if(mButton == 1) {
				System.out.println("모든 상품을 조회합니다.");
				manController.allProduct();
			} // [우성] 특정 상품 정보 검색하기
			else if (mButton == 2) {
				System.out.println("1 : 상품명으로 검색하기\n2 : 품목으로 검색하기\n3 : 금액대로 검색하기");
				System.out.print("[입력값] : ");
				int oButton = in.nextInt();
				if (oButton == 1) {
					// [우성] 상품명으로 상품 검색하기
					System.out.println("상품명으로 상품을 검색합니다.");
					System.out.print("[상품명] : ");
					String productName = in.next();
					manController.getProductName(productName);
				} else if (oButton == 2) {
					// [우성] 품목으로 상품 검색하기
					System.out.println("품목으로 상품을 검색합니다.");
					System.out.print("[품목명] : ");
					String productCategory = in.next();
					cusController.getProductCategory(productCategory);
				} else if (oButton == 3) {
					// [우성] 금액대로 상품 검색하기
					System.out.println("설정한 금액대로 상품을 검색합니다.");
					System.out.print("[최소 금액] : ");
					int minPrice = in.nextInt();
					System.out.print("[최대 금액] : ");	
					int maxPrice = in.nextInt();
					cusController.getProductPrice(minPrice, maxPrice);
				}else {
					System.out.println("번호를 잘못 입력하셨습니다.");
				}
				
			} // [우성] 새로운 상품 추가하기
			else if (mButton == 3) {
				System.out.println("추가할 상품 정보를 입력해주세요.");
				System.out.print("상품ID : ");
				int proID = in.nextInt();
				System.out.print("\n사업자번호 : ");
				String storeID = in.next();
				System.out.print("\n상품명 : ");
				String proName = in.next();
				System.out.print("\n품목 : ");
				String proCategory = in.next();
				System.out.print("\n가격 : ");
				int proPrice = in.nextInt();
				System.out.print("\n수량 : ");
				int proCnt = in.nextInt();
				manController.adddProduct(proID, storeID, proName, proCategory, proPrice, proCnt);
				System.out.println("상품을 등록하였습니다.");
					
			} // [우성] 특정 상품 가격 수정하기
			else if (mButton == 4) {
				manController.allProduct();
				System.out.println("위를 참고하여 가격을 수정할 상품ID와 금액을 입력해주세요.");
				System.out.print("상품ID : ");
				int productId = in.nextInt();
				System.out.print("\n가격 : ");
				int productPrice = in.nextInt();
				manController.updatePrice(productId, productPrice);
					
			}// [우성] 특정 상품 수량 수정하기
			else if (mButton == 5) {
				manController.allProduct();
				System.out.println("위를 참고하여 금액을 수정할 상품ID와 개수을 입력해주세요.");
				System.out.print("상품ID : ");
				int productId = in.nextInt();
				System.out.print("\n개수 : ");
				int productCnt = in.nextInt();
				manController.updatePrice(productId, productCnt);
				
			} // [우성] 특정 상품 삭제
			else if (mButton == 6) {
				System.out.println("삭제할 상품의 상품Id를 입력해주세요.");
				System.out.print("상품명 : ");
				String productName = in.next();
				manController.deleteProduct(productName);
				
			} // [륜경] 특정 상품 판매이력 검색하기
			else if (mButton == 7) {
				manController.allProduct();
				System.out.println("위를 참고하여 판매이력을 조회할 상품ID를 입력해주세요.");
				System.out.print("상품ID : ");
				String productId = in.next();
	            manController.getProductHistory(productId); 
					
			}else {
				System.out.println("번호를 잘못 입력하셨습니다.");
			}
		}else {
			System.out.println("번호를 잘못 입력하셨습니다.");
		}
		
	}
	// ----------------------------------------------------
	
	
	
	// [우성] 회원으로 로그인 했을 때 ------------------------------------------------------------------------------------
	public static void customerLogin(String id, String pw) {
		System.out.println("어서오십시오. 파프리카입니다.");
		System.out.println("원하시는 작업을 입력해주세요.");
		System.out.println("1 : 쇼핑하기\n2 : 마이페이지");
		// 첫번째 버튼 입력
		System.out.print("[입력값] : ");
		int nButton = in.nextInt();
		// 쇼핑하기 part 접속 --------------------------------
		if(nButton == 1) {
			System.out.println("쇼핑하기를 선택하셨습니다.");
			System.out.println("쇼핑하기 중 원하시는 작업을 입력해주세요.");
			System.out.println("1 : 모든 상품 검색하기\n2 : 상품명으로 검색하기\n3 : 카테고리로 검색하기\n4 : 가격대로 검색하기\n5 : 제품 구매하기");
			// 두번째 버튼 입력
			System.out.print("[입력값] : ");
			int mButton = in.nextInt();
			// [우성] 모든 상품 검색
			if(mButton == 1) {
				System.out.println("모든 상품을 검색합니다.");
				cusController.getAllProduct();
			} // [우성] 상품명으로 검색
			 else if (mButton == 2) {
				System.out.println("상품명으로 상품을 조회합니다.");
				System.out.print("[상품명] : ");
				String productName = in.next();
				cusController.getProductName(productName);	
			} // [우성] 품목으로 검색
			 else if (mButton == 3) {
				System.out.println("품목으로 상품을 검색합니다.");
				System.out.print("[품목명] : ");
				String productCategory = in.next();
				cusController.getProductCategory(productCategory);
			} // [우성] 가격대로 검색
			 else if (mButton == 4) {
				System.out.println("설정한 금액대로 상품을 검색합니다.");
				System.out.print("[최소 금액] : ");
				int minPrice = in.nextInt();
				System.out.print("[최대 금액] : ");	
				int maxPrice = in.nextInt();
				cusController.getProductPrice(minPrice, maxPrice);
			} // [륜경] 상품 구매
			 else if (mButton == 5) {
				cusController.getAllProduct();
				System.out.println("위를 참고하여 구매할 상품ID와 개수를 입력해주세요.");
				// cus_id : A123, pro_id : 2001, 8개 구매
				System.out.print("[상품 ID] : ");
				int productId = in.nextInt();
				System.out.print("[구매 개수] : ");
				int productCnt = in.nextInt();
	            cusController.newPurchase(productId, id, productCnt); 
			}else {
				System.out.println("번호를 잘못 입력하셨습니다.");
			}
		}
		
		// 회원정보 part 접속 -------------------------------
		else if (nButton == 2) {
			System.out.println("마이페이지에 접속하였습니다.");
			System.out.println("원하시는 작업을 선택해주세요.");
			System.out.println("1 : 모든 구매 내역 조회\n2 : 특정 구매 내역 조회\n3 : 구매내역 수정하기");
			System.out.println("4 : 주소 변경\n5 : 전화번호 변경\\n6 : 비밀번호 변경\\n7 : 회원탈퇴");
			// + 구매내역 수정하기
			// 두번째 버튼 입력
			System.out.print("[입력값] : ");
			int mButton = in.nextInt();
			// [륜경] 모든 구매 내역 조회
			if(mButton == 1) {
				System.out.println(id + "님의 모든 구매 내역을 조회");
				cusController.getAllPurchase(id);	
					
			} // [륜경] 특정 구매 내역 조회
			else if (mButton == 2) {
				System.out.println("특정 구매 내역 조회");
				// cus_id로 구매한 내역 조회
				// String colName = in.next();	 -> 추후 "cus_id" 대신 colName 입력 하기
	            cusController.getPurchaseInfo("cus_id", id);
	            // cus_id 등 특정 컬럼명 입력받아 특정 구매내역 조회하기
				
			} // [륜경] 구매내역 수정하기
			else if (mButton == 3) {
				// 구매내역 보여주는 메소드
				// 주문번호와 수정할 수량 입력하기
				// 주문번호와 수정할 수량을 입력받은 메소드 
				System.out.println("구매내역 수정하기");
				// order_id, cus_id, 변경할수량
				cusController.getEditInfo("cus_id", id);
				// 다른 회원의 구매내역도 수정할 수 있다는 결점을 발견 -> 수정보안이 필요함(ex: 로그인 id를  추가 입력받기)
				System.out.print("[주문번호] : ");
				int orderID = in.nextInt();
				System.out.print("[변경할 수량] : ");
				int changeCnt = in.nextInt();
				cusController.editPurchase(orderID, changeCnt);
				
			} // [계진] 주소 변경
			else if (mButton == 4) {
				System.out.println("주소 변경");
	            System.out.println("변경하실 주소를 입력해주세요");
	            System.out.print("[주소] : ");
	            String customerAddress = in.next();
	            cusController.updateAddress(id, customerAddress); 
	
					
			} // [계진] 전화번호 변경
			else if (mButton == 5) {
				System.out.println("전화번호 변경");
	            System.out.println("변경하실 전화번호를 입력해주세요");
	            System.out.print("[전화번호] : ");
	            String phoneNumber = in.next();
	            cusController.updatePhone(id, phoneNumber);

					
			} // [계진] 비밀번호 변경
			else if (mButton == 6) {
				System.out.println("비밀번호 변경");
	            System.out.println("변경하실 비밀번호를 입력해주세요");
	            System.out.print("[PW] : ");
	            String customerPassword = in.next();
	            cusController.updatepassword(id, customerPassword); 
	
					
			} // [계진] 회원탈퇴
			else if (mButton == 7) {
				System.out.println("회원탈퇴");
	            System.out.println("고객의 비밀번호를 입력해주세요");
	            System.out.print("[PW] : ");
	            String customerPW = in.next();
	            cusController.deleteCustomer(id, customerPW);

					
			}else {
				System.out.println("번호를 잘못 입력하셨습니다.");
			}
		} else {
				System.out.println("번호를 잘못 입력하셨습니다.");
		}
	}
	// --------------------------------------------------------------------------------------------------------
	
	
	
	// [우성] 메인홈 -> ID 확인 및 관리자/회원 분류 ------------------------------------------------------------------------
	public static void paprikaHome(){
		while(true) {
			System.out.println("어서오십시오. 파프리카입니다.");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("원하시는 작업을 선택해주세요.");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("1 : 로그인\n2 : 회원가입");
			// 첫번째 버튼 입력
			System.out.print("[입력값] : ");
			int lButton = in.nextInt();
			// 로그인 ------------------------------------------------------------------------------------------------
			if(lButton == 1) {
				System.out.println("아이디를 입력해주세요.");
				System.out.print("ID : ");
				String id = in.next();
				if(cusController.checkId(id)) {
					// 존재하는 id일 경우
					System.out.println("비밀번호를 입력해주세요.");
					System.out.print("PW : ");
					String pw = in.next();
					if(cusController.checkPw(id, pw)) {
						// 존재하는 비밀번호일 경우
						if(checkManager(id)) {
							managerLogin(id, pw);
							break;
						} else {
							customerLogin(id, pw);
							break;
						}
					} else {
						// 존재하지 않는 비밀번호일 경우
						System.out.println("잘못된 비밀번호입니다.");
						break;
					}
				} else {
					System.out.println("존재하지 않는 아이디입니다.");
					break;
				}
			} else if(lButton == 2) {
				// 회원가입 -------------------------------------------------------------------------------------------
	            customerDTO customer = new customerDTO();         
	            System.out.println("아이디를 입력해주세요.");
	            System.out.print("ID : ");
	            String cusID = in.next();
	            if(cusController.checkId(cusID) == false) {
	            	customer.setCusID(cusID);
	                System.out.println("비밀번호를 입력해주세요.");
	                System.out.print("PW : ");
	                String cusPW = in.next();
					customer.setCusPW(cusPW);
					
					System.out.println("이름을 입력해주세요.");
					System.out.print("[이름] : ");
					String cusName = in.next();
					customer.setCusName(cusName);
					
					System.out.println("email을 입력해주세요.");
					System.out.print("[email] : ");
					String cusEmail = in.next();
					customer.setCusEmail(cusEmail);
					
					System.out.println("주소를 입력해주세요.");
					System.out.print("[주소] : ");
					String cusAdd = in.next();
					customer.setCusAdd(cusAdd);
					
					System.out.println("전화번호를 입력해주세요.");
					System.out.print("[전화번호] : ");
					String cusPhone = in.next();
					customer.setCusPhone(cusPhone);
					
					customer.setCusRank(1);
					cusController.insertCustomer(customer);
					
					System.out.println("회원가입이 정상적으로 완료되었습니다.");
	            } else {
	                System.out.println("중복된 아이디입니다. 초기 화면으로 돌아갑니다.");
	            }
				continue;
			} else {
				System.out.println("잘못된 번호입니다. 다시 입력해주세요.");
				continue;
			}
		}
	}
	//------------------------------------------------------------------------------------------------------------
	
	
	
	// [우성] ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^  ★☆★☆start view MAIN 실행☆★☆★ ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	public static void main(String[] args) {
		paprikaHome();
	} // ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
}
