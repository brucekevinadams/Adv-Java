//Bruce Adams Advanced Java INEW 2338 Asg06a.java  9-30-14 Instructor: Baldwin

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.net.*;
 
public class Asg06a extends HttpServlet{

  public void doGet(HttpServletRequest req, 
                    HttpServletResponse res)
                      throws ServletException, IOException{
					  
	//Get and display name of localhost
    InetAddress inetAddress = InetAddress.getLocalHost();
    String hostName = inetAddress.getHostName();
    System.out.println(hostName);	
    System.out.println("Bruce Adams");	

    String Uname = req.getParameter("name");	
    String name = req.getParameter("name");	

	String parameters = "?";
    String[] items = req.getParameterValues("Uname");	
	

	//An array for getting and saving the values contained
    // in the hidden fields named item.
    String[] Uitems = req.getParameterValues("item");
	
	if(items != null) {
		for(int i = 0; i < items.length; i++) {
			parameters = parameters + "Uname=" + items[i] + "&";
			} //end for loop
		} //end if

    //Establish the type of output
    res.setContentType("text/html");
    
    //Get an output stream
    PrintWriter out = res.getWriter();
    
    //Construct an html page to return to the client
    out.println("<html>");
    out.println("<head><title>Asg06a</title></head>");
    out.println("<body>");

    out.println("Servlet Asg06a");
	out.println("</BR></BR>");            
    out.println("Bruce Adams");
	out.println("</BR>");
    out.println("<p>The data you entered was:<br/><br/>");	

    //getting value from the query string  
	String n=req.getParameter("uname");  
	out.print(""+n+"</br></br>");  
	out.print("Thank you.</br></br>");
	
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

	
    if(Uitems != null){
      for(int i = 0; i < Uitems.length; i++){
        //Display names previously saved in hidden fields
        out.println(Uitems[i] + "<br/>");
        //Save the names in hidden fields on form currently
        // under construction.
        out.println("<input type=\"hidden\" name=\"item\" "
                           + "value=\"" + Uitems[i] + "\">");
		System.out.println(Uitems[i]);
      }//end for loop
    }//end if

    if(Uname != null){
      //Display name submitted with current GET request
      out.println(Uname + "<br/>");
      //Save name submitted with current GET request in a
      // hidden field on the form currently under
      // construction
      out.println("<input type=\"hidden\" name=\"item\" "
                               + "value=\"" + Uname + "\">");
						   
    }//end if
	
	out.println("<a href='http://" + hostName + ":8080/Asg06" + "?" + n + "'>Go to Page 1</a>");	
	
    out.println("</body></html>");
  }//end doGet()
}//end class Asg06a	