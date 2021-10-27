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
        this.deck = new ArrayList<>(NUM_PLAYERS);
        this.draw = new ArrayList<>(52);
        this.discard = new ArrayList<>(52);
        this.playerTurn = 0;
        this.playerStatus = new boolean[] {true, true, true, true};
        for(int i = 0; i< size; i++){
            this.deck.add(new ArrayList<>(7));
        }
        gameState = STATE.INIT_ARRAYS;
    }

    /**
     * ExplodingKittensGameState Deep Copy
     * @param state: the target instance of EKGS to deep copy
     */
    public ExplodingKittensGameState(ExplodingKittensGameState state){
        playerTurn = 0;
        draw = new ArrayList<>();
        for (int i = 0; i < state.draw.size(); i++) {
            draw.add(state.draw.get(i));
        }

        discard = new ArrayList<>();
        for (int i = 0; i < state.discard.size(); i++) {
            discard.add(state.discard.get(i));
        }

        deck = new ArrayList<>(NUM_PLAYERS);
        for (int i = 0; i < state.deck.size(); i++) {
            deck.add(new ArrayList<>(7));
            for (int j = 0; j < state.deck.get(i).size(); j++ ) {
                deck.get(i).add(new Card(state.deck.get(i).get(j)));
            }
        }
        this.playerStatus = state.playerStatus;
    }

    /**
     * Ends the current player's turn, and executes specific commands based on the circumstances
     * under which the turn should be ended
     * @param playerTurn - ID of the player whose turn is being ended
     * @param reason - calls in static variables to represent all the manners in which a player can
     *               end their turn, such as drawing a card, playing a skip, attack, or losing
     */
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
     * The helper function to move a card obj from src to dest arrayLists iff it contains that card
     * @param card - card object to be moved
     * @param src - source ArrayList
     * @param dest - destination ArrayLIst
     * @return - returns true if it was able to move, false if not
     */
    public boolean moveStart(Card card, ArrayList<Card> src, ArrayList<Card> dest){
        if(src.contains(card)){
            dest.add(card);
            src.remove(card);
            return true;
        }
        return false;
    }

    /**
     * Draws a card from the draw pile arrayList and removes it from there
     * @return - returns the card object that was drawn
     */
    public Card takeFromDraw() {
        Card fromDraw = draw.get(0);
        draw.remove(0);
        return fromDraw;
    }


    /**
     * playCard:
     * @param playerTurn - the index of the player who is playing the card
     * @param card - the card being played
     * @param src - the source array for the card being played
     * @param dest - the desination array for the card being played
     * @return boolean - whether play card executed or nor
     */
    //TODO test each playcard
    public boolean playCard(int playerTurn, CARDTYPE card, ArrayList<Card> src, ArrayList<Card> dest){
        switch(card){
            case MELON:
                int moveMelon = getCardIndex(CARDTYPE.MELON, deck.get(playerTurn));
                Card moveCardMelon = getCard(CARDTYPE.MELON, deck.get(playerTurn));
                if(moveMelon != -1) {
                    discard.add(moveCardMelon);
                    deck.get(playerTurn).remove(moveMelon);
                    return true;
                }
                break;
            case BEARD:
                int moveBeard = getCardIndex(CARDTYPE.BEARD, deck.get(playerTurn));
                Card moveCardBeard = getCard(CARDTYPE.BEARD, deck.get(playerTurn));
                if(moveBeard != -1) {
                    discard.add(moveCardBeard);
                    deck.get(playerTurn).remove(moveBeard);
                    return true;
                }
                break;
            case POTATO:
                int movePotato = getCardIndex(CARDTYPE.POTATO, deck.get(playerTurn));
                Card moveCardPotato = getCard(CARDTYPE.POTATO, deck.get(playerTurn));
                if(movePotato != -1) {
                    discard.add(moveCardPotato);
                    deck.get(playerTurn).remove(movePotato);
                    return true;
                }
                break;
            case TACO:
                int moveTaco = getCardIndex(CARDTYPE.TACO, deck.get(playerTurn));
                Card moveCardTaco = getCard(CARDTYPE.TACO, deck.get(playerTurn));
                if(moveTaco != -1) {
                    discard.add(moveCardTaco);
                    deck.get(playerTurn).remove(moveTaco);
                    return true;
                }
                break;
            case ATTACK:
                int moveAttack = getCardIndex(CARDTYPE.ATTACK, deck.get(playerTurn));
                Card moveCardAttack = getCard(CARDTYPE.ATTACK, deck.get(playerTurn));
                if(moveAttack != -1) {
                    discard.add(moveCardAttack);
                    deck.get(playerTurn).remove(moveAttack);
                    return true;
                }
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
                int moveFavor = getCardIndex(CARDTYPE.FAVOR, deck.get(playerTurn));
                Card moveCardFavor = getCard(CARDTYPE.FAVOR, deck.get(playerTurn));
                if (moveFavor != -1) {
                    //TODO: Make so able to take another player's card
                    discard.add(moveCardFavor);
                    deck.get(playerTurn).remove(moveFavor);
                    return true;
                }
                break;
            case SKIP:
                int moveSkip = getCardIndex(CARDTYPE.SKIP, deck.get(playerTurn));
                Card moveCardSkip = getCard(CARDTYPE.SKIP, deck.get(playerTurn));
                if(moveSkip != -1) {
                    discard.add(moveCardSkip);
                    deck.get(playerTurn).remove(moveSkip);
                    endTurn(playerTurn, SKIPTURN);
                }
                break;
            case SEEFUTURE:
                int moveSeeFuture = getCardIndex(CARDTYPE.SEEFUTURE, deck.get(playerTurn));
                Card moveCardSeeFuture = getCard(CARDTYPE.SEEFUTURE, deck.get(playerTurn));
                if (moveSeeFuture != -1) {
                    discard.add(moveCardSeeFuture);
                    deck.get(playerTurn).remove(moveSeeFuture);
                    return true;
                }
                break;
            case NOPE:
                int moveNope = getCardIndex(CARDTYPE.NOPE, deck.get(playerTurn));
                Card moveCardNope = getCard(CARDTYPE.NOPE, deck.get(playerTurn));
                if (moveNope != -1) {
                    discard.add(moveCardNope);
                    deck.get(playerTurn).remove(moveNope);
                    return true;
                }
                break;
            case DEFUSE:
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


    /**
     * boolean to determine if a arrayLIst has an explode card
     * @param src- source arrayList to search
     * @return - true if the deck has an explode card, false if it doesn't
     */
    public boolean hasExplode(ArrayList<Card> src){
        if(getCard(CARDTYPE.EXPLODE, src) != null) {
            return true;
        }
        return false;
    }


    /**
     * getter method to get the index of a card in an arrayList
     * @param type - the cardtype in mind to search for an object for
     * @param src - the source arrayList to look in
     * @return - returns the index that the card object is located at, or -1 if it is not found in src
     */
    public int getCardIndex(CARDTYPE type, ArrayList<Card> src) {
        for(int index = 0; index < src.size(); index++) {
            if(src.get(index).getType() == type) {
                return index;
            }
        }
        return -1;
    }

    /**
     * gets a card object of a certain type from a source arrayLIst
     * @param type - cardtype to search for
     * @param src - the source arrayList to search in
     * @return - retruns the card Object if it exists, null if it doesn't exist
     */
    public Card getCard(CARDTYPE type, ArrayList<Card> src){
        for(Card card: src){
            if(card.getType() == type){
                return card;
            }
        }
        return null;
    }

    /**
     * computes the integer number of the next player in a turn sequence (loops around through NUM PLAYERS
     * @param currentPlayer - current player index whose turn it is
     * @return - returns the integer of the next player that is in the game still
     */
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

    /**
     * Checks if the current player index is valid or not (in the game or out)
     * @param currentPlayer - index of current player
     * @return - true if player is still in the game, false if not
     */
    public boolean checkIfValid(int currentPlayer) {
        if (deck.get(currentPlayer) != null) return true;
        else return false;
    }

    /**
     * returns the state of the game, NOT THE EKGAMESTATE object
     * @return - a string message indicating what point the game is in
     */
    public String gameStatetoString(){
        String gstring = "Game State:" + gameState.name() + "\n\n";
        return gstring;
    }

    /**
     * Creats a string of the big info about the EKgamestate, like current player, the contents of
     * all the ArrayList<Card>,
     * @return - String - the info string
     */
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
    //TODO make sure draw is shuffled in the function
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
        //TODO delete below line(s) that was for testing only
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

    /**
     * sets a player's deck to playable
     * @param playerTurn - index of current player
     * @return - true if it did the actions
     * TODO: implement some checking to make sure the right player is being called
     */
    public boolean takeTurn(int playerTurn){
        for(Card card: deck.get(playerTurn)){
            card.isPlayable = true;
            card.isSelected = false;
        }
        return true;
    }

    /**
     * sets the gameState to MAIN_PLAY
     * todo: check to checking to make sure this cannot be done out of order
     */
    public void startGame(){
        gameState = STATE.MAIN_PLAY;
    }

    /**
     * Tests if the game is over
     * @param playerStatus - an array indicated which players are in the game (true) and which are
     *                     out (false)
     * @return - true if there is only one in (true) player in playerStatus, false if there are more
     * than one players still playing
     */
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
