package com.epb.techtech;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    //----------------------------------------------------------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

    //----------------------------------------------------------------------------------------------
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                MainActivity();
            }
        }, 500);
    }
    private void MainActivity() {
        Intent intent = new Intent(
                HomeActivity.this,MainActivity.class
        );
        startActivity(intent);
        finish();
    }
    //----------------------------------------------------------------------------------------------
    private long backPressedTime;
    @Override
    public void onBackPressed() {
        if(backPressedTime + 1000 > System.currentTimeMillis()) {
            super.onBackPressed();
            return;
        } else {
            Toast.makeText(getBaseContext(), "Press back again to Exit",  Toast.LENGTH_SHORT).show();
        }
        backPressedTime = System.currentTimeMillis();
    }
}
