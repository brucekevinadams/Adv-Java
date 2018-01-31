//Bruce Adams Advanced Java INEW 2338 Asg05.java  

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.net.*;
 
public class Asg05 extends HttpServlet{

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
	
	if(name == null){
      System.out.println("No data entered");
    } 
	
    //Establish the type of output
    res.setContentType("text/html");
    
    //Get an output stream
    PrintWriter out = res.getWriter();
    
    //Construct an html page to return to the client
    out.println("<html>");
    out.println("<head><title>Asg05</title></head>");
    out.println("<body>");
              
    out.println("Bruce Adams");
	out.println("</BR>");
	
    if(name == null){	
		out.println("<form method='get' action="
				+ "\"http://" + hostName + ":8080/Asg05\">");

		out.println("<p>Enter a data item and press the button</p>");
		out.println("<p>Data: <input type=\"text\" name="
									   + "\"firstName\"/></p>");
		out.println("<input type=\"submit\" value="
										 + "\"Submit Data Item\"/>");
		out.println("<p>List of data items:<br/>");

	
    if(items != null){
      for(int i = 0; i < items.length; i++){
        //Display names previously saved in hidden fields
        out.println(items[i] + "<br/>");
        //Save the names in hidden fields on form currently
        // under construction.
        out.println("<input type=\"hidden\" name=\"item\" "
                           + "value=\"" + items[i] + "\">");
		System.out.println(items[i]);
      }//end for loop
    }//end if

    if(name != null){
      //Display name submitted with current GET request
      out.println(name + "<br/>");
      //Save name submitted with current GET request in a
      // hidden field on the form currently under
      // construction
      out.println("<input type=\"hidden\" name=\"item\" "
                               + "value=\"" + name + "\">");
	  System.out.println(name);							   
    }//end if
	
		} //end if 
   	else {
		out.println("</BR>");
//		out.println("<a href='http://" + hostName + ":8080/Asg06a" + "?" + name + "'>Go to next page</a>");
		 //appending the username in the query string  
        out.print("<a href='Asg06a?firstName="+name+"'>Go to next page</a>");  
	}	
		

    out.println("</body></html>");
  }//end doGet()
}//end class Asg05