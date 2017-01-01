package com.ednerdaza.plannutricionaled.mvc.controllers.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.ednerdaza.plannutricionaled.R;
import com.ednerdaza.plannutricionaled.mvc.controllers.utilities.AppPreferences;
import com.ednerdaza.plannutricionaled.mvc.controllers.utilities.Config;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private AppPreferences mAppPreferences;
    private Button mButtonEditSave, mButtonCancel;
    private EditText mEditTextDate, mEditTextName, mEditTextWeigth, mEditTextSize, mEditTextIMC,
            mEditTextRefWeigth, mEditTextGoalWeigth;
    private TextView mTextViewClick;
    private boolean mButtonEditSaveState = false;

    //region LIFECICLEACTIVITYMETHODS
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.v( Config.APP_LOG , " // onCreate = "+savedInstanceState);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAppPreferences = new AppPreferences(this);

        mButtonEditSave = (Button)findViewById(R.id.button_edit_save_footer_main);
        mButtonCancel= (Button)findViewById(R.id.button_cancel_footer_main);
        mTextViewClick = (TextView) findViewById(R.id.textview_title_main);

        mButtonEditSave.setOnClickListener(this);
        mButtonCancel.setOnClickListener(this);
        mTextViewClick.setOnClickListener(this);

        mEditTextDate = (EditText) findViewById(R.id.edittext_date_main);
        mEditTextName = (EditText) findViewById(R.id.edittext_name_main);
        mEditTextWeigth = (EditText) findViewById(R.id.edittext_weigth_main);
        mEditTextSize = (EditText) findViewById(R.id.edittext_size_main);
        mEditTextIMC = (EditText) findViewById(R.id.edittext_imc_main);
        mEditTextRefWeigth = (EditText) findViewById(R.id.edittext_ref_weigth_main);
        mEditTextGoalWeigth = (EditText) findViewById(R.id.edittext_goal_weigth_main);

        openPreferences();
    }

    //endregion

    //region ONCLICKLISTENERMETHODS
    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.button_edit_save_footer_main:
                Log.v( Config.APP_LOG , " // EDIT BUTTON CLICK");
                if(mButtonEditSaveState){
                    editPreferences();
                }else {
                    savePreferences();
                }
                break;
            case R.id.button_cancel_footer_main:
                Log.v( Config.APP_LOG , " // CANCEL BUTTON CLICK");
                openPreferences();
                break;
            default:
                Log.v( Config.APP_LOG , " // DEFAULT CLICK");
                break;
        }

    }
    //endregion

    //region OPTIONSMENU
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_recommendations) {
             Intent mainIntent = new Intent().setClass(
                        MainActivity.this, RecommendationsActivity.class);
            startActivity(mainIntent);
            overridePendingTransition(R.anim.left_to_right, R.anim.right_to_left);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    //endregion

    private void openPreferences() {
        Log.v( Config.APP_LOG , " // openPreferences()");
        String date = mAppPreferences.getStorageDate();
        String name = mAppPreferences.getStorageName();
        int weigth = mAppPreferences.getStorageWeigth();
        int size = mAppPreferences.getStorageSize();
        float imc = mAppPreferences.getStorageIMC();
        int refWeigth = mAppPreferences.getStorageRefWeigth();
        int goalWeigth = mAppPreferences.getStorageGoalWeigth();

        if(!date.equals("")){
            mEditTextDate.setEnabled(false);
            mEditTextDate.setText(date);
        }

        if(!name.equals("")){
            mEditTextName.setEnabled(false);
            mEditTextName.setText(name);
        }

        if(weigth != 0){
            mEditTextWeigth.setEnabled(false);
            mEditTextWeigth.setText(Integer.toString(weigth));
        }

        if(size != 0){
            mEditTextSize.setEnabled(false);
            mEditTextSize.setText(Integer.toString(size));
        }

        if(imc != 0.0f){
            mEditTextIMC.setEnabled(false);
            mEditTextIMC.setText(Float.toString(imc));
        }

        if(refWeigth != 0){
            mEditTextRefWeigth.setEnabled(false);
            mEditTextRefWeigth.setText(Integer.toString(refWeigth));
        }

        if(goalWeigth != 0){
            mEditTextGoalWeigth.setEnabled(false);
            mEditTextGoalWeigth.setText(Integer.toString(goalWeigth));
        }

        if((date.equals("")) || (name.equals("")) || (weigth == 0) || (size == 0) || (imc == 0.0f)
                || (refWeigth == 0) || (goalWeigth == 0)){

            Log.v( Config.APP_LOG , " // preferencias Vacias()");

            mEditTextDate.setEnabled(true);
            mEditTextName.setEnabled(true);
            mEditTextWeigth.setEnabled(true);
            mEditTextSize.setEnabled(true);
            mEditTextIMC.setEnabled(true);
            mEditTextRefWeigth.setEnabled(true);
            mEditTextGoalWeigth.setEnabled(true);

            mButtonEditSave.setEnabled(true);
            mButtonEditSave.setVisibility(View.VISIBLE);
            mButtonCancel.setEnabled(false);
            mButtonCancel.setVisibility(View.VISIBLE);
            changeEditSaveButton(false);
        }else {
            mButtonEditSave.setEnabled(true);
            mButtonEditSave.setVisibility(View.VISIBLE);
            mButtonCancel.setEnabled(false);
            mButtonCancel.setVisibility(View.VISIBLE);
            changeEditSaveButton(true);
        }

    }

    private void savePreferences() {
        Log.v( Config.APP_LOG , " // savePreferences()");
        String date = "", name = "";
        float imc = 0.0f;
        int weigth = 0, size = 0, refWeigth = 0, goalWeigth = 0;
        String dateString = mEditTextDate.getText().toString();
        String nameString = mEditTextName.getText().toString();
        String weigthString = mEditTextWeigth.getText().toString();
        String sizeString = mEditTextSize.getText().toString();
        String imcString = mEditTextIMC.getText().toString();
        String refWeigthString = mEditTextRefWeigth.getText().toString();
        String goalWeigthString = mEditTextGoalWeigth.getText().toString();

        if(!dateString.equals("")){
            date = dateString;
            if(!nameString.equals("")){
                name = nameString;
                if(!weigthString.equals("")){
                    weigth = Integer.parseInt(weigthString);
                    if(!sizeString.equals("")){
                        size = Integer.parseInt(sizeString);
                        if(!imcString.equals("")){
                            imc = Float.parseFloat(imcString);
                            if(!refWeigthString.equals("")){
                                refWeigth = Integer.parseInt(refWeigthString);
                                if(!goalWeigthString.equals("")){
                                    goalWeigth = Integer.parseInt(goalWeigthString);

                                    mAppPreferences.setStorageGoalWeigth(goalWeigth);
                                    mAppPreferences.setStorageRefWeigth(refWeigth);
                                    mAppPreferences.setStorageIMC(imc);
                                    mAppPreferences.setStorageSize(size);
                                    mAppPreferences.setStorageWeigth(weigth);
                                    mAppPreferences.setStorageName(name);
                                    mAppPreferences.setStorageDate(date);

                                    Toast.makeText(this, getResources().getString(R.string.done_save), Toast.LENGTH_SHORT).show();
                                    openPreferences();

                                }else {
                                    Toast.makeText(this, String.format( getResources().getString(R.string.error_save) ,
                                            getResources().getString(R.string.goal_weigth)), Toast.LENGTH_SHORT).show();
                                }
                            }else {
                                Toast.makeText(this, String.format( getResources().getString(R.string.error_save) ,
                                        getResources().getString(R.string.ref_weigth)), Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            Toast.makeText(this, String.format( getResources().getString(R.string.error_save) ,
                                    getResources().getString(R.string.imc)), Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(this, String.format( getResources().getString(R.string.error_save) ,
                                getResources().getString(R.string.size)), Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(this, String.format( getResources().getString(R.string.error_save) ,
                            getResources().getString(R.string.weigth)), Toast.LENGTH_SHORT).show();
                }
            }else{
                Toast.makeText(this, String.format( getResources().getString(R.string.error_save) ,
                        getResources().getString(R.string.name)), Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this, String.format( getResources().getString(R.string.error_save) ,
                    getResources().getString(R.string.date)), Toast.LENGTH_SHORT).show();
        }



        Log.v( Config.APP_LOG , " // date = "+date+"\n // name = "+name+"\n // weigth = "+weigth+
                "\n // size = "+size+"\n // imc = "+imc+"\n // refWeigth = "+refWeigth+
                "\n // goalWeigth = "+goalWeigth);

    }

    private void editPreferences(){
        Log.v( Config.APP_LOG , " // editPreferences()");
        mEditTextDate.setEnabled(true);
        mEditTextName.setEnabled(true);
        mEditTextWeigth.setEnabled(true);
        mEditTextSize.setEnabled(true);
        mEditTextIMC.setEnabled(true);
        mEditTextRefWeigth.setEnabled(true);
        mEditTextGoalWeigth.setEnabled(true);

        mButtonEditSave.setEnabled(true);
        mButtonEditSave.setVisibility(View.VISIBLE);
        mButtonCancel.setEnabled(true);
        mButtonCancel.setVisibility(View.VISIBLE);
        changeEditSaveButton(false);
    }

    private void changeEditSaveButton(boolean state){
        mButtonEditSaveState = state;
        if(mButtonEditSaveState){
            mButtonEditSave.setText(getResources().getString(R.string.button_edit));
        }else{
            mButtonEditSave.setText(getResources().getString(R.string.button_save));
        }
    }

}
