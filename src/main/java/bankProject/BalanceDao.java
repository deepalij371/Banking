package bankProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.http.HttpServletRequest;

public class BalanceDao 
{
	public static AccountBean getBalance(HttpServletRequest req)
	{
	 AccountBean ab1=null;
		
		try 
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","System","Deepali");
			PreparedStatement ps=con.prepareStatement("select * from bankdetails where ACCOUNTNO=? and USERNAME=? and PASSWORD=?");
			ps.setString(1, req.getParameter("acno"));
			ps.setString(2, req.getParameter("name"));
			ps.setString(3, req.getParameter("password"));
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				ab1=new AccountBean();
				ab1.setName(rs.getString(1));
				ab1.setPassword(rs.getString(2));
				ab1.setAmount(rs.getDouble(3));
				ab1.setAddress(rs.getString(4));
				ab1.setPhone(rs.getLong(5));
				ab1.setAccount(rs.getLong(6));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return ab1;
		}
}
