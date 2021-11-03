package com.example.explodingkittensgamestat;

import org.junit.Test;

import static org.junit.Assert.*;

import android.widget.EditText;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

//TODO: write unit tests to test elements of this project:
    //TODO maybe need to set SDK to 28
public class ExampleUnitTest {

    @Test
    public void testThreeMoves(ExplodingKittensGameState ins, EditText textBox) {
        //PREPARE THE GAME
        //TODO: Right before gameplay starts, shuffle each player hand
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