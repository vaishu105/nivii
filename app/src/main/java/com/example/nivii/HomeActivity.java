package com.example.nivii;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity implements
        BottomNavigationView.OnNavigationItemSelectedListener {

    boolean doubletap = false;

    BottomNavigationView bottomNavigationView;

    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home);

        setTitle("Home Activity");

        preferences = PreferenceManager.getDefaultSharedPreferences(HomeActivity.this);
        editor = preferences.edit();

        boolean firsttime = preferences.getBoolean("isFirstTime",true);

        if(firsttime) {
            welcom();
        }

        bottomNavigationView = findViewById(R.id.homeBotNav);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.menuBotNavHome);


    }

    public void welcom()
    {
        AlertDialog.Builder ad = new AlertDialog.Builder(HomeActivity.this);
        ad.setMessage("Welcom Guys..!! ");
        ad.setPositiveButton("Thank You",
                new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        }).create().show();

        editor.putBoolean("isFirstTime",false).commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_home,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id .menuHomeMyProfile)
        {
            Intent i = new Intent(HomeActivity.this , MyProfileActivity.class);
            startActivity(i);
        }
        if(item.getItemId() == R.id .menuHomeSetting)
        {

        }
        if(item.getItemId() == R.id .menuHomeContactUs)
        {

        }
        if(item.getItemId() == R.id .menuHomeAboutUs)
        {

        }
        if(item.getItemId() == R.id .menuHomeLogout)
        {
           logout();
        }
        return true;
    }

    private void logout()
    {
        AlertDialog.Builder ad = new AlertDialog.Builder(HomeActivity.this);
        ad.setMessage("Are you sure you want to logout?");
        ad.setPositiveButton("Cancle", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        ad.setNegativeButton("Logout", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
                editor.putBoolean("isLogin",false).commit();
                startActivity(intent);
            }
        }).create().show();
    }

    @Override

    public void onBackPressed() {
        if(doubletap)
        {
            finishAffinity();
        }
        else
        {
            Toast.makeText(HomeActivity.this,"Presss Again to Exit App",
                    Toast.LENGTH_SHORT).show();
            doubletap = true;
            Handler h = new Handler();
            h.postDelayed(new Runnable() {
                @Override
                public void run() {
                    doubletap = false;
                }
            },2000);
        }
    }


    HomeFragment homeFragment = new HomeFragment();
    GadgetsFragment gadgetsFragment = new GadgetsFragment();
    FriendsFragment friendsFragment = new FriendsFragment();
    EpisodesFragment episodesFragment = new EpisodesFragment();
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        if(item.getItemId() == R.id.menuBotNavHome)
        {
           getSupportFragmentManager().beginTransaction()
                   .replace(R.id.homeFrameLayout,homeFragment).commit();
        }
        else if (item.getItemId() == R.id.menuBotNavGadgets)
        {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.homeFrameLayout,gadgetsFragment).commit();
        }
        else if (item.getItemId() == R.id.menuBotNavFriends)
        {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.homeFrameLayout,friendsFragment).commit();
        }
        else if (item.getItemId() == R.id.menuBotNavEpisodes)
        {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.homeFrameLayout,episodesFragment).commit();
        }

        return true;
    }
}