package paprika.dto;

public class customerDTO {
	private String cusID; 	// �� ID
	private String cusPW; 	// �� Password
	private String cusName;	// �� �̸�
	private String cusAdd; 	// �� �ּ�
	private int cusRank; 		// �� ���
	private String cusPhone;	// �� ��ȭ��ȣ
	private String cusEmail;	// �� �̸���
	
	public customerDTO() {}
	public customerDTO(String cusID, String cusPW, String cusName, String cusAdd, int cusRank, String cusPhone,
			String cusEmail) {
		super();
		this.cusID = cusID;
		this.cusPW = cusPW;
		this.cusName = cusName;
		this.cusAdd = cusAdd;
		this.cusRank = cusRank;
		this.cusPhone = cusPhone;
		this.cusEmail = cusEmail;
	}
	public String getCusID() {
		return cusID;
	}

	public void setCusID(String cusID) {
		this.cusID = cusID;
	}

	public String getCusPW() {
		return cusPW;
	}

	public void setCusPW(String cusPW) {
		this.cusPW = cusPW;
	}

	public String getCusName() {
		return cusName;
	}

	public void setCusName(String cusName) {
		this.cusName = cusName;
	}

	public String getCusAdd() {
		return cusAdd;
	}

	public void setCusAdd(String cusAdd) {
		this.cusAdd = cusAdd;
	}

	public int getCusRank() {
		return cusRank;
	}

	public void setCusRank(int cusRank) {
		this.cusRank = cusRank;
	}

	public String getCusPhone() {
		return cusPhone;
	}

	public void setCusPhone(String cusPhone) {
		this.cusPhone = cusPhone;
	}

	public String getCusEmail() {
		return cusEmail;
	}

	public void setCusEmail(String cusEmail) {
		this.cusEmail = cusEmail;
	}
	@Override
	public String toString() {
		return "customerDTO [cusID=" + cusID + ", cusPW=" + cusPW + ", cusName=" + cusName + ", cusAdd=" + cusAdd
				+ ", cusRank=" + cusRank + ", cusPhone=" + cusPhone + ", cusEmail=" + cusEmail + "]";
	}
	

	
	

}
