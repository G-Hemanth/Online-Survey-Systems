
import java.io.*;  
import java.sql.*;  
import javax.servlet.ServletException;  
import javax.servlet.http.*; 
import javax.servlet.RequestDispatcher;
  
public class Login extends HttpServlet {  
public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
  
response.setContentType("text/html");  
PrintWriter out = response.getWriter();  
          
String n=request.getParameter("email");  
String p=request.getParameter("password");  

          
try{  
Class.forName("com.mysql.jdbc.Driver");  
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/signup","root","Abcd@1234");  
  
PreparedStatement ps=con.prepareStatement("select email,password from signupdetails where email=? and password=?");  
  
ps.setString(1,n);  
ps.setString(2,p);  
  
          
ResultSet rs=ps.executeQuery();  
if(rs.next())  
response.sendRedirect("Homepage.html");
else {
	
	out.println("<br/><center><h1 style=\"color:white\">incorrect password or email</h1></center>");
	RequestDispatcher thi=request.getRequestDispatcher("LOGIN.html");
	thi.include(request,response);
	//out.println("<script type=\"text/javascript\">");
    //out.println("alert('Invalid username or password !')");
    //out.println("location='LOGIN.html';");
    //out.println("</script>");
}

      
          
}catch (Exception e2) {System.out.println("please enter correct details"+e2.getMessage());}  
          
out.close();  
}  
  
}