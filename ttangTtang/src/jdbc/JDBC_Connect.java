package jdbc;

import java.sql.*;

public class JDBC_Connect {

	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";

		Connection con = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, "auction", "auc");
			System.out.println("�����ͺ��̽� ���� ����~!!");
		} catch (Exception e) {
			System.out.println("�����ͺ��̽� ���� ����~!!");
			e.printStackTrace();
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
