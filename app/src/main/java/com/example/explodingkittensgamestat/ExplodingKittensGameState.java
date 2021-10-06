package com.example.explodingkittensgamestat;

import android.content.Context;

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

    Hashtable<CARDTYPE,String> ht1 = new Hashtable();

    /**
     * ExplodingKittensGameState: creates the various decks for the players, draw, and discard piles
     *
     */
    //default constructor
    public ExplodingKittensGameState(int numPlayers){
        this.deck = new ArrayList<ArrayList<Card>>(6);
        this.draw = new ArrayList<Card>(52);
        this.discard = new ArrayList<Card>(52);
        deck.add(draw);
        deck.add(discard);
        for(int i = 0; i < numPlayers; i++){
            deck.add(new ArrayList<Card>(7));
        }
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
     * @param context
     */

    public void createCards(Context context) {
        //sets the hash table keys and strings to the card description, and the card ID.
        ht1.put(CARDTYPE.MELON, "Cat Cards: tacocat, cattermelon, hairy potato cat, and beard " +
                "cat, must be played in matched pairs, a pair of three allows player to ask for a " +
                "specific card from another's hand, and a pair of two allows player to ask for a " +
                "random card from another's hand.");
        ht1.put(CARDTYPE.BEARD, "Cat Cards: tacocat, cattermelon, hairy potato cat, and beard " +
                "cat, must be played in matched pairs, a pair of three allows player to ask for a " +
                "specific card from another's hand, and a pair of two allows player to ask for a " +
                "random card from another's hand.");
        ht1.put(CARDTYPE.POTATO, "Cat Cards: tacocat, cattermelon, hairy potato cat, and beard " +
                "cat, must be played in matched pairs, a pair of three allows player to ask for a " +
                "specific card from another's hand, and a pair of two allows player to ask for a " +
                "random card from another's hand.");
        ht1.put(CARDTYPE.TACO, "Cat Cards: tacocat, cattermelon, hairy potato cat, and beard " +
                "cat, must be played in matched pairs, a pair of three allows player to ask for a " +
                "specific card from another's hand, and a pair of two allows player to ask for a " +
                "random card from another's hand.");
        ht1.put(CARDTYPE.ATTACK, "Attack: the player ends their turn(s) without drawing a card and the next player takes two turns.");
        ht1.put(CARDTYPE.SHUFFLE, "Shuffle: the player views the top three cards of the deck.");
        ht1.put(CARDTYPE.FAVOR, "Favor: another player must give the player a card from their hand.");
        ht1.put(CARDTYPE.SKIP, "Skip: the player ends their turn without drawing a card.");
        ht1.put(CARDTYPE.SEEFUTURE, "See the Future: the player views the top three cards of the deck.");
        ht1.put(CARDTYPE.NOPE, "Nope: stops the action of another player. Cannot be used on Exploding Kitten or Defuse cards.");
        ht1.put(CARDTYPE.DEFUSE, "Defuse: allows the player to continue playing after drawing an Exploding Kitten.");
        ht1.put(CARDTYPE.EXPLODE, "Exploding Kitten: a player loses when they draw this card, unless they have Defuse " +
                "is discarded and the Exploding Kitten placed back into the deck.\n");

        //TODO: ADD in card ID and description to the constructor
        Card explode1 = new Card(CARDTYPE.EXPLODE);
        Card explode2 = new Card(CARDTYPE.EXPLODE);
        Card explode3 = new Card(CARDTYPE.EXPLODE);

        Card defuse1 = new Card(CARDTYPE.DEFUSE);
        Card defuse2 = new Card(CARDTYPE.DEFUSE);
        Card defuse3 = new Card(CARDTYPE.DEFUSE);
        Card defuse4 = new Card(CARDTYPE.DEFUSE);
        Card defuse5 = new Card(CARDTYPE.DEFUSE);
        Card defuse6 = new Card(CARDTYPE.DEFUSE);

        Card attack1 = new Card(CARDTYPE.ATTACK);
        Card attack2 = new Card(CARDTYPE.ATTACK);
        Card attack3 = new Card(CARDTYPE.ATTACK);
        Card attack4 = new Card(CARDTYPE.ATTACK);

        Card favor1 = new Card(CARDTYPE.FAVOR);
        Card favor2 = new Card(CARDTYPE.FAVOR);
        Card favor3 = new Card(CARDTYPE.FAVOR);
        Card favor4 = new Card(CARDTYPE.FAVOR);

        Card nope1 = new Card(CARDTYPE.NOPE);
        Card nope2 = new Card(CARDTYPE.NOPE);
        Card nope3 = new Card(CARDTYPE.NOPE);
        Card nope4 = new Card(CARDTYPE.NOPE);
        Card nope5 = new Card(CARDTYPE.NOPE);

        Card shuffle1 = new Card(CARDTYPE.SHUFFLE);
        Card shuffle2 = new Card(CARDTYPE.SHUFFLE);
        Card shuffle3 = new Card(CARDTYPE.SHUFFLE);
        Card shuffle4 = new Card(CARDTYPE.SHUFFLE);

        Card skip1 = new Card(CARDTYPE.SKIP);
        Card skip2 = new Card(CARDTYPE.SKIP);
        Card skip3 = new Card(CARDTYPE.SKIP);
        Card skip4 = new Card(CARDTYPE.SKIP);

        Card seeFuture1 = new Card(CARDTYPE.SEEFUTURE);
        Card seeFuture2 = new Card(CARDTYPE.SEEFUTURE);
        Card seeFuture3 = new Card(CARDTYPE.SEEFUTURE);
        Card seeFuture4 = new Card(CARDTYPE.SEEFUTURE);
        Card seeFuture5 = new Card(CARDTYPE.SEEFUTURE);

        Card melon1 = new Card(CARDTYPE.MELON);
        Card melon2 = new Card(CARDTYPE.MELON);
        Card melon3 = new Card(CARDTYPE.MELON);
        Card melon4 = new Card(CARDTYPE.MELON);

        Card beard1 = new Card(CARDTYPE.BEARD);
        Card beard2 = new Card(CARDTYPE.BEARD);
        Card beard3 = new Card(CARDTYPE.BEARD);
        Card beard4 = new Card(CARDTYPE.BEARD);

        Card potato1 = new Card(CARDTYPE.POTATO);
        Card potato2 = new Card(CARDTYPE.POTATO);
        Card potato3 = new Card(CARDTYPE.POTATO);
        Card potato4 = new Card(CARDTYPE.POTATO);

        Card taco1 = new Card(CARDTYPE.TACO);
        Card taco2 = new Card(CARDTYPE.TACO);
        Card taco3 = new Card(CARDTYPE.TACO);
        Card taco4 = new Card(CARDTYPE.TACO);
    }

    /**
     * playCard: Determines the card selected to be played and executes that play if legal
     * @return if card can be legally played
     */

    boolean playCard() {
        if (true) {
            return true;
        }
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
