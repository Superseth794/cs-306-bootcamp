package com.github.superseth794.bootcamp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Called when the user touches the button
     */
    public void transferActivity(View view) {
        EditText text = (EditText) findViewById(R.id.mainName);
        Intent myIntent = new Intent(MainActivity.this, GreetingsActivity.class);
        myIntent.putExtra("name", text.getText().toString());
        MainActivity.this.startActivity(myIntent);
    }
}