package paprika.dto;

public class productDTO {
	private int proID;				// 상품 고유 번호
	private String storeID;			// 사업자번호
	private String proName;			// 상품이름
	private String proCategory;		// 상품 품목
	private int proPrice;			// 상품가격
	private int proCnt;			// 상품수량
	
	public productDTO() {}
	public productDTO(int proID, String storeID, String proName, String proCategory, int proPrice, int proCnt) {
		super();
		this.proID = proID;
		this.storeID = storeID;
		this.proName = proName;
		this.proCategory = proCategory;
		this.proPrice = proPrice;
		this.proCnt = proCnt;
	}
	public int getProID() {
		return proID;
	}
	public void setProID(int proID) {
		this.proID = proID;
	}
	public String getStoreID() {
		return storeID;
	}
	public void setStoreID(String storeID) {
		this.storeID = storeID;
	}
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}
	public String getProCategory() {
		return proCategory;
	}
	public void setProCategory(String proCategory) {
		this.proCategory = proCategory;
	}
	public int getProPrice() {
		return proPrice;
	}
	public void setProPrice(int proPrice) {
		this.proPrice = proPrice;
	}
	public int getProCnt() {
		return proCnt;
	}
	public void setProCnt(int proCnt) {
		this.proCnt = proCnt;
	}
	@Override
	public String toString() {
		return "productDTO [상품번호=" + proID + ", 사업자번호=" + storeID + ", 상품명=" + proName + ", 품목="
				+ proCategory + ", 가격=" + proPrice + ", 수량=" + proCnt + "]";
	}
}
