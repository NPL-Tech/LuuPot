package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author MyPC
 *
 */
public class DBConnect {
	public Connection cn;
	public void getConnection() throws Exception{
		String hostName = "localhost";
		String database = "WebBanHang";
		String userName = "sa";
		String password = "icandoit";
		// Xac dinh he quan tri co so du lieu
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			cn = DriverManager.getConnection("jdbc:sqlserver://"+hostName+":1433;databaseName="+database+";user="+userName+";password="+password);
	}
	public static void main(String[] args) throws Exception {
		DBConnect  c = new DBConnect();
		c.getConnection();
		System.out.println("ok");
	}

}
