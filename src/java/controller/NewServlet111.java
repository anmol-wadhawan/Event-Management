 package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NewServlet111 extends HttpServlet {

   

    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
       response.setContentType("text/html");
       PrintWriter out = response.getWriter();
       String n = request.getParameter("user");
       
       String p = request.getParameter("pwsd");
       if(loginDAO.validate(n, p)){
          RequestDispatcher rd = request.getRequestDispatcher("events.html");
          rd.forward(request,response);
       }
       else{
           out.println("<html><head></head><body onload=\"alert('username or password error!')\"></body></html>"); 
        RequestDispatcher rd=request.getRequestDispatcher("login.html");  
        rd.include(request,response);  
       }
       out.close();
    }
}
   