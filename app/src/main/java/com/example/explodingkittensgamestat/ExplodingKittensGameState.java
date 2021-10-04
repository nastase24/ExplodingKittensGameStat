package com.example.explodingkittensgamestat;

import android.content.Context;

import java.util.ArrayList;

/**
 * Exploding Kittens Game State
 * @author annayrjanson
 */

public class ExplodingKittensGameState {


    /**
     * DECK:
     * index 0: draw pile
     * index 1: discard pile
     * index 2: human player deck
     * index 3: dumb AI deck
     * index 4: dumber AI deck
     * index 5 dumbest AI deck
     */
    public ArrayList<ArrayList<Card>> deck;
    public ArrayList<Card> discard;
    public ArrayList<Card> draw;
    public ArrayList<Card> humanPlayer;
    public  ArrayList<Card> dumb;
    public ArrayList<Card> dumber;
    public ArrayList<Card> dumbest;


    //default constructor
    public ExplodingKittensGameState(Context context){

        deck = new ArrayList<ArrayList<Card>>(6);

        draw = new ArrayList<Card>(56);
        deck.add(draw);

        discard = new ArrayList<Card>();
        deck.add(discard);

        humanPlayer = new ArrayList<Card>(7);
        deck.add(humanPlayer);

        dumb = new ArrayList<Card>(7);
        deck.add(dumb);

        dumber = new ArrayList<>(7);
        deck.add(dumber);

        dumbest = new ArrayList<Card>(7);
        deck.add(dumbest);

        createCards(context);
    }

    //deep copy constructor
    public ExplodingKittensGameState(ExplodingKittensGameState state){
        // With objects, need to use "new" keyword to
        // assign new memory

        // this.x = p.x;
        //this.y = p.y;
        //this.address = new address(p.address); // deep copy
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
        deck.get(0).add(defuse1);
        deck.get(0).add(defuse2);
        deck.get(2).add(defuse3);
        deck.get(3).add(defuse4);
        deck.get(4).add(defuse5);
        deck.get(5).add(defuse6);

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

    boolean playCard() {
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

    @Override
    public String toString() {
        return "";
    }
}
