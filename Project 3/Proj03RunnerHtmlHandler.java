import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkEvent.EventType;
import javax.swing.event.HyperlinkListener;
import javax.swing.text.html.HTMLFrameHyperlinkEvent;

class Proj03RunnerHtmlHandler
  extends JFrame
  implements ActionListener, HyperlinkListener
{
  JEditorPane html;
  JPanel panel = new JPanel();
  JButton backButton = new JButton("Back");
  JButton forwardButton = new JButton("Forward");
  JTextField newSite = new JTextField("http://www.dickbaldwin.com");
  ArrayList<String> history;
  ArrayList<String> forward;
  Proj03RunnerHtmlHandler handler;
  
  public Proj03RunnerHtmlHandler(ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2)
  {
    this.history = paramArrayList1;
    this.forward = paramArrayList2;
    this.handler = this;
    
    this.backButton.addActionListener(this);
    this.forwardButton.addActionListener(this);
    this.newSite.addActionListener(this);
    setDefaultCloseOperation(3);
    
    try
    {
      if (paramArrayList1.get(paramArrayList1.size() - 1) != null)
      {
        this.html = new JEditorPane((String)paramArrayList1.get(paramArrayList1.size() - 1));
        this.html.setEditable(false);
        
        this.html.addHyperlinkListener(this);
        
        JScrollPane localJScrollPane = new JScrollPane();
        JViewport localJViewport = localJScrollPane.getViewport();
        localJViewport.add(this.html);
        getContentPane().add(localJScrollPane, "Center");
        this.panel.add(this.backButton);
        this.panel.add(this.newSite);
        this.panel.add(this.forwardButton);
        getContentPane().add(this.panel, "North");
        

        setSize(669, 669);
        setVisible(true);
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void hyperlinkUpdate(HyperlinkEvent paramHyperlinkEvent)
  {
    if (paramHyperlinkEvent.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
      if ((paramHyperlinkEvent instanceof HTMLFrameHyperlinkEvent)) {
        System.out.println("HTML Frame events are not handled");
      } else {
        try
        {
          this.history.add(paramHyperlinkEvent.getURL().toString());
          
          this.html.setPage((String)this.history.get(this.history.size() - 1));
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
    }
  }
  
  public void actionPerformed(ActionEvent paramActionEvent)
  {
    if (paramActionEvent.getActionCommand().equals("Back"))
    {
      if (this.history.size() > 1)
      {
        this.forward.add(this.history.get(this.history.size() - 1));
        this.history.remove(this.history.size() - 1);
        try
        {
          this.html.setPage((String)this.history.get(this.history.size() - 1));
        }
        catch (IOException localIOException1)
        {
          System.out.println("IOE: " + localIOException1);
        }
      }
    }
    else if (paramActionEvent.getActionCommand().equals("Forward"))
    {
      if (this.forward.size() >= 1)
      {
        String str = (String)this.forward.get(this.forward.size() - 1);
        this.history.add(str);
        this.forward.remove(this.forward.size() - 1);
        try
        {
          this.html.setPage(str);
        }
        catch (IOException localIOException2)
        {
          System.out.println("IOE: " + localIOException2);
        }
      }
    }
    else
    {
      this.history.add(this.newSite.getText());
      this.handler = new Proj03RunnerHtmlHandler(this.history, this.forward);
    }
  }
}
