package com.example.explodingkittensgamestat;

import android.content.Context;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Hashtable;

/**
 * Exploding Kittens Game State
 * @author annayrjanson
 */

public class ExplodingKittensGameState extends Hashtable{


    public ArrayList<ArrayList<Card>> playerHand;
    public ArrayList<Card> discard;
    public ArrayList<Card> draw;

    public static final int MELON = 16536;
    public static final int BEARD = 16552;
    public static final int POTATO = 16547;
    public static final int TACO = 16538;
    public static final int ATTACK = 16550;
    public static final int SHUFFLE = 16544;
    public static final int FAVOR = 16542;
    public static final int SKIP = 16540;
    public static final int SEEFUTURE = 16555;
    public static final int NOPE = 16557;
    public static final int DEFUSE = 16559;
    public static final int EXPLODE = 16561;

    Hashtable<Integer,String> ht1 = new Hashtable();




    //default constructor
    public ExplodingKittensGameState(ArrayList<ArrayList<Card>> playerHand, ArrayList<Card> discard, ArrayList<Card> draw){
        this.playerHand = playerHand;
        this.discard = discard;
        this.draw = draw;
        // Assign variables as normal
        // Create totally normal constructor
    }

    //deep copy constructor
    public ExplodingKittensGameState(ExplodingKittensGameState state){
        // Check if this actually assigns new memory or not - ask Tribelhorn
        this.playerHand.addAll(state.playerHand);
        for (int i = 0; i < playerHand.size(); i++) {
            playerHand.add(new ArrayList<Card>(playerHand.get(i)));
        }
        this.discard.addAll(state.discard);
        this.draw.addAll(state.draw);
    }

