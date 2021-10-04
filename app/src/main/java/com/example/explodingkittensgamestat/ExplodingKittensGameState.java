package com.example.explodingkittensgamestat;

import android.content.Context;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Exploding Kittens Game State
 * @author annayrjanson
 */

public class ExplodingKittensGameState {


    public ArrayList<ArrayList<Card>> playerHand;
    public ArrayList<Card> discard;
    public ArrayList<Card> draw;


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
