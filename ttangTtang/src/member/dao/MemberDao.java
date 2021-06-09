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
					"select * from board.member where memberid = ?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			Member member = null;
			if (rs.next()) {
				member = new Member(
						rs.getString("userid"), 
						rs.getString("uname"), 
						rs.getString("upw"),
						rs.getString("upw2"),
						rs.getString("uemail"),
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


	public void insert(Connection conn, Membr mem) throws SQLException {
		try (PreparedStatement pstmt = 
				conn.prepareStatement("insert into board.member values(?,?,?,?,?,?,?)")) {
			pstmt.setString(1, mem.getUserid());
			pstmt.setString(2, mem.getUname());
			pstmt.setString(3, mem.getUpw());
			pstmt.setString(4, mem.getUpw2());
			pstmt.setString(5, mem.getUemail());	
			pstmt.setString(6, mem.getPhone());
			pstmt.setString(67, mem.getSex());		
			
		}
	}

	public void update(Connection conn, Member member) throws SQLException {
		try (PreparedStatement pstmt = conn.prepareStatement(
				"update board.member set name = ?, password = ? where memberid = ?")) {
			pstmt.setString(1, member.getUname());
			pstmt.setString(2, member.getUpw());
			pstmt.setString(3, member.getUserid());
			pstmt.executeUpdate();
		}
	}
}
