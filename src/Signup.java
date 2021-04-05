
import java.io.*;  
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;  
import javax.servlet.http.*;  
  
public class Signup extends HttpServlet {  
public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
  
response.setContentType("text/html");  
PrintWriter out = response.getWriter();  
          
String n=request.getParameter("email");  
String p=request.getParameter("psw");  
String e=request.getParameter("psw-repeat");  

try{  
Class.forName("com.mysql.jdbc.Driver");  
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/signup","root","Abcd@1234");  
  
PreparedStatement ps=con.prepareStatement("insert into signupdetails values(?,?,?)");  
  
ps.setString(1,n);  
ps.setString(2,p);  
ps.setString(3,e);  
  
          
int i=ps.executeUpdate();  
if(i>0)  
response.sendRedirect("LOGIN.html");  
      
          
}catch (Exception e2) {
	
	out.println("<br/><center><h1 style=\"color:white\">this email already exsists</h1></center>");
	RequestDispatcher thi=request.getRequestDispatcher("SIGNUP.html");
	thi.include(request,response);
	

}  
          
out.close();  
}  
  
}