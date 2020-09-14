package projectone;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/add")
public class Formtesting extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		  String a = request.getParameter("username");
	        String b = request.getParameter("password");
	        String c = request.getParameter("email");

	        String docType = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " + "Transitional//EN\">\n";

			response.setContentType("text/html");
	        PrintWriter out = response.getWriter();
	        
	        String errormsg = "password required";
			if ((a == null) || (b.trim().equals("") || c.trim().equals(""))) {
				out.println("enter info");
	            //response.sendRedirect( "invalid.html" );
	            //return ;
	        }		
		
		
			
        
   
        
        
        out.println("<p>Username: "
                + request.getParameter("username") + "</p>");
        out.println("<p>Password: "
                + request.getParameter("password")
                + errormsg + "</p> " );
        out.println("<p>Email: "
                + request.getParameter("email") + "</p>");
        
      
        out.println("<p>The username is " + a + " and password entered is " + b
                + ".</p>");
        
        out.println("</body></html>");
	    }
	
	

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);

	}
}