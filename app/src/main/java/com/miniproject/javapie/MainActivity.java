package com.miniproject.javapie;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.miniproject.javapie.ui.home.HomeFragment;
import com.miniproject.javapie.ui.previous_activity.PreviousActivityFragment;
import com.miniproject.javapie.ui.registered_events.RegisteredEventsFragment;
import com.miniproject.javapie.ui.today_activity.TodayActivityFragment;
import com.miniproject.javapie.ui.upcoming_activity.UpcomingActivityFragment;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
private ActionBar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        BottomNavigationView mbottom = findViewById(R.id.bnavigationView);
        NavigationView navigationView = findViewById(R.id.nav_view);
//        // Passing each menu ID as a set of Ids because each
//        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_upcoming, R.id.nav_today,
                R.id.nav_previous, R.id.nav_registerfor)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
//        Log.d("Error","Error",get);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment fragment;
                switch (menuItem.getItemId())
                {
                    case R.id.nav_home:
                        toolbar.setTitle("Home");
                        fragment=new HomeFragment();
                        loadFragment(fragment);
                        return true;
                    case R.id.nav_upcoming:
                        toolbar.setTitle("Upcoming Events");
                        fragment=new UpcomingActivityFragment();
                        loadFragment(fragment);
                        return true;
                    case R.id.nav_today:
                        toolbar.setTitle("Today Events");
                        fragment=new TodayActivityFragment();
                        loadFragment(fragment);
                        return true;
                    case R.id.nav_previous:
                        toolbar.setTitle("Previous Events");
                        fragment=new PreviousActivityFragment();
                        loadFragment(fragment);
                        return true;
                    case R.id.nav_registerfor:
                        toolbar.setTitle("Events Registered For");
                        fragment=new RegisteredEventsFragment();
                        loadFragment(fragment);
                        return true;
                }
                return false;

            }
        });
        mbottom.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment fragment;
                switch (menuItem.getItemId())
                {
                    case R.id.navigation_dashboard:
                        toolbar.setTitle("Dashboard");
                        fragment=new DashboardFragment();
                        loadFragment(fragment);
                        return true;
                    case R.id.navigation_profile:
                        toolbar.setTitle("Profile");
                       fragment=new ProfileFragement();
                        loadFragment(fragment);
                        return true;
                    case R.id.navigation_about:
                        toolbar.setTitle("About");
                        fragment=new ProfileFragement();
                        loadFragment(fragment);
                        return true;
                }
                return true;
            }
        });

    }

    private void loadFragment(Fragment fragment) {
   FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
   fragmentTransaction.replace(R.id.nav_host_fragment,fragment);
   fragmentTransaction.addToBackStack(null);
   fragmentTransaction.commit();
    }
}
