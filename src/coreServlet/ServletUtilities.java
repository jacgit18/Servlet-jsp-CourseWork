package coreServlet;

import javax.servlet.http.*;


public class ServletUtilities {
	
	
	public static String headWithTitle(String title) {
		return ("<!DOCTYPE html>\n" + "<html>\n" + "<head><title>" + title + "</title></head>\n");
		
		
		
	}
	
	
//	public static String headWithTitle(String title) {
//		return ("<!DOCTYPE html>\n" + "<html>\n" + "<head><title>" + title + "</title></head>\n" + "<body>" + "</body>"
//	+ "</html>");
//		
//		
//		
//	}
	
}
