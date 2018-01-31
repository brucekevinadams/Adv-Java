//Bruce Adams Advanced Java INEW 2338 Proj04Runner.java

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

class Proj04Runner
{
  Proj04Runner.SocketWrapper socketWrapper;
  
  void run(String paramString)
  {
    System.out.println("Bruce Adams");

    this.socketWrapper = getSocket(paramString);    
    this.socketWrapper.outputStream.println("GET / HTTP/1.1");
    this.socketWrapper.outputStream.println("Host: " + paramString);
    this.socketWrapper.outputStream.println();
    print(22, this.socketWrapper.inputStream);
    
	try
    {
      this.socketWrapper.socket.close();
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  void print(int paramInt, BufferedReader paramBufferedReader)
  {
    int i = 0;
    String str = "dummy";
    try
    {
      while (((str = paramBufferedReader.readLine()) != null) && (i++ < paramInt)) {
        System.out.println(i + ": " + str);
      }
      if (i >= paramInt) {
        System.out.println("**Print terminated on line count.**");
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  Proj04Runner.SocketWrapper getSocket(String paramString)
  {
    int i = 80;
    Proj04Runner.SocketWrapper localSocketWrapper = new Proj04Runner.SocketWrapper();
    try
    {
      localSocketWrapper.socket = new Socket(paramString, i);      
      localSocketWrapper.inputStream = new BufferedReader(new InputStreamReader(localSocketWrapper.socket.getInputStream()));
      localSocketWrapper.outputStream = new PrintStream(localSocketWrapper.socket.getOutputStream(), true);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return localSocketWrapper;
  }
  
  class SocketWrapper
  {
    Socket socket;
    PrintStream outputStream;
    BufferedReader inputStream;
    
    SocketWrapper() {}
  }
}
