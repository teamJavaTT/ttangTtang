package mypage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.DBConnection;
import jdbc.JdbcUtil;
import mypage.model.DeleteFrom;

public class DeleteFromDao {

	
	
	public String DeteleFrom(Connection conn, String userid, String userpassword) throws SQLException {
		ResultSet rs = null;
		String upw = null;

	try(PreparedStatement pstmt = conn.prepareStatement( 
			"select upw from member where userid=? and userpassword=?")){
		
		pstmt.setString(1, userid);
		pstmt.setString(2, userpassword);
		rs= pstmt.executeQuery();
		
		if(rs.next()) {
			upw=rs.getString("upw");
		}
		return upw;
		}finally{
			JdbcUtil.close(rs);
			
		}
	
	}
	
	public int outuserDelete(Connection conn, int delNo) throws SQLException {
		try (PreparedStatement pstmt = 
				conn.prepareStatement(
						"delete from member where bNo = ?")) {
			pstmt.setInt(1, delNo);
			return pstmt.executeUpdate();
		}
	}
	
	 /**
     * 회원정보를 삭제한다.
     * @param id 회원정보 삭제 시 필요한 아이디
     * @param pw 회원정보 삭제 시 필요한 비밀번호
     * @return x : deleteMember() 수행 후 결과값
     */
    @SuppressWarnings("resource")
    public int deleteMember(String id, String pw) 
    {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
 
        String dbpw = ""; // DB상의 비밀번호를 담아둘 변수
        int x = -1;
 
        try {
            // 비밀번호 조회
            StringBuffer query1 = new StringBuffer();
            query1.append("SELECT PASSWORD FROM JSP_MEMBER WHERE ID=?");
 
            // 회원 삭제
            StringBuffer query2 = new StringBuffer();
            query2.append("DELETE FROM JSP_MEMBER WHERE ID=?");
 
            conn = DBConnection.getConnection();
 
            // 자동 커밋을 false로 한다.
            conn.setAutoCommit(false);
            
            // 1. 아이디에 해당하는 비밀번호를 조회한다.
            pstmt = conn.prepareStatement(query1.toString());
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
 
            if (rs.next()) 
            {
                dbpw = rs.getString("password");
                if (dbpw.equals(pw)) // 입력된 비밀번호와 DB비번 비교
                {
                    // 같을경우 회원삭제 진행
                    pstmt = conn.prepareStatement(query2.toString());
                    pstmt.setString(1, id);
                    pstmt.executeUpdate();
                    conn.commit(); 
                    x = 1; // 삭제 성공
                } else {
                    x = 0; // 비밀번호 비교결과 - 다름
                }
            }
 
            return x;
 
        } catch (Exception sqle) {
            try {
                conn.rollback(); // 오류시 롤백
            } catch (SQLException e) {
                e.printStackTrace();
            }
            throw new RuntimeException(sqle.getMessage());
        } finally {
            try{
                if ( pstmt != null ){ pstmt.close(); pstmt=null; }
                if ( conn != null ){ conn.close(); conn=null;    }
            }catch(Exception e){
                throw new RuntimeException(e.getMessage());
            }
        }
    } // end deleteMember


    public DeleteFrom selectById(Connection conn, String userid) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(
					"select * from member where userid = ?");
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			DeleteFrom deleteFrom = null;
			if (rs.next()) {
				deleteFrom = new DeleteFrom(
						rs.getString("userid"), 
						rs.getString("userpassword")
						
						);
			}
			return deleteFrom;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
}

			
		


