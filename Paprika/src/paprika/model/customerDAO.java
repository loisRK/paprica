package paprika.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import paprika.dto.customerDTO;
import paprika.util.DBUtil;

public class customerDAO {
	// �� �߰��ϱ�
	public static boolean addCustomer(customerDTO customer) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
		con = DBUtil.getConnection();
		pstmt = con.prepareStatement("insert into customer values(?, ?, ?, ?, ?, ?, ?)");

		pstmt.setString(1, customer.getCusID());
		pstmt.setString(2, customer.getCusPW());
		pstmt.setString(3, customer.getCusName());
		pstmt.setString(4, customer.getCusAdd());
		pstmt.setInt(5, customer.getCusRank());
		pstmt.setString(6, customer.getCusPhone());
		pstmt.setString(7, customer.getCusEmail());
		
		int result = pstmt.executeUpdate();
		
		if(result ==1) {
			return true;
			}
		}finally {
			DBUtil.close(con, pstmt);
	}
	return false;

	}

	// �� ������ �����ϱ�
	public static boolean deleteCustomer(String customerid) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();

			pstmt = con.prepareStatement("DELETE FROM customer WHERE cus_id=?");
			pstmt.setString(1, customerid);

			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}
	
	// id�� ���� �������� ��ȯ
	public static customerDTO getCustomer (String customerId) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		customerDTO customer = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("SELECT * FROM customer WHERE cus_id =?");
				pstmt.setString(1, customerId);
				rset = pstmt.executeQuery();
				if(rset.next()) {
					customer = new customerDTO(rset.getString(1),rset.getString(2),rset.getString(3),rset.getString(4),rset.getInt(5),rset.getString(6),rset.getString(7));
				}
		}finally {
			DBUtil.close(con, pstmt, rset);
		}return customer;
	}
	
	// ��� ���� ����Ʈ�� ��ȯ
	public static ArrayList<customerDTO> getAllCustomers() throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<customerDTO> list = null;
		
		
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("SELECT * FROM customer");
			rset = pstmt.executeQuery();			
			list = new ArrayList<customerDTO>();
			while(rset.next()) {
				list.add(new customerDTO(rset.getString(1),rset.getString(2),rset.getString(3),rset.getString(4),rset.getInt(5),rset.getString(6),rset.getString(7)));
			}
		} finally  {
			DBUtil.close(con, pstmt, rset);
		}	
		return list;
	}
	
	// �� ���̵� ���� ��й�ȣ ����
	public static boolean updatePassword (String customerId, String customerPassword) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("UPDATE customer SET cus_pw = ? WHERE cus_id =?");
			pstmt.setString(2, customerId);
			pstmt.setString(1, customerPassword);
				
			int result = pstmt.executeUpdate();
				if(result == 1) {
					return true;
				}
		}finally {
			DBUtil.close(con, pstmt);
		}return false;
	}
	// �� ���̵� �ּ� ����
	public static boolean updateAddress (String customerId, String address) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("UPDATE customer SET cus_add=(?) WHERE cus_id =(?)");
			pstmt.setString(2, customerId);
			pstmt.setString(1, address);
			int result = pstmt.executeUpdate();
				if(result == 1) {
					return true;
				}
		}finally {
			DBUtil.close(con, pstmt);
		}return false;
	}
	// �� ���̵� ���� ��ȭ��ȣ ����
	public static boolean updatephoneNumber (String customerId, String phoneNumber) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("UPDATE customer SET cus_phone=? WHERE cus_id =?");
			pstmt.setString(2, customerId);
			pstmt.setString(1, phoneNumber);
				
			int result = pstmt.executeUpdate();
				if(result == 1) {
					return true;
				}
		}finally {
			DBUtil.close(con, pstmt);
		}return false;
	}
	
	
		
}
	
	





