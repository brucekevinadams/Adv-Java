//Bruce Adams Advanced Java INEW 2338 Asg07.java 

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.net.*;

public class session1 extends HttpServlet{
  public void doGet(HttpServletRequest req, 
                    HttpServletResponse res)
                      throws ServletException, IOException{

    //Get and display name of localhost
    InetAddress inetAddress = InetAddress.getLocalHost();
    String hostName = inetAddress.getHostName();
    System.out.println(hostName);
	
	//display student name
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
    
    //Construct an html form and send it back to the client
    out.println("<html>");
    out.println("<head><title>session1</title></head>");
    out.println("<body>");
    out.println("Servlet Asg07");
	out.println("</BR></BR>");
    out.println("Bruce Adams");
	out.println("</BR>");        
    out.println("<form method='get' action="
            + "\"http://" + hostName + ":8080/session1\">");

    out.println("<p>Enter text and press the button</p>");
    out.println("<p>Data: <input type=\"text\" name="
                                   + "\"firstName\"/></p>");
    out.println("<input type=\"submit\" value="
                                     + "\"Submit Data\"/>");
    out.println("<p>When you are finished entering data, click the following link to display your data:<br/>");
    if(name == null){
      out.println("Empty</p>");
    }//end if 
    
    if(items != null){
      for(int i = 0; i < items.length; i++){
        //Display names previously saved in hidden fields
//        out.println(items[i] + "<br/>");
        //Save the names in hidden fields on form currently
        // under construction.
        out.println("<input type=\"hidden\" name=\"item\" "
                           + "value=\"" + items[i] + "\">");
      }//end for loop
    }//end if

    if(name != null){
      //Display name submitted with current GET request
 //     out.println(name + "<br/>");
      //Save name submitted with current GET request in a
      // hidden field on the form currently under
      // construction
      out.println("<input type=\"hidden\" name=\"item\" "
                               + "value=\"" + name + "\">");
    }//end if

	out.println("<a href='http://" + hostName + ":8080/Asg07a" + "?" + items[] + name "'>Display your data</a>");	
	
    out.println("</form></body></html>");
      
  }//end doGet()
}//end class Java4550a