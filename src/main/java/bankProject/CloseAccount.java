package bankProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class CloseAccount 
{
	public static int getClose(AccountBean b)
	{
		int k=0;
		try 
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","System","Deepali");
			PreparedStatement ps=con.prepareStatement("delete from bankdetails where ACCOUNTNO=? and USERNAME=? and PASSWORD=?");
			ps.setLong(1,b.getAccount());
			ps.setString(2,b.getName());
			ps.setString(3,b.getPassword());
			k=ps.executeUpdate();
	    }
		
		catch(Exception e)
		{
			System.out.println(e);
		}
		return k;
	}

}
