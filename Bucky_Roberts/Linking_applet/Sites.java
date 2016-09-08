import java.awt.*;
import java.util.*;
import java.net.*;
import java.applet.*;
import javax.swing.*;
import javax.swing.event.*;

public class Sites extends JApplet {
        private HashMap<String, URL> websiteInfo;
        private ArrayList<String> titles;

        private JList mainList;


        public void init(){
                websiteInfo = new HashMap<String, URL>();
                titles = new ArrayList<String>();

                grabHTMLInfo();
                add(new JLabel("What Website Do you want to visit?"), BorderLayout.NORTH);
                mainList = new JList(titles.toArray());

                mainList.addListSelectionListener(
                        new ListSelectionListener() {
                                @Override
                                public void valueChanged(ListSelectionEvent event) {
                                        Object object = mainList.getSelectedValue();
                                        URL newDocument = websiteInfo.get(object);
                                        AppletContext browser = getAppletContext();
                                        browser.showDocument(newDocument);
                                }
                        }
                                                 );
        }

        // Grab HTML INFO
        private void grabHTMLInfo(){
                String title;
                String address;
                URL url;
                int counter = 0;
                title = getParameter("title" + counter);

                while (title != null) {
                        address = getParameter("address" + counter);
                        try {
                                url = new URL(address);
                                websiteInfo.put(title, url);
                                titles.add(title);
                        } catch (MalformedURLException URLException) {
                                URLException.printStackTrace();
                        }
                        ++counter;
                        title = getParameter("title" + counter);
                }
        }
}
