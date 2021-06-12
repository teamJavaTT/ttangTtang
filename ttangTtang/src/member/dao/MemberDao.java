package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.JdbcUtil;
import member.model.Member;

public class MemberDao {

	public Member selectById(Connection conn, String id) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(
					"select * from member where userid = ?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			Member member = null;
			if (rs.next()) {
				member = new Member(
						rs.getString("userid"), 
						rs.getString("upw"),
						rs.getString("uemail"),
						rs.getString("uname"),
						rs.getString("phone"),
						rs.getString("sex")
						);
			}
			return member;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}


	public void memberInsert(Connection conn, Member mem) throws SQLException {
		try (PreparedStatement pstmt = 
				conn.prepareStatement("insert into member values(?,?,?,?,?,?,null,null,null,sysdate,sysdate,null,1)")) {
			pstmt.setString(1, mem.getUserid());
			pstmt.setString(2, mem.getUpw());
			pstmt.setString(3, mem.getUemail());
			pstmt.setString(4, mem.getUname());	
			pstmt.setString(5, mem.getPhone());
			pstmt.setString(6, mem.getSex());
			pstmt.executeUpdate();
		}
	}

	public void memberUpdate(Connection conn, Member member) throws SQLException {
		try (PreparedStatement pstmt = conn.prepareStatement(
				"update member set uname = ?, upw = ? where userid = ?")) {
			pstmt.setString(1, member.getUname());
			pstmt.setString(2, member.getUpw());
			pstmt.setString(3, member.getUserid());
			pstmt.executeUpdate();
		}
	}
}
