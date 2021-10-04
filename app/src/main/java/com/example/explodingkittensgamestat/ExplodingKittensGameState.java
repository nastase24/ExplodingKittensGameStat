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


    public ArrayList<ArrayList<Card>> playerHand;
    public ArrayList<Card> discard;
    public ArrayList<Card> draw;

    Hashtable<CARDTYPE,String> ht1 = new Hashtable();


    /**
     * ExplodingKittensGameState: creates the various decks for the players, draw, and discard piles
     *
     */
    //default constructor
    public ExplodingKittensGameState(int numPlayers){
        this.playerHand = new ArrayList<ArrayList<Card>>(6);
        this.draw = new ArrayList<Card>(52);
        this.discard = new ArrayList<Card>(52);
        playerHand.add(draw);
        playerHand.add(discard);
        for(int i = 0; i < numPlayers; i++){
            ArrayList<Card> player = new ArrayList<Card>(7);
            playerHand.add(player);
        }

        // Assign variables as normal
        // Create totally normal constructor
    }

    /**
     * ExplodingKittensGameState Deep Copy
     * @param state: the
     */
    //deep copy constructor
    public ExplodingKittensGameState(ExplodingKittensGameState state){
        playerHand = new ArrayList<ArrayList<Card>>(6);
        for (int i = 0; i < state.draw.size(); i++) {
            draw.add(state.draw.get(i));
        }
        for (int i = 0; i < state.discard.size(); i++) {
            discard.add(state.discard.get(i));
        }
        for (int i = 0; i < state.playerHand.size(); i++) {
            playerHand.add(new ArrayList<Card>(52));
            for (int j = 0; j < state.playerHand.get(i).size(); j++ ) {
                playerHand.get(i).add( new Card (state.playerHand.get(i).get(j)));
            }
        }


    }

    /**
     * createCards: creates a hashtable with the card types and their enum values, creates card
     * objects for the number of that type of card in the deck for a four-player game
     * @param context
     */

    public void createCards(Context context){
        //sets the hash table keys and strings to the card description, and the card ID.
        ht1.put(CARDTYPE.MELON,"Cat Cards: tacocat, cattermelon, hairy potato cat, and beard " +
                "cat, must be played in matched pairs, a pair of three allows player to ask for a " +
                "specific card from another's hand, and a pair of two allows player to ask for a " +
                "random card from another's hand.");
        ht1.put(CARDTYPE.BEARD,"Cat Cards: tacocat, cattermelon, hairy potato cat, and beard " +
                "cat, must be played in matched pairs, a pair of three allows player to ask for a " +
                "specific card from another's hand, and a pair of two allows player to ask for a " +
                "random card from another's hand.");
        ht1.put(CARDTYPE.POTATO,"Cat Cards: tacocat, cattermelon, hairy potato cat, and beard " +
                "cat, must be played in matched pairs, a pair of three allows player to ask for a " +
                "specific card from another's hand, and a pair of two allows player to ask for a " +
                "random card from another's hand.");
        ht1.put(CARDTYPE.TACO,"Cat Cards: tacocat, cattermelon, hairy potato cat, and beard " +
                "cat, must be played in matched pairs, a pair of three allows player to ask for a " +
                "specific card from another's hand, and a pair of two allows player to ask for a " +
                "random card from another's hand.");
        ht1.put(CARDTYPE.ATTACK, "Attack: the player ends their turn(s) without drawing a card and the next player takes two turns.");
        ht1.put(CARDTYPE.SHUFFLE, "Shuffle: the player views the top three cards of the deck.");
        ht1.put(CARDTYPE.FAVOR, "Favor: another player must give the player a card from their hand.");
        ht1.put(CARDTYPE.SKIP,"Skip: the player ends their turn without drawing a card.");
        ht1.put(CARDTYPE.SEEFUTURE, "See the Future: the player views the top three cards of the deck.");
        ht1.put(CARDTYPE.NOPE,"Nope: stops the action of another player. Cannot be used on Exploding Kitten or Defuse cards.");
        ht1.put(CARDTYPE.DEFUSE,"Defuse: allows the player to continue playing after drawing an Exploding Kitten.");
        ht1.put(CARDTYPE.EXPLODE, "Exploding Kitten: a player loses when they draw this card, unless they have Defuse " +
                "is discarded and the Exploding Kitten placed back into the deck.\n");


        //TODO: ADD in card ID and descrption to the constructor
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
     * toString: prints a string of all variables in instance to EditText
     * @return String of the various components
     */
    @Override
    public String toString() {
        return playerHand + " " + discard + " " + draw;
    }
}
