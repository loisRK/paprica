package paprika.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import paprika.dto.purchaseDTO;
import paprika.util.DBUtil;

public class purchaseDAO {
	// 주문서 저장
	public static boolean addPurchase(purchaseDTO purchase) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("insert into purchase values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			pstmt.setInt(1, purchase.getOrderID());
			pstmt.setInt(2, purchase.getProID());
			pstmt.setString(3, purchase.getCusID());
			pstmt.setInt(4, purchase.getOrderCnt());
			pstmt.setString(5, purchase.getOrderName());
			pstmt.setString(6, purchase.getOrderAdd());
			pstmt.setString(7, purchase.getOrderRecNumber());
			pstmt.setString(8, purchase.getOrderStatus());
			pstmt.setString(9, purchase.getOrderDate());
			pstmt.setString(10, purchase.getDeliveryType());

			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}
	
	// 전체 주문 내역 조회
	public static ArrayList<purchaseDTO> getAllPurchase() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<purchaseDTO> list = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from purchase");
			rset = pstmt.executeQuery();

			list = new ArrayList<purchaseDTO>();
			while (rset.next()) {
				list.add(new purchaseDTO(rset.getInt(1),
										  rset.getInt(2), 
										  rset.getString(3),
										  rset.getInt(4),
										  rset.getString(5),
										  rset.getString(6),
										  rset.getString(7),
										  rset.getString(8),
										  rset.getString(9),
										  rset.getString(10)));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}
	
	// 특정 주문 내역 조회
	public static purchaseDTO getOnePurchase(String orderID) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		purchaseDTO purchaseOne = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from purchase where order_id = ?");
			pstmt.setString(1, orderID);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				purchaseOne = new purchaseDTO(rset.getInt(1),
											  rset.getInt(2), 
											  rset.getString(3),
											  rset.getInt(4),
											  rset.getString(5),
											  rset.getString(6),
											  rset.getString(7),
											  rset.getString(8),
											  rset.getString(9),
											  rset.getString(10));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return purchaseOne;
	}
	
	// 주문상태 변경(update)
	public static boolean updatePurchaseStatus(String status, String orderID) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("update purchase set order_status=? where order_id=?");
			pstmt.setString(1, status);
			pstmt.setString(2, orderID);

			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}
	
}
