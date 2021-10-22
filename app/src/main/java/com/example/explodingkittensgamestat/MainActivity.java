package com.example.explodingkittensgamestat;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;

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

        EditText editText;
        editText = findViewById(R.id.textBox);
        editText.setText("Test");

        Button runTest;
        runTest = findViewById(R.id.button);
        runTest.setOnClickListener(this);

    }

    /**
     * onClick:
     * @param view
     */


    //TODO: Test three moves, print out every value for the cards??? (Ask Triblehorn)
    //TODO: call second and third instance at proper times and print them out.

    @Override
    public void onClick(View view) {
        // 1. Clear any previous text displayed in the multi-line EditText
        EditText editText = findViewById(R.id.textBox);
        ExplodingKittensGameState firstInstance;

        // 2. New instance of the game class created - firstInstance
        firstInstance = new ExplodingKittensGameState(ExplodingKittensGameState.NUM_PLAYERS);

        //reports contents of arrays and gamestate right after constructor is called
        //editText.setText("Instance: First Instance\n" + firstInstance.toString());

        firstInstance.prepareGame();
       // editText.append(firstInstance.toString());
        test(firstInstance, editText);

        //creates cards, assigns them to decks, shuffles the draw pile
        //TODO: Right before gameplay starts, shuffle each player hand

        //editText.append("\n****************\n" + "Instance: First Instance\n" + firstInstance.toString());

        // 3. Assign secondInstance as deep copy of firstInstance
        ExplodingKittensGameState secondInstance = new ExplodingKittensGameState(firstInstance);
        //editText.append("\n****************\n" + "Instance: Second Instance\n" + secondInstance.toString());


        // 4. Print out firstInstance to EditText to verify the default constructor sets all values appropriately
        //Tests the information in the firstInstance Game State
        //String test2 = "Test 2" + secondInstance.toString();

        // 5. Using firstInstance, test play over THREE legal moves
        // After each action method call, the toString needs to be called on the firstInstance
        // to verify that the game state reflects the updated state - print to EditText

        // 6. Create new instance w/ default constructor - thirdInstance
        // I am not sure if this is the correct way to assign the variables
        //ExplodingKittensGameState thirdInstance = new ExplodingKittensGameState(4);
        //editText.setText(test1 + test2 + "Test 3" + thirdInstance.toString());

        // 7. Call toString() method on second and thirdInstance - should be identical printouts
        // Print to the multi-line EditText for visual inspection - append not overwrite previous messages
    }

    public void test(ExplodingKittensGameState firstInstance, EditText textBox){
        firstInstance.startGame();
        textBox.append(firstInstance.toString());

        firstInstance.takeTurn(0);
        firstInstance.deck.get(0).add(0,new Card(CARDTYPE.EXPLODE));
        firstInstance.endTurn(0, 4000);
        firstInstance.nextPlayer(firstInstance.playerTurn);
        textBox.append(firstInstance.toString());

        firstInstance.takeTurn(0);
        firstInstance.deck.get(0).add(0,new Card(CARDTYPE.SHUFFLE));
        firstInstance.playCard(0,firstInstance.getCard(CARDTYPE.SHUFFLE,firstInstance.deck.get(0)),firstInstance.deck.get(0),firstInstance.discard);
        firstInstance.endTurn(0, 4000);
        firstInstance.nextPlayer(firstInstance.playerTurn);
        textBox.append(firstInstance.toString());

        firstInstance.takeTurn(0);
        firstInstance.deck.get(0).add(0,new Card(CARDTYPE.SKIP));
        firstInstance.playCard(firstInstance.playerTurn,firstInstance.getCard(CARDTYPE.SKIP,firstInstance.deck.get(0)),firstInstance.deck.get(0),firstInstance.discard);
        firstInstance.endTurn(0, 4000);

        firstInstance.endTurn(0, 4000);
        firstInstance.nextPlayer(firstInstance.playerTurn);
        textBox.append(firstInstance.toString());
        firstInstance.endGame(firstInstance.playerStatus);
    }
}