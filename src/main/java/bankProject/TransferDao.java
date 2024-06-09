package bankProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class TransferDao 
{
	public static int getTransfer(AccountBean a)
	{
	int y=0;
	int x=0;
		try 
		{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","System","Deepali");
		con.setAutoCommit(false);
		PreparedStatement p1=con.prepareStatement("update bankdetails set AMOUNT=AMOUNT-? where USERNAME=? and PASSWORD=? and ACCOUNTNO=?");
		p1.setDouble(1,a.getAmount());
		p1.setString(2,a.getName());
		p1.setString(3,a.getPassword());
		p1.setLong(4,  a.getAccount());
		
		y=p1.executeUpdate();
		
		PreparedStatement p2=con.prepareStatement("update bankdetails set AMOUNT=AMOUNT+? where ACCOUNTNO=?");
		p2.setDouble(1, a.getAmount());
		p2.setLong(2,   a.getTaccount());
		x=p1.executeUpdate();
		if(x>0)
		{
			con.commit();
		}
		else {
			con.rollback();
		}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return x+y;
		}
}
