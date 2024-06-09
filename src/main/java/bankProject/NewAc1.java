package bankProject;

import jakarta.security.auth.message.callback.PrivateKeyCallback.Request;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

@WebServlet("/nac")
public class NewAc1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
    	response.setContentType("text/html");
    	PrintWriter pw=response.getWriter();
    	AccountBean a1=new AccountBean();
    	a1.setName(request.getParameter("name"));
    	a1.setPassword(request.getParameter("password"));
    	a1.setAmount(Double.parseDouble(request.getParameter("amount")));
    	a1.setAddress(request.getParameter("address"));
    	a1.setPhone(Long.parseLong(request.getParameter("phone")));
    	String s1=request.getParameter("password");
    	String s2=request.getParameter("re-password");
    	
    	if(!s1.equals(s2))
    	{
    		pw.print("password should be match");
    		RequestDispatcher rd = request.getRequestDispatcher("newAccount.html");
    		rd.include(request, response);
    	}
    	else 
    	{
    		int k=NewAcDao.Account1(a1);
    		if(k>0)
    		{
    		    request.setAttribute("data", a1);
    			RequestDispatcher rd=request.getRequestDispatcher("view.jsp");
    			rd.forward(request, response);
    		}
    		}
    	}
}
