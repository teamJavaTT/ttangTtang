package member.service;

import java.sql.Connection;
import java.sql.SQLException;


import jdbc.DBConnection;
import jdbc.JdbcUtil;
import member.dao.MemberDao;
import member.model.Member;

public class MemberService {

	private MemberDao memberDao = new MemberDao();

	public void member(MemberRequest memberReq) throws Exception {
		Connection conn = null;
		try {
			conn = DBConnection.getConnection();
			conn.setAutoCommit(false);

			Member member = memberDao.selectById(conn, memberReq.getUserid());
			if (member != null) {
				JdbcUtil.rollback(conn);
				throw new DuplicateIdException();
			}

			memberDao.insert(conn, new Member(memberReq.getUserid(), memberReq.getUname(), memberReq.getUpw(), memberReq.getUpw2(),memberReq.getUemail(),memberReq.getPhone(),memberReq.getSex(),memberReq.getBirth()));
			conn.commit();
		} catch (SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(conn);
		}
	}
}
