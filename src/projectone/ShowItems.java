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
			PrintWriter out = response.getWriter();

			@SuppressWarnings("unchecked")
			List<SimpleItem> previousItems = (List<SimpleItem>) session.getAttribute("previousItems");

		

			if (previousItems == null) {

				previousItems = new ArrayList<SimpleItem>();

				session.setAttribute("previousItems", previousItems);

			}
			String newItem = request.getParameter("newItem");
			String itemQty = request.getParameter("itemQty");

			// out.println(previousItems);

			if ((newItem != null) && (!newItem.trim().equals(""))) {
				SimpleItem item = findItem(newItem, previousItems);
				if (item != null) {
					item.incrementItemCount();
					// something here
				} else {
					item = new SimpleItem(newItem);

					previousItems.add(item);
				}
			}
			
			response.setContentType("text/html");
			String title = "Items Purchased";
			String docType = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " + "Transitional//EN\">\n";
			out.println(docType + "<HTML>\n" + "<HEAD><TITLE>" + title + "</TITLE></HEAD>\n"
					+ "<BODY BGCOLOR=\"#FDF5E6\">\n" + "<H1>" + title + "</H1>");
			if (previousItems.size() == 0) {

				out.println("<I>No items</I>");
			} else {
				out.println("<UL>");
				for (SimpleItem item : previousItems) {

					out.println("  <LI>" + item);

				}
				out.println("</UL>");
			}
			out.println("</BODY></HTML>");
		}
	}

	
	private SimpleItem findItem(String newItem, List<SimpleItem> previousItems) {
		for (SimpleItem item : previousItems) {
			if (item.getItemName().equals(newItem)) {
				return (item);
			}
		}
		return (null);
	}
}
	