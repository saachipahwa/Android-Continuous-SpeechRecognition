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
            heading.setText("About WordSmith");
            text.setText("Thank you for using WordSmith! We started work on this app in late 2020 to help people speak more easily and connect with others.\n\n" +
                    "We will always treat your personal data securely (in line with GDPR).\n\n" +
                    "We hope you find our product useful. Please contact us at wordsmithproj@gmail.com to tell us how we can improve.\n\n" +
                    "Team WordSmith");
        }
        if (id==1){
            heading.setText("How to use this app");
            text.setText("To use the Predictive Text Teleprompter\n\n" +
                    "1. Find a quiet place where there is little background noise\n\n" +
                    "2. Make sure that your phone microphone and speaker are working\n\n" +
                    "3. Leave the app open and speak normally\n\n" +
                    "4. If you can’t think of the next word to say, check your screen to see predicted words\n\n" +
                    "5. If you’d like, tap a word to hear it read aloud\n\n" +
                    "6. Continue your conversation");
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
