package projectone;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.servlet.annotation.*;

@WebServlet("/ShowItems")
public class ShowItems extends HttpServlet {
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		synchronized (session) {

			@SuppressWarnings("unchecked")
			List<ArrayList<String>> previousItems = (List<ArrayList<String>>) session.getAttribute("previousItems");


			if (previousItems == null) {

				previousItems = new ArrayList<ArrayList<String>>();

				session.setAttribute("previousItems", previousItems);

			}
			String[] allnewItem = request.getParameterValues("newItem");
			String[] allitemQty = request.getParameterValues("itemQty");
//			request.getParameterMap();

			// out.println(previousItems);

			if (allnewItem.length == 1) {
				String newItem = allnewItem[0];
				String itemQty = allitemQty[0];
				
				if ((itemQty == null) || (newItem.trim().equals("")))
					itemQty = "0";
				if ((newItem != null) && (!newItem.trim().equals(""))){
					previousItems.add((ArrayList<String>) Arrays.asList(newItem,itemQty));
				}
			} else {
				String itemQty = "0"; 
				
				for (int i =0; i<allnewItem.length; i++) {
					if ((allnewItem[i] != null) && (!allnewItem[i].trim().equals(""))){
						ArrayList<String> arySt = new ArrayList<String>();
						arySt.add(allnewItem[i]);
						itemQty =  allitemQty[i];
						if ((itemQty == null) || (itemQty.trim().equals("")));
						itemQty = "0";
						arySt.add(itemQty);
						previousItems.add(arySt);
						
					   }
					
					}
			}
			
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			String title = "Items Purchased";
			String docType = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " + "Transitional//EN\">\n";
			out.println(docType + "<HTML>\n" + "<HEAD><TITLE>" + title + "</TITLE></HEAD>\n"
					+ "<BODY BGCOLOR=\"#FDF5E6\">\n" + "<H1>" + title + "</H1>");
			if (previousItems.size() == 0) {

				out.println("<I>No items</I>");
			} else {
				int totalQty = 0;
				for(ArrayList<String> item : previousItems){
					out.println("<UL>");
					out.println(item.get(0)+ "");
					out.println(item.get(1));
					totalQty = totalQty + Integer.parseInt(item.get(1));

					out.println("</UL>");

				}
				out.println("Total Quantity: " +totalQty);

			}
			out.println("</BODY></HTML>");
		}
	}

	
}
	