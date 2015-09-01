package ne4y_dev.de.mensatuebingen;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.widget.Toast;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class MyXMLParser extends AsyncTask<String, Integer, MyXMLParser> {
    private Document dom;
    private Element docElm;
    private LoadingActivity la;

    public MyXMLParser(LoadingActivity la) {
        this.la = la;
    }

    public String getDay() {
        // get Day
        NodeList day = docElm.getElementsByTagName("day");

        Element d = (Element)day.item(0);

        return d.getTextContent();
    }

    public String getDate() {
        // get date
        NodeList date = docElm.getElementsByTagName("date");

        Element d = (Element) date.item(0);

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

            // guestPrice
            NodeList guest = el.getElementsByTagName("guestPrice");
            Element g = (Element) guest.item(0);

            menue[i] = new Menue(d.getTextContent(), f.getTextContent(), s.getTextContent(), g.getTextContent());
        }

        return menue;
    }

    protected MyXMLParser doInBackground(String... urls)  {
        //get the factory
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try {
            //Using factory get an instance of document builder
            DocumentBuilder db = dbf.newDocumentBuilder();

            //parse using builder to get DOM representation of the XML file
            this.dom = db.parse(urls[0]);

            this.docElm = this.dom.getDocumentElement();
        }
        catch(Exception e) {
            Log.i("Fehler", e.getMessage());

        }
        return this;
    }

    protected void onProgressUpdate(Integer param) {

    }

    protected void onPostExecute(MyXMLParser parser) {
        MainActivity.parser = this;

        try {
            Intent d = new Intent(this.la, MainActivity.class);
            this.la.startActivity(d);
        }
        catch(Exception e) {
            Log.i("Fehler", e.getMessage());
        }
    }
}
