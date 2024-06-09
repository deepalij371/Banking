package bankProject;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Deposite")
public class DepositeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
//		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		AccountBean a2=new AccountBean();
		a2.setAccount(Long.parseLong(request.getParameter("acno")));
		a2.setName(request.getParameter("name"));
		a2.setPassword(request.getParameter("password"));
		a2.setAmount(Double.parseDouble(request.getParameter("amount")));
		response.setContentType("text/html");
		try 
		{
			System.out.println(a2);
			int n=DepositDao.getDeposite(a2);
			if(n>0)
			{
				request.setAttribute("depos",a2);
				RequestDispatcher r1=request.getRequestDispatcher("deposite.jsp");
				r1.forward(request, response);
			}
			else
			{
				pw.println("username and password is wrong....");
				RequestDispatcher r1=request.getRequestDispatcher("Deposite.html");
				r1.include(request, response);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
			
		}
		}
}
