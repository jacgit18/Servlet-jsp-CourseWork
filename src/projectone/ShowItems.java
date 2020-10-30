package projectone;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.servlet.annotation.*;

@WebServlet("/ShowItems")
public class ShowItems extends HttpServlet {
  @Override
  public void doPost (HttpServletRequest request,
                      HttpServletResponse response)
      throws ServletException, IOException {
    HttpSession session = request.getSession();
    synchronized(session) {
    
    	 @SuppressWarnings("unchecked")
         List<String> previousItems = (List<String>)session.getAttribute("previousItems");
         
         if (previousItems == null) {
           previousItems = new ArrayList<String>();
           session.setAttribute("previousItems", previousItems);
         }
         
         
         
         
         
         
         String newItem = request.getParameter("newItem");
         String newQty = request.getParameter("itemQty");
         
         
         // potential 
         /*
          * request.getParameterMap()
          * maps and enummeration are similar maps are newer
          */
         
         
//         Enumeration<String> paramNames =
//        		 request.getParameterNames();
//        		 while(paramNames.hasMoreElements()) {
//        		 String paramName = (String)paramNames.nextElement();
//        		 out.print("<TR><TD>" + paramName + "\n<TD>");
//        		 String[] paramValues =
//        		 request.getParameterValues(paramName);
//        		 if (paramValues.length == 1) {
//        		 String paramValue = paramValues[0];
//        		 if (paramValue.length() == 0)
//        		 out.println("<I>No Value</I>");
//        		 else
//        		 out.println(paramValue);
//        		 } else {
//        		 out.println("<UL>");
//        		 for(int i=0; i<paramValues.length; i++) {
//        		 out.println("<LI>" + paramValues[i]);
//        		 }
//        		 out.println("</UL>");
         
         if ((newItem != null) && (!newItem.trim().equals(""))) {
           previousItems.add(newItem);
      	 // work here
           
         }
    	 // work here

         
         
         
         
         
         response.setContentType("text/html");
         PrintWriter out = response.getWriter();
         String title = "Items Purchased";
         String docType =
           "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
           "Transitional//EN\">\n";
         out.println(docType +
                     "<HTML>\n" +
                     "<HEAD><TITLE>" + title + "</TITLE></HEAD>\n" +
                     "<BODY BGCOLOR=\"#FDF5E6\">\n" +
                     "<H1>" + title + "</H1>");
         if (previousItems.size() == 0) {
           out.println("<I>No items</I>");
         } else {
        	 
        	 // work here
           out.println("<UL>");
           for(String item: previousItems) {
             out.println("  <LI>" + item);
           }
           out.println("</UL>");
         }
         out.println("</BODY></HTML>");
       }
    
    
     }
   }