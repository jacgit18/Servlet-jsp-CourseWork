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

		 String a = request.getParameter("first");
	        String b = request.getParameter("second");

	        int sum = Integer.parseInt(a) + Integer.parseInt(b);

	        response.setContentType("text/html");
	        PrintWriter out = response.getWriter();
	        out.println("<html><head><title>Add</title></head><body>");

	        out.println("<p>The sum of " + a + " and " + b
	                + " is " + sum + ".</p>");

	        out.println("</body></html>");
	    }
	
	

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);

	}
}