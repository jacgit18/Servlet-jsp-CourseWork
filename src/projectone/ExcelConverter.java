package projectone;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/excel-math")
public class ExcelConverter extends HttpServlet {
  @Override
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("application/vnd.ms-excel");
    PrintWriter out = response.getWriter();
    for(int rows=0; rows<10; rows++) {
      for(int cols=0; cols<5; cols++) {
        out.print(Math.random() + "\t");
      }
      out.println();
    }
  }
}
