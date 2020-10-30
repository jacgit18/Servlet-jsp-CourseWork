package projectone;

import javax.servlet.annotation.WebServlet;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/shopping-cart")
public class shoppingcart extends HttpServlet {

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		synchronized (session) {
			/*
			 * 
			 * (15 pts) Order button will move to the ShoppingCart page (ShoppingCart.java)
			 * which should list all products ordered with total quantity they ordered so
			 * far for each product. System should add whatever quantity user typed into
			 * previous order using the session object. The Item Id and Item Name is fixed
			 * and you should use same when you print the full list in the ShoppingCart
			 * page. 
			 * 
			 * (2 pts) System should update their quantity from each textbox and only
			 * update if the quantity is not blank. 
			 * 
			 * (4 pts) The ShoppingCart page only works
			 * for IE (check word "Trident" for IE or not). If not, show error page using
			 * HTML standard error code "HttpServletResponse.SC_HTTP_VERSION_NOT_SUPPORTED"
			 * and your message "Only Microsoft IE browser is working for this site." 
			 * 
			 * (4 pts) You must block user going directly to shoppingCart.java if user is not
			 * coming from the product.html page. If they do, send user back to the
			 * ProductList.html. You can't use Cookie or Session object. 
			 * 
			 * (10 pts) In the
			 * Shopping cart page, add Export to Excel button that exports as below picture
			 * and the total quantity must calculated in Excel using Excel formula. This
			 * should be done in exportExcel.java file.
			 * 
			 */
			
//			request.getContextPath()
			
			
			String productListPath = "http://localhost:8080/MYCookiesHW/ProductList.html";
			String productfile = "ProductList.html";
			String Shopfile = "/shopping-cart";

			boolean ProductPathChecker = request.getServletPath().contains(productfile);
			boolean ShopPathChecker = request.getServletPath().contains(Shopfile);
			
			 if(ProductPathChecker != ShopPathChecker){
				 System.out.println("On Path");
//			      request.getRequestDispatcher(productfile).forward(request, response);  
			} else if(request.getServletPath().equals("/shopping-cart")) {
				
			}
			
//			if(productListPath == null) {
//				
//			}

			String title = "MyCart";

			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			String docType = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " + "Transitional//EN\">\n";
			
	         out.println(docType +
                     "<HTML>\n" +
                     "<HEAD><TITLE>" + title + "</TITLE></HEAD>\n" +
                     "<BODY BGCOLOR=\"#FDF5E6\">\n" +
                     "<H1>" + title + "</H1>");
	         
	         out.println("<>");
	         
	         out.println("</>");

	         out.println("<>" + "</>");


//         if (previousItems.size() == 0) {
//           out.println("<I>No items</I>");
//         } else {
        	 
        	 // work here
//           out.println("<UL>");
//           for(String item: previousItems) {
//             out.println("  <LI>" + item);
//           }
//           out.println("</UL>");
//         }
	         
	         
         out.println("</BODY></HTML>");
       
		}

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		doGet(request, response);
	}

}
