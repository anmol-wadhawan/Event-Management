package controller;
import java.io.*;  
import java.sql.*;  
import javax.servlet.ServletException;  
import javax.servlet.http.*;  


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
  
public class NewServlet123 extends HttpServlet {  
public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
  
response.setContentType("text/html");  
PrintWriter out = response.getWriter();  
          
String n=request.getParameter("First_Name");  
String p=request.getParameter("Last Name");  
String f=request.getParameter("Password");  
String c=request.getParameter("Mobile No."); 
String q=request.getParameter("E-mail");
String r=request.getParameter("Address"); 
String s=request.getParameter("Date Of Birth"); 
          
try{  
Class.forName("com.mysql.cj.jdbc.Driver");  
Connection con=DriverManager.getConnection("jdbc:mysql://localhost/testdemo?useSSL=false&allowMultiQueries=true","root","Anmol@1234");  
  
PreparedStatement ps=con.prepareStatement("insert into table1 values(?,?,?,?,?,?,?)");  
  
ps.setString(1,n);  
ps.setString(2,p);  
ps.setString(3,f);  
ps.setString(4,c); 
ps.setString(5,q);
ps.setString(6,r);
ps.setString(7,s);
          
int i=ps.executeUpdate();  
if(i>0)  
out.print("You are successfully registered...");
 RequestDispatcher rd=request.getRequestDispatcher("login.html");
rd.forward(request,response); 
      
          
}catch (Exception e2) {System.out.println(e2);}
          out.println("<html><head></head><body onload=\"alert('user already exist!')\"></body></html>");

out.close();  
}  
  
}