package com.example.explodingkittensgamestat;

import android.content.Context;

import java.util.ArrayList;

public class ExplodingKittensGameState {


    public ArrayList<ArrayList<Card>> playerHand;



    //default constructor
    public ExplodingKittensGameState(){

    }

    //deep copy constructor
    public ExplodingKittensGameState(ExplodingKittensGameState state){

    }
    public void createCards(Context context){
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
}
