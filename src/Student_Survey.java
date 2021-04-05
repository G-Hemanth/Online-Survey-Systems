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

public class Student_Survey extends HttpServlet {  
public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
  
response.setContentType("text/html");  
PrintWriter out = response.getWriter();  
          
String n=request.getParameter("q1");  
String p=request.getParameter("q2");  
String e=request.getParameter("q3");  

try{  
Class.forName("com.mysql.cj.jdbc.Driver");  
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/signup","root","Abcd@1234");  

PreparedStatement ps=con.prepareStatement("insert into StudentSurveyDetails values(?,?,?)");  
  
ps.setString(1,n);  
ps.setString(2,p);  
ps.setString(3,e); 

  
          
int i=ps.executeUpdate(); 
if(i>0)  
response.sendRedirect("Homepage.html");  
      
          
}catch (Exception e2) {
	System.out.print(false);
}  
          
  
}  

}

