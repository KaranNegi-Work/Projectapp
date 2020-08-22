package com.example.projectapp;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.projectapp.fragments.home;
import com.example.projectapp.fragments.message;
import com.example.projectapp.fragments.radio;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomePage extends AppCompatActivity {
    private AlertDialog.Builder dialogBox;
    Button logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.frame, new home()).commit();

        logout = findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sp;
                sp = getSharedPreferences("LoginDetail", Context.MODE_PRIVATE);
                SharedPreferences.Editor check = sp.edit();
                check.putString("Status", "false");
                check.commit();
                startActivity(new Intent(HomePage.this, MainActivity.class));
            }
        });

    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListener= new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            Fragment selectedFragment=null ;
            switch (item.getItemId()) {
                case R.id.home:
                    selectedFragment = new home();
                    break;
                case R.id.message:
                    selectedFragment = new message();
                    break;
                case R.id.radio:
                    selectedFragment = new radio();
                    break;

                default:
                    throw new IllegalStateException("Unexpected value: " + item.getItemId());

            }
            getSupportFragmentManager().beginTransaction().replace(R.id.frame,selectedFragment).commit();
            return true;

        }
    };

}