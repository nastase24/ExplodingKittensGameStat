package com.example.explodingkittensgamestat;

import android.content.Context;
import android.widget.Button;
import android.widget.ImageButton;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class Card extends androidx.appcompat.widget.AppCompatImageButton{

    private final Object cardType;

    /**
     * DECK for 4 players, 56 cards TOTAL
     * 4 exploders
     * 6 diffuse
     * 4 attack
     * 4 favor
     * 5 nope cards
     * 4 shuffle
     *
     * 4 skip
     * 5 see the future
     * 4 melon
     * 4 beard
     * 4 potato
     * 4 taco
     */

    public enum cardType{
        MELON,
        BEARD,
        POTATO,
        TACO,
        FERAL,
        ATTACK,
        SHUFFLE,
        FAVOR,
        SKIP,
        SEEFUTURE,
        NOPE,
        DEFUSE,
        EXPLODE
    }


    //Unique ID for each specific card
    public int ID;

    //Button to link with the Model
    public ImageButton button;

    //Booleans to track whether a card is selcted and playable, both required to
    //actually play a card
    public boolean isSelected;
    public boolean isPlayable;
    public boolean isOnScreen;

    //Description of what the card does
    public String description;

    //set card info in this constructor
    public Card(Context context, cardType type) {
        super(context);
        cardType = type;
        //button = onScreenButton;

        isPlayable = false;
        isSelected = false;
        isOnScreen = false;
    }

}
