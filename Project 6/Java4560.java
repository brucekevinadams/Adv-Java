//Bruce Adams Advanced Java INEW 2338 Asg06.java  

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.net.*;
 
public class Java4560 extends HttpServlet{

  public void doGet(HttpServletRequest req, 
                    HttpServletResponse res)
                      throws ServletException, IOException{
					  
	//Get and display name of localhost
    InetAddress inetAddress = InetAddress.getLocalHost();
    String hostName = inetAddress.getHostName();
    System.out.println(hostName);	
    System.out.println("Bruce Adams");	

    String parameters = "?";	
	
	//An array for getting and saving the values contained
    // in the hidden fields named item.
    String[] items = req.getParameterValues("item");

    //Establish the type of output
    res.setContentType("text/html");
    
    //Get an output stream
    PrintWriter out = res.getWriter();
    
    //Construct an html page to return to the client
    out.println("<html>");
    out.println("<head><title>Java4560</title></head>");
    out.println("<body>");

    out.println("Asg06");
	out.println("</BR></BR>");            
    out.println("Bruce Adams");
	out.println("</BR>");
	
	if(items != null) {
		for(int i = 0; i < items.length; i++) {
			parameters = parameters + "item=" + items[i] + "&";
		} //end for loop
	} // end if
	
    parameters = parameters + "item=";	
	
	out.println("<a href='http://localhost:8080/Java4560" + parameters + "'>Click Here</a>");
	
	out.println("<br/><br/>Your list of times is:<br/>");
	
   if(items != null){
      for(int i = 0; i < items.length; i++){
        long millis = Long.parseLong(items[i]);
        out.println("" + new Date(millis) + "<br/>");
      }//end for loop
    }//end if
	
		
	
    out.println("</body></html>");
  }//end doGet()
}//end class Asg06	