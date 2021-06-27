package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import auth.model.Product;
import jdbc.JdbcUtil;
import member.model.Alim;
import member.model.Member;

public class MemberDao {

	

	public Member selectById(Connection conn, String id) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("select * from member where userid = ?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			Member member = null;
			if (rs.next()) {
				member = new Member(rs.getString("userid"), rs.getString("upw"), rs.getString("uemail"),
						rs.getString("uname"), rs.getString("phone"), rs.getString("sex"), rs.getString("address1"),
						rs.getString("address2"), rs.getString("address3"), rs.getString("memberchk"));
			}
			return member;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}

	public void memberInsert(Connection conn, Member mem) throws SQLException {
		try (PreparedStatement pstmt = conn
				.prepareStatement("insert into member values(?,?,?,?,?,?,?,?,?,sysdate,sysdate,null,?)")) {
			pstmt.setString(1, mem.getUserid());
			pstmt.setString(2, mem.getUpw());
			pstmt.setString(3, mem.getUemail());
			pstmt.setString(4, mem.getUname());
			pstmt.setString(5, mem.getPhone());
			pstmt.setString(6, mem.getSex());
			pstmt.setString(7, mem.getAddress1());
			pstmt.setString(8, mem.getAddress2());
			pstmt.setString(9, mem.getAddress3());
			pstmt.setString(10, mem.getMemberChk());
			pstmt.executeUpdate();
		}
	}

	public void memberUpdate(Connection conn, Member member) throws SQLException {
		try (PreparedStatement pstmt = conn.prepareStatement("update member set uname = ?, upw = ? where userid = ?")) {
			pstmt.setString(1, member.getUname());
			pstmt.setString(2, member.getUpw());
			pstmt.setString(3, member.getUserid());
			pstmt.executeUpdate();
		}
	}

	public String memberidFind(Connection conn, String uname, String uemail) throws SQLException {
		ResultSet rs = null;
		String userId = null;

		try (PreparedStatement pstmt = conn.prepareStatement("select userid from member where uname=? and uemail=?")) {

			pstmt.setString(1, uname);
			pstmt.setString(2, uemail);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				userId = rs.getString("userid");
			}
			return userId;
		} finally {
			JdbcUtil.close(rs);

		}

	}

	public String memberpasswordFind(Connection conn, String userid, String uname, String uemail) throws SQLException {
		ResultSet rs = null;
		String upw = null;

		try (PreparedStatement pstmt = conn
				.prepareStatement("select upw from member where userid=? and uname=? and uemail=?")) {

			pstmt.setString(1, userid);
			pstmt.setString(2, uname);
			pstmt.setString(3, uemail);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				upw = rs.getString("upw");
			}
			return upw;
		} finally {
			JdbcUtil.close(rs);

		}

	}

	public void memberEdit(Connection conn, Member mem) throws SQLException {

		try (PreparedStatement pstmt = conn.prepareStatement(
				"update member set upw=?, uemail=?, phone=?, address1=?, address2=?, address3=?, updatetime=sysdate where userid=?")) {
			pstmt.setString(1, mem.getUpw());
			pstmt.setString(2, mem.getUemail());
			pstmt.setString(3, mem.getPhone());
			pstmt.setString(4, mem.getAddress1());
			pstmt.setString(5, mem.getAddress2());
			pstmt.setString(6, mem.getAddress3());
			pstmt.setString(7, mem.getUserid());
			pstmt.executeUpdate();
		}

	}

	public int idCheck(Connection conn, String userid) throws SQLException {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int value = 0;

		try {
			String sql = "select userid from member where userid = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();

			if (rs.next())
				value = 1;

		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
		return value;
	}

	public ArrayList<String> addressSelect(Connection conn, String userid) throws SQLException {
		ResultSet rs = null;
		ArrayList<String> address = new ArrayList<String>();
		try (PreparedStatement pstmt = conn.prepareStatement("select address1,address2,address3 from member where userid=? ")) {

			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				address.add(rs.getString("address1"));
				address.add(rs.getString("address2"));
				address.add(rs.getString("address3"));
				
			}
			return address;
		} finally {
			JdbcUtil.close(rs);

		}

	}

}
