//Bruce Adams Advanced Java INEW 2338 Proj05.java  9-24-14 Instructor: Baldwin

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
 
public class Servlet01 extends HttpServlet{

  public void doGet(HttpServletRequest req, 
                    HttpServletResponse res)
                      throws ServletException, IOException{

    //Establish the type of output
    res.setContentType("text/html");
    
    //Get an output stream
    PrintWriter out = res.getWriter();
    
    //Construct an html page to return to the client
    out.println("<html>");
    out.println("<head><title>Asg05</title></head>");
    out.println("<body>");
              
    out.println("Bruce Adams");
	
    out.println("Enter a data item and press the button");

    out.println("</body></html>");
  }//end doGet()
}//end class Servlet01