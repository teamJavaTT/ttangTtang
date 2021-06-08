package product.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import product.model.AucPro;

public class AucProDao {
	//상품 등록
	public void aucProductWrite(Connection conn,AucPro aucpro) throws SQLException{
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			pstmt=conn.prepareStatement("insert into")
			
		}
	}

	}

// 2번 기능 : 전체 상품 조회 기능

