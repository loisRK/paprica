package paprika.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import paprika.dto.productDTO;
import paprika.util.DBUtil;

public class productDAO {
	
	// 상품 저장
	public static boolean addproduct(productDTO product) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("INSERT INTO product VALUES(?, ?, ?, ?, ?, ?)");
			pstmt.setInt(1, product.getProID());
			pstmt.setString(2, product.getStoreID());
			pstmt.setString(3, product.getProName());
			pstmt.setString(4, product.getProCategory());
			pstmt.setInt(5, product.getProPrice());
			pstmt.setInt(6, product.getProCnt());

			int result = pstmt.executeUpdate();

			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}
	
	// 전체 상품 검색
	public static ArrayList<productDTO> getAllProduct() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<productDTO> list = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("SELECT * FROM product");
			rset = pstmt.executeQuery();

			list = new ArrayList<productDTO>();
			while (rset.next()) {
				list.add(new productDTO(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getString(4),
						rset.getInt(5), rset.getInt(6)));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}

	// ----------------
//	con = DBUtil.getConnection();
//	pstmt = con.prepareStatement("SELECT * FROM product WHERE product_name=?");
//	pstmt.setString(1, productName);
//	rset = pstmt.executeQuery();
//
//	list = new ArrayList<productDTO>();
//	while (rset.next()) {
//		list.add(new productDTO(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getString(4),
//				rset.getInt(5), rset.getInt(6)));
//		
//		con = DBUtil.getConnection();
//		pstmt = con.prepareStatement("SELECT * FROM product WHERE product_name=?");
//		pstmt.setString(1, productName);
//		rset = pstmt.executeQuery();
//		if (rset.next()) {
//			productInfo = new productDTO(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getString(4),
//					rset.getInt(5), rset.getInt(6));
	// ----------------

	// 상품명으로 상품 검색
	public static ArrayList<productDTO> getProductName(String productName) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<productDTO> list = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("SELECT * FROM product WHERE product_name=?");
			pstmt.setString(1, productName);
			rset = pstmt.executeQuery();

			list = new ArrayList<productDTO>();
			while (rset.next()) {
				list.add(new productDTO(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getString(4),
						rset.getInt(5), rset.getInt(6)));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}
	
	// 특정 상품 가격 수정
	public static boolean updatePrice(String productID, int productPrice) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();

			pstmt = con.prepareStatement("UPDATE product SET product_price=? WHERE product_name=?");
			pstmt.setInt(1, productPrice);
			pstmt.setString(2, productID);

			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}
	
	// 특정 상품 수량 수정
	public static boolean updateCount(String productID, int productCnt) throws SQLException {
			Connection con = null;
			PreparedStatement pstmt = null;
			try {
				con = DBUtil.getConnection();

				pstmt = con.prepareStatement("UPDATE product SET product_cnt = ? WHERE product_name=?");
				pstmt.setInt(1, productCnt);
				pstmt.setString(2, productID);

				int result = pstmt.executeUpdate();
				if (result == 1) {
					return true;
				}
			} finally {
				DBUtil.close(con, pstmt);
			}
			return false;
		}
	
	// 특정 상품 삭제
	public static boolean deleteProduct(String productName) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("DELETE FROM product WHERE product_name=?");
			pstmt.setString(1, productName);
			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	// 카테고리로 상품 찾기
	public static ArrayList<productDTO> getProductCategory(String proCategory) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<productDTO> list = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("SELECT * FROM product WHERE product_category=?");
			pstmt.setString(1, proCategory);
			rset = pstmt.executeQuery();

			list = new ArrayList<productDTO>();
			while (rset.next()) {
				list.add(new productDTO(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getString(4),
						rset.getInt(5), rset.getInt(6)));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}
	
	// 단가로 상품 찾기
	public static ArrayList<productDTO> getProductPrice(int minPrice, int maxPrice) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<productDTO> list = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("SELECT * FROM product WHERE product_price BETWEEN ? AND ?");
			pstmt.setInt(1, minPrice);
			pstmt.setInt(2, maxPrice);
			rset = pstmt.executeQuery();

			list = new ArrayList<productDTO>();
			while (rset.next()) {
				list.add(new productDTO(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getString(4),
						rset.getInt(5), rset.getInt(6)));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}
}
