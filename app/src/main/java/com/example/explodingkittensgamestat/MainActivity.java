package com.example.explodingkittensgamestat;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.util.Collections;
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
         *
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
         *
         * @param view
         */
        //TODO: Test three moves, print out every value for the cards??? (Ask Triblehorn)
        //TODO: call second and third instance at proper times and print them out.
        @Override
        public void onClick(View view) {
            // 1. Clear any previous text displayed in the multi-line EditText
            EditText editText = findViewById(R.id.textBox);

            ExplodingKittensGameState instance1;

            // 2. New instance of the game class created - instance1
            instance1 = new ExplodingKittensGameState(ExplodingKittensGameState.NUM_PLAYERS);

            //reports contents of arrays and gamestate right after constructor is called
            //editText.setText("Instance: First Instance\n" + instance1.toString());

            test(instance1, editText);


            //creates cards, assigns them to decks, shuffles the draw pile
            //TODO: Right before gameplay starts, shuffle each player hand
            //editText.append("\n****************\n" + "Instance: First Instance\n" + instance1.toString());
            // 3. Assign secondInstance as deep copy of instance1
           // ExplodingKittensGameState instance2 = new ExplodingKittensGameState(instance1);
            //editText.append("\n****************\n" + "Instance: Second Instance\n" + secondInstance.toString());
        }


        public void test(ExplodingKittensGameState ins, EditText textBox) {
            ins.prepareGame();
            textBox.append(ins.gameStatetoString());
            //textBox.append(ins.toString());
            ins.startGame();
            textBox.append(ins.gameStatetoString());
            //textBox.append(ins.toString());
            ins.takeTurn(ins.playerTurn);
            //Card defuse = new Card(CARDTYPE.DEFUSE);

            //ins.playCard(ins.playerTurn, defuse, ins.deck.get(ins.playerTurn), ins.discard);
          //  ins.lolz();

            ins.endTurn(ins.playerTurn, 4000);
            textBox.append(ins.toString());
            ins.nextPlayer(ins.playerTurn);
            ins.takeTurn(ins.playerTurn);
            Card skip = new Card(CARDTYPE.SKIP);
            ins.playCard(ins.playerTurn, skip, ins.deck.get(ins.playerTurn), ins.discard);
            textBox.append(ins.toString());
            ins.nextPlayer(ins.playerTurn);
            ins.takeTurn(ins.playerTurn);
            Card shuffle = new Card(CARDTYPE.SHUFFLE);
            ins.playCard(ins.playerTurn, shuffle, ins.deck.get(ins.playerTurn), ins.discard);
            ins.endTurn(ins.playerTurn, 4000);
            textBox.append(ins.toString());
            ins.endGame(ins.playerStatus);
            textBox.append(ins.gameStatetoString());
        }



    }
