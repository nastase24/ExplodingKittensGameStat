package com.example.explodingkittensgamestat;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Context context = this;

    public ArrayList<ArrayList<Card>> playerHand;
    public ArrayList<Card> discard;
    public ArrayList<Card> draw;

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
        ExplodingKittensGameState firstInstance = new ExplodingKittensGameState(playerHand, discard, draw);
        ExplodingKittensGameState secondInstance = new ExplodingKittensGameState(firstInstance);
        // I am not sure if this is the correct way to assign the variables
        ExplodingKittensGameState thirdInstance = new ExplodingKittensGameState(playerHand, discard, draw);
    }
}