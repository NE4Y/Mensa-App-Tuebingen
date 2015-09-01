package ne4y_dev.de.mensatuebingen;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;


public class MainActivity extends FragmentActivity {
    FragmentPagerAdapter adapterViewPager;
    static MyXMLParser parser;
    SlidingMenu menu;

    // Fragments
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

        // menu
        menu = new SlidingMenu(this);
        menu.setMode(SlidingMenu.LEFT);
        //menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        menu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
        menu.setFadeDegree(0.35f);
        menu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
        menu.setMenu(R.layout.menu);

        //menue button
        ImageButton menuBTN = (ImageButton) findViewById(R.id.menu);
        menuBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleMenu();
            }
        });

        final TextView textViewToChange = (TextView) findViewById(R.id.debug);

        try {
            TextView day = (TextView) findViewById(R.id.date);
            day.setText(parser.getDay() + " - " + parser.getDate());
            Menue[] menues = parser.getMenues();

            ViewPager vpPager = (ViewPager) findViewById(R.id.vpPager);
            adapterViewPager = new MyPagerAdapter(getSupportFragmentManager(), menues);
            vpPager.setAdapter(adapterViewPager);
        }
        catch (Exception e) {
            textViewToChange.setText("An error occurred. Please try again.");
            Log.i("Fehler", e.toString());
        }
    }

    @Override
    public void onBackPressed() {
        if (menu.isMenuShowing()) {
            menu.toggle();
        }
        else {
            super.onBackPressed();
        }
    }

    public void toggleMenu() {
        menu.toggle();
    }
}
