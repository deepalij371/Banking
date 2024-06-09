package bankProject;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/transfer")
public class Transferservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
    	PrintWriter pw=response.getWriter();
    	AccountBean ac=new AccountBean();
    	ac.setAccount(Long.parseLong(request.getParameter("acno")));
    	ac.setName(request.getParameter("name"));
    	ac.setPassword(request.getParameter("password"));
    	ac.setTaccount(Long.parseLong(request.getParameter("TAC")));
    	ac.setAmount(Double.parseDouble(request.getParameter("amount")));
    	
    	System.out.println(ac);
    	 
    	response.setContentType("text/html");
    	try
    	{
    		int n=TransferDao.getTransfer(ac);
    		if(n>0)
    		{
    			request.setAttribute("tran",ac);
    			System.out.println("Transferservlet.doPost()");
    			RequestDispatcher r=request.getRequestDispatcher("transfer.jsp");
    			r.forward(request, response);
    		}
    		else 
    		{
    			pw.print("please check username and password and target accountno....");
    			RequestDispatcher r=request.getRequestDispatcher("Transfer.html");
    			r.include(request, response);
    		}
    	}
    	catch(Exception e)
    	{
    		System.out.println(e);
    	}
}
}
