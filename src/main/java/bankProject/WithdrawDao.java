package bankProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class WithdrawDao 
{
	public static int getWithdraw(AccountBean ac)
	{
		int k=0;
		try 
		{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","System","Deepali");
		PreparedStatement ps=con.prepareStatement("update bankdetails set AMOUNT=AMOUNT-? where USERNAME=? and PASSWORD=? and ACCOUNTNO=?");
		ps.setDouble(1, ac.getAmount());
		ps.setString(2,ac.getName());
		ps.setString(3, ac.getPassword());
		ps.setDouble(4, ac.getAccount());
		k=ps.executeUpdate();
		if(k>0)
		{
			PreparedStatement p1=con.prepareStatement("select AMOUNT from bankdetails where ACCOUNTNO=?");
			p1.setDouble(1, ac.getAmount());
			ResultSet r=p1.executeQuery();
			while(r.next())
			{
				ac.setAmount(r.getDouble(1));
			}
		}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return k;
}
}
