package com.example.explodingkittensgamestat;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

/**
 * MainActivity: Assigns the onCreate and onClick methods to create and allow click actions
 * @author Anna Yrjanson
 * @author Audrey Sauter
 * @author Claire Porter
 * @author Alex Nastase
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    /**
     * onCreate: creates the initial view of the game on the device
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*
        TESTING STUFF
        EditText editText;
        editText = findViewById(R.id.textBox);
        editText.setText("Test");
        Button runTest;
        runTest = findViewById(R.id.button);
        runTest.setOnClickListener(this);

         */

    }

    /**
     * onClick:
     *
     * @param view
     */
    //TODO: Test three moves, print out every value for the cards??? (Ask Triblehorn)
    //TODO: call second and third instance at proper times and print them out.
    @Override
    public void onClick(View view) {
        // 1. Clear any previous text displayed in the multi-line EditText
        //EditText editText = findViewById(R.id.textBox);
        //editText.setText("");
        //ImageButton imageButton = findViewById(R.id.imageButton);

        ExplodingKittensGameState firstInstance;
        ExplodingKittensGameState secondInstance;
        ExplodingKittensGameState thirdInstance;

        firstInstance = new ExplodingKittensGameState(ExplodingKittensGameState.NUM_PLAYERS);
        thirdInstance = new ExplodingKittensGameState(ExplodingKittensGameState.NUM_PLAYERS);

        //editText.append("Instance: First Instance\n");
        firstInstance.prepareGame();
        //imageButton.setImageResource(firstInstance.draw.get(0).image);
        //editText.append(firstInstance.toString());
        secondInstance = new ExplodingKittensGameState(firstInstance);
        //test(firstInstance, editText);

        //thirdInstance.prepareGame();
        //editText.append("Instance: Second Instance\n" + secondInstance.toString());

        //editText.append("Instance: Third Instance\n" + thirdInstance.toString());

    }



}