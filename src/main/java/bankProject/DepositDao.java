package bankProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.http.HttpServletRequest;

public class DepositDao 
{
	public static int getDeposite(AccountBean a)
	{
		int k=0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","System","Deepali");
			PreparedStatement ps=con.prepareStatement("update bankdetails set AMOUNT=AMOUNT+? where  USERNAME=? and PASSWORD=? and ACCOUNTNO=?");
		    ps.setDouble(1,a.getAmount());
		    ps.setString(2,a.getName());
		    ps.setString(3,a.getPassword());
		    ps.setDouble(4,a.getAccount());
		    k=ps.executeUpdate();
		    if(k>0)
		    {
		    	PreparedStatement p1=con.prepareStatement("select AMOUNT from bankdetails where ACCOUNTNO=?");
		    	p1.setDouble(1, a.getAmount());
		    	ResultSet rs=p1.executeQuery();
		    	while(rs.next())
		    	{
		    		a.setAmount(rs.getDouble(1));
		    	}
		    	}
		    }
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return k;
	}
}
