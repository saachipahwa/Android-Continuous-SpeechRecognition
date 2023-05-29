package com.example.divyansh.googleapivoice;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class InfoActivity extends AppCompatActivity {

    private TextView heading;
    private TextView text;
    private Button formButton;

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
        formButton = findViewById(R.id.feedbackFormButton);

        Uri uri = Uri.parse("http://www.google.com"); // missing 'http://' will cause crashed
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);


        if (id==0){
            heading.setText("About WordSmith");
            text.setText("Thank you for using WordSmith! We started work on this app in late 2020 to help people speak more easily and connect with others.\n" +
                    "We will always treat your personal data securely (in line with GDPR).\n" +
                    "We hope you find our product useful. Please contact us at wordsmithproj@gmail.com to tell us how we can improve.\n" +
                    "Team WordSmith");
            formButton.setVisibility(View.INVISIBLE);
        }
        else if (id==1){
            heading.setText("How to use this app");
            text.setText("To use the Predictive Text Teleprompter\n" +
                    "1. Find a quiet place where there is little background noise\n" +
                    "2. Make sure that your phone microphone and speaker are working\n" +
                    "3. Leave the app open and speak normally\n" +
                    "4. If you can’t think of the next word to say, check your screen to see predicted words\n" +
                    "5. If you’d like, tap a word to hear it read aloud\n" +
                    "6. Continue your conversation\n\n"+
                    "To customise the app’s appearance, press the back button below or press ⊕ \n");
            formButton.setVisibility(View.VISIBLE);
            formButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://google.com")));

                }
            });

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
