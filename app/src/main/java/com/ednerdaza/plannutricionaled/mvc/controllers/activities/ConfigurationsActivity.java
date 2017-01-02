package com.ednerdaza.plannutricionaled.mvc.controllers.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.ednerdaza.plannutricionaled.R;
import com.ednerdaza.plannutricionaled.mvc.controllers.adapters.ItemsAdapter;
import com.ednerdaza.plannutricionaled.mvc.controllers.utilities.Config;

import java.util.ArrayList;
import java.util.List;

public class ConfigurationsActivity extends AppCompatActivity {

    private ListView mListViewMilk, mListViewChesseOr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configurations);

        mListViewMilk = (ListView) findViewById(R.id.listview_milk_daily);
       //mListViewChesseOr = (ListView) findViewById(R.id.listview_chesse_or_daily);

        // Instanciating an array list (you don't need to do this,
        // you already have yours).
        List<String> your_array_list = new ArrayList<String>();
        your_array_list.add("foo");
        your_array_list.add("bar");

        // This is the array adapter, it takes the context of the activity as a
        // first parameter, the type of list view as a second parameter and your
        // array as a third parameter.
        /*ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                your_array_list );

        lv.setAdapter(arrayAdapter);*/

        ItemsAdapter adapter;
        // Inicializamos el adapter.
        adapter = new ItemsAdapter(this, getResources().getStringArray(R.array.milk_array));
        // Asignamos el Adapter al ListView, en este punto hacemos que el
        // ListView muestre los datos que queremos.
        mListViewMilk.setAdapter(adapter);
        //mListViewChesseOr.setAdapter(adapter);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                this.overridePendingTransition(R.anim.anim_slide_in_right, R.anim.anim_slide_out_right);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Log.v( Config.APP_LOG , " // onBackPressed Called from BaseActionBarActivity");
        this.overridePendingTransition(R.anim.anim_slide_in_right, R.anim.anim_slide_out_right);
    }

}
