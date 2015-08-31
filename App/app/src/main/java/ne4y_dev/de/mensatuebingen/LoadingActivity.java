package ne4y_dev.de.mensatuebingen;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.widget.TextView;

public class LoadingActivity extends Activity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loadingscreen);

        MyXMLParser parser = new MyXMLParser(this);

        if(isOnline()) {
            parser.execute("http://ne4y-dev.de/Mensa-App-Tuebingen/Python%20XML%20Generator/mensa.xml");
        }
        else {
            TextView msg = (TextView) findViewById(R.id.loadingMSG);

            msg.setText("Keine Internetverbindung");
            msg.setBackgroundResource(R.drawable.roundedred);
        }
    }

    // checks if internet connection exists
    public boolean isOnline() {
        ConnectivityManager cm =
                (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }
}
