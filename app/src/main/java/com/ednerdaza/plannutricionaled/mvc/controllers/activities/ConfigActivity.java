package com.ednerdaza.plannutricionaled.mvc.controllers.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ListView;

import com.ednerdaza.plannutricionaled.R;

public class ConfigActivity extends AppCompatActivity {

    private ListView mListView;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_lacteos:
                    //mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_queso:
                    //mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_carnes:
                    //mTextMessage.setText(R.string.title_notifications);
                    return true;
                case R.id.navigation_cereles:
                    //mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_leguminosas:
                    //mTextMessage.setText(R.string.title_dashboard);
                    return true;
                /*case R.id.navigation_verduras:
                    //mTextMessage.setText(R.string.title_notifications);
                    return true;
                case R.id.navigation_frutas:
                    //mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_azucares:
                    //mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_grasas:
                    //mTextMessage.setText(R.string.title_notifications);
                    return true;*/
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.config_activity);

        mListView = (ListView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
