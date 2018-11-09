package com.jpndev.dbapp.utility;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

/**
 * Created by jithi on 04-06-2018.
 */

public class PrefManager {

    public static final String PREFERENCES = "beeone_preference";
    public static final String USERID = "Userid";

    public static final String MTICKER = "mticker";
    public static final String MUSER = "muser";
    public static final String MUSER2 = "muser2";
    public static final String MKYCSTATUS = "mKYCstatus";


    Context context;
    SharedPreferences sharedpreferences;
    SharedPreferences.Editor editor;
    private static PrefManager instance = null;
    private PrefManager()
    {

    }

    // http://graph.facebook.com/1156564127777842/picture?type=larg
    public static PrefManager getInstance(Context context) {
        if(instance == null) {
            instance = new PrefManager(context);
        }
        return instance;
    }
    private PrefManager(Context context) {
        super();
        this.context = context;
        sharedpreferences=context.getSharedPreferences(PREFERENCES, Context.MODE_PRIVATE);
        editor=sharedpreferences.edit();
    }


    public String getUserID()
    {
        return getSharedString(USERID,"");

    }


    public String getSharedString(String KEY, String defValue) {
        if(!isValid(sharedpreferences))
            sharedpreferences =context.getSharedPreferences(PREFERENCES, Context.MODE_PRIVATE);
        if(!isValid(editor))
            editor = sharedpreferences.edit();
        return sharedpreferences.getString(KEY, defValue);
    }

    public Integer getSharedInteger(String KEY, Integer defValue) {
        if(!isValid(sharedpreferences))
            sharedpreferences =context.getSharedPreferences(PREFERENCES, Context.MODE_PRIVATE);
        if(!isValid(editor))
            editor = sharedpreferences.edit();
        return sharedpreferences.getInt(KEY, defValue);
    }

    public void putSharedString(String KEY, String value) {
        if(!isValid(sharedpreferences))
            sharedpreferences =context.getSharedPreferences(PREFERENCES, Context.MODE_PRIVATE);
        if(!isValid(editor))
            editor = sharedpreferences.edit();
        editor.putString(KEY, value).commit();

    }

    public void putSharedInteger(String KEY, Integer value) {
        if(!isValid(sharedpreferences))
            sharedpreferences =context.getSharedPreferences(PREFERENCES, Context.MODE_PRIVATE);
        if(!isValid(editor))
            editor = sharedpreferences.edit();
        editor.putInt(KEY, value).commit();

    }


    public boolean getSharedBoolean(String KEY, boolean defValue) {
        if(!isValid(sharedpreferences))
            sharedpreferences = context.getSharedPreferences(PREFERENCES, Context.MODE_PRIVATE);
        if(!isValid(editor))
            editor = sharedpreferences.edit();
        return sharedpreferences.getBoolean(KEY, defValue);
    }

    public void putSharedBoolean(String KEY, boolean value) {
        if(!isValid(sharedpreferences))
            sharedpreferences = context.getSharedPreferences(PREFERENCES, Context.MODE_PRIVATE);
        if(!isValid(editor))
            editor = sharedpreferences.edit();
        editor.putBoolean(KEY, value).commit();
    }

    private Long getSharedLong(String KEY) {
        if(!isValid(sharedpreferences))
            sharedpreferences =context.getSharedPreferences(PREFERENCES, Context.MODE_PRIVATE);
        if(!isValid(editor))
            editor = sharedpreferences.edit();
        return sharedpreferences.getLong(KEY,0L);
    }

    private void putSharedLong(String KEY, long value) {
        if(!isValid(sharedpreferences))
            sharedpreferences =context.getSharedPreferences(PREFERENCES, Context.MODE_PRIVATE);
        if(!isValid(editor))
            editor = sharedpreferences.edit();
        editor.putLong(KEY, value).commit();
    }


    public void clearSharedAll() {
        if(!isValid(editor))
        {
            if(!isValid(sharedpreferences))
                sharedpreferences =context.getSharedPreferences(PREFERENCES, Context.MODE_PRIVATE);
            editor = sharedpreferences.edit();
        }
        editor.clear().commit();
    }



    public void logout() {
        try {

            String json =null;

            putSharedString(MUSER, json);
        }catch (Exception e)
        {

        }
    }

    public void clearUser()
    {
        try {


            if(!isValid(sharedpreferences))
                sharedpreferences =context.getSharedPreferences(PREFERENCES, Context.MODE_PRIVATE);
            if(!isValid(editor))
                editor = sharedpreferences.edit();
            //  editor.putString(KEY, value).commit();
        /*    SharedPreferences mySPrefs = PreferenceManager.getDefaultSharedPreferences(this);
            SharedPreferences.Editor editor = mySPrefs.edit();*/
            editor.remove(MUSER);
            editor.apply();



        }catch (Exception e)
        {
            e.getMessage();
        }
    }
    public void clearUser2()
    {
        try {


            if(!isValid(sharedpreferences))
                sharedpreferences =context.getSharedPreferences(PREFERENCES, Context.MODE_PRIVATE);
            if(!isValid(editor))
                editor = sharedpreferences.edit();
            //  editor.putString(KEY, value).commit();
        /*    SharedPreferences mySPrefs = PreferenceManager.getDefaultSharedPreferences(this);
            SharedPreferences.Editor editor = mySPrefs.edit();*/
            editor.remove(MUSER2);
            editor.apply();



        }catch (Exception e)
        {
            e.getMessage();
        }
    }
    public void clearKYCstatus()
    {
        try {


            if(!isValid(sharedpreferences))
                sharedpreferences =context.getSharedPreferences(PREFERENCES, Context.MODE_PRIVATE);
            if(!isValid(editor))
                editor = sharedpreferences.edit();
          //  editor.putString(KEY, value).commit();
        /*    SharedPreferences mySPrefs = PreferenceManager.getDefaultSharedPreferences(this);
            SharedPreferences.Editor editor = mySPrefs.edit();*/
            editor.remove(MKYCSTATUS);
            editor.apply();



        }catch (Exception e)
        {
          e.getMessage();
        }
    }


    public Boolean isValid(Object text)
    {
        if(text!=null)

            return  true;
        return  false;

    }

    public Boolean isValid(int count)
    {
        if(count>0)
            return  true;
        return  false;

    }
    public Boolean isValid(String text)
    {
        if(text!=null)
            if(!text.trim().equalsIgnoreCase(""))
                return  true;
        return  false;

    }
    public Boolean isValid(List list)
    {
        if(list!=null)
            if(list.size()>0)
                return  true;
        return  false;

    }


}
