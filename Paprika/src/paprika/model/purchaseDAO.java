package paprika.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
	public static purchaseDTO getOnePurchase(int orderID) throws SQLException {
		Connection con = null;
		Statement stmt = null;
		ResultSet rset = null;
		purchaseDTO purchaseOne = null;

		try {
			con = DBUtil.getConnection();
			stmt = con.createStatement();
			rset = stmt.executeQuery("select * from purchase where order_id = " + orderID);
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
			DBUtil.close(con, stmt, rset);
		}
		return purchaseOne;
	}
	
	// 특정 주문 내역 조회(어떤 정보로 검색할지 키워드 설정)
	public static ArrayList<purchaseDTO> getSomePurchase(String colName, String colValue) throws SQLException {
		Connection con = null;
		Statement stmt = null;
		ResultSet rset = null;
		ArrayList<purchaseDTO> list = null;
		try {
			con = DBUtil.getConnection();
			stmt = con.createStatement();
			rset = stmt.executeQuery("select * from purchase where "
										+ colName + " = '" + colValue + "'");

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
			DBUtil.close(con, stmt, rset);
		}
		return list;
	}
	
	// 특정 주문 내역 조회 - 자료형이 달라서 위에 식으로 적용 안됨
	public static ArrayList<purchaseDTO> getAllPurchaseByPID(int productID) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<purchaseDTO> list = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from purchase where pro_id = ?");
			pstmt.setInt(1, productID);
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
	
	// 가장 최근 등록된 주문 조회
	public static int getOrderID() throws SQLException {
		Connection con = null;
		Statement stmt = null;
		ResultSet rset = null;
		int list = 0;
		try {
			con = DBUtil.getConnection();
			stmt = con.createStatement();
			rset = stmt.executeQuery("SELECT order_id FROM purchase ORDER BY order_id DESC LIMIT 1");
			list = rset.getInt("order_id");
		} finally {
			DBUtil.close(con, stmt, rset);
		}
		return list;
	}
	
	// 구매목록 개수 가져오기
	public static int getOrderCount() throws SQLException {
		Connection con = null;
		Statement stmt = null;
		ResultSet rset = null;
		int cnt = 0;
		try {
			con = DBUtil.getConnection();
			stmt = con.createStatement();
			rset = stmt.executeQuery("SELECT count(order_id) FROM purchase");
			while(rset.next()) {
				cnt = rset.getInt("count(order_id)");
			}
			
		} finally {
			DBUtil.close(con, stmt, rset);
		}
		return cnt;
	}
	
	// 주문내역 변경 - 수량 변경 (륜경)
	public static boolean updateOrderCnt(int changeCnt, int orderID) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("update purchase set order_cnt=? where order_id=?");
			pstmt.setInt(1, changeCnt);
			pstmt.setInt(2, orderID);

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