    public void createCards(Context context){
        //sets the hash table keys and strings to the card description, and the card ID.
        ht1.put(MELON,"Cat Cards: tacocat, cattermelon, hairy potato cat, and beard " +
                "cat, must be played in matched pairs, a pair of three allows player to ask for a " +
                "specific card from another's hand, and a pair of two allows player to ask for a " +
                "random card from another's hand.");
        ht1.put(BEARD,"Cat Cards: tacocat, cattermelon, hairy potato cat, and beard " +
                "cat, must be played in matched pairs, a pair of three allows player to ask for a " +
                "specific card from another's hand, and a pair of two allows player to ask for a " +
                "random card from another's hand.");
        ht1.put(POTATO,"Cat Cards: tacocat, cattermelon, hairy potato cat, and beard " +
                "cat, must be played in matched pairs, a pair of three allows player to ask for a " +
                "specific card from another's hand, and a pair of two allows player to ask for a " +
                "random card from another's hand.");
        ht1.put(TACO,"Cat Cards: tacocat, cattermelon, hairy potato cat, and beard " +
                "cat, must be played in matched pairs, a pair of three allows player to ask for a " +
                "specific card from another's hand, and a pair of two allows player to ask for a " +
                "random card from another's hand.");
        ht1.put(ATTACK, "Attack: the player ends their turn(s) without drawing a card and the next player takes two turns.");
        ht1.put(SHUFFLE, "Shuffle: the player views the top three cards of the deck.");
        ht1.put(FAVOR, "Favor: another player must give the player a card from their hand.");
        ht1.put(SKIP,"Skip: the player ends their turn without drawing a card.");
        ht1.put(SEEFUTURE, "See the Future: the player views the top three cards of the deck.");
        ht1.put(NOPE,"Nope: stops the action of another player. Cannot be used on Exploding Kitten or Defuse cards.");
        ht1.put(DEFUSE,"Defuse: allows the player to continue playing after drawing an Exploding Kitten.");
        ht1.put(EXPLODE, "Exploding Kitten: a player loses when they draw this card, unless they have Defuse " +
                "is discarded and the Exploding Kitten placed back into the deck.\n");


        //TODO: ADD in card ID and descrption to the constructor
        Card explode1 = new Card(context, Card.cardType.EXPLODE);
        Card explode2 = new Card(context, Card.cardType.EXPLODE);
        Card explode3 = new Card(context, Card.cardType.EXPLODE);

        Card defuse1 = new Card(context, Card.cardType.DEFUSE);
        Card defuse2 = new Card(context, Card.cardType.DEFUSE);
        Card defuse3 = new Card(context, Card.cardType.DEFUSE);
        Card defuse4 = new Card(context, Card.cardType.DEFUSE);
        Card defuse5 = new Card(context, Card.cardType.DEFUSE);
        Card defuse6 = new Card(context, Card.cardType.DEFUSE);

        Card attack1 = new Card(context, Card.cardType.ATTACK);
        Card attack2 = new Card(context, Card.cardType.ATTACK);
        Card attack3 = new Card(context, Card.cardType.ATTACK);
        Card attack4 = new Card(context, Card.cardType.ATTACK);

        Card favor1 = new Card(context, Card.cardType.FAVOR);
        Card favor2 = new Card(context, Card.cardType.FAVOR);
        Card favor3 = new Card(context, Card.cardType.FAVOR);
        Card favor4 = new Card(context, Card.cardType.FAVOR);

        Card nope1 = new Card(context, Card.cardType.NOPE);
        Card nope2 = new Card(context, Card.cardType.NOPE);
        Card nope3 = new Card(context, Card.cardType.NOPE);
        Card nope4 = new Card(context, Card.cardType.NOPE);
        Card nope5 = new Card(context, Card.cardType.NOPE);

        Card shuffle1 = new Card(context, Card.cardType.SHUFFLE);
        Card shuffle2 = new Card(context, Card.cardType.SHUFFLE);
        Card shuffle3 = new Card(context, Card.cardType.SHUFFLE);
        Card shuffle4 = new Card(context, Card.cardType.SHUFFLE);

        Card skip1 = new Card(context, Card.cardType.SKIP);
        Card skip2 = new Card(context, Card.cardType.SKIP);
        Card skip3 = new Card(context, Card.cardType.SKIP);
        Card skip4 = new Card(context, Card.cardType.SKIP);

        Card seeFuture1 = new Card(context, Card.cardType.SEEFUTURE);
        Card seeFuture2 = new Card(context, Card.cardType.SEEFUTURE);
        Card seeFuture3 = new Card(context, Card.cardType.SEEFUTURE);
        Card seeFuture4 = new Card(context, Card.cardType.SEEFUTURE);
        Card seeFuture5 = new Card(context, Card.cardType.SEEFUTURE);

        Card melon1 = new Card(context, Card.cardType.MELON);
        Card melon2 = new Card(context, Card.cardType.MELON);
        Card melon3 = new Card(context, Card.cardType.MELON);
        Card melon4 = new Card(context, Card.cardType.MELON);

        Card beard1 = new Card(context, Card.cardType.BEARD);
        Card beard2 = new Card(context, Card.cardType.BEARD);
        Card beard3 = new Card(context, Card.cardType.BEARD);
        Card beard4 = new Card(context, Card.cardType.BEARD);

        Card potato1 = new Card(context, Card.cardType.POTATO);
        Card potato2 = new Card(context, Card.cardType.POTATO);
        Card potato3 = new Card(context, Card.cardType.POTATO);
        Card potato4 = new Card(context, Card.cardType.POTATO);

        Card taco1 = new Card(context, Card.cardType.TACO);
        Card taco2 = new Card(context, Card.cardType.TACO);
        Card taco3 = new Card(context, Card.cardType.TACO);
        Card taco4 = new Card(context, Card.cardType.TACO);
    }

    boolean playCard(boolean isValid) {
        if (/* Something */) {
            return true;
        }
        return false;
    }
    boolean drawCard() {
        return false;
    }
    boolean defuse() {
        return false;
    }
    boolean attack() {
        return false;
    }
    boolean skip() {
        return false;
    }
    boolean seeFuture() {
        return false;
    }
    boolean shuffle() {
        return false;
    }
    boolean favor() {
        return false;
    }
    boolean nope() {
        return false;
    }
    boolean twoOfKind() {
        return false;
    }
    boolean threeOfKind() {
        return false;
    }
    boolean playFive() {
        return false;
    }
    boolean restartGame() {
        return false;
    }
    boolean quitGame() {
        return false;
    }


    @Override
    public String toString() {
        return playerHand + " " + discard + " " + draw;
    }
}
