package com.siddheswar.socialbook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    NavigationView navigationView;
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionbartoggle;
    BottomNavigationView BottomNavgationDrawer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SetUpToolBar();
        navigationView = findViewById(R.id.nav_view);

        // clicking logics for menu items
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menuHome:
                        Toast.makeText(MainActivity.this, "Home Clicked", Toast.LENGTH_LONG).show();
                        Log.d("papaya","nhi hua");
                        break;

                    case R.id.menuChatBox:
                        Toast.makeText(MainActivity.this, "Chat Clicked", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.menuSetting:
                        Toast.makeText(MainActivity.this, "Settings clicked", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.menuDeveloperInfo:
                        Toast.makeText(MainActivity.this, "Developed by Siddheswar Ojha", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.menuShare:
                        Toast.makeText(MainActivity.this, "Share Clicked", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.menuLogout:
                        Intent i = new Intent(MainActivity.this, activity_profile.class);
                        startActivity(i);
                        break;

                    default:
                        Log.d("messageDrawer", "error gen default");
                }
                return true;
            }
        });
        //  Code Logic for Bottom Navigation Bar
//        BottomNavgationDrawer = findViewById(R.id.BottomNavigationDrawer);
//        BottomNavgationDrawer.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//
//                switch(item.getItemId())
//                {
//                    case R.id.BottomMenuHome:
//
//                        Toast.makeText(MainActivity.this, "Home Selected", Toast.LENGTH_SHORT).show();
//
//                        break;
//                    case R.id.BottomMenuChat:
//                        Toast.makeText(MainActivity.this, "Chat Selected", Toast.LENGTH_SHORT).show();
//                        break;
//                    case R.id.BottomMenuProfile:
//                        Toast.makeText(MainActivity.this, "Profile Selected", Toast.LENGTH_SHORT).show();
//                        break;
//                }
//
//                return true;
//            }
//        });


        // code logic for Recycler Home
      String data = "hi";
        RecyclerView recyclerHome = (RecyclerView)findViewById(R.id.RecyclerHome);
        recyclerHome.setLayoutManager(new LinearLayoutManager(this));
      recyclerHome.setAdapter(new HomeRecylerAdapter(data));

      ImageView imgAddpostIcon = findViewById(R.id.addPostIcon);
      imgAddpostIcon.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent i = new Intent(MainActivity.this,Add_Post_Activity.class);
              startActivity(i);
          }
      });


    }


    //Function helps to set up toolbar
    private void SetUpToolBar() {
        drawerLayout = findViewById(R.id.drawer);
        toolbar = findViewById(R.id.toolbar);

        actionbartoggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.app_name, R.string.app_name);
        drawerLayout.addDrawerListener(actionbartoggle);
        actionbartoggle.syncState();

    }
}