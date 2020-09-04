package project1;

import java.io.*;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// make sure use only lower case for address

@WebServlet("/hello")
public class HelloWorld extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, 
						HttpServletResponse response)
		throws ServletException, IOException{
			
		
		// Always define response first
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("Hello World </B>");
		out.println("<B> Hello World </B><BR>");
		out.println("<H1>Hello World</H1>");

	}	
}