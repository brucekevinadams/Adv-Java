import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Java4580a extends HttpServlet{
  
  public void doGet(HttpServletRequest request, 
                    HttpServletResponse response)
                           throws ServletException, IOException{
    
    //Get the session associated with this request,
    HttpSession session = request.getSession(true);

    response.setContentType("text/html");
    
    //Get the output stream from the session object.
    // If this is the first call to servlet, create an output
    // stream and save it in the session object.
    PrintWriter out = (PrintWriter)session.getValue("out");
    if(out == null){
      //First request from this client
      out = response.getWriter();
      session.putValue("out",out);
    }//end if
    
    //Create HTML page header
    out.println("<html>");
    out.println("<head><title>Java4580a</title></head>");
    out.println("<body>");
    
    //Create a hit counter for this servlet 
    Integer cnt = (Integer)session.getValue("counter");
    if(cnt == null) cnt = new Integer(1);
    else cnt = new Integer(cnt.intValue() + 1);
    session.putValue("counter",cnt);
    
    //Add a new Date object each time the servlet i called
    Date theDate = new Date();
    long millis = theDate.getTime();
    String strMillis = "" + millis;
    session.putValue(strMillis,theDate);
    
    //When the hit counter is 1, instantiate a new object of
    // type MyClass and put it in the session. Pass
    // a reference to the output stream to the constructor.
    //Remove the object from the session when the value
    // of the hit counter is 4.
    if(cnt.intValue() == 1) 
               session.putValue("MyClassObj", new MyClass(out));
    if(cnt.intValue() == 4) session.removeValue("MyClassObj");

    //Display information about the session.
    out.println("<p>Session Characteristics:<br/>"); 
    out.println("New Session: " + session.isNew()+ "<br/>");
    out.println("Session ID: " + session.getId()+ "<br/>");
    out.println("Session Context: " 
                        + session.getSessionContext()+ "<br/>");
    out.println("Creation Time: " 
               + new Date(session.getCreationTime()) + "<br/>");
    out.println("Last Accessed: " 
            + new Date(session.getLastAccessedTime()) + "</p>");

    //Display information about all of the objects currently in
    // the session.  Note that the session now contains a
    // PrintWriter object that was not in the session in the
    // original version of the servlet named Java4580a.
    out.println("<p>Session Data:<br/>");
    String[] names = session.getValueNames();
    for(int i = 0; i < names.length; i++){
      out.println(names[i] + ": " 
                        + session.getValue(names[i]) + "<br/>");
    }//end for loop

    //Finish off the HTML page
    out.println("</p></body></html>");
  }//end doGet()
  //==========================================================//
  
  //This is an inner class. In the original version, this
  class MyClass implements HttpSessionBindingListener,
                                                   Serializable{
    PrintWriter localOut;//local copy of output stream to client
    
    public MyClass(PrintWriter out){//constructor
      //Save a local copy of the output stream to the client.
      localOut = out;
    }//end constructor

    public String toString(){
      return "This is a MyClass object";
    }//end toString()
    
    //This method is called when the object is put into
    // the session.
    public void valueBound(HttpSessionBindingEvent e){
      localOut.println("<p>Event<br/>");
      localOut.println("In valueBound method<br/>");
      //Returns the name of the object as identified when
      // put into the session
      localOut.println("Name = " +e.getName() + "</p>");
    }//end valueBound()

    //This method is called when the object is removed
    // from the session.
    public void valueUnbound(HttpSessionBindingEvent e){
      localOut.println("<p>Event<br/>");
      localOut.println("In valueUnbound method<br/>");
      localOut.println("Name = " +e.getName() + "</p>");
    }//end valueUnbound()
  }//end inner class named MyClass 
  

}//end class Java4580a