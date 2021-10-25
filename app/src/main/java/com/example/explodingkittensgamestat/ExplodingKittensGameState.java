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
    public boolean[] playerStatus;
    public STATE gameState = STATE.PROGRAM_LAUNCHED;

    public static final int NUM_PLAYERS = 4;
    public int playerTurn;
    public static final int DRAWCARD = 4000;
    public static final int SKIPTURN = 4001;
    public static final int ATTACKPLAYER = 4002;
    public static final int LOST = 4003;

    /**
     * ExplodingKittensGameState: creates the various decks for the players, draw, and discard piles
     * @param size: the number of players to declare hands for
     */
    public ExplodingKittensGameState(int size) {
        this.deck = new ArrayList<ArrayList<Card>>(NUM_PLAYERS);
        this.draw = new ArrayList<Card>(52);
        this.discard = new ArrayList<Card>(52);
        this.playerTurn = 0;
        this.playerStatus = new boolean[] {true, true, true, true};
        for(int i = 0; i< size; i++){
            this.deck.add(new ArrayList<Card>(7));
        }
        gameState = STATE.INIT_ARRAYS;
    }

    /**
     * ExplodingKittensGameState Deep Copy
     * @param state: the target instance of EKGS to deep copy
     */
    public ExplodingKittensGameState(ExplodingKittensGameState state){
        playerTurn = 0;
        draw = new ArrayList<Card>();
        for (int i = 0; i < state.draw.size(); i++) {
            draw.add(state.draw.get(i));
        }

        discard = new ArrayList<Card>();
        for (int i = 0; i < state.discard.size(); i++) {
            discard.add(state.discard.get(i));
        }

        deck = new ArrayList<ArrayList<Card>>(NUM_PLAYERS);
        for (int i = 0; i < state.deck.size(); i++) {
            deck.add(new ArrayList<Card>(7));
            for (int j = 0; j < state.deck.get(i).size(); j++ ) {
                deck.get(i).add(new Card(state.deck.get(i).get(j)));
            }
        }
        this.playerStatus = state.playerStatus;
    }

    public void endTurn(int playerTurn, int reason){
        switch(reason){
            case DRAWCARD:
                CARDTYPE temp = draw.get(0).getType();
                ArrayList<Card> destination = deck.get(playerTurn);
                destination.add(takeFromDraw());

                if(temp == CARDTYPE.EXPLODE){
                    playCard(playerTurn, CARDTYPE.DEFUSE, deck.get(playerTurn) ,discard);
                }
                for(Card card: deck.get(playerTurn)) {
                    card.isPlayable = false;
                }
                break;
            case SKIPTURN:
                for( Card card: deck.get(playerTurn)){
                    card.isPlayable = false;
                }
                break;
            case ATTACKPLAYER:
                break;
            case LOST:
                if(deck.get(playerTurn)!=null) {
                    deck.get(playerTurn).addAll(discard);
                    deck.get(playerTurn).clear();
                }
                playerStatus[this.playerTurn] = false;
                break;
        }
    }

    /**
     * Move: Moves the card from src to dest iff it exists in src
     * @param card card object to move
     * @param src - source arrayList to take it from
     * @param dest - destination arrayList to move it to
     * @return - true: action was executed, false: card not found in src
     */
    public boolean move(CARDTYPE card, ArrayList<Card> src, ArrayList<Card> dest){
        if(src.contains(card)){
            Card card1 = new Card(card);
            dest.add(card1);
            src.remove(card1);
        }
        return false;
    }

    public boolean moveStart(Card card, ArrayList<Card> src, ArrayList<Card> dest){
        if(src.contains(card)){
            dest.add(card);
            src.remove(card);
            return true;
        }
        return false;
    }

    public Card takeFromDraw() {
        Card fromDraw = draw.get(0);
        draw.remove(0);
        return fromDraw;
    }

    //TODO test each playcard
    public boolean playCard(int playerTurn, CARDTYPE card, ArrayList<Card> src, ArrayList<Card> dest){
        switch(card){
            case MELON:
            case BEARD:
            case POTATO:
            case TACO:
                if(move(card,src,dest)){
                    return true;
                }
                break;
            case ATTACK:
                break;
            case SHUFFLE:
                int moveShuffle = getCardIndex(CARDTYPE.SHUFFLE, deck.get(playerTurn));
                Card moveCardShuffle = getCard(CARDTYPE.SHUFFLE, deck.get(playerTurn));
                if(moveShuffle != -1) {
                    discard.add(moveCardShuffle);
                    deck.get(playerTurn).remove(moveShuffle);
                    Collections.shuffle(draw);
                    return true;
                }
                break;
            case FAVOR:
                break;
            case SKIP:
                boolean containsSkip = hasSkip(deck.get(playerTurn));
                int moveSkip = getCardIndex(CARDTYPE.SKIP, deck.get(playerTurn));
                Card moveCardSkip = getCard(CARDTYPE.SKIP, deck.get(playerTurn));
                if(moveSkip != -1) {
                    //Card getSkip = getCard(CARDTYPE.SKIP, deck.get(playerTurn));
                    discard.add(moveCardSkip);
                    deck.get(playerTurn).remove(moveSkip);
                    endTurn(playerTurn, SKIPTURN);
                }
                break;
            case SEEFUTURE:
                break;
            case NOPE:
                break;
            case DEFUSE:
                //boolean containsDefuse = deck.get(playerTurn).contains(card);
                boolean containsDefuse = hasDefuse(deck.get(playerTurn));
                boolean containsExplode = hasExplode(deck.get(playerTurn));
                int moveExplode = getCardIndex(CARDTYPE.EXPLODE, deck.get(playerTurn));
                int moveDefuse = getCardIndex(CARDTYPE.DEFUSE, deck.get(playerTurn));
                Card moveCardExplode = getCard(CARDTYPE.EXPLODE, deck.get(playerTurn));
                Card moveCardDefuse = getCard(CARDTYPE.DEFUSE, deck.get(playerTurn));
                if(moveExplode != -1 && moveDefuse != -1){
                    discard.add(moveCardExplode);
                    discard.add(moveCardDefuse);
                    deck.get(playerTurn).remove(moveExplode);
                    deck.get(playerTurn).remove(moveDefuse);
                    ArrayList<Card> reference = deck.get(playerTurn);
                    //move(CARDTYPE.EXPLODE,src,discard);
                    return true;
                }
                else if(deck.get(playerTurn).contains(card) && !hasExplode(deck.get(playerTurn))) {
                    return false;
                }
                else{
                    endTurn(playerTurn, LOST);
                    return false;
                }
            case EXPLODE:
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + card);
        }
        return false;
    }

    public boolean hasDefuse(ArrayList<Card> src) {
        if (getCard(CARDTYPE.DEFUSE, src) != null) {
            return true;
        }
        return false;
    }

    public boolean hasExplode(ArrayList<Card> src){
        if(getCard(CARDTYPE.EXPLODE, src) != null) {
            return true;
        }
        return false;
    }

    public boolean hasSkip(ArrayList<Card> src) {
        if (getCard(CARDTYPE.SKIP, src) != null) {
            return true;
        }
        return false;
    }

    public int getCardIndex(CARDTYPE type, ArrayList<Card> src) {
        for(int index = 0; index < src.size(); index++) {
            if(src.get(index).getType() == type) {
                return index;
            }
        }
        return -1;
    }

    public Card getCard(CARDTYPE type, ArrayList<Card> src){
        for(Card cards: src){
            if(cards.getType() == type){
                return cards;
            }
        }
        return null;
    }


    public int nextPlayer(int currentPlayer) {
        if (currentPlayer > 2) {
            currentPlayer = 0;
        }
        else currentPlayer++;

        if (checkIfValid(currentPlayer)) {
            playerTurn = currentPlayer;
            return currentPlayer;
        }
        else return nextPlayer(currentPlayer);
    }

    public boolean checkIfValid(int currentPlayer) {
        if (deck.get(currentPlayer) != null) return true;
        else return false;
    }

    /**
     * ToString: Returns a string including the current gamestate, and the contents of Deck, Draw, and discard arrayLists
     * @return - returns said string
     **/

    // @Override
    public String gameStatetoString(){
        String gstring = "Game State:" + gameState.name() + "\n\n";
        return gstring;
    }


    @Override
    public String toString(){
        String string ="****************\n" + "Current Player: " + this.playerTurn + "\n\n DECK: \n" + this.deck.toString() +
                "\n\n DRAW: \n" + this.draw.toString() + "\n\n DISCARD: \n" + this.discard.toString()
                + "\n\n";
        return string;
    }

    /**
     * PrepareGame: calls createCards(), and then shuffles the draw pile. Iterates through the 4 player hands in
     * deck, and adds the first 6 cards into a player hand iff it isnt an exploding kitten using move()
     * and finally sets the gameState to GAME_SETUP
     */
    //TODO change line 309 to send to draw
    //TODO mkae sure draw is rando
    //TODO shuffle the hands
    public void prepareGame(){
        createCards();
        for(int i = 0; i < 4; i++) {
            for (int j = 0; j < 6; j++) {
                //FIXME: make sure this gets every deck 7 cards even if there is double explode in draw
                if (this.draw.get(j).getType() != CARDTYPE.EXPLODE) {
                    moveStart(this.draw.get(j), this.draw, this.deck.get(i));
                } else if (this.draw.get(j + 1).getType() != CARDTYPE.EXPLODE) {
                    moveStart(this.draw.get(j + 1), this.draw, this.deck.get(i));
                }
            }
        }

        draw.clear();
        this.draw.add(new Card(CARDTYPE.EXPLODE));
        this.draw.add(new Card(CARDTYPE.SKIP));
        this.draw.add(new Card(CARDTYPE.ATTACK));
        this.draw.add(new Card(CARDTYPE.FAVOR));
        this.draw.add(new Card(CARDTYPE.NOPE));
        this.deck.get(2).add(new Card(CARDTYPE.SHUFFLE));
        this.draw.add(new Card(CARDTYPE.MELON));
        this.draw.add(new Card(CARDTYPE.BEARD));
        this.draw.add(new Card(CARDTYPE.TACO));
        this.draw.add(new Card(CARDTYPE.POTATO));
        this.draw.add(new Card(CARDTYPE.EXPLODE));
        this.draw.add(new Card(CARDTYPE.EXPLODE));

        gameState = STATE.GAME_SETUP;
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

        for(int i = 0; i < 4; i++){
            deck.get(i).add(new Card(CARDTYPE.DEFUSE));
        }

        this.draw.add(new Card(CARDTYPE.DEFUSE));
        this.draw.add(new Card(CARDTYPE.DEFUSE));
        this.draw.add(new Card(CARDTYPE.NOPE));
        this.draw.add(new Card(CARDTYPE.SEEFUTURE));

        gameState = STATE.INIT_OBJECTS;
    }

    public boolean takeTurn(int playerTurn){
        for(Card card: deck.get(playerTurn)){
            card.isPlayable = true;
        }
        return true;
    }

    public void startGame(){
        gameState = STATE.MAIN_PLAY;
    }

    public boolean endGame(boolean[] playerStatus){
        int out = 0;
        for(int i = 0; i < playerStatus.length; i++){
            if(playerStatus[i] == false) {
                out++;
            }
        }
        if(out == 3){
            gameState = STATE.GAME_END;
            return true;
        }
        return false;
    }
}
