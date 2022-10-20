package DBConnector;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class SQLConnector {

	// Connect to your database.
	// Replace server name, username, and password with your credentials
	public static ResultSet DBConnection(String query) {
		String servName = readProperty().getProperty("SQLServerName");
		String SQLserverName = servName.substring(0, servName.indexOf("\\"));
		String SQLInstanceName = servName.substring(servName.indexOf("\\")+1, servName.length());
		String DBName = readProperty().getProperty("ALBDBName");
		String DBUserName = readProperty().getProperty("DBUserName");
		String DBPassword = readProperty().getProperty("DBPassword");
		ResultSet rs = null;
//		String connectionUrl = "jdbc:sqlserver://" + serverName + ";databaseName=" + DBName;

		String connectionUrl = "jdbc:sqlserver://" + SQLserverName + "\\" + SQLInstanceName + ";databaseName=" + DBName;

//		System.out.println(serverName + "\t" + DBName + "\t" + DBUserName + "\t" + DBPassword);

		System.out.println(connectionUrl);
		// url = jdbc:sqlserver:hostname\\instance:port;databaseName=dbName;

		try {
			Connection con = DriverManager.getConnection(connectionUrl, DBUserName, DBPassword);
			System.out.println("Connected to SSMS");
			// Code here.
			// Query to Execute
//			String query = "select * from SysParam where SysParamId=47;";
			// Create Statement Object
			Statement stmt = con.createStatement();

			// Execute the SQL Query. Store results in ResultSet
			rs = stmt.executeQuery(query);

			// While Loop to iterate through all data and print results
//			while (rs.next()) {
//				System.out.println("sysParamId" + "\t" + "sysParamName" + "\t" + "sysParamValue");
//				String sysParamId = rs.getString(1);
//				String sysParamName = rs.getString(2);
//				String sysParamValue = rs.getString(3);
//				System.out.println(sysParamId + "\t" + sysParamName + "\t" + sysParamValue);
//			}
		}
		// Handle any errors that may have occurred.
		catch (SQLException e) {
			System.out.println("Error occured while connecting");
			e.printStackTrace();
		}
		
		return rs;
	}

	private static Properties readProperty() {
		String credsPath = System.getProperty("user.dir") + "\\credentials.properties";
//		System.out.println(credsPath);
		Properties credentials = new Properties();

		try {
			FileInputStream fi = new FileInputStream(credsPath);
			credentials.load(fi);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return credentials;

	}
}