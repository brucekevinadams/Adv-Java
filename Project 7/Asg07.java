//Bruce Adams Advanced Java INEW 2338 Asg07.java  

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.net.*;

public class Asg07 extends HttpServlet{
  public void doGet(HttpServletRequest req, 
                    HttpServletResponse res)
                      throws ServletException, IOException{

    //Get and display name of localhost
    InetAddress inetAddress = InetAddress.getLocalHost();
    String hostName = inetAddress.getHostName();
    System.out.println(hostName);

	//display student name
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
    
    //Construct an html form and send it back to the client
    out.println("<html>");
    out.println("<head><title>Asg07</title></head>");
    out.println("<body>");
    out.println("Servlet Asg07");
	out.println("</BR></BR>");
    out.println("Bruce Adams");
	out.println("</BR>");        


    out.println("<form method='get' action="
            + "\"http://" + hostName + ":8080/Asg07\">");

    out.println("<p>Enter text and press the button</p>");
    out.println("<p>Data: <input type=\"text\" name="
                                   + "\"item\"/></p>");
    out.println("<input type=\"submit\" value="
                                     + "\"Submit Data\"/>");
    out.println("<p>When you are finished entering data, click the following link to display your data:<br/>");

		
//	res.encodeURL(res.encodeRedirectUrl("Asg07"));

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
	
	String query = req.getQueryString();	
//	out.println(query);
	parameters = "?" + query;
	out.println("</BR>");  	
	
//	out.println("<a href='http://" + hostName + ":8080/" + res.encodeURL(res.encodeRedirectUrl("Asg07a"))
//		+ parameters + "'>Click Here</a>");	

	out.println("<a href='http://" + hostName + ":8080/Asg07a" + parameters + "'>Display your data</a>");	

	
    out.println("</form></body></html>");
      
  }//end doGet()
}//end class Java4550a

 
