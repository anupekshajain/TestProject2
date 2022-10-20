package DBConnectionTests;

import java.sql.ResultSet;

import org.testng.annotations.Test;

import DBConnector.SQLConnector;
import DBConnector.SQLConnector_Ver2;

public class RunSelectQuery {

	@Test
	public void dbTest() {
		String query ="Select * from Users;";
		ResultSet res = SQLConnector_Ver2.executeSelectQuery(query);
		System.out.println("Result : "+res);
		String query2 ="Update Users\r\n"
				+ "Set UserDBRole = 1\r\n"
				+ "where userName = 'SALLY';";
//		int i = SQLConnector_Ver2.executeEditQuery(query2);
//		System.out.println(i);
//		SQLConnector_Ver2.closeDBConnection();
		
	}

}
