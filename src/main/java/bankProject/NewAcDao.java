package bankProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class NewAcDao 
{
	public static int Account1(AccountBean ac)
	{
		int k=0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","System","Deepali");
			PreparedStatement p1=con.prepareStatement("insert into bankdetails values(?,?,?,?,?,accountnumber.nextval)");
			p1.setString(1,  ac.getName());
			p1.setString(2,  ac.getPassword());
			p1.setString(4,  ac.getAddress());
			p1.setLong(5,    ac.getPhone());
			p1.setDouble(3,  ac.getAmount());
		    k=p1.executeUpdate();
			System.out.println("data inserted successfully........");

		     }
		catch(Exception e)
		{
			System.out.println(e);
		}
		return k;
	}
}
	