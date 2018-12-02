/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Arrays;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class regservlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();  
          
String n=request.getParameter("First_Name");  
String p=request.getParameter("Last_Name");  
String f=request.getParameter("Birthday_day");  
String c=request.getParameter("Birthday_Month"); 
String q=request.getParameter("Birthday_Year");
String r=request.getParameter("Email_Id"); 
String s=request.getParameter("Mobile_Number");
String a=request.getParameter("Gender");
String b=request.getParameter("Gender");
String l=request.getParameter("Father_Name");
String e=request.getParameter("Address");
String g=request.getParameter("college-name");
String k[];
 k=request.getParameterValues("Vogue");
 String k1=Arrays.toString(k);
 try{  
Class.forName("com.mysql.cj.jdbc.Driver");  
Connection con=DriverManager.getConnection("jdbc:mysql://localhost/testdemo?useSSL=false&allowMultiQueries=true","root","Anmol@1234");  
  
PreparedStatement ps=con.prepareStatement("insert into table12 values(?,?,?,?,?,?,?,?,?,?,?,?)");  
  
ps.setString(1,n);  
ps.setString(2,p);  
ps.setString(3,f);  
ps.setString(4,c); 
ps.setString(5,q);
ps.setString(6,r);
ps.setString(7,s);
ps.setString(8,a);
ps.setString(9,l);
ps.setString(10,e);
ps.setString(11,q);
ps.setString(12,k1);
          
int i=ps.executeUpdate();  
if(i>0)  
out.print("You are successfully registered...");
 RequestDispatcher rd=request.getRequestDispatcher("index.html");
rd.forward(request,response); 
      
          
}catch (Exception e2) {System.out.println(e2);}
          out.println("<html><head></head><body onload=\"alert('user already exist!')\"></body></html>");

out.close();  
  
response.sendRedirect("events.html");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
