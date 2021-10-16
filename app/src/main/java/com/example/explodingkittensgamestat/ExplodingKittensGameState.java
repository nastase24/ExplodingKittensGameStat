package com.example.explodingkittensgamestat;

import java.util.ArrayList;
import java.util.Collections;

/**
 * ExplodingKittensGameState: Creates the decks and assigns and moves cards according to player
 * actions
 * @author Anna Yrjanson
 * @author Audrey Sauter
 * @author Claire Porter
 * @author Alex Nastase
 */

public class ExplodingKittensGameState {

    public ArrayList<ArrayList<Card>> deck;
    public ArrayList<Card> discard;
    public ArrayList<Card> draw;
    public STATE gameState = STATE.PROGRAM_LAUNCHED;
    public static final int NUM_PLAYERS = 4;

    /**
     * ExplodingKittensGameState: creates the various decks for the players, draw, and discard piles
     * @param size: the number of players to declare hands for
     */
    //default constructor
    public ExplodingKittensGameState(int size) {
        this.deck = new ArrayList<ArrayList<Card>>(NUM_PLAYERS);
        this.draw = new ArrayList<Card>(52);
        this.discard = new ArrayList<Card>(52);
        for(int i = 0; i< size; i++){
            this.deck.add(new ArrayList<Card>(7));
        }
        gameState = STATE.INIT_ARRAYS;
    }

    /**
     * ExplodingKittensGameState Deep Copy
     * @param state: the target instance of EKGS to deep copy
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

        deck = new ArrayList<ArrayList<Card>>(NUM_PLAYERS);
        //deck.add(draw);
        //deck.add(discard);
        for (int i = 0; i < state.deck.size(); i++) {
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


        for(int i = 0; i < 4; i++){
            this.draw.add(new Card(CARDTYPE.ATTACK));
            this.draw.add(new Card(CARDTYPE.FAVOR));
            this.draw.add(new Card(CARDTYPE.NOPE));
            this.draw.add(new Card(CARDTYPE.SHUFFLE));
            this.draw.add(new Card(CARDTYPE.SKIP));
            this.draw.add(new Card(CARDTYPE.SEEFUTURE));
            this.draw.add(new Card(CARDTYPE.MELON));
            this.draw.add(new Card(CARDTYPE.BEARD));
            this.draw.add(new Card(CARDTYPE.TACO));
            this.draw.add(new Card(CARDTYPE.POTATO));
        }

        this.draw.add(new Card(CARDTYPE.EXPLODE));
        this.draw.add(new Card(CARDTYPE.EXPLODE));
        this.draw.add(new Card(CARDTYPE.EXPLODE));

        for(int i = 0; i < 4; i++){
            deck.get(i).add(new Card(CARDTYPE.DEFUSE));
        }
        this.draw.add(new Card(CARDTYPE.DEFUSE));
        this.draw.add(new Card(CARDTYPE.DEFUSE));
        this.draw.add(new Card(CARDTYPE.NOPE));
        this.draw.add(new Card(CARDTYPE.SEEFUTURE));

        gameState = STATE.INIT_OBJECTS;
    }
/*
    public boolean playCard(ArrayList<Card> src, ArrayList<Card> dest, Card card){
        CARDTYPE type = card.getType();
        switch(type){

        }
        return false;
    }

 */

    /**
     * PrepareGame: calls createCards(), and then shuffles the draw pile. Iterates through the 4 player hands in
     * deck, and adds the first 6 cards into a player hand iff it isnt an exploding kitten using move()
     * and finally sets the gameState to GAME_SETUP
     */
    public void prepareGame(){
        createCards();
        Collections.shuffle(this.draw);
        //iterates through the 4
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 6; j++){
                //FIXME: make sure this gets every deck 7 cards even if there is double explode in draw
                if(this.draw.get(j).getType() != CARDTYPE.EXPLODE ){
                    move(this.draw.get(j),this.draw,this.deck.get(i));
                }else if(this.draw.get(j+1).getType() != CARDTYPE.EXPLODE ){
                    move(this.draw.get(j+1),this.draw,this.deck.get(i));
                }
            }
        }
        gameState = STATE.GAME_SETUP;
    }

    /**
     * ToString: Returns a string including the current gamestate, and the contents of Deck, Draw, and discard arrayLists
     * @return - returns said string
     *      */
    @Override
    public String toString(){
        String string = "Game State: " + gameState.name()
                +"\n############\n"+ "DECK: \n" + this.deck.toString() +
                "\nDRAW: \n" + this.draw.toString() + "\nDISCARD: \n" + this.discard.toString();
        return string;
    }


    /**
     * Move: Moves the card from src to dest iff it exists in src
     * @param card card object to move
     * @param src - source arrayList to take it from
     * @param dest - destination arrayList to move it to
     * @return - true: action was executed, false: card not found in src
     */
    public boolean move(Card card, ArrayList<Card> src, ArrayList<Card> dest){
        if(src.contains(card)){
            dest.add(card);
            src.remove(card);
            return true;
        }
        return false;
    }

}

