package com.ednerdaza.plannutricionaled.mvc.controllers.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;

import com.ednerdaza.plannutricionaled.R;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity
{

    private static final long SPLASH_SCREEN_DELAY = 3000;
    private Timer timer;
    private TimerTask task;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
        task = new TimerTask()
        {
            @Override
            public void run()
            {
                openDashboard();
            }
        };

        timer = new Timer();
        timer.schedule(task, SPLASH_SCREEN_DELAY);

    }


    public void openDashboard()
    {
        Intent mainIntent = new Intent().setClass(
                SplashActivity.this, MainActivity.class);
        startActivity(mainIntent);
        finish();
    }
    
}
