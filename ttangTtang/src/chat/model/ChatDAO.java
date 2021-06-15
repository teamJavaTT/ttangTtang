package chat.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ChatDAO {

		private Connection conn;

		public ChatDAO() {
			try {
				String dbURL = "jdbc:mysql://localhost:3306/ANONYMOUSCHAT";
				String dbID = "AUCTION";
				String dbPassword = "auc";
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		public ArrayList<Chat> getChatList(String nowTime){
			ArrayList<Chat> chatList = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String SQL = "SELECT * FROM CHAT WHERE chatTime > ? ORDER BY chatTime";
		} 
	} catch (Exception e) {
		e.printStackTrace();
	}finally {
		try {
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	return chatList;
}
}
