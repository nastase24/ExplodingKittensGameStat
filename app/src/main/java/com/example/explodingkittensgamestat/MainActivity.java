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

        ExplodingKittensGameState firstInstance;
        ExplodingKittensGameState secondInstance;
        ExplodingKittensGameState thirdInstance;

        firstInstance = new ExplodingKittensGameState(ExplodingKittensGameState.NUM_PLAYERS);
        thirdInstance = new ExplodingKittensGameState(ExplodingKittensGameState.NUM_PLAYERS);

        editText.append("Instance: First Instance\n");
        firstInstance.prepareGame();
        secondInstance = new ExplodingKittensGameState(firstInstance);
        test(firstInstance, editText);

        thirdInstance.prepareGame();
        editText.append("Instance: Second Instance\n" + secondInstance.toString());

        editText.append("Instance: Third Instance\n" + thirdInstance.toString());

    }


    public void test(ExplodingKittensGameState ins, EditText textBox) {
        //PREPARE THE GAME
        //TODO: Right before gameplay starts, shuffle each player hand
        textBox.setText("");
        ins.startGame();

        textBox.append("This is the initial game state\n");
        textBox.append(ins.toString());

        //TAKE THE FIRST TURN
        ins.takeTurn(ins.playerTurn);
        ins.endTurn(ins.playerTurn, ExplodingKittensGameState.DRAWCARD);
        textBox.append("Objective: Player 0 draws an exploding kitten card which is automatically" +
                " defused by the computer and sends both cards to discard\n");
        textBox.append(ins.toString());
        ins.nextPlayer(ins.playerTurn);

        //TAKE THE SECOND TURN
        ins.takeTurn(ins.playerTurn);
        ins.playCard(ins.playerTurn, CARDTYPE.SKIP, ins.deck.get(ins.playerTurn), ins.discard);
        ins.endTurn(ins.playerTurn, ExplodingKittensGameState.SKIPTURN);
        textBox.append("Objective: Player 1 plays a skip card to avoid drawing a card, the skip card" +
                " is sent to the discard pile\n");
        textBox.append(ins.toString());
        ins.nextPlayer(ins.playerTurn);

        //TAKE THE THIRD TURN
        ins.takeTurn(ins.playerTurn);
        ins.playCard(ins.playerTurn, CARDTYPE.SHUFFLE, ins.deck.get(ins.playerTurn), ins.discard);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ins.endTurn(ins.playerTurn, ExplodingKittensGameState.DRAWCARD);
        textBox.append("Objective: Player 2 plays a shuffle card which randomizes the draw pile, the" +
                " shuffle card is sent to the discard pile\n");
        textBox.append(ins.toString());

        //END THE GAME
        ins.endGame(ins.playerStatus);
        textBox.append(ins.gameStatetoString());
    }
}