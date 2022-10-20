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

public class SQLConnector_Ver2 {

	public static String servName = readProperty().getProperty("SQLServerName");
	public static String SQLserverName = servName.substring(0, servName.indexOf("\\"));
	public static String SQLInstanceName = servName.substring(servName.indexOf("\\") + 1, servName.length());
	public static String DBName = readProperty().getProperty("ALBDBName");
	public static String DBUserName = readProperty().getProperty("DBUserName");
	public static String DBPassword = readProperty().getProperty("DBPassword");
	public static String connectionUrl = "jdbc:sqlserver://" + SQLserverName + "\\" + SQLInstanceName + ";databaseName="
			+ DBName;
	public static Connection con;

	public static void connectDB() {

		try {
			// Connect to your database.

			con = DriverManager.getConnection(connectionUrl, DBUserName, DBPassword);
			System.out.println("Connected to SSMS");
		}
		// Handle any errors that may have occurred.
		catch (SQLException e) {
			System.out.println("Error occured while connecting");
			e.printStackTrace();
		}
	}

	public static ResultSet executeSelectQuery(String query) {

		connectDB();
		ResultSet rs = null;
		Statement stmt;
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rs;
	}

	public static int executeEditQuery(String query) {

		int rs = 0;
		connectDB();
		Statement stmt;
		try {
			stmt = con.createStatement();
			rs = stmt.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rs;
	}

	private static Properties readProperty() {
		String credsPath = System.getProperty("user.dir") + "\\credentials.properties";
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

	public static void closeDBConnection() {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}