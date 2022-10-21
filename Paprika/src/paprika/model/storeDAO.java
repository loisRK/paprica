package paprika.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import paprika.dto.storeDTO;
import paprika.util.DBUtil;

public class storeDAO {
	// 모든 가게들의 정보들을 반환
	public static ArrayList<storeDTO> getAllStores() throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<storeDTO> AllStore = null;
		
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("SELECT * FROM store");
			rset = pstmt.executeQuery();			
			AllStore = new ArrayList<storeDTO>();
			while(rset.next()) {
				AllStore.add(new storeDTO(rset.getString(1),rset.getString(2),rset.getString(3),rset.getString(4),rset.getString(5)));
			}
		} finally  {
			DBUtil.close(con, pstmt, rset);
		}	
		return AllStore;
	}
	
	// id를 통한 사업장 정보 반환하기
	public static storeDTO getStore (String customerId) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		storeDTO store = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("SELECT * FROM store WHERE store_id =?");
				pstmt.setString(1, customerId);
				rset = pstmt.executeQuery();
				if(rset.next()) {
					store = new storeDTO(rset.getString(1),rset.getString(2),rset.getString(3),rset.getString(4),rset.getString(5));
				}
		}finally {
			DBUtil.close(con, pstmt, rset);
		}return store;
	}
	
	// id를 통한 사업장 주소 정보 변경하기
	public static boolean updateAddress(String storeID, String address) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("UPDATE store SET store_add =?  WHERE store_id =?");
			pstmt.setString(1, storeID);
			pstmt.setString(2, address);
				
			int result = pstmt.executeUpdate();
				if(result == 1) {
					return true;
				}
		}finally {
			DBUtil.close(con, pstmt);
		}return false;
	}
	
	// id를 통한 사업장 명 변경하기
	public static boolean updateStoreName (String storeID, String storeName) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("UPDATE store SET store_name=? WHERE store_id =?");
			pstmt.setString(1, storeID);
			pstmt.setString(2, storeName);
				
			int result = pstmt.executeUpdate();
				if(result == 1) {
					return true;
				}
		}finally {
			DBUtil.close(con, pstmt);
		}return false;
	}
		
	// id를 통한 사업장 전화번호 변경하기
	public static boolean updateStorePhone (String storeID, String phoneNumber) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("UPDATE store SET store_number=? WHERE store_id =?");
			pstmt.setString(1, storeID);
			pstmt.setString(2, phoneNumber);
				
			int result = pstmt.executeUpdate();
				if(result == 1) {
					return true;
				}
		}finally {
			DBUtil.close(con, pstmt);
		}return false;
	}
	
	// 가게 정보 추가하기
	public static boolean addStore(storeDTO store) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
		con = DBUtil.getConnection();
		pstmt = con.prepareStatement("insert into store values(?, ?, ?, ?, ?)");

		pstmt.setString(1, store.getStoreID());
		pstmt.setString(2, store.getStoreName());
		pstmt.setString(3, store.getOwnerName());
		pstmt.setString(4, store.getStoreAdd());
		pstmt.setString(5, store.getStoreNumber());

		
		int result = pstmt.executeUpdate();
		
		if(result ==1) {
			return true;
			}
		}finally {
			DBUtil.close(con, pstmt);
	}
	return false;

	}
	
	// 가게 정보 삭제하기
	public static boolean deleteStore(String storeID) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();

			pstmt = con.prepareStatement("DELETE FROM store WHERE store_id=?");
			pstmt.setString(1, storeID);

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
