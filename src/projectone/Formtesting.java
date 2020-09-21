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
@WebServlet("/add") // be aware of having two classes in the same package with the same address
public class Formtesting extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String errormsg = "password required";
		String title = "Reading Three Request Parameters";

		// for displaying new changes to page java error variable for errors
		String docType = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " + "Transitional//EN\">\n";

		boolean isError = true;

		if (request.getParameter("username") == null || (request.getParameter("username").trim().equals(""))) {
			isError = true;
		} else {

			if (request.getParameter("password") == null || (request.getParameter("password").trim().equals(""))) {
				isError = true;
			} else {

				if (request.getParameter("email") == null || (request.getParameter("email").trim().equals(""))) {
					isError = true;
				}
			}

		}

		String a = replaceNull(request.getParameter("username"));
		String UserPrompt = prompt(request.getParameter("username"), "Username:",
				"You must enter a Username:");
		String b = replaceNull(request.getParameter("password"));
		 String PasswordPrompt =
			      prompt(request.getParameter("password"),
			             "Password:",
			             "You must enter a Password:");
		String c = replaceNull(request.getParameter("email"));
		String emailAddressPrompt =
			      prompt(request.getParameter("email"),
			             "Email Address:",
			             "You must enter an Email Address:");
		
//		String a = checkVal(request.getParameter("username"), "Missing Param1");
//		String b = checkVal(request.getParameter("password"), "Missing Param2");
//		String c = checkVal(request.getParameter("email"), "Missing Param3");
//		
		if (isError) {
			out.println(docType + "<HTML>\n" + "<HEAD><TITLE>" + title + "</TITLE></HEAD>\n"
					+ "<BODY BGCOLOR=\"#FDF5E6\">\n" + "<H1 ALIGN=\"CENTER\">" + title + "</H1>\n"
					+ "<FORM ACTION=\"add\" METHOD=\"POST\" >\n" + UserPrompt + " <INPUT TYPE=\"TEXT\" NAME=\"username\" VALUE=\""
					+ a + "\"><BR>\n" + PasswordPrompt + " <INPUT TYPE=\"password\" NAME=\"password\" VALUE=\""
					+ b + "\"><BR>\n" + emailAddressPrompt
					+ " <INPUT TYPE=\"email\" NAME=\"email\" VALUE=\"" + c + "\"><BR>\n"
					+ "<CENTER><INPUT TYPE=\"SUBMIT\" VALUE=\"submit\">" + "</CENTER>\n</FORM>\n" + "</BODY></HTML>");
		} else {
			out.println(docType + "<HTML>\n" + "<HEAD><TITLE>" + title + "</TITLE></HEAD>\n"
					+ "<BODY BGCOLOR=\"#FDF5E6\">\n" + "<H1 ALIGN=\"CENTER\">" + title + "</H1>\n"
					+ "<FORM ACTION=\"add\" METHOD=\"POST\" >\n" + UserPrompt + " <INPUT TYPE=\"TEXT\" NAME=\"username\" VALUE=\""
					+ a + "\"><BR>\n" + PasswordPrompt + " <INPUT TYPE=\"password\" NAME=\"password\" VALUE=\""
					+ b + "\"><BR>\n" + emailAddressPrompt
					+ " <INPUT TYPE=\"email\" NAME=\"email\" VALUE=\"" + c + "\"><BR>\n"
					+ "<CENTER><INPUT TYPE=\"SUBMIT\" VALUE=\"submit\">" + "</CENTER>\n</FORM>\n" + "</BODY></HTML>");

		}

//		out.println("<p>Username: " + request.getParameter("username") + "</p>");
//		out.println("<p>Password: " + request.getParameter("password") + errormsg + "</p> ");
//		out.println("<p>Email: " + request.getParameter("email") + "</p>");

		out.println("<p>The username is " + a + " password entered is " + b + " and the email " + c + ".</p>");

	}

	/** Returns error message if value is missing or is empty string. */

	protected String checkVal(String orig, String replacement) {
		if ((orig == null) || (orig.trim().equals(""))) {
			return ("<FONT COLOR=RED><B>" + replacement + "</B></FONT>");
		} else {
			return (orig);
		}
	}

	private String prompt(String param, String regularMessage, String warningMessage) {
		if ((param != null) && param.trim().equals("")) {
			return ("<B><FONT COLOR=RED>" + warningMessage + "</FONT></B>");
		} else {
			return (regularMessage);
		}
	}
	
	 /** Replace null with empty String. Return anything else unchanged. */

	  private String replaceNull(String val) {
	    if(val == null) {
	      return("");
	    } else {
	      return(val);
	    }
	  }

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);

	}
}