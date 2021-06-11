package product.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jdbc.JdbcUtil;
import product.model.NorPro;

public class NorProDao {
	
	// 상품 등록
	public static NorPro insert(Connection conn, NorPro norProduct) throws SQLException {
		PreparedStatement pstmt= null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement("INSERT INTO PRODUCT(INO, USERID, CCODE, CNAME, UAD, INAME, PRICE, PRICETEXT, IMAGEFACE, VIEWCOUNT, LIKECOUNT, PDATE, REDATE, UDATE, SELLCHECK)"+"VALUES(product_seq.NEXTVAL, '?', '?', '?', '?','?', '?', '?', '?', 0, 0, sysdate, sysdate, '?', '?')");
			
			pstmt.setString(1, norProduct.getProduct_name());
			pstmt.setString(2, norProduct.getCategory());
			pstmt.setString(3, norProduct.getPrice());
			pstmt.setString(5, norProduct.getDescription());
			                   
			return null;
		
	}finally {
		JdbcUtil.close(rs);
		JdbcUtil.close(stmt);
	
	}
	}
}



// 2번 기능 : 전체 상품 조회 기능
