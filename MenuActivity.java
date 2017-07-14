package com.menselux.bikeride.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.menselux.bikeride.R;
import com.menselux.bikeride.fragment.ChallengeFragment;
import com.menselux.bikeride.fragment.ChronologyFragment;
import com.menselux.bikeride.fragment.FriendsFragment;
import com.menselux.bikeride.fragment.NewsFragment;
import com.menselux.bikeride.fragment.OtzivFragment;
import com.menselux.bikeride.fragment.ProkatVeloFragment;
import com.menselux.bikeride.fragment.SettingsFragment;
import com.menselux.bikeride.fragment.SovetFragment;
import com.menselux.bikeride.fragment.SpravkaFragment;
import com.menselux.bikeride.fragment.UsloviaFragment;
import com.menselux.bikeride.fragment.VeloMarshFragment;
import com.menselux.bikeride.fragment.VeloRoadsFragment;
import com.menselux.bikeride.fragment.VeloShopsFragment;
import com.menselux.bikeride.fragment.YourPlacesFragment;

import static com.menselux.bikeride.R.id.map;


public class MenuActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item)

    {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_yourplaces) {
            showActivity(YourPlacesFragment.class);

        } else if (id == R.id.nav_chronology) {
            showActivity(ChronologyFragment.class);
        } else if (id == R.id.nav_veloroads) {
            showActivity(VeloRoadsFragment.class);
        } else if (id == R.id.nav_veloshops) {
            showActivity(VeloShopsFragment.class);
        } else if (id == R.id.nav_prokat) {
            showActivity(ProkatVeloFragment.class);
        } else if (id == R.id.nav_velomarsh) {
            showActivity(VeloMarshFragment.class);
        } else if (id == R.id.nav_news) {
            showActivity(NewsFragment.class);
        } else if (id == R.id.nav_friends) {
            showActivity(FriendsFragment.class);
        } else if (id == R.id.nav_challenge) {
            showActivity(ChallengeFragment.class);
        } else if (id == R.id.nav_sovet) {
            showActivity(SovetFragment.class);

        } else if (id == R.id.nav_settings) {
            showActivity(SettingsFragment.class);

        } else if (id == R.id.nav_spravka) {
            showActivity(SpravkaFragment.class);

        } else if (id == R.id.nav_otziv) {
            Intent Email = new Intent(Intent.ACTION_SEND);
            Email.setType("text/email");
            Email.putExtra(Intent.EXTRA_EMAIL, new String [] {"caseqol@gmail.com"});
            Email.putExtra(Intent.EXTRA_SUBJECT, "Feedback");
            Email.putExtra(Intent.EXTRA_TEXT, "Dear...," + "");
            startActivity(Intent.createChooser(Email, "Send feedback:"));

        } else if (id == R.id.nav_uslovia) {
            Intent intent = new Intent(this, UsloviaFragment.class);
            //intent.setClass(this, DetailActivity.class);
            intent.putExtra("head", 0);

            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void showActivity (Class show) {
        Intent intent = new Intent(this, show);
        startActivity (intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String regular = prefs.getString(getString(R.string.pref_style), "");
        if (regular.contains("English")){
            Toast.makeText(getApplicationContext(),
                    "Вы выбрали " + " элемент", Toast.LENGTH_SHORT).show();
            attachBaseContext(getBaseContext());
        }

    }

}


