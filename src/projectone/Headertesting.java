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
@WebServlet("/head") // be aware of having two classes in the same package with the same address
public class Headertesting extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Enumeration<String> headers = request.getHeaderNames();
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String title = "Header Request";

		// for displaying new changes to page java error variable for errors
		String docType = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " + "Transitional//EN\">\n";
	
		String bgColor, fgColor;
		   
	    String userAgent = request.getHeader("User-Agent");
	    if ((userAgent != null) &&
	            (userAgent.contains("MSIE"))) {
	          bgColor = "YELLOW";
	          fgColor = "RED";
	        } else {
	          bgColor = "GREEN";
	          fgColor = "RED";
	        }
	    
		out.println(
				docType + "<HTML>\n" + "<HEAD><TITLE>" + title + "</TITLE></HEAD>\n" + 
					       "<BODY BGCOLOR=\"" + bgColor + "\" TEXT=\"" + fgColor + "\">\n" 
						+ "<H1 ALIGN=\"CENTER\">" + title + "</H1>\n" + "<CENTER><TABLE BORDER= 1> " +  "<B>Request Method: </B>" +
		                request.getMethod() + "<BR>\n" +
		                "<B>Request URI: </B>" +
		                request.getRequestURI() + "<BR>\n" +
		                "<B>Request Protocol: </B>" +
		                request.getProtocol() + "<BR><BR>\n" );

		while (headers.hasMoreElements()) {
			String header = headers.nextElement();
			String headerValue = request.getHeader(header);
			out.println("<TR><TD>" + header + "</TD> <TD>" + headerValue + "</TD></TR> ");
		}
		out.println("</TABLE></CENTER>" + "</BODY></HTML>");

	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);

	}
}