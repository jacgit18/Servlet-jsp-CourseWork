package projectone;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/registration-results")
public class AdvancedFormQ6 extends HttpServlet {
	  @Override
	  public void doGet(HttpServletRequest request,
	                    HttpServletResponse response)
	      throws ServletException, IOException {
	    String errorData = "";
	    boolean isComplete = true;
	    String firstName = request.getParameter("firstName");
	    errorData = errorData + "firstName=" + firstName;
	    if(isMissing(firstName)) {
	      isComplete = false;
	    }
	    String lastName = request.getParameter("lastName");
	    errorData = errorData + "&lastName=" + lastName;
	    if(isMissing(lastName)) {
	      isComplete = false;
	    }
	    String emailAddress = request.getParameter("emailAddress");
	    errorData = errorData + "&emailAddress=" + emailAddress;
	    if(isMissing(emailAddress)) {
	      isComplete = false;
	    }
	    if (isComplete) { // No missing form data
	      response.setContentType("text/html");
	      PrintWriter out = response.getWriter();
	      String title = "Registering";
	      String docType =
	        "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
	        "Transitional//EN\">\n";
	      out.println(docType +
	                  "<HTML>\n" +
	                  "<HEAD><TITLE>" + title + "</TITLE></HEAD>\n" +
	                  "<BODY BGCOLOR=\"#FDF5E6\">\n" +
	                  "<H1 ALIGN=\"CENTER\">" + title + "</H1>\n" +
	                  "<UL>\n" +
	                  "  <LI><B>First Name</B>: " +
	                  firstName + "\n" +
	                  "  <LI><B>Last Name</B>: " +
	                  lastName + "\n" +
	                  "  <LI><B>Email address</B>: " +
	                  emailAddress + "\n" +
	                  "</UL>\n" +
	                  "</BODY></HTML>");
	    } else { // Missing form data
//	      response.sendRedirect("registration-form"
//	                            + "?" + errorData);
		      PrintWriter out = response.getWriter();

	    	out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">\n" + 
	    			"<HTML>\n" + 
	    			"<HEAD><TITLE>Registration Form</TITLE></HEAD>\n" + 
	    			"<BODY BGCOLOR=\"#FDF5E6\">\n" + 
	    			"<H1 ALIGN=\"CENTER\">Registration Form</H1>\n" + 
	    			"\n" + 
	    			"<FORM ACTION=\"register\">\n" + 
	    			"  First Name:  <INPUT TYPE=\"TEXT\" NAME=\"firstName\"><BR>\n" + 
	    			"  Last Name: <INPUT TYPE=\"TEXT\" NAME=\"lastName\"><BR>\n" + 
	    			"  Email Address:  <INPUT TYPE=\"TEXT\" NAME=\"emailAddress\"><BR>\n" + 
	    			"  <CENTER><INPUT TYPE=\"SUBMIT\" VALUE=\"Register\"></CENTER>\n" + 
	    			"</FORM>\n" + 
	    			"\n" + 
	    			"</BODY></HTML>");
	    	
//	    	out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">\n" + 
//	    			"<HTML>\n" + 
//	    			"<HEAD><TITLE>Registration Form</TITLE></HEAD>\n" + 
//	    			"<BODY BGCOLOR=\"#FDF5E6\">\n" + 
//	    			"<H1 ALIGN=\"CENTER\">Registration Form</H1>\n" + 
//	    			"\n" + 
//	    			"<FORM ACTION=\"register\">\n" + 
//	    			"  First Name:  <INPUT TYPE=\"TEXT\" NAME=\"firstName\" VALUE='" + firstName "'><BR>\n" + 
//	    			"  Last Name: <INPUT TYPE=\"TEXT\" NAME=\"lastName\"><BR>\n" + 
//	    			"  Email Address:  <INPUT TYPE=\"TEXT\" NAME=\"emailAddress\"><BR>\n" + 
//	    			"  <CENTER><INPUT TYPE=\"SUBMIT\" VALUE=\"Register\"></CENTER>\n" + 
//	    			"</FORM>\n" + 
//	    			"\n" + 
//	    			"</BODY></HTML>");
	    }
	  }

	  /** Returns true if value is missing or is empty string. */

	  private boolean isMissing(String param) {
	    return((param == null) || (param.trim().equals("")));
	  }
	}

	
	
	

