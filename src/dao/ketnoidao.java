package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ketnoidao {
	public static Connection cn;
	public void ketnoi() throws Exception {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		System.out.println("Da xac dinh he QTCSDL");
		String url = "jdbc:sqlserver://LAPTOP-N2S29REU:1433;databaseName=QLVinMart; user=sa; password=123";
		cn= DriverManager.getConnection(url);
		System.out.println("Co the qua mon nay");
		
	}
	
	public void ketnoi(String server, String db, String un, String pass) throws Exception {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		System.out.println("Da xac dinh he QTCSDL");
		String url = "jdbc:sqlserver://" + server + ":1433; databaseName=" + db + "; user=" + un + "; password=" + pass;
		cn= DriverManager.getConnection(url);
		System.out.println("Co the qua mon nay");
		
	}
}
