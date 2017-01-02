package com.ednerdaza.plannutricionaled.mvc.controllers.activities;


import android.app.Activity;
import android.app.ActionBar;
import android.app.FragmentTransaction;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v13.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.ednerdaza.plannutricionaled.R;
import com.ednerdaza.plannutricionaled.mvc.controllers.utilities.Config;

public class DailyPlanActivity extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link android.support.v4.app.FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_plan);

        /*Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        //tabLayout.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        tabLayout.setupWithViewPager(mViewPager);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Log.v( Config.APP_LOG , " // onBackPressed Called from BaseActionBarActivity");
        this.overridePendingTransition(R.anim.anim_slide_in_right, R.anim.anim_slide_out_right);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_daily_plan, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_configurations) {
            Intent mainIntent = new Intent().setClass(
                    DailyPlanActivity.this, ConfigurationsActivity.class);
            startActivity(mainIntent);
            //overridePendingTransition(R.anim.left_to_right, R.anim.right_to_left);
            this.overridePendingTransition(R.anim.anim_slide_in_left, R.anim.anim_slide_out_left);
            return true;
        }

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_switch_workouts) {
            //TODO : HACER QUE CAMBIE DE NUTRIVION A EJERCICIOS !!
            /*Intent mainIntent = new Intent().setClass(
                    MainActivity.this, RecommendationsActivity.class);
            startActivity(mainIntent);
            this.overridePendingTransition(R.anim.anim_slide_in_left, R.anim.anim_slide_out_left);*/
            Toast.makeText(this, getResources().getString(R.string.toast_switch), Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends android.support.v4.app.Fragment implements AdapterView.OnItemSelectedListener{
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_daily_plan, container, false);

            Spinner spinnerMilk = (Spinner) rootView.findViewById(R.id.spinner_milk_daily);
            ArrayAdapter<CharSequence> adapterMilk = ArrayAdapter.createFromResource(
                    getContext(), R.array.milk_array, android.R.layout.simple_spinner_item);
            adapterMilk.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            spinnerMilk.setSelection(Config.SPINNER_DEFAULT);
            spinnerMilk.setPrompt(getResources().getString(R.string.milk_prompt));

            //spinnerMilk.setPrompt("Select your favorite Planet!");
            spinnerMilk.setAdapter(adapterMilk);
            spinnerMilk.setOnItemSelectedListener(this);

            Toast.makeText(getContext(),"BIEN "+spinnerMilk.getAdapter().getCount(),Toast.LENGTH_SHORT).show();


            Spinner spinnerChesseOr = (Spinner) rootView.findViewById(R.id.spinner_chesse_or_daily);
            ArrayAdapter<CharSequence> adapterChesseOr = ArrayAdapter.createFromResource(
                    getContext(), R.array.chesse_or_array, android.R.layout.simple_spinner_item);
            adapterChesseOr.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            //spinnerChesseOr.setPrompt("Select your favorite Planet!");
            spinnerChesseOr.setAdapter(adapterChesseOr);
            /*if(spinnerChesseOr.getSelectedItem().ge == 0){
                Toast.makeText(getContext(),"BIEN",Toast.LENGTH_SHORT).show();
            }*/

            Spinner spinnerFlour = (Spinner) rootView.findViewById(R.id.spinner_flour_daily);
            ArrayAdapter<CharSequence> adapterFlour = ArrayAdapter.createFromResource(
                    getContext(), R.array.flour_array, android.R.layout.simple_spinner_item);
            adapterFlour.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerFlour.setAdapter(adapterFlour);

            Spinner spinnerFruit = (Spinner) rootView.findViewById(R.id.spinner_fruit_daily);
            ArrayAdapter<CharSequence> adapterFruit = ArrayAdapter.createFromResource(
                    getContext(), R.array.fruit_array, android.R.layout.simple_spinner_item);
            adapterFruit.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerFruit.setAdapter(adapterFruit);

            Spinner spinnerFat = (Spinner) rootView.findViewById(R.id.spinner_fat_daily);
            ArrayAdapter<CharSequence> adapterFat = ArrayAdapter.createFromResource(
                    getContext(), R.array.fat_array, android.R.layout.simple_spinner_item);
            adapterFat.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerFat.setAdapter(adapterFat);

            Spinner spinnerSugar = (Spinner) rootView.findViewById(R.id.spinner_sugar_daily);
            ArrayAdapter<CharSequence> adapterSugar = ArrayAdapter.createFromResource(
                    getContext(), R.array.sugar_array, android.R.layout.simple_spinner_item);
            adapterSugar.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerSugar.setAdapter(adapterSugar);

            /*TextView textView = (TextView) rootView.findViewById(R.id.section_label);
            textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));*/
            return rootView;
        }

        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
            //Toast.makeText(getContext(),"BIEN "+position,Toast.LENGTH_SHORT).show();
            Object e = adapterView.getItemAtPosition(position);
            if (position==0) {
                //view.setEnabled(false);
            }
            else{
                //adapterView.setEnabled(true);
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    }

    /**
     * A {@link android.support.v4.app.FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends android.support.v4.app.FragmentPagerAdapter {

        public SectionsPagerAdapter(android.support.v4.app.FragmentManager fm) {
            super(fm);
        }

        @Override
        public android.support.v4.app.Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 6;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return getResources().getString(R.string.breakfast);
                case 1:
                    return getResources().getString(R.string.snack);
                case 2:
                    return getResources().getString(R.string.lunch);
                case 3:
                    return getResources().getString(R.string.some);
                case 4:
                    return getResources().getString(R.string.meal);
                case 5:
                    return getResources().getString(R.string.dinner);
            }
            return null;
        }
    }
}
