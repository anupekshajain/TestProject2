package DBConnectionTests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLDatabaseConnection {

	private static final String connectionUrl = "jdbc:sqlserver://BLR-763F163-L\\MSSQLSERVER2017;databaseName=IRISLawBusiness";
	private static final String username = "sa";
	private static final String password = "20Mountain08";

	// Connect to your database.
	// Replace server name, username, and password with your credentials
	public static void main(String[] args) {

		// url = jdbc:sqlserver:hostname\\instance:port;databaseName=dbName;

		try {
			Connection con = DriverManager.getConnection(connectionUrl, username, password);
			System.out.println("Connected to SSMS");
			// Code here.
			// Query to Execute
			String query = "select * from SysParam where SysParamId=47;";
			// Create Statement Object
			Statement stmt = con.createStatement();

			// Execute the SQL Query. Store results in ResultSet
			ResultSet rs = stmt.executeQuery(query);

			// While Loop to iterate through all data and print results
			while (rs.next()) {
				System.out.println("sysParamId"+"\t"+"sysParamName"+"\t"+"sysParamValue");
				String sysParamId = rs.getString(1);
				String sysParamName = rs.getString(2);
				String sysParamValue = rs.getString(3);
				System.out.println(sysParamId +"\t"+ sysParamName+"\t"+sysParamValue);
			}
		}
		// Handle any errors that may have occurred.
		catch (SQLException e) {
			System.out.println("Error occured while connecting");
			e.printStackTrace();
		}
	}
}