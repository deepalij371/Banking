package bankProject;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/balance")
public class BalanceServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
       
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
    	response.setContentType("text/html");
    	PrintWriter pw=response.getWriter();
    	
    	AccountBean balance = BalanceDao .getBalance(request);
    	if(balance==null) 
    	{
    		pw.print("check details");
    		RequestDispatcher requestDispatcher = request.getRequestDispatcher("balance.html");
    		requestDispatcher.include(request, response);
    	}
    	else 
    	{
//    		pw.print("phone no:"+balance.getPhone()+" "+"AccountNo:"+balance.getAccount()+" "+"Address:"+balance.getAddress()+" "+"name:"+balance.getName()+" "+"amount:"+balance.getAmount());
    		request.setAttribute("data", balance);
    		RequestDispatcher requestDispatcher = request.getRequestDispatcher("balance.jsp");
    		requestDispatcher.include(request, response);
    	}
    }
}
