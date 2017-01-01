package com.ednerdaza.plannutricionaled.mvc.controllers.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ednerdaza.plannutricionaled.R;

public class RecommendationsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommendations);
        //getActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
