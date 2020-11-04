package projectone;

import javax.servlet.annotation.WebServlet;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import projectone.StartMyShopping;


@WebServlet("/shopping-cart")
public class CyberShopping extends HttpServlet {

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// public void doGet(HttpServletRequest request, HttpServletResponse
		// response) throws ServletException, IOException {

		HttpSession session = request.getSession();

		synchronized (session) {

			/*
			 * 
			 
			 * 
			 
			 * 
			 
			 * 
			 
			 * 
			 * 
			 * 3. (10 pts) From shoppingList.java, it just shows all shopping
			 * list you added so far in list format. And, at the end, you have a
			 * link to go back "Keep Shopping" to StartMyShopping.java. All
			 * shopping items must be stored in a session object. So, whenever
			 * you add new item from StartMyShopping.java page, your list keeps
			 * previous items in list and just add new one.
			 * 
			 * 
			 * 
	
			 * 
			 */

			// request.getContextPath()

			 String countString =
			 CookieUtilities.getCookieValue(request,
			 "accessCount",
			 "1");
			 int count = 1;
			 try {
			 count = Integer.parseInt(countString);
			 } catch(NumberFormatException nfe) { }
			 LongLivedCookie cd =
			 new LongLivedCookie("accessCount",
			 String.valueOf(count+1));
			 response.addCookie(cd);

			String productListPath = "http://localhost:8080/MYCookiesHW/ProductList.html";
			String productfile = "ProductList.html";
			String Shopfile = "/shopping-cart";

			boolean ProductPathChecker = request.getServletPath().contains(productfile);
			boolean ShopPathChecker = request.getServletPath().contains(Shopfile);

			String[] newQty = request.getParameterValues("itemQty");

			// if(ProductPathChecker != ShopPathChecker){
			// System.out.println("On Path");
			//// request.getRequestDispatcher(productfile).forward(request,
			// response);
			// } else if(request.getServletPath().equals("/shopping-cart")) {
			//
			// }
			//
			// if(productListPath == null) {
			//
			// }

			String title = "MyCart";

			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			// response.setContentType("application/vnd.ms-excel");
			// out.println("\titemID\tName\tQty");
			// out.println("123\tOrange\t10");
			// out.println("124\tApple\t1");
			// out.println("125\tBanana\t3");
			// out.println("\tTotal Qty\t=SUM(C2:C5)");
			String docType = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " + "Transitional//EN\">\n";

			// if (request.getParameter("previewButton") != null) {
			// showPreview(request, out);
			// } else {
			// storeResume(request);
			// showConfirmation(request, out);
			// }
			// }
			//

			/*
			 ** (3 pts) Your site only works for IE (check word "Trident" for IE
			 * or not). If not, show error page using HTML standard error code
			 * "HttpServletResponse.SC_HTTP_VERSION_NOT_SUPPORTED" and your
			 * message "Only Microsoft IE browser is working for this site." 
			 */
			String referer = request.getHeader("Referer");// referer contains
															// address of
															// previous ul
			String userAgent = request.getHeader("User-Agent");
			boolean userAgentcontent = userAgent.contains("Trident");

			
			if ((userAgent != null) && (userAgentcontent == false)) {
				response.setStatus(response.SC_HTTP_VERSION_NOT_SUPPORTED); //505
//				response.sendRedirect(productListPath);

			} else {
				
				 boolean newbie = true;
				    Cookie[] cookies = request.getCookies();
				    if (cookies != null) {
				      for(Cookie c: cookies) {
				        if ((c.getName().equals("repeatVisitor")) &&
				            // Could omit test and treat cookie name as a flag
				            (c.getValue().equals("yes"))) {
				          newbie = false;
				          break;
				        }
				      }
				    }
				    StartMyShopping send = new StartMyShopping();
				    if (newbie) {
				      Cookie returnVisitorCookie =
				        new Cookie("repeatVisitor", "yes");
				      returnVisitorCookie.setMaxAge(60*60*24*365); // 1 year
				      response.addCookie(returnVisitorCookie);
				      title = "Welcome Aboard";
				    } else {
				    	/*
				    	 * * (7pts) Check if user is first time visitor by checking the cookie
			 * object "Visit" yer or no. if new visitor, set " Visit " cookie
			 * with yes for one year and move user to StartMyShopping.java
			 * servlet.
				    	 */
					      response.sendRedirect("http://localhost:8080/MYCookiesHW/shopping-start");

				      title = "Welcome Back";
				    }
				out.println(docType + "<HTML>\n" + "<HEAD><TITLE>" + title + "</TITLE></HEAD>\n"
						+ "<BODY BGCOLOR=\"#FDF5E6\">\n" + "<H1>" + title + "</H1>");

				out.println("<>");

				out.println("</>");

				out.println("<>" + "</>");

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

				out.println("</BODY></HTML>");
			}

		}

	}

	// public void doPost(HttpServletRequest request, HttpServletResponse
	// response) throws ServletException, IOException{

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		// doGet(request, response);

	}

}