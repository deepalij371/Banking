package bankProject;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/closeac")
public class CloseServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
    	PrintWriter pw=response.getWriter();
    	response.setContentType("text/html");
    	AccountBean ac=new AccountBean();
    	ac.setAccount(Long.parseLong(request.getParameter("acno")));
    	ac.setName(request.getParameter("name"));
    	ac.setPassword(request.getParameter("password"));
//    	response.setContentType("text/html");
    	try 
    	{
    		int n=CloseAccount.getClose(ac);
    		if(n>0)
    		{
    			pw.println("account deleted.....");
    			request.setAttribute("close", ac);
    			RequestDispatcher r=request.getRequestDispatcher("closeAccout.jsp");
    			r.forward(request, response);
    		}
    		else 
    		{
    			pw.print("please check username and password..");
    			RequestDispatcher r=request.getRequestDispatcher("closeAcount.html");
    			r.include(request, response);
    		}
    	}
    	catch(Exception e)
    	{
    		System.out.println(e);
    	}
    }
}
