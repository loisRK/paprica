package paprika.dto;

public class storeDTO {
	private String storeID;		// 사업자번호
	private String storeName;	// 가게명
	private String ownerName;	// 사업자명
	private String storeAdd;	// 가게 주소
	private String storeNumber;	// 가게 번호
	
	storeDTO(){}

	public storeDTO(String storeID, String storeName, String ownerName, String storeAdd, String storeNumber) {
		super();
		this.storeID = storeID;
		this.storeName = storeName;
		this.ownerName = ownerName;
		this.storeAdd = storeAdd;
		this.storeNumber = storeNumber;
	}

	public String getStoreID() {
		return storeID;
	}

	public void setStoreID(String storeID) {
		this.storeID = storeID;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getStoreAdd() {
		return storeAdd;
	}

	public void setStoreAdd(String storeAdd) {
		this.storeAdd = storeAdd;
	}

	public String getStoreNumber() {
		return storeNumber;
	}

	public void setStoreNumber(String storeNumber) {
		this.storeNumber = storeNumber;
	}

	@Override
	public String toString() {
		return "storeDTO [storeID=" + storeID + ", storeName=" + storeName + ", ownerName=" + ownerName + ", storeAdd="
				+ storeAdd + ", storeNumber=" + storeNumber + "]";
	};
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
