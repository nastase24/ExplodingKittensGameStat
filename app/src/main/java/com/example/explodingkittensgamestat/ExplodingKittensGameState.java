package com.example.explodingkittensgamestat;

import android.content.Context;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Hashtable;

/**
 * ExplodingKittensGameState: Creates the decks and assigns and moves cards according to player
 * actions
 * @author Anna Yrjanson
 * @author Audrey Sauter
 * @author Claire Porter
 * @author Alex Nastase
 */

public class ExplodingKittensGameState extends Hashtable{

    public ArrayList<ArrayList<Card>> deck;
    public ArrayList<Card> discard;
    public ArrayList<Card> draw;
    public ArrayList<Card> humanPlayer;
    public  ArrayList<Card> dumb;
    public ArrayList<Card> dumber;
    public ArrayList<Card> dumbest;


    /**
     * ExplodingKittensGameState: creates the various decks for the players, draw, and discard piles
     *
     */
    //default constructor
    public ExplodingKittensGameState(int size) {
        deck = new ArrayList<ArrayList<Card>>(4);
        draw = new ArrayList<Card>(52);
        discard = new ArrayList<Card>(52);
        for(int i = 0; i< size; i++){
            deck.add(new ArrayList<Card>(7));
        }
        createCards();
    }

    /**
     * ExplodingKittensGameState Deep Copy
     * @param state: the
     */
    //deep copy constructor
    public ExplodingKittensGameState(ExplodingKittensGameState state){
        draw = new ArrayList<Card>();
        for (int i = 0; i < state.draw.size(); i++) {
            draw.add(state.draw.get(i));
        }

        discard = new ArrayList<Card>();
        for (int i = 0; i < state.discard.size(); i++) {
            discard.add(state.discard.get(i));
        }

        deck = new ArrayList<ArrayList<Card>>(6);
        deck.add(draw);
        deck.add(discard);
        for (int i = 2; i < state.deck.size(); i++) {
            deck.add(new ArrayList<Card>(7));
            for (int j = 0; j < state.deck.get(i).size(); j++ ) {
                deck.get(i).add(new Card(state.deck.get(i).get(j)));
            }
        }
    }

    /**
     * createCards: creates a hashtable with the card types and their enum values, creates card
     * objects for the number of that type of card in the deck for a four-player game
     *
     */

    public void createCards() {
        //sets the hash table keys and strings to the card description, and the card ID.


        //TODO: ADD in card ID and description to the constructor
        for(int i = 0; i < 4; i++){
            draw.add(new Card(CARDTYPE.ATTACK));
            draw.add(new Card(CARDTYPE.FAVOR));
            draw.add(new Card(CARDTYPE.NOPE));
            draw.add(new Card(CARDTYPE.SHUFFLE));
            draw.add(new Card(CARDTYPE.SKIP));
            draw.add(new Card(CARDTYPE.SEEFUTURE));
            draw.add(new Card(CARDTYPE.MELON));
            draw.add(new Card(CARDTYPE.BEARD));
            draw.add(new Card(CARDTYPE.TACO));
            draw.add(new Card(CARDTYPE.POTATO));
        }
        draw.add(new Card(CARDTYPE.EXPLODE));
        draw.add(new Card(CARDTYPE.EXPLODE));
        draw.add(new Card(CARDTYPE.EXPLODE));

        for(int i = 0; i < 4; i++){
            deck.get(i).add(new Card(CARDTYPE.DEFUSE));
        }
        draw.add(new Card(CARDTYPE.DEFUSE));
        draw.add(new Card(CARDTYPE.DEFUSE));
        draw.add(new Card(CARDTYPE.NOPE));
        draw.add(new Card(CARDTYPE.SEEFUTURE));

       }

    /**
     * playCard: Determines the card selected to be played and executes that play if legal
     * @return if card can be legally played
     */

    // actions verification methods start here

    boolean playCard() {
        if (true) {
        // requirements for defuse
        if( deck.(CARDTYPE.DEFUSE) && deck.(CARDTYPE.EXPLODE)){
            // if user draws exploding kitten card, and has a defuse card, the exploding kitten gets defused
            return true;
        }

        /**
         * requirements for attack
         * player selected attack card
         * player selected another player to attack
         *
         */

        /**
         * requirements for skip
         * player selected skip card
         * player selected discard pile
         *
         */

        /**
         * requirements for seeFuture
         * player selected seeFuture
         * player selected draw pile
         *
         */

        /**
         * requirements for shuffle
         * player selected shuffle
         * player selected draw pile
         *
         */

        /**
         * requirements for favor
         * player selected favor
         * player clicked on another player
         *
         */

        /**
         * requirements for nope
         * another player plays a card
         * player selects nope and selects player or discard pile
         *
         */

        /**
         * requirements for two of a kind
         * player selects select multiple button
         * player selects two of a kind
         * player selects another player
         *
         */

        /**
         * requirements for three of a kind
         * player selects select multiple button
         * player selects three of a kind
         * player selects another player
         * player selects a type of card they ask for
         *
         */

        /**
         * requirements for five
         * player selects select multiple button
         * player selects five cards
         * player selects another player
         * player selects type of card they ask for
         *
         */

    return false;
    }

    /**
     * drawCard: determines which card type was drawn, accordingly defuses exploding kittens or
     * eliminates player if appropriate
     * @return if card was drawn and actions executed legally
     */
    boolean drawCard() {
        if (true) {
            return true;
        }
        return false;
    }

    /**
     * defuse: defuses exploding kittens when drawn
     * @return if defuse executed legally
     */
    boolean defuse() {
        if (true) {
            return true;
        }
        return false;
    }

    /**
     * attack: forces next player to play two turns, current player need not draw card
     * @return if attack executed legally
     */
    boolean attack() {
        if (true) {
            return true;
        }
        return false;
    }

    /**
     * skip: skips current player's turn without drawing card
     * @return if skip executed legally
     */

    boolean skip() {
        if (true) {
            return true;
        }
        return false;
    }

    /**
     * seeFuture: allows player to look at top three draw pile cards
     * @return if see the future executed legally
     */
    boolean seeFuture() {
        if (true) {
            return true;
        }
        return false;
    }

    /**
     * Shuffle: shuffles the draw pile cards
     * @return if shuffle executed legally
     */
    boolean shuffle() {
        if (true) {
            return true;
        }
        return false;
    }

    /**
     * favor: forces another player to give you one card from their hand
     * @return if favor executed legally
     */
    boolean favor() {
        if (true) {
            return true;
        }
        return false;
    }

    /**
     * nope: stops an action before it is executed
     * @return if nope executed legally
     */
    boolean nope() {
        if (true) {
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
        if (true) {
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
        if (true) {
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
        if (true) {
            return true;
        }
        return false;
    }

    /**
     * restartGame: restarts the game at the original game state
     * @return if return executed legally
     */
    boolean restartGame() {
        if (true) {
            return true;
        }
        return false;
    }

    /**
     * quitGame: returns to the main screen
     * @return if quit game executed correctly
     */
    boolean quitGame() {
        if (true) {
            return true;
        }
        return false;
    }

    /**
     * toString: prints a string of all variables in instance to EditText
     * @return String of the various components
     */
    @Override
    public String toString() {
        return deck + " " + discard + " " + draw;
    }
}
