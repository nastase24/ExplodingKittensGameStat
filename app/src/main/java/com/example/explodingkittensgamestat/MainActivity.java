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
    Context context = this;


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
    /**
     * playCard:
     * @return
     */

    boolean playCard() {
        if () {
            return true;
        }
        return false;
    }

    /**
     * drawCard: determines which card type was drawn, accordingly defuses exploding kittens or
     * eliminates player if appropriate
     * @return if card was drawn and actions executed legally
    //add closer
    boolean drawCard() {
    if () {
    return true;
    }
    return false;
    }

    /**
     * defuse: defuses exploding kittens when drawn
     * @return if defuse executed legally
     */
    boolean defuse() {
        if (/* Something */) {
            return true;
        }
        return false;
    }

    /**
     * attack: forces next player to play two turns, current player need not draw card
     * @return if attack executed legally
     */
    boolean attack() {
        if (/* Something */) {
            return true;
        }
        return false;
    }

    /**
     * skip: skips current player's turn without drawing card
     * @return if skip executed legally
     */
    boolean skip() {
        if (/* Something */) {
            return true;
        }
        return false;
    }

    /**
     * seeFuture: allows player to look at top three draw pile cards
     * @return if see the future executed legally
     */
    boolean seeFuture() {
        if (/* Something */) {
            return true;
        }
        return false;
    }

    /**
     * Shuffle: shuffles the draw pile cards
     * @return if shuffle executed legally
     */
    boolean shuffle() {
        if (/* Something */) {
            return true;
        }
        return false;
    }

    /**
     * favor: forces another player to give you one card from their hand
     * @return if favor executed legally
     */
    boolean favor() {
        if (/* Something */) {
            return true;
        }
        return false;
    }

    /**
     * nope: stops an action before it is executed
     * @return if nope executed legally
     */
    boolean nope() {
        if (/* Something */) {
            return true;
        }
        return false;
    }

    /**
     * twoOfKind: determines if two cat cards are the same type, player can steal a random card from
     * another player
     * @return if two of a kind executed legally
     */
    boolean twoOfKind() {
        if (/* Something */) {
            return true;
        }
        return false;
    }

    /**
     * threeOfKind: determines if three matching cards, player can ask player for specific type of
     * card
     * @return if three of a kind executed legally
     */
    boolean threeOfKind() {
        if (/* Something */) {
            return true;
        }
        return false;
    }

    /**
     * playFive: determines if all five selected cards are different, allows player to take card
     * from discard pile
     * @return if five of a kind executed legally
     */
    boolean playFive() {
        if (/* Something */) {
            return true;
        }
        return false;
    }

    /**
     * restartGame: restarts the game at the original game state
     * @return if return executed legally
     */
    boolean restartGame() {
        if (/* Something */) {
            return true;
        }
        return false;
    }

    /**
     * quitGame: returns to the main screen
     * @return if quit game executed correctly
     */
    boolean quitGame() {
        if (/* Something */) {
            return true;
        }
        return false;
    }


}