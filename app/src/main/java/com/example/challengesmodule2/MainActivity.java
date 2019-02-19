package com.example.challengesmodule2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void challenge1(View view) {

        Intent i = new Intent( this, challenge1.class);
        startActivity(i);
    }

    public void challenge2(View view) {
        Intent i = new Intent( this, challenge2.class);
        startActivity(i);
    }

    public void challenge3(View view) {
        Intent i = new Intent( this, challenge3.class);
        startActivity(i);
    }

    public void challenge4(View view) {
        Intent i = new Intent( this, challenge4.class);
        startActivity(i);
    }

    public void challenge5(View view) {
        Intent i = new Intent( this, challenge5.class);
        startActivity(i);
    }
}
