package ne4y_dev.de.mensatuebingen;

import android.os.StrictMode;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class MyCrawler {
    private String url;

    public MyCrawler(String url) {
        this.url = url;
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);
    }

    public String getXML() throws Exception {
        URL xmlURL = new URL(this.url);
        URLConnection xml = xmlURL.openConnection();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        xml.getInputStream()));
        String inputLine;
        String rXML = "";

        while ((inputLine = in.readLine()) != null)
            rXML += inputLine;
        in.close();

        return rXML;

    }
}
