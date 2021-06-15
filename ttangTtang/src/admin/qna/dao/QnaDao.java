package admin.qna.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import admin.qna.model.Qnacolumn;
import jdbc.JdbcUtil;

public class QnaDao {
	public Qnacolumn qnaInsert(Connection conn, Qnacolumn qna) throws SQLException {
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;
		// insert 부분 구문
		try {
			pstmt = conn.prepareStatement("insert into qna values (qna_seq.NEXTVAL,?,?,?,sysdate,'N',null,null)");

			pstmt.setString(1, qna.getUserId());
			pstmt.setString(2, qna.getQtit());
			pstmt.setString(3, qna.getQtext());
			int insertedCount = pstmt.executeUpdate();

			if (insertedCount > 0) {
				stmt = conn.createStatement();
				rs = stmt.executeQuery("select max(qno) from Qna");
				if (rs.next()) {
					Integer newNo = rs.getInt(1);
					return new Qnacolumn(newNo, qna.getUserId(), qna.getQtit(), qna.getQtext(), qna.getQdate(), "N", null, null);
				}
			}
			return null;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
			JdbcUtil.close(pstmt);
		}
	}
	// insert 부분 구문끝
	// select 부분 시작
	
	public int selectCount(Connection conn) throws SQLException{
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select count(*) from qna");
			if(rs.next()) {
				return rs.getInt(1);
			}
			return 0;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}
		
	}
	
	
	public List<Qnacolumn> qnaSelect(Connection conn, int startNo, int endNo) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("select * from (select  row_number() over (order by qno desc) num, A.* from qna A order by qno desc) where num between ? and ?");
			pstmt.setInt(1, startNo);
			pstmt.setInt(2, endNo);
			rs = pstmt.executeQuery();
			List<Qnacolumn> result = new ArrayList<>();
			while (rs.next()) {
				result.add(qnaConvert(rs));
			}
			return result;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
	
	public Qnacolumn qnaReadSelect(Connection conn, int no) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(
					"select * from qna where qno = ?");
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			Qnacolumn qnaColumn = null;
			if (rs.next()) {
				qnaColumn = qnaConvert(rs);
			}
			return qnaColumn;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
	
	/*
	 * public List<Noticecolumn> selectNotice(Connection conn) throws SQLException {
	 * PreparedStatement pstmt = null; ResultSet rs = null; try { pstmt =
	 * conn.prepareStatement("select * from notice order by mno"); rs =
	 * pstmt.executeQuery(); List<Noticecolumn> result = new ArrayList<>(); while
	 * (rs.next()) { result.add(convertNotice(rs)); } return result; } finally {
	 * JdbcUtil.close(rs); JdbcUtil.close(pstmt); } }
	 */	
	private Qnacolumn qnaConvert(ResultSet rs) throws SQLException {
		return new Qnacolumn(rs.getInt("qno"), rs.getString("userid"), rs.getString("qtit"), rs.getString("qtext"), rs.getDate("qdate"), rs.getString("patext"), rs.getString("qstext"), rs.getDate("qsdate")); // null에 아이디 추가
	}
	// select 부분 끝
	
	
	// 조회수 올리는 것
	/*
	 * public void increaseReadCount(Connection conn, int no) throws SQLException {
	 * try (PreparedStatement pstmt = conn.
	 * prepareStatement("update notice set read_cnt = read_cnt + 1 where mno = ?"))
	 * { pstmt.setInt(1, no); pstmt.executeUpdate(); } }
	 */
	//업데이트
	public Qnacolumn qnaUpdate(Connection conn, Qnacolumn qna) throws SQLException {
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("update qna set qtit = ?, qtext = ? where qno = ?");
			pstmt.setString(1, qna.getQtit());
			pstmt.setString(2, qna.getQtext());
			pstmt.setInt(3, qna.getQno());
			int insertedCount = pstmt.executeUpdate();

			if (insertedCount > 0) {
				stmt = conn.createStatement();
				rs = stmt.executeQuery("select max(qno) from qna");
				if (rs.next()) {
					Integer newNo = rs.getInt(1);
					return new Qnacolumn(newNo, qna.getUserId(), qna.getQtit(), qna.getQtext(), qna.getQdate(), "N", null, null); // null에 아이디 추가
				}
			}
		return null;
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
			JdbcUtil.close(pstmt);
		}
	}
	
	// 삭제
	public int qnaDelete(Connection conn, int delNo) throws SQLException {
		try (PreparedStatement pstmt = conn.prepareStatement("delete from qna where qno = ?")) {
			pstmt.setInt(1, delNo);
			return pstmt.executeUpdate();
		}
	}
	
	//댓글
	public Qnacolumn qnaAnswerUpdate(Connection conn, int delNo, String answerContent) throws SQLException {
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("update qna set patext = 'Y', qstext = ?, qsdate = sysdate where qno = ?");
			pstmt.setString(1, answerContent);
			pstmt.setInt(2, delNo);
			pstmt.executeUpdate();

			return null;
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
			JdbcUtil.close(pstmt);
		}
	}
	public Qnacolumn qnaAnswerReUpdate(Connection conn, int qNo) throws SQLException {
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("update qna set patext = 'N' where qno = ?");
			pstmt.setInt(1, qNo);
			pstmt.executeUpdate();

			return null;
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
			JdbcUtil.close(pstmt);
		}
	}
}
