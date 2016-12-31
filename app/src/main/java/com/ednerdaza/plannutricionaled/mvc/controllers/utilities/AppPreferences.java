package com.ednerdaza.plannutricionaled.mvc.controllers.utilities;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

public class AppPreferences {

    /**********************************************************************************************/

    public static final String PREFS_NAME = "prefsApp";
    public static final String PREF_DATE = "pref_date";
    public static final String PREF_NAME = "pref_name";
    public static final String PREF_WEIGTH = "pref_weigth";
    public static final String PREF_SIZE = "pref_size";
    public static final String PREF_IMC = "pref_imc";
    public static final String PREF_REF_WEIGTH = "pref_ref_weigth";
    public static final String PREF_GOAL_WEIGTH = "pref_goal_weigth";


    private Context context;

    public AppPreferences(Context context) {
        this.context = context;
        Log.v( Config.APP_LOG , this+" // "+this.context);
    }

    public void clear() {
        clear(this.context);
    }

    public static void clear(Context context) {
        SharedPreferences sharePreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor sharedPreferencesEditor;
        sharedPreferencesEditor = sharePreferences.edit();
        sharedPreferencesEditor.clear();
        sharedPreferencesEditor.commit();
        sharedPreferencesEditor.apply();
    }

    //STRING
    public String get(String sConfig, String defaultValue) {
        return get(context, sConfig, defaultValue);
    }

    private static String get(Context context, String sConfig, String defaultValue) {
        SharedPreferences sharePreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        return sharePreferences.getString(sConfig, defaultValue);
    }

    private void set(String sConfig, String value) {
        set(context, sConfig, value);
    }

    private static void set(Context context, String sConfig, String value) {
        SharedPreferences sharePreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor sharedPreferencesEditor;
        sharedPreferencesEditor = sharePreferences.edit();
        sharedPreferencesEditor.putString(sConfig, value);
        sharedPreferencesEditor.commit();
        sharedPreferencesEditor.apply();
        Log.v( Config.APP_LOG , " // "+sharePreferences);
    }

    //BOOLEAN
    private Boolean get(String sConfig, Boolean defaultValue) {
        return get(context, sConfig, defaultValue);
    }

    private static Boolean get(Context context, String sConfig, Boolean defaultValue) {
        SharedPreferences sharePreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        return sharePreferences.getBoolean(sConfig, defaultValue);
    }

    private void set(String sConfig, Boolean value) {
        set(context, sConfig, value);
    }

    private static void set(Context context, String sConfig, Boolean value) {
        SharedPreferences sharePreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor sharedPreferencesEditor;
        sharedPreferencesEditor = sharePreferences.edit();
        sharedPreferencesEditor.putBoolean(sConfig, value);
        sharedPreferencesEditor.commit();
        sharedPreferencesEditor.apply();
        Log.v( Config.APP_LOG , " // "+sharePreferences);
    }

    //INTEGER
    private Integer get(String sConfig, Integer defaultValue) {
        return get(context, sConfig, defaultValue);
    }

    private static Integer get(Context context, String sConfig, Integer defaultValue) {
        SharedPreferences sharePreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        return sharePreferences.getInt(sConfig, defaultValue);
    }

    private void set(String sConfig, Integer value) {
        set(context, sConfig, value);
    }

    private static void set(Context context, String sConfig, Integer value) {
        SharedPreferences sharePreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor sharedPreferencesEditor;
        sharedPreferencesEditor = sharePreferences.edit();
        sharedPreferencesEditor.putInt(sConfig, value);
        sharedPreferencesEditor.commit();
        sharedPreferencesEditor.apply();
        Log.v( Config.APP_LOG , " // "+sharePreferences);
    }

    //LONG
    private Long get(String sConfig, Long defaultValue) {
        return get(context, sConfig, defaultValue);
    }

    private static Long get(Context context, String sConfig, Long defaultValue) {
        SharedPreferences sharePreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        return sharePreferences.getLong(sConfig, defaultValue);
    }

    private void set(String sConfig, Long value) {
        set(context, sConfig, value);
    }

    private static void set(Context context, String sConfig, Long value) {
        SharedPreferences sharePreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor sharedPreferencesEditor;
        sharedPreferencesEditor = sharePreferences.edit();
        sharedPreferencesEditor.putLong(sConfig, value);
        sharedPreferencesEditor.commit();
        sharedPreferencesEditor.apply();
        Log.v( Config.APP_LOG , " // "+sharePreferences);
    }

    //FLOAT
    private Float get(String sConfig, Float defaultValue) {
        return get(context, sConfig, defaultValue);
    }

    private static Float get(Context context, String sConfig, Float defaultValue) {
        SharedPreferences sharePreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        return sharePreferences.getFloat(sConfig, defaultValue);
    }

    private void set(String sConfig, Float value) {
        set(context, sConfig, value);
    }

    private static void set(Context context, String sConfig, Float value) {
        SharedPreferences sharePreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor sharedPreferencesEditor;
        sharedPreferencesEditor = sharePreferences.edit();
        sharedPreferencesEditor.putFloat(sConfig, value);
        sharedPreferencesEditor.commit();
        sharedPreferencesEditor.apply();
        Log.v( Config.APP_LOG , " // "+sharePreferences);
    }


    /**********************************************************************************************/

    public void setStorageDate(String date) {
        set(context, PREF_DATE, date);
    }

    public String getStorageDate() {
        return get(context, PREF_DATE, "");
    }

    public void setStorageName(String name) {
        set(context, PREF_NAME, name);
    }

    public String getStorageName() {
        return get(context, PREF_NAME, "");
    }

    public void setStorageWeigth(int weigth) {
        set(context, PREF_WEIGTH, weigth);
    }

    public int getStorageWeigth() {
        return get(context, PREF_WEIGTH, 0);
    }

    public void setStorageSize(int size) {
        set(context, PREF_SIZE, size);
    }

    public int getStorageSize() {
        return get(context, PREF_SIZE, 0);
    }

    public void setStorageIMC(float imc) {
        set(context, PREF_IMC, imc);
    }

    public float getStorageIMC() {
        return get(context, PREF_IMC, 0.0f);
    }

    public void setStorageRefWeigth(int ref_weigth) {
        set(context, PREF_REF_WEIGTH, ref_weigth);
    }

    public int getStorageRefWeigth() {
        return get(context, PREF_REF_WEIGTH, 0);
    }

    public void setStorageGoalWeigth(int goal_weigth) {
        set(context, PREF_GOAL_WEIGTH, goal_weigth);
    }

    public int getStorageGoalWeigth() {
        return get(context, PREF_GOAL_WEIGTH, 0);
    }

}
