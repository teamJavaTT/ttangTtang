package mypage.service;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import admin.notice.model.Notice;
import admin.notice.model.Noticecolumn;
import jdbc.DBConnection;
import jdbc.JdbcUtil;
import mypage.dao.DeleteFormDao;
import mypage.model.DeleteFormcolumn;

public class DeleteFormService {

	private DeleteFormDao deleteFormDao = new DeleteFormDao();

	
	public void getDeleteform(String delmember) throws SQLException, Exception {
		try(Connection conn = DBConnection.getConnection()){
			deleteFormDao.memberUpdate(conn, delmember);
		}
	}

	
//수정

	public Integer noticeMod(int delMember, Notice modReq) throws Exception {
		Connection conn = null;
		try {
			conn = DBConnection.getConnection();
			conn.setAutoCommit(false);

			DeleteFormcolumn delete = todeleteMod(delMember, modReq);
			DeleteFormcolumn savedArticle = deleteFormDao.deleteUpdate(conn, delete);
			if (savedArticle == null) {
				throw new RuntimeException("fail to update");
			}
			conn.commit();

			return savedArticle.getMno();
		} catch (SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		} catch (RuntimeException e) {
			JdbcUtil.rollback(conn);
			throw e; 
		} finally {
			JdbcUtil.close(conn);
		}
	}
	private DeleteFormcolumn todeleteMod(int delMember, Notice modReq) {
		// TODO Auto-generated method stub
		return null;
	}


	// 수정 끝
	private DeleteFormcolumn toDeleteMod(String userId, String uEmail, String uName, String phone, String sex, Date dateTime, Integer memberChk) {
		Date now = new Date();
		return new DeleteFormcolumn(userId, req.getMtit(), req.getMtext(), now);
	}

	//업데이트
		public DeleteFormcolumn deleteUpdate(Connection conn, DeleteFormcolumn delete) throws SQLException {
			PreparedStatement pstmt = null;
			Statement stmt = null;
			ResultSet rs = null;
			try {
				pstmt = conn.prepareStatement("update delete set mtit = ?, mtext = ? where mno = ?");
				pstmt.setString(1, delete.getMtit());
				pstmt.setString(2, delete.getMtext());
				pstmt.setInt(3, delete.getMno());
				int insertedCount = pstmt.executeUpdate();

				if (insertedCount > 0) {
					stmt = conn.createStatement();
					rs = stmt.executeQuery("select max(mno) from Notice");
					if (rs.next()) {
						Integer newNo = rs.getInt(1);
						return new DeleteFormcolumn(newNo, delete.getMtit(), delete.getMtext(), delete.getMdate());
					}
				}
			return null;
			}finally {
				JdbcUtil.close(rs);
				JdbcUtil.close(stmt);
				JdbcUtil.close(pstmt);
			}
		}
}