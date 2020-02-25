package com.example.teamwork.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.teamwork.HomeFragment;
import com.example.teamwork.PostFragment;
import com.example.teamwork.ProfileFragment;
import com.example.teamwork.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Home extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        setTitle("TeamWork");

        //Initializing of Member Variable "Bottom NavigationBar"
        bottomNavigationView = findViewById(R.id.bottomNavigation);

        toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

        final HomeFragment homeFragment = new HomeFragment();
        final PostFragment postFragment = new PostFragment();
        final ProfileFragment profileFragment = new ProfileFragment();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

             switch (menuItem.getItemId()) {
                 case R.id.Home_item:
                     setFragment(homeFragment);
                     setTitle("Home");
                     break;
                 case R.id.post_item:
                     setFragment(postFragment);
                     setTitle("Post");
                     break;
                 case R.id.profile_item:
                     setFragment(profileFragment);
                     setTitle("Profile");
                     break;

             }
                return true;
            }
        });

        bottomNavigationView.setSelectedItemId(R.id.Home_item);

    }

    //Method to set Fragment
    private void setFragment(Fragment fragment){

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame,fragment);
        fragmentTransaction.commit();

    }

    //method to inflate menu


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.popup_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {


        switch (item.getItemId()){

         case R.id.Sign_out:
            Toast.makeText(this, "Exit Button is clicked", Toast.LENGTH_SHORT).show();
            break;
        }


        return super.onOptionsItemSelected(item);
    }
}
