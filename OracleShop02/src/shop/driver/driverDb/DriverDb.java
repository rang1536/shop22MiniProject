package shop.driver.driverDb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DriverDb {
	public static Connection driverDbcon() throws ClassNotFoundException, SQLException{
		System.out.println("01 드라이버로딩 및 DB연결 driverDbcon DriverDB.java");
		Connection reconn = null;
		Class.forName("com.mysql.jdbc.Driver");
		String jdbcDriver = "jdbc:mysql://localhost:3306/shop22?useUnicode=true&characterEncoding=euc-kr";
		String dbUser = "root";
		String dbPass = "java0000";
		reconn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
		
		return reconn;
	}
}
