package com.example.todo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Settings extends AppCompatActivity {
    private Switch switch1;
    private TextView suggestions;
    com.example.todo.SharedPrefs sharedPrefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        sharedPrefs = new com.example.todo.SharedPrefs(this);
        //Load App theme
        if(sharedPrefs.loadDarkMode() == true){
            setTheme(R.style.SettingsDarkTheme);
        }
        else{
            setTheme(R.style.SettingsTheme);
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        switch1 = (Switch) findViewById(R.id.switch1);

        //control the state of the switch using the saved data in sharedPreference
        if(sharedPrefs.loadDarkMode() == true){
            switch1.setChecked(true);
        }
        else{
            switch1.setChecked(false);
        }

        //switch to set the AppTheme
        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    sharedPrefs.setDarkMode(true);
                    restartApp();
                }
                else {
                    sharedPrefs.setDarkMode(false);
                    restartApp();
                }
            }
        });

        //link for the user to send suggestions to the owner
        suggestions = findViewById(R.id.suggestions);

        suggestions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mailIntent = new Intent(Intent.ACTION_VIEW);

                //initialse the values for the mail
                Uri data = Uri.parse("mailto:?subject=" + "ToDo App Suggestion"+ "&body=" + "Your Suggestions" + "&to=" + "mmchinmay555@mail.com");

                mailIntent.setData(data);
                startActivity(Intent.createChooser(mailIntent, "Send mail..."));
            }
        });
    }

    //if the AppTheme switch's state is changed, we need to restart the app
    // to load the set AppTheme
    public void restartApp(){
        Intent j = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(j);

        Intent i = new Intent(getApplicationContext(), Settings.class);
        startActivity(i);

        finish();
    }
}
