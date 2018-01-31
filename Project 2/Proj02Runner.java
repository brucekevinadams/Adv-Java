//Bruce Adams Advanced Java INEW 2338 Proj02Runner.java

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.URL;

class Proj02Runner
{
  URL website;
  
  void run(String paramString)
  {
    System.out.println("Bruce Adams");
    try
    {
      this.website = new URL(paramString);
          BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(this.website.openStream()));
          int i = 0;
      String str;
      while (((str = localBufferedReader.readLine()) != null) && (i++ < 10)) {
        System.out.println("" + i + " " + str);
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}
