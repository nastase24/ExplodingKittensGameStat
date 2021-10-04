package com.example.explodingkittensgamestat;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {




    Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button runTest;
        runTest = findViewById(R.id.button);
        runTest.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        ExplodingKittensGameState firstInstance = new ExplodingKittensGameState(context);
    }
}