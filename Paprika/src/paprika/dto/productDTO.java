package paprika.dto;

public class productDTO {
	private int proID;
	private String storeID;
	private String proName;
	private String proCategory;
	private int proPrice;
	private int proCnt;
	
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
		return "productDTO [proID=" + proID + ", storeID=" + storeID + ", proName=" + proName + ", proCategory="
				+ proCategory + ", proPrice=" + proPrice + ", proCnt=" + proCnt + "]";
	}
}
