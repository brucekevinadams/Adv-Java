//Bruce Adams Advanced Java INEW 2338 Asg07a.java  

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.net.*;
 
public class Asg07a extends HttpServlet{

  public void doGet(HttpServletRequest req, 
                    HttpServletResponse res)
                      throws ServletException, IOException{
					  
	//Get and display name of localhost
    InetAddress inetAddress = InetAddress.getLocalHost();
    String hostName = inetAddress.getHostName();
    System.out.println(hostName);	
//    System.out.println("Bruce Adams");	
	
	String parameters = "?";
    String[] items = req.getParameterValues("item");

	if(items != null) {
		for(int i = 0; i < items.length; i++) {
		parameters = parameters + "item=" + items[i] + "&";
		}
	}	
	
    //Establish the type of output
    res.setContentType("text/html");
    
    //Get an output stream
    PrintWriter out = res.getWriter();
    
    //Construct an html page to return to the client
    out.println("<html>");
    out.println("<head><title>Asg07a</title></head>");
    out.println("<body>");

    out.println("Servlet Asg07a");
	out.println("</BR></BR>");            
    out.println("Bruce Adams");
	out.println("</BR>");
    out.println("<p>Your session ID and list of data is:<br/>");	
		
	HttpSession ssn = req.getSession();
	if(ssn != null){
	String ssnId = ssn.getId();
	out.println(ssnId);
	}
	else
	{
	out.println("Your session is not created yet");
	}

	out.println("</BR>");
	
    if(items != null){
		for(int counter=items.length -1; counter >= 0;counter--){
        //Display names previously saved in hidden fields
        out.println(items[counter] + "<br/>");
        //Save the names in hidden fields on form currently
        // under construction.
        out.println("<input type=\"hidden\" name=\"item\" "
                           + "value=\"" + items[counter] + "\">");
      }//end for loop
    }//end if
	
	String query = req.getQueryString();	
	parameters = "?" + query;	
	out.println("</BR>");  	

	out.println("<a href='http://" + hostName + ":8080/Asg07" + parameters + "'>Go to Page 1</a>");	
	
    out.println("</body></html>");
  }//end doGet()
}//end class Asg06a	