//Bruce Adams Advanced Java INEW 2338 8-31-14 

import java.io.PrintStream;
import java.net.InetAddress;
import java.net.UnknownHostException;

class Proj01Runner
{
  public void run()
  {
    System.out.println("Bruce Adams");
    try
    {
      System.out.println("Get and display IP address of ACC website by name");
      
      InetAddress localInetAddress = InetAddress.getByName("www.austincc.edu");
      
      System.out.println(localInetAddress);
      
      System.out.println("Get and display current IP address of LocalHost");
      
      localInetAddress = InetAddress.getLocalHost();
      System.out.println(localInetAddress);
      
      System.out.println("Get and display current name of LocalHost");
      
      System.out.println(localInetAddress.getHostName());
      
      System.out.println("Get and display current IP address of LocalHost");

      byte[] arrayOfByte = localInetAddress.getAddress();
      for (int i = 0; i < arrayOfByte.length; i++)
      {
        int j = arrayOfByte[i] < 0 ? arrayOfByte[i] + 256 : arrayOfByte[i];
        
        System.out.print(j + " ");
      }
      System.out.println();
    }
    catch (UnknownHostException localUnknownHostException)
    {
      System.out.println(localUnknownHostException);
      System.out.println("Must be online to run properly.");
    }
  }
}
