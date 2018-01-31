//Bruce Adams Advanced Java INEW 2338 Asg06.java  

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.net.*;
 
public class Asg06 extends HttpServlet{

  public void doGet(HttpServletRequest req, 
                    HttpServletResponse res)
                      throws ServletException, IOException{
	
	//Get and display name of localhost
    InetAddress inetAddress = InetAddress.getLocalHost();
    String hostName = inetAddress.getHostName();
    System.out.println(hostName);	
    System.out.println("Bruce Adams");	
  
	//An array for getting and saving the values contained
    // in the hidden fields named item.
    String[] items = req.getParameterValues("item");

    //Get the submitted name for the current GET request
    String name = req.getParameter("firstName");	
	
    //Establish the type of output
    res.setContentType("text/html");
    
    //Get an output stream
    PrintWriter out = res.getWriter();
    
    //Construct an html page to return to the client
    out.println("<html>");
    out.println("<head><title>Asg06</title></head>");
    out.println("<body>");
    out.println("Servlet Asg06");
	out.println("</BR></BR>");
    out.println("Bruce Adams");
	out.println("</BR>");
	
    if(name == null){	
	out.println("<form method='get' action="
            + "\"http://" + hostName + ":8080/Asg06\">");

	out.println("<p>Enter a data item and press the button</p>");
    out.println("<p>Data: <input type=\"text\" name="
                                   + "\"firstName\"/></p>");
    out.println("<input type=\"submit\" value="
                                     + "\"Submit Data Item\"/>");
	}
	else {
		out.println("</BR>");
//		out.println("<a href='http://" + hostName + ":8080/Asg06a" + "?" + name + "'>Go to next page</a>");
		 //appending the username in the query string  
        out.print("<a href='Asg06a?uname="+name+"'>Go to next page</a>");  
	}
    
    if(items != null){
      for(int i = 0; i < items.length; i++){
        //Save the names in hidden fields on form currently
        // under construction.
        out.println("<input type=\"hidden\" name=\"item\" "
                           + "value=\"" + items[i] + "\">");
      }//end for loop
    }//end if

    if(name != null){
      //Save name submitted with current GET request in a
      // hidden field on the form currently under
      // construction
      out.println("<input type=\"hidden\" name=\"item\" "
                               + "value=\"" + name + "\">");
	}//end if

    out.println("</body></html>");
  }//end doGet()
}//end class Asg06