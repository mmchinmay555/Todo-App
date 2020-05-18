package com.example.todo    ;

import android.content.Context;
import android.content.SharedPreferences;

//This deals with storing the AppTheme...
public class SharedPrefs {
    SharedPreferences mySharedPrefs;

    public SharedPrefs(Context context){
        mySharedPrefs = context.getSharedPreferences("filename", Context.MODE_PRIVATE);
    }

    //to save the dark mode
    public void setDarkMode(Boolean state){
        SharedPreferences.Editor editor = mySharedPrefs.edit();
        editor.putBoolean("DarkMode", state);
        editor.apply();
    }
    //to get the set mode (AppTheme)
    public Boolean loadDarkMode(){
        Boolean state = mySharedPrefs.getBoolean("DarkMode", false);
        return state;
    }
}
