package com.example.divyansh.googleapivoice;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.icu.text.IDNA;
import android.preference.PreferenceManager;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

public class SettingsActivity extends AppCompatActivity {

    String store_theme;
    String store_font;
    String store_fontsize;
    private TextView heading;
    public static final String KEY_FONT = "Font";
    public static final String KEY_FONTSIZE = "Font size";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        heading = findViewById(R.id.settingshead);

        //set up info buttons
        Button aboutButton;
        aboutButton = findViewById(R.id.aboutButton);
        Button howtoButton;
        howtoButton = findViewById(R.id.howtoButton);
        aboutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openInfoPages(0);
            }
        });
        howtoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openInfoPages(1);
            }
        });

        // set up home button
        ImageButton homeButton;
        homeButton = findViewById(R.id.homeButton);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(SettingsActivity.this);

        store_font = sharedPreferences.getString(KEY_FONT, "Montserrat");
        Typeface typeface = ResourcesCompat.getFont(getApplicationContext(), R.font.montserratmed);

        switch (store_font) {
            case "Montserrat":
                typeface = ResourcesCompat.getFont(getApplicationContext(), R.font.montserratmed);
                break;
            case "Calibri":
                typeface = ResourcesCompat.getFont(getApplicationContext(), R.font.calibri);
                break;
            case "Arial":
                typeface = ResourcesCompat.getFont(getApplicationContext(), R.font.arial);
                break;
            case "Helvetica":
                typeface = ResourcesCompat.getFont(getApplicationContext(), R.font.helvetica);
                break;
        }

        aboutButton.setTypeface(typeface);
        howtoButton.setTypeface(typeface);

        // inflate settings fragment
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.list_container, new SettingsFragment())
                .commit();


    }

    public void openInfoPages(int pageID) {
        Intent intent = new Intent(this, InfoActivity.class);
        intent.putExtra("pageID", pageID); // 0 = About page, 1 = How to page
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        SharedPreferences sharedprefs = PreferenceManager.getDefaultSharedPreferences(this);

        //preferenceFrag.setTypeface(typeface);

    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
    }

}


