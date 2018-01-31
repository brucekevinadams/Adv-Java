import java.io.*;  
import javax.servlet.*;  
import javax.servlet.http.*;  
  
public class first extends HttpServlet {  
public void doGet(HttpServletRequest request, HttpServletResponse response){  
        try{  
  
        response.setContentType("text/html");  
        PrintWriter out = response.getWriter();  
		String n=request.getParameter("userName");  
		
		out.println("<p>Enter a data item and press the button</p>");
		out.println("<p>Data: <input type=\"text\" name=userName\"/></p>");
		out.println("<input type=\"submit\" value="
                                     + "\"Submit Data Item\"/>");
          
		//appending the username in the query string  
        out.print("<a href='second?uname="+n+"'>visit</a>");  
                  
 		//Construct an html page to return to the client
		out.println("<html>");
		out.println("<head><title>Asg06</title></head>");
		out.println("<body>");
		out.println("Servlet Asg06");
		out.println("</BR></BR>");
		out.println("Bruce Adams");
		out.println("</BR>");
        
  
                }catch(Exception e){System.out.println(e);}  
    }  
  
}  