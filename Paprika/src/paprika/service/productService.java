package paprika.service;

import java.sql.SQLException;
import java.util.ArrayList;

import paprika.exception.NotExistException;
import paprika.dto.productDTO;
import paprika.model.productDAO;

public class productService {
	
	private static productService instance = new productService();
	private productService() {}
	public static productService getInstance() {
		return instance;
	}
	
	// product - CRUD
	//-----------------------NotExistException--------------------------------------------
	// notExistProduct - 이름으로 검색할 때
	public void notExistProductName(String productName) throws NotExistException, SQLException{
		ArrayList<productDTO> product = productDAO.getProductName(productName);
		if(product == null){
			throw new NotExistException("존재하는 상품이 없습니다.");
		}
	}

	// notExistProduct - 품목으로 검색할 때
	public void notExistProductCategory(String productCategory) throws NotExistException, SQLException{
		ArrayList<productDTO> product = productDAO.getProductCategory(productCategory);
		if(product == null){
			throw new NotExistException("존재하는 상품이 없습니다.");
		}
	}
	
	// notExistProduct - 가격으로 검색할 때
	public void notExistProductPrice(int startPrice, int endPrice) throws NotExistException, SQLException{
		ArrayList<productDTO> product = productDAO.getProductPrice(startPrice, endPrice);
		if(product == null){
			throw new NotExistException("존재하는 상품이 없습니다.");
		}
	}
	
	//--------------------------------------------------------------------------------------
	
	
	
	// 상품 조회하기-----------------------------------------------------------------------------
	// 모든 품목 정보 반환
	public ArrayList<productDTO> getAllProduct() throws SQLException{
		return productDAO.getAllProduct();
	}
	
	// 이름으로 특정 품목 정보 반환
	public ArrayList<productDTO> getProductName(String productName) throws SQLException, NotExistException{
		notExistProductName(productName);
		return productDAO.getProductName(productName);
	}
	
	// 카테고리로 특정 품목 정보 반환
	public ArrayList<productDTO> getProductCategory(String proCategory) throws SQLException, NotExistException{
		notExistProductCategory(proCategory);
		return productDAO.getProductCategory(proCategory);
	}
	
	// 가격대로 특정 품목 정보 반환
	public ArrayList<productDTO> getProductPrice(int minPrice, int maxPrice) throws SQLException, NotExistException{
		notExistProductPrice(minPrice, maxPrice);
		return productDAO.getProductPrice(minPrice, maxPrice);
	}
	// ---------------------------------------------------------------------------------------------------------------------------------------
	
	
	
	// 상품 등록 --------------------------------------------------------------------------------------------------------------------------------
	// 새로운 품목 저장
//  notExistProduct - 이미 데이터가 있는 경우
	public boolean addproduct(int proID, String storeID, String proName, String proCategory, int proPrice, int proCnt) throws SQLException, NotExistException{
		ArrayList<productDTO> checkProduct = productDAO.getProductName(proName);
		if(checkProduct != null){
			throw new NotExistException("이미 존재하는 상품입니다.");
		}
		productDTO product = new productDTO(proID, storeID, proName, proCategory, proPrice, proCnt);
		return productDAO.addproduct(product);
	}
	// ---------------------------------------------------------------------------------------------------------------------------------------
	
	
	
	// 상품 수정 --------------------------------------------------------------------------------------------------------------------------------
	// 이름으로 특정 품목 가격 수정
	public boolean updatePrice(int productID, int productPrice) throws SQLException {
		return productDAO.updatePrice(productID, productPrice);
	}

	// 이름으로 특정 품목 수량 수정
	public boolean updateCount(String productID, int productCnt) throws SQLException {
		return productDAO.updateCount(productID, productCnt);
	}
	// ---------------------------------------------------------------------------------------------------------------------------------------
	
	
	
	// 상품 삭제 --------------------------------------------------------------------------------------------------------------------------------
	// 이름으로 특정 품목 삭제
	public boolean deleteProduct(String productName) throws SQLException, NotExistException {
		ArrayList<productDTO> checkProduct = productDAO.getProductName(productName);
		if(checkProduct == null){
			throw new NotExistException("존재하지 않는 상품입니다.");
		}
		return productDAO.deleteProduct(productName);
	}
	// ---------------------------------------------------------------------------------------------------------------------------------------
	
	
	
	// 상품 아이디로 상품정보 불러오기
	public productDTO callProduct(int productId) throws SQLException {
		productDTO getProduct = productDAO.getProductId(productId);
		return getProduct;
	}
	
	
	
	// 장바구니 담기 (륜경)
//	public void 
}
