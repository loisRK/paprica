package paprika.dto;

public class purchaseDTO {
	private int orderID;			// 주문번호
	private int proID;				// product 아이디
	private String cusID;			// customer 아이디
	private int orderCnt;			// 수량
	private String orderName;		// 수령자 이름
	private String orderAdd;		// 
	private String orderRecNumber;
	private String orderStatus;
	private String orderDate;
	private String deliveryType;
	
	public purchaseDTO() {}
	public purchaseDTO(int orderID, int proID, String cusID, int orderCnt, String orderName,
			String orderAdd, String orderRecNumber, String orderStatus, String orderDate, String deliveryType) {
		super();
		this.orderID = orderID;
		this.cusID = cusID;
		this.proID = proID;
		this.orderCnt = orderCnt;
		this.orderName = orderName;
		this.orderAdd = orderAdd;
		this.orderRecNumber = orderRecNumber;
		this.orderStatus = orderStatus;
		this.orderDate = orderDate;
		this.deliveryType = deliveryType;
	}
	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	public String getCusID() {
		return cusID;
	}
	public void setCusID(String cusID) {
		this.cusID = cusID;
	}
	public int getProID() {
		return proID;
	}
	public void setProID(int proID) {
		this.proID = proID;
	}
	public int getOrderCnt() {
		return orderCnt;
	}
	public void setOrderCnt(int orderCnt) {
		this.orderCnt = orderCnt;
	}
	public String getOrderName() {
		return orderName;
	}
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
	public String getOrderAdd() {
		return orderAdd;
	}
	public void setOrderAdd(String orderAdd) {
		this.orderAdd = orderAdd;
	}
	public String getOrderRecNumber() {
		return orderRecNumber;
	}
	public void setOrderRecNumber(String orderRecNumber) {
		this.orderRecNumber = orderRecNumber;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public String getDeliveryType() {
		return deliveryType;
	}
	public void setDeliveryType(String deliveryType) {
		this.deliveryType = deliveryType;
	}
	@Override
	public String toString() {
		return "buyingDTO [orderID=" + orderID + ", cusID=" + cusID + ", proID=" + proID + ","
				+ ", orderCnt=" + orderCnt + ", orderName=" + orderName + ", orderAdd=" + orderAdd + ", orderRecNumber="
				+ orderRecNumber + ", orderStatus=" + orderStatus + ", orderDate=" + orderDate + ", deliveryType="
				+ deliveryType + "]";
	}
	
}
