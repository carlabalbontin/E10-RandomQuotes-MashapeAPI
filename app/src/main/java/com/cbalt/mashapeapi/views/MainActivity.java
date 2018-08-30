package com.cbalt.mashapeapi.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.cbalt.mashapeapi.models.Quote;
import com.cbalt.mashapeapi.R;
import com.cbalt.mashapeapi.network.GetQuoteTask;

public class MainActivity extends AppCompatActivity {

    TextView quoteTv, authorTv;
    Button newQuoteButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        quoteTv = findViewById(R.id.quoteTv);
        authorTv = findViewById(R.id.authorTv);
        newQuoteButton = findViewById(R.id.newQuoteBtn);

        newQuoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new BackgroundTask().execute("iiNQ9VEQiamshocO4YEtGc6sP9jCp1tdFX5jsnn6TdiotTm2dQ");
            }
        });
    }

    private class BackgroundTask extends GetQuoteTask {

        @Override
        protected void onPostExecute(Quote[] quotes) {
            quoteTv.setText(quotes[0].getQuote());
            authorTv.setText(quotes[0].getAuthor());
        }

    }
}
