package DBConnectionTests;
	
import  java.sql.Connection;		
import  java.sql.Statement;		
import  java.sql.ResultSet;		
import  java.sql.DriverManager;		
import  java.sql.SQLException;		
public class  SQLConnector {				
    	public static void  main(String[] args) throws  ClassNotFoundException, SQLException {													
				//Connection URL Syntax: "jdbc:mysql://ipaddress:portnumber/db_name"		
                String dbUrl = "jdbc:mysql://192.168.29.103:1433/IRISLawBusiness";					

				//Database Username		
				String username = "sa";	
                
				//Database Password		
				String password = "20Mountain08";				

				//Query to Execute		
				String query = "select * from SysParam;";	
                
         	    //Load mysql jdbc driver		
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");		
           
           		//Create Connection to DB		
            	Connection con = DriverManager.getConnection(dbUrl,username,password);
          
          		//Create Statement Object		
        	   Statement stmt = con.createStatement();					
       
       			// Execute the SQL Query. Store results in ResultSet		
         		ResultSet rs= stmt.executeQuery(query);							
         
         		// While Loop to iterate through all data and print results		
				while (rs.next()){
			        		String myName = rs.getString(1);								        
                            String myAge = rs.getString(2);					                               
                            System. out.println(myName+"  "+myAge);		
                    }		
      			 // closing DB Connection		
      			con.close();			
		}
}