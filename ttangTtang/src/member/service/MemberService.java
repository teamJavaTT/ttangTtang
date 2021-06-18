package member.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.DBConnection;
import jdbc.JdbcUtil;
import member.dao.MemberDao;
import member.model.Member;

public class MemberService {

	private MemberDao memberDao = new MemberDao();

	// id로 member 테이블 select
	public Member selectById(String Userid) throws Exception {
		Connection conn = null;
		try {
			conn = DBConnection.getConnection();
			// DAO 객체를 생성 시 Connection 전달
			MemberDao memberDao = new MemberDao();
			Member member = memberDao.selectById(conn, Userid);
			return member;
		} catch (SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(conn);
		}
	}

	// �쉶�썝媛��엯
	public void memberInsert(MemberRequest memberReq) throws Exception {
		Connection conn = null;
		try {
			conn = DBConnection.getConnection();
			conn.setAutoCommit(false);

			Member member = selectById(memberReq.getUserid());
			if (member != null) {
				JdbcUtil.rollback(conn);
				throw new DuplicateIdException();
			}

			memberDao.memberInsert(conn,
					new Member(memberReq.getUserid(), memberReq.getUpw(), memberReq.getUemail(), memberReq.getUname(),
							memberReq.getPhone(), memberReq.getSex(), memberReq.getAddress1(), memberReq.getAddress2(),
							memberReq.getAddress3()));
			conn.commit();
		} catch (SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(conn);
		}
	}

	// 濡쒓렇�씤
	public User login(String id, String password) throws Exception {
		try (Connection conn = DBConnection.getConnection()) {
			Member member = selectById(id);
			if (member == null) {
				throw new LoginFailException();
			}
			if (!member.matchPassword(password)) {
				throw new LoginFailException();
			}
			return new User(member.getUserid(), member.getUname());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public String memberidFind(String Uname, String Uemail) throws Exception {
		Connection conn = null;

		try {
			conn = DBConnection.getConnection();
			// DAO 객체를 생성 시 Connection 전달
			MemberDao memberDao = new MemberDao();
			String userId = memberDao.memberidFind(conn, Uname, Uemail);
			return userId;
		}

		finally {
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {
				}
			;

		}

	}

	public String memberpasswordFind(String Userid, String Uname, String Uemail) throws Exception {
		Connection conn = null;

		try {
			conn = DBConnection.getConnection();
			// DAO 객체를 생성 시 Connection 전달
			MemberDao memberDao = new MemberDao();
			String upw = memberDao.memberpasswordFind(conn, Userid, Uname, Uemail);
			return upw;
		} finally {
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {
				}
			;

		}

	}

	public void memberEdit(MemberRequest memberEdit) throws Exception {
		Connection conn = null;
		try {
			conn = DBConnection.getConnection();
			conn.setAutoCommit(false);

			Member member = selectById(memberEdit.getUserid());
			if (member == null) {
				JdbcUtil.rollback(conn);
				throw new DuplicateIdException();
			}

			memberDao.memberEdit(conn,
					new Member(memberEdit.getUserid(), memberEdit.getUpw(), memberEdit.getUemail(),
							memberEdit.getUname(), memberEdit.getPhone(), memberEdit.getSex(), memberEdit.getAddress1(),
							memberEdit.getAddress2(), memberEdit.getAddress3()));
			conn.commit();
		} catch (SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(conn);
		}
	}

}
