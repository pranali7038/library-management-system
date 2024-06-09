package project;
import java.sql.*;

public class ConnectionProvider {
	public static Connection getCon()
	{
		try{
			 Class.forName("com.mysql.cj.jdbc.Driver");
             Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/lms","root","");
             return con;
             
		}
		catch(Exception ae){
			System.out.println(ae);
			return null;
			
		}
	}
}
