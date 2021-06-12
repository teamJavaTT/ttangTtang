package member.service;

import java.sql.Connection;
import java.sql.SQLException;


import jdbc.DBConnection;
import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import member.dao.MemberDao;
import member.model.Member;

public class MemberService {

	private MemberDao memberDao = new MemberDao();

	//회원가입
	public void memberInsert(MemberRequest memberReq) throws Exception {
		Connection conn = null;
		try {
			conn = DBConnection.getConnection();
			conn.setAutoCommit(false);

			Member member = memberDao.selectById(conn, memberReq.getUserid());
			if (member != null) {
				JdbcUtil.rollback(conn);
				throw new DuplicateIdException();
			}

			memberDao.memberInsert(conn, new Member(memberReq.getUserid(), memberReq.getUpw(), memberReq.getUemail(), memberReq.getUname(), memberReq.getPhone(), memberReq.getSex()));
			conn.commit();
		} catch (SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(conn);
		}
	}
	
	// 로그인
	public User login(String id, String password) throws Exception {
		try (Connection conn = DBConnection.getConnection()) {
			Member member = memberDao.selectById(conn, id);
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
}
