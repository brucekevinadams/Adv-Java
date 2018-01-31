//Bruce Adams Advanced Java INEW 2338 Asg08.java  

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.net.*;
import java.util.Date;
import java.util.Enumeration;
import java.util.UUID;

public class Asg08 extends HttpServlet{
  public void doGet(HttpServletRequest req, 
                    HttpServletResponse res)
                      throws ServletException, IOException{
					  
    //Establish the type of output
    res.setContentType("text/html");
    
    //Get an output stream
    PrintWriter out = res.getWriter();
	
    //Get and display name of localhost
    InetAddress inetAddress = InetAddress.getLocalHost();
    String hostName = inetAddress.getHostName();
    System.out.println(hostName);
	
    HttpSession session = req.getSession();
    long ctime=session.getCreationTime();
    long ltime=session.getLastAccessedTime();
	long lDateTime = new Date().getTime();
	
	//store session ID as string
	String code = session.getId();
	session.setAttribute("code", code);	
	String sessionID =  (String) session.getAttribute("code");	

	//get time in seconds
	long diff = (lDateTime-ctime)/1000;
	session.setAttribute("time", diff);
	
 // Get the current session ID by searching the received cookies.
    String sessionid = null;
    Cookie[] cookies = req.getCookies();
    if (cookies != null) {
      for (int i = 0; i < cookies.length; i++) {
        if (cookies[i].getName().equals("sessionid")) {
          sessionid = cookies[i].getValue();
          break;
        }
      }
    }

    // If the session ID wasn't sent, generate one.
    // Then be sure to send it to the client with the response.
    if (sessionid == null) {
      sessionid = sessionID;
      Cookie c = new Cookie("sessionid", sessionid);
      res.addCookie(c);
    }		
	
	for (int i = 0; i < cookies.length; i++) {
        Cookie c = cookies[i];
        out.println(c.getName() + " " + c.getValue() + " "
            + c.getComment() + "  " + c.getMaxAge() + " ");
      }	
	
	//set timeout to 60 seconds
	session.setMaxInactiveInterval(60);	

	//cast time variable as long and get attribute
	Long time = (Long) session.getAttribute("time");	
	
	Integer count = (Integer) session.getAttribute("count");
		if (count == null)
		//first time session has been started
		  count = new Integer(1);
		else
		  count = new Integer(count.intValue() + 1);
		session.setAttribute("count", count);	
	

    //Construct an html form and send it back to the client
    out.println("<html>");
    out.println("<head><title>Asg08</title></head>");
    out.println("<body>");
    out.println("Servlet Asg08");
	out.println("</BR></BR>");
    out.println("Bruce Adams");
	out.println("</BR></BR>");  	
	
	
    if (session.isNew() && time <= 60) {
		out.println("sessionID: " + sessionID + "<BR>");
		out.println("<BR>"); 
		out.println("Hello new secret agent.<BR>");
		out.println("<BR>");    
		out.println("Your code name will be");
		out.println(sessionID.substring(21));
		out.println("<BR><BR>"); 
		out.println("Terminate and restart both your server and your browser" + "<br>");
		out.println("and come back within 60 seconds and I will remember" + "<br>");
		out.println("you and give you the secret of life" + "</br></br>");		
		out.println("Otherwise I won't remember you." + "<br>");	
		}
	else if (time > 60) {
		session.invalidate();
		}
    else {
	
		//store session ID as string
		if (code == session.getId()) {
		
		}
		else {
		code = session.getId();
		session.setAttribute("code", code);	
		sessionID =  (String) session.getAttribute("code");	
		}
		
		out.println("Welcome back " + sessionID.substring(21) + "<br><br>");
		out.println("Elapsed time: " + time + " seconds" + "<br><br>");	
		out.println("sessionID: " + sessionID + "<BR><BR>");
		out.println("The secret of life is Buy low, sell high" + "</br></br>");	
	}
	
    out.println("</form></body></html>");
      
  }//end doGet()
}//end class Asg08

 
