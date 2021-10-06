package com.example.explodingkittensgamestat;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;

import java.util.ArrayList;

/**
 * MainActivity: Assigns the onCreate and onClick methods to create and allow click actions
 * @author Anna Yrjanson
 * @author Audrey Sauter
 * @author Claire Porter
 * @author Alex Nastase
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //Context context = this;

    /**
     * onCreate: creates the initial view of the game on the device
     * @param savedInstanceState
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button runTest;
        runTest = findViewById(R.id.button);
        runTest.setOnClickListener(this);

    }

    /**
     * onClick:
     * @param view
     */

    @Override
    public void onClick(View view) {
        // 1. Clear any previous text displayed in the multi-line EditText

        // 2. New instance of the game class created - firstInstance
        ExplodingKittensGameState firstInstance = new ExplodingKittensGameState(4);

        // 3. Assign secondInstance as deep copy of firstInstance
        ExplodingKittensGameState secondInstance = new ExplodingKittensGameState(firstInstance);

        // 4. Print out firstInstance to EditText to verify the default constructor sets all values appropriately

        // 5. Using firstInstance, test play over THREE legal moves
            // After each action method call, the toString needs to be called on the firstInstance
            // to verify that the game state reflects the updated state - print to EditText

        // 6. Create new instance w/ default constructor - thirdInstance
            // I am not sure if this is the correct way to assign the variables
        ExplodingKittensGameState thirdInstance = new ExplodingKittensGameState(4);

        // 7. Call toString() method on second and thirdInstance - should be identical printouts
            // Print to the multi-line EditText for visual inspection - append not overwrite previous messages
    }
}