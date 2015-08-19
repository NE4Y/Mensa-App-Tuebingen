package ne4y_dev.de.mensatuebingen;

import android.os.StrictMode;
import android.util.Log;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class MyXMLParser {
    private Document dom;
    private Element docElm;

    public MyXMLParser() throws Exception {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);

        //get the factory
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        //Using factory get an instance of document builder
        DocumentBuilder db = dbf.newDocumentBuilder();

        //parse using builder to get DOM representation of the XML file

        this.dom = db.parse("http://www.ne4y-dev.de/Mensa-App-Tuebingen/Python%20XML%20Generator/mensa.xml");
        Log.i("xml", "geht");

        this.docElm = this.dom.getDocumentElement();
    }

    public String getDay() {
        // get Day
        NodeList day = docElm.getElementsByTagName("day");

        Element d = (Element)day.item(0);

        Log.i("day", d.getTextContent());

        return d.getTextContent();
    }

    public String getDate() {
        // get date
        NodeList date = docElm.getElementsByTagName("date");

        Element d = (Element) date.item(0);

        getMenues();
        return d.getTextContent();
    }

    public Menue[] getMenues() {

        // get menues
        NodeList menues = docElm.getElementsByTagName("menue");

        Menue[] menue = new Menue[menues.getLength()];

        for (int i = 0; i < menues.getLength(); i++) {
            Element el = (Element) menues.item(i);

            // name
            NodeList day = el.getElementsByTagName("name");
            Element d = (Element) day.item(0);

            // food
            NodeList food = el.getElementsByTagName("food");
            Element f = (Element) food.item(0);

            // studentPrice
            NodeList student = el.getElementsByTagName("studentPrice");
            Element s = (Element) student.item(0);

            // pupilPrice
            NodeList pupil = el.getElementsByTagName("pupilPrice");
            Element p = (Element) pupil.item(0);

            // guestPrice
            NodeList guest = el.getElementsByTagName("guestPrice");
            Element g = (Element) guest.item(0);

            menue[i] = new Menue(d.getTextContent(), f.getTextContent(), s.getTextContent(), p.getTextContent(), g.getTextContent());
        }

        return menue;
    }
}
