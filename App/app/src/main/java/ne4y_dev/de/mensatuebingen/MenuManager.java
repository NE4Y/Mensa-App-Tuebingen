package ne4y_dev.de.mensatuebingen;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

public class MenuManager {
    private MenuInterface con;

    public MenuManager(MenuInterface con) {
        this.con = con;
    }


    public void generateListener() {
        //menue button
        ImageButton menuBTN = (ImageButton) ((Activity) con).findViewById(R.id.menu);
        menuBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                con.toggleMenu();
            }
        });

        // menu item
        //menue button
        Button monday = (Button) ((Activity) con).findViewById(R.id.monday);
        monday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent d = new Intent(((Activity) con), MainActivity.class);
                d.putExtra("index", 0);
                ((Activity) con).startActivity(d);
            }
        });

        //menue button
        Button tuesday = (Button) ((Activity) con).findViewById(R.id.tuesday);
        tuesday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent d = new Intent(((Activity) con), MainActivity.class);
                d.putExtra("index", 1);
                ((Activity) con).startActivity(d);
            }
        });

        //menue button
        Button wednesday = (Button) ((Activity) con).findViewById(R.id.wednesday);
        wednesday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent d = new Intent(((Activity) con), MainActivity.class);
                d.putExtra("index", 2);
                ((Activity) con).startActivity(d);
            }
        });

        //menue button
        Button thursday = (Button) ((Activity) con).findViewById(R.id.thursday);
        thursday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent d = new Intent(((Activity) con), MainActivity.class);
                d.putExtra("index", 3);
                ((Activity) con).startActivity(d);
            }
        });

        //menue button
        Button friday = (Button) ((Activity) con).findViewById(R.id.friday);
        friday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent d = new Intent(((Activity) con), MainActivity.class);
                d.putExtra("index", 4);
                ((Activity) con).startActivity(d);
            }
        });

        //menue button
        Button about = (Button) ((Activity) con).findViewById(R.id.about);
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent d = new Intent(((Activity) con), AboutAcitivty.class);
                ((Activity) con).startActivity(d);
            }
        });

        // menu button
        Button settings = (Button) ((Activity) con).findViewById(R.id.settings);
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent d = new Intent(((Activity) con), SettingsActivity.class);
                ((Activity) con).startActivity(d);
            }
        });

        final Button morgenstelle = (Button) ((Activity) con).findViewById(R.id.showMorgenstelle);
        morgenstelle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout morgen = (LinearLayout) ((Activity) con).findViewById(R.id.morgenstelle);
                if (morgen.getVisibility() == View.GONE) {
                    morgen.setVisibility(View.VISIBLE);
                    morgenstelle.setCompoundDrawablesWithIntrinsicBounds(R.drawable.menuitembg, 0, R.drawable.arrowup, 0);
                } else {
                    morgen.setVisibility(View.GONE);
                    morgenstelle.setCompoundDrawablesWithIntrinsicBounds(R.drawable.menuitembg, 0, R.drawable.arrow, 0);
                }
            }
        });

        final Button willhelm = (Button) ((Activity) con).findViewById(R.id.willhelmstr);
        willhelm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout morgen = (LinearLayout) ((Activity) con).findViewById(R.id.willhelmView);
                if (morgen.getVisibility() == View.GONE) {
                    morgen.setVisibility(View.VISIBLE);
                    willhelm.setCompoundDrawablesWithIntrinsicBounds(R.drawable.menuitembg, 0, R.drawable.arrowup, 0);
                } else {
                    morgen.setVisibility(View.GONE);
                    willhelm.setCompoundDrawablesWithIntrinsicBounds(R.drawable.menuitembg, 0, R.drawable.arrow, 0);
                }
            }
        });
    }
}
