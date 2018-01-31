import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.net.*;

public class Java4550a extends HttpServlet{
  public void doGet(HttpServletRequest req, 
                    HttpServletResponse res)
                      throws ServletException, IOException{

    //Get and display name of localhost
    InetAddress inetAddress = InetAddress.getLocalHost();
    String hostName = inetAddress.getHostName();
    System.out.println(hostName);

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
    out.println("<head><title>Java4550a</title></head>");
    out.println("<body>");
        
    out.println("<form method='get' action="
            + "\"http://" + hostName + ":8080/Java4550a\">");

    out.println("<p>Enter a name and press the button</p>");
    out.println("<p>Name: <input type=\"text\" name="
                                   + "\"firstName\"/></p>");
    out.println("<input type=\"submit\" value="
                                     + "\"Submit Name\"/>");
    out.println("<p>Your list of names is:<br/>");
    if(name == null){
      out.println("Empty</p>");
    }//end if 
    
    if(items != null){
      for(int i = 0; i < items.length; i++){
        //Display names previously saved in hidden fields
        out.println(items[i] + "<br/>");
        //Save the names in hidden fields on form currently
        // under construction.
        out.println("<input type=\"hidden\" name=\"item\" "
                           + "value=\"" + items[i] + "\">");
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
    }//end if

    out.println("</form></body></html>");
      
  }//end doGet()
}//end class Java4550a