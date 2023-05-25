package com.example.divyansh.googleapivoice;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class InfoActivity extends AppCompatActivity {

    private TextView heading;
    private TextView text;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        Bundle b = getIntent().getExtras();
        assert b != null;
        int id = b.getInt("pageID"); // 0 = About page, 1 = How to page


        //set up text
        heading = findViewById(R.id.heading);
        text = findViewById(R.id.text);

        if (id==0){
            heading.setText("About Wordsmith");
            text.setText("About...");
        }
        if (id==1){
            heading.setText("How to use this app");
            text.setText("How to...");
        }

        // set up home button
        ImageButton homeButton;
        homeButton = findViewById(R.id.homeButton);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

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
