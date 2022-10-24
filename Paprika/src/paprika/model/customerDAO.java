package paprika.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import paprika.dto.customerDTO;
import paprika.util.DBUtil;

public class customerDAO {
	// 고객 정보 추가
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
	
	// 아이디로 고객 정보 조회
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
	
	// 모든 고객 정보 보기
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
	
	// 고객 비밀번호 변경
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
	
	// 고객 주소 변경
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
	
	// 고객 전화번호 변경
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
	
   // 고객 등급변경 
   public static boolean updatecustomerGrade () throws SQLException{
      Connection con = null;
      PreparedStatement pstmt = null;
      try {
         con = DBUtil.getConnection();
         pstmt = con.prepareStatement("UPDATE customer c inner join (select s.cus_id,order_name,sum(pro_price*order_cnt) as z\r\n" + 
               "                        from purchase s,product p\r\n" + 
               "                        where s.pro_id = p.pro_id\r\n" + 
               "                                GROUP BY s.cus_id) as b\r\n" + 
               "on c.cus_id = b.cus_id\r\n" + 
               "set cus_rank = (\r\n" + 
               "case\r\n" + 
               "WHEN c.cus_id = 'admin' then 0 \r\n" +
               "WHEN z>=0 and z < 10000 then 1 \r\n" + 
               "WHEN z >= 10000 and z <20000 then 2\r\n" + 
               "WHEN z >= 20000 and z <30000 THEN 3\r\n" + 
               "WHEN z >= 30000 and z <40000 THEN 4\r\n" + 
               "WHEN z >= 40000 and z <1000000000 THEN 5\r\n" + 
               "else 1 \r\n" + 
               "end);\r\n");
         int result = pstmt.executeUpdate();
            if(result == 1) {
               return true;
            }
      }finally {
         DBUtil.close(con, pstmt);
      }return false;
   }

   public static boolean deleteCustomer(String customerid, String customer_pw) throws SQLException {
	   Connection con = null;
	   PreparedStatement pstmt = null;
	   try {
	      con = DBUtil.getConnection();
	
	      pstmt = con.prepareStatement("DELETE FROM customer WHERE cus_id=? and cus_pw=?");
	      pstmt.setString(1, customerid);
	      pstmt.setString(2, customer_pw);
	
	      int result = pstmt.executeUpdate();
	      if (result == 1) {
	         return true;
	      }
	   } finally {
	      DBUtil.close(con, pstmt);
	   }
	   return false;
	}

   	//--------------------------------------------- 로그인하기 (계진)
	public static customerDTO login (String customerId,String customerPW) throws SQLException{
	   Connection con = null;
	   PreparedStatement pstmt = null;
	   ResultSet rset = null;
	   customerDTO customer = null;
	   try {
	      con = DBUtil.getConnection();
	      pstmt = con.prepareStatement("SELECT * FROM customer WHERE cus_id =? and cus_pw=?");
	         pstmt.setString(1, customerId);
	         pstmt.setString(2, customerPW);
	         rset = pstmt.executeQuery();
	         if(rset.next()) {
	            customer = new customerDTO(rset.getString(1),rset.getString(2),rset.getString(3),rset.getString(4),rset.getInt(5),rset.getString(6),rset.getString(7));
	         }
	   }finally {
	      DBUtil.close(con, pstmt, rset);
	   }return customer;
	}
	
		
}
	
	





