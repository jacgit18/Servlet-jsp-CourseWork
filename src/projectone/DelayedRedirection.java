package projectone;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/delayed-redirection")
public class DelayedRedirection extends HttpServlet {
  @Override
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html");
    String url;
   
    String userAgent = request.getHeader("User-Agent");
    if ((userAgent != null) && (userAgent.contains("MSIE"))) {
      url = "http://www.microsoft.com";
    } else {
      url = "http://www.mozilla.org";
    }
    response.setHeader("Refresh", "10; URL=" + url);
    PrintWriter out = response.getWriter();
    String title = "Delayed Redirection";
    String docType =
      "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
      "Transitional//EN\">\n";
    out.println(docType +
                "<HTML>\n" +
                "<HEAD><TITLE>" + title + "</TITLE></HEAD>\n" +
                "<BODY BGCOLOR=\"#FDF5E6\">\n" +
                "<H1 ALIGN=\"CENTER\">" + title + "</H1>\n" +
                "You will be sent to <B>" + url + "</B>\n" +
                "in 10 seconds.\n" +
                "<ul>\r\n" + 
                "<ul>\r\n" + 
                "  <li><a href=\"index.html\">Home</a></li>\r\n" + 
                "  <li><a href=\"random-destination-with_statuscode\">Random Status code Destination</a></li>\r\n" + 
                "  <li><a href=\"reloadPg\">ReloadPg</a></li>\r\n" + 
                "  <li><a href=\"excel-math\">ExcelMathSpreadsheet</a></li>\r\n" + 
                "  <li><a href=\"delayed-redirection\">DelayedRedirection</a></li>\r\n" + 
                "</ul>" +
                "</BODY></HTML>");
  }
}
