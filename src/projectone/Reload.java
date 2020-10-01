package projectone;  

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.util.Date;  

@WebServlet("/reloadPg")
public class Reload extends HttpServlet {
  @Override
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
    response.setIntHeader("Refresh", 5);
    response.setContentType("text/html");
    
    PrintWriter out = response.getWriter();
    
    String title = "Reloading Servlet";
    String docType =
        "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
        "Transitional//EN\">\n";
    out.println(docType +
                "<HTML>\n" +
                "<HEAD><TITLE>" + title + "</TITLE></HEAD>\n" +
                "<BODY BGCOLOR=\"#FDF5E6\">\n" +
                "<H1 ALIGN=\"CENTER\">" + title + "</H1>\n" +
                "<ul>\r\n" + 
                "  <li><a href=\"index.html\">Home</a></li>\r\n" + 
                "  <li><a href=\"random-destination-with_statuscode\">Random Status code Destination</a></li>\r\n" + 
                "  <li><a href=\"reloadPg\">ReloadPg</a></li>\r\n" + 
                "  <li><a href=\"excel-math\">ExcelMathSpreadsheet</a></li>\r\n" + 
                "  <li><a href=\"delayed-redirection\">DelayedRedirection</a></li>\r\n" + 
                "</ul>" +
                "<BR>" +
                "The time is " + new Date() + "\n" +

                "</BODY></HTML>");
  }
}
