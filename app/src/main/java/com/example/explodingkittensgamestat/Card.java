package com.example.explodingkittensgamestat;

import android.content.Context;
import android.widget.Button;
import android.widget.ImageButton;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Card: Creates a class that allows all card types to be assigned and executed accordingly
 * @author Anna Yrjanson
 * @author Audrey Sauter
 * @author Claire Porter
 * @author Alex Nastase
 */

// TODO: Assign cards image ID so that it doesn't have to be an image button

public class Card {

    private CARDTYPE cardType;

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


    //Unique ID for each specific card
    public int ID;

    //Button to link with the Model
    //public ImageButton button;

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
        cardType = type;
        //button = onScreenButton;

        isPlayable = false;
        isSelected = false;
        isOnScreen = false;
        isCatCard = false;
        canPlayIfNope = false;
    }

    // Copy constructor
    public Card(Card oldCard) {

    }
}
