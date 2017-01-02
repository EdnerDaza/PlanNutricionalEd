package com.ednerdaza.plannutricionaled.mvc.controllers.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.ednerdaza.plannutricionaled.R;

public class ConfigurationsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configurations);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                //overridePendingTransition(R.anim.left_to_right, R.anim.right_to_left);
                this.overridePendingTransition(R.anim.anim_slide_in_right, R.anim.anim_slide_out_right);
        }
        return super.onOptionsItemSelected(item);
    }

}
