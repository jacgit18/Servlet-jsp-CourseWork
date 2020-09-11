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
@WebServlet("/getform")
public class Formtesting extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String param1 = request.getParameter("param1");
		String errormsg = "param 1 required";

		if ((param1 == null) || (param1.trim().equals(""))) {
			out.print("Please enter name Right now");

		} else {
			out.print(param1);

			}
		
		// do single qoutes for html values
		String title = "Reading Three Request Parameters";
		String docType = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " + "Transitional//EN\">\n";
		out.println(docType + 
		"<HTML> <HEAD> <TITLE>Collecting Three Parameters</TITLE> </HEAD>" +
		"<BODY BGCOLOR='#FDF5E6'>" +
			"<H1 ALIGN=\"CENTER\">Collecting Three Parameters</H1>" +

			"<FORM ACTION='getform' METHOD='POST'>" +
				"First Parameter: (Required): <INPUT TYPE='TEXT' NAME='param1 VALUE='" + request.getParameter("param1") + "'>" + errormsg +"<BR>"
				+"Second Parameter: <INPUT TYPE='TEXT' NAME='param2' VALUE='" + request.getParameter("param2") + "'><BR>"
				+"Third Parameter: <INPUT TYPE='TEXT' NAME='param3' VALUE='" + request.getParameter("param3") + "'><BR>"
				+"<CENTER>"
					+"<INPUT TYPE='SUBMIT'>"
				+"</CENTER>"
			+"</FORM>" +

		"</BODY></HTML>");
		// + " <LI><B>param1</B>: ");

		
		
	
		Enumeration<String> paramNames = request.getParameterNames();
		while (paramNames.hasMoreElements()) {
			String paramName = (String) paramNames.nextElement();
			out.print("<TR><TD>" + paramName + "\n<TD>");
			
			String[] paramValues = request.getParameterValues(paramName);
			if (paramValues.length == 1) {
				String paramValue = paramValues[0];
				if (paramValue.length() == 0)
					out.println("<I>No Value</I>");
				else
					out.println(paramValue);
			} else {
				out.println("<UL>");
				for (int i = 0; i < paramValues.length; i++) {
					out.println("<LI>" + paramValues[i]);
				}
				out.println("</UL>");
			}
		}
		out.println("</TABLE>\n</BODY></HTML>");

//	                + request.getParameter("param1") + "\n" +
//	                "  <LI><B>param2</B>: "
//	                + request.getParameter("param2") + "\n" +
//	                "  <LI><B>param3</B>: "
//	                + request.getParameter("param3") + "\n" +
//	                "</UL>\n" +
//	                "</BODY></HTML>");

	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);

	}
}