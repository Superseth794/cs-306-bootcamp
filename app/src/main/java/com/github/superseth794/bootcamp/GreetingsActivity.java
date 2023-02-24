package com.github.superseth794.bootcamp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GreetingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greetings);
        Intent intent = getIntent();
        String value = intent.getStringExtra("name");
        TextView label = findViewById(R.id.greetingsLabel);
        label.setText("Hello " + value + "!");
    }
}
