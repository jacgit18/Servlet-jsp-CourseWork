package projectone;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GetName")
public class list extends HttpServlet{
	
	@Override
	public void doGet(HttpServletRequest request, 
						HttpServletResponse response)
		throws ServletException, IOException{
			
		
		// Always define response first
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<!DOCTYPE html>");
        out.println("<head><title> Test </title></head>");
        out.println("<body>");
        out.println(
        		 request.getParameter("lastName") +
        		 request.getParameter("firstName") 
        		
        		);



	        
	        out.println("</body></html>");
		


	}	
	

	
	@Override
	public void doPost(HttpServletRequest request, 
						HttpServletResponse response)
		throws ServletException, IOException{
		
		doGet(request, response);


	}	
}