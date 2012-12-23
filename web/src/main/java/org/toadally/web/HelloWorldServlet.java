package org.toadally.web;
import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.toadally.boot.DemoDataLoader;

@SuppressWarnings("serial")
@WebServlet("/HelloWorld")                                           // 1
public class HelloWorldServlet extends HttpServlet {

   static String PAGE_HEADER =
       "<html><head><title>helloworld</title><body>";                // 2

   static String PAGE_FOOTER = "</body></html>";

//   @Inject
//   public DemoDataLoader loader;
   
   @Override
   protected void doGet(HttpServletRequest req,
                        HttpServletResponse resp)
                        throws ServletException, IOException {
      resp.setContentType("text/html");
      
      PrintWriter writer = resp.getWriter();
      writer.println(PAGE_HEADER);
      writer.println("<h1>" +
                   "World" +      // 4
                     "</h1>");
      writer.println(PAGE_FOOTER);
      writer.close();
   }

}