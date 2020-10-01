package projectone;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/random-destination-with_statuscode")
public class RandomStatusDestination extends HttpServlet {
  @Override
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
    if (Math.random() < 0.5) {
      response.setStatus(302);
      response.setHeader("Location", "http://www.mozilla.org");
    } else {
      response.setStatus(302);
      response.setHeader("Location", "http://www.microsoft.com");
    }
  }
}
