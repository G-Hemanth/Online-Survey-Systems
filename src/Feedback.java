import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Feedback extends HttpServlet {  
public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
  
response.setContentType("text/html");  
PrintWriter out = response.getWriter();  
          
String n=request.getParameter("q1");  
String p=request.getParameter("q2");  
String e=request.getParameter("q3");  
String p1=request.getParameter("q4");  
String e1=request.getParameter("q5");

try{  
Class.forName("com.mysql.cj.jdbc.Driver");  
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/signup","root","Abcd@1234");  

PreparedStatement ps=con.prepareStatement("insert into feedbackDetails values(?,?,?,?,?)");  
  
ps.setString(1,n);  
ps.setString(2,p);  
ps.setString(3,e); 
ps.setString(4,p1);  
ps.setString(5,e1); 
  
          
int i=ps.executeUpdate(); 
if(i>0)  
response.sendRedirect("Homepage.html");  
      
          
}catch (Exception e2) {
	System.out.print(false);
}  
          
  
}  

}

