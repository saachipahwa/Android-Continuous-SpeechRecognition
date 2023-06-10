package com.example.divyansh.googleapivoice;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.Html;
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

        Uri uri = Uri.parse("https://forms.gle/b1P8azZEc9nMd1RQ6");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);

        String heading0 = "<b>" + "About WordSmith" + "<b> ";
        String text0 ="Thank you for using WordSmith! We started work on this app in late 2020 to help people <b>speak more easily</b> and <b>connect with others</b>.<br><br>" +
                "We will always <b>treat your personal data securely</b> (in line with GDPR).<br><br>" +
                "We hope you find our product useful. Please <b>contact us< at wordsmithproj@gmail.com/b> to tell us how we can improve.<br><br>" +
                "Team WordSmith";
        String heading1 = "<b>" + "How to use WordSmith" + "<b> ";
        String text1 = "To use the Predictive Text Teleprompter<br>" +
                "1. Find a <b>quiet place</b> where there is little background noise<br>" +
                "2. Make sure that your <b>phone microphone and speaker</b> are working<br>" +
                "3. Leave the app open and speak normally<br>" +
                "4. If you can’t think of the next word to say, <b>check your screen to see predicted words</b><br>" +
                "5. If you’d like, <b>tap</b> a word to hear it read aloud<br>" +
                "6. Continue your conversation<br><br>"+
                "To <b>customise the app’s appearance</b>, press the back button below or press ⊕ from the home screen. <br>";
        if (id==0){
            heading.setText(Html.fromHtml(heading0));
            text.setText(Html.fromHtml(text0));
            formButton.setVisibility(View.INVISIBLE);
        }
        else if (id==1){
            heading.setText(Html.fromHtml(heading1));
            text.setText(Html.fromHtml(text1));
            formButton.setVisibility(View.VISIBLE);
            formButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(Intent.ACTION_VIEW, uri));

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
