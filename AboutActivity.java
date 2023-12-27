package com.example.individualassignment2;


import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import android.content.Intent;
import android.net.Uri;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);


        TextView urlTextView = findViewById(R.id.urlTextView);


        urlTextView.setMovementMethod(LinkMovementMethod.getInstance());


        SpannableString spannableString = new SpannableString("SOURCE CODE");


        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View widget) {

                String githubUrl = "https://ufuture.uitm.edu.my/home/";


                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(githubUrl));


                startActivity(intent);
            }
        };


        spannableString.setSpan(clickableSpan, 0, spannableString.length(), 0);


        urlTextView.setText(spannableString, TextView.BufferType.SPANNABLE);
    }
}
