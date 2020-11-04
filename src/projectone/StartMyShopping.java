package projectone;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/shopping-start")
public class StartMyShopping extends HttpServlet {

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// public void doGet(HttpServletRequest request, HttpServletResponse
		// response) throws ServletException, IOException {

		HttpSession session = request.getSession();

		synchronized (session) {
		

			/*
			 *  * 2. (10 pts) From StartMyShopping.java, does following: This page
			 * has one shopping item text box that user can type any item but
			 * blank with "Add to Shopping List" button to add to shopping list
			 * (shoppingList.java). If user types blank and submit "Add" button,
			 * system should show same page with error message
			 * "Please enter shopping item." next to the shopping item text box.
			 * 
			 */
			String title = "Start Shopping";
//			 String errorData = "";
//			    boolean isComplete = true;
			    String firstName = request.getParameter("firstName");
//			    errorData = errorData + "firstName=" + firstName;
//			    if(isMissing(firstName)) {
//			      isComplete = false;
//			    }
//		    if (isComplete) { // No missing form data

			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
		
//			Enumeration enum = request.getHeaderNames();  
//	        while (enum.hasMoreElements()) {  
//	        String headerName = (String) enum.nextElement();  
//	        String headerValue = request.getHeader(headerName);  
//	       out.print("<b>"+headerName + "</b>: ");  
//	        out.println(headerValue + "<br>");  
			
			


			String docType = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " + "Transitional//EN\">\n";

			
				out.println(docType + "<HTML>\n" + "<HEAD><TITLE>" + title + "</TITLE></HEAD>\n"
						+ "<BODY BGCOLOR=\"#FDF5E6\">\n" + "<H1>" + title + "</H1>"
						
						+ " <LI><B>First Name</B>:" + firstName +
						
						   request.getMethod() + "<BR>\n" +
			                "<B>Request URI: </B>" +
			                request.getRequestURI() + "<BR>\n" +
			                "<B>Request Protocol: </B>" +
			                request.getProtocol() + "<BR><BR>\n" 
			                
			                
						);
				   Enumeration<String> headerNames = request.getHeaderNames();
				    while(headerNames.hasMoreElements()) {
				      String headerName = headerNames.nextElement();
				      out.println("<TR><TD>" + headerName);
				      out.println("    <TD>" + request.getHeader(headerName));
				    }

			  
				out.println(""
						+ "<FORM ACTION=\"registration-results\">\n" +
       " <INPUT TYPE=\"TEXT\" NAME=\"firstName\" VALUE=\"" + firstName +
      
       
      
    
       "<CENTER><INPUT TYPE=\"SUBMIT\" VALUE=\"Register\">" +
       "</CENTER>\n</FORM>\n" 
						
						
						);

				 
				out.println("</BODY></HTML>");
//		    } else { // Missing form data
//			      response.sendRedirect("registration-form"
//                        + "?" + errorData);
//		    }
		}

				    
		    
				     
				 

				  /** Returns true if value is missing or is empty string. */

			

				// if (previousItems.size() == 0) {
				// out.println("<I>No items</I>");
				// } else {

				// work here
				// out.println("<UL>");
				// for(String item: previousItems) {
				// out.println(" <LI>" + item);
				// }
				// out.println("</UL>");
				// }

				
//			
  
	

		}

	
			  private boolean isMissing(String param) {
				    return((param == null) || (param.trim().equals("")));
				  }

	// public void doPost(HttpServletRequest request, HttpServletResponse
	// response) throws ServletException, IOException{

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		// doGet(request, response);

	}

}