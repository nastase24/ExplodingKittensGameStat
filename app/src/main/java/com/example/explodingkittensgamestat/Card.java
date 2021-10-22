package com.example.explodingkittensgamestat;

import android.content.Context;
import android.widget.Button;
import android.widget.ImageButton;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Hashtable;

/**
 * Card: Creates a class that allows all card types to be assigned and executed accordingly
 * @author Anna Yrjanson
 * @author Audrey Sauter
 * @author Claire Porter
 * @author Alex Nastase
 */

// TODO: Assign cards image ID so that it doesn't have to be an image button

public class Card extends Hashtable {

    private CARDTYPE cardType;

    Hashtable<CARDTYPE,String> ht1 = new Hashtable();


    /**
     * DECK for 4 players, 52 cards TOTAL
     * 4 exploders
     * 6 diffuse
     * 4 attack
     * 4 favor
     * 5 nope cards
     * 4 shuffle
     * 4 skip
     * 5 see the future
     * 4 melon
     * 4 beard
     * 4 potato
     * 4 taco
     */

    //Booleans to track whether a card is selcted and playable, both required to
    //actually play a card
    public boolean isSelected;
    public boolean isPlayable;
    public boolean isOnScreen;
    public boolean isCatCard;
    public boolean canPlayIfNope;

    //Description of what the card does
    public String description;

    //set card info in this constructor
public Card(CARDTYPE type) {

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
        cardType = type;
        //button = onScreenButton;
        description = ht1.get(cardType);
        isPlayable = false;
        isSelected = false;
        isOnScreen = false;
        if(type == CARDTYPE.BEARD || type == CARDTYPE.MELON || type == CARDTYPE.POTATO || type == CARDTYPE.TACO){
            isCatCard = true;
        }else {
            isCatCard = false;
        }
        canPlayIfNope = false;
    }

    // Copy constructor
    public Card(Card oldCard) {
        cardType = oldCard.cardType;
        description = oldCard.description;
        isPlayable = oldCard.isPlayable;
        isSelected = oldCard.isSelected;
        isOnScreen = oldCard.isOnScreen;
        isCatCard = oldCard.isCatCard;
        canPlayIfNope = oldCard.canPlayIfNope;
    }

    public String toString(){
        //return "Type: " + cardType.name() + " Is catCard: "+ isCatCard + "\n";
        return cardType.name();
    }

    public CARDTYPE getType(){ return this.cardType; }
}
