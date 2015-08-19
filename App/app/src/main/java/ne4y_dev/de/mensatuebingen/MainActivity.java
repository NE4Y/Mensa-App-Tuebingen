package ne4y_dev.de.mensatuebingen;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;


public class MainActivity extends FragmentActivity {
    FragmentPagerAdapter adapterViewPager;

    public static class MyPagerAdapter extends FragmentPagerAdapter {
        private int NUM_ITEMS;
        private Menue[] menue;

        public MyPagerAdapter(FragmentManager fragmentManager, Menue[] men) {
            super(fragmentManager);
            this.menue = men;
            this.NUM_ITEMS = men.length;
        }

        // Returns total number of pages
        @Override
        public int getCount() {
            return NUM_ITEMS;
        }

        // Returns the fragment to display for that page
        @Override
        public Fragment getItem(int position) {
            return FirstFragment.newInstance(position, this.menue[position]);
        }

        // Returns the page title for the top indicator
        @Override
        public CharSequence getPageTitle(int position) {
            return this.menue[position].getName();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView textViewToChange = (TextView) findViewById(R.id.debug);

        //MyCrawler xml = new MyCrawler("http://www.ne4y-dev.de/Mensa-App-Tuebingen/Python%20XML%20Generator/mensa.xml");

        try {
            //String response = xml.getXML();
            //textViewToChange.setText("geht");
            //Log.i("xml", response);
            MyXMLParser parser = new MyXMLParser();
            //textViewToChange.setText("Geht");

            TextView day = (TextView) findViewById(R.id.date);
            day.setText(parser.getDay()+" - " + parser.getDate());
            Menue[] menues = parser.getMenues();

            for(int i=0; i< menues.length; i++) {
                Log.i("menue", menues[i].toString());
            }

            ViewPager vpPager = (ViewPager) findViewById(R.id.vpPager);
            adapterViewPager = new MyPagerAdapter(getSupportFragmentManager(), menues);
            vpPager.setAdapter(adapterViewPager);
        }
        catch(Exception e) {
            textViewToChange.setText("An error occurred.");
            Log.i("error", e.toString());

        }
    }
}
