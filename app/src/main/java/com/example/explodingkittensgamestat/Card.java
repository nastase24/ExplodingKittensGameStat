package com.example.explodingkittensgamestat;

import android.content.Context;
import android.widget.Button;
import android.widget.ImageButton;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class Card extends androidx.appcompat.widget.AppCompatImageButton{

    private final Object cardType;

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
    public Card(Context context, int id, cardType type, ImageButton onScreenButton) {
        super(context);
        ID = id;
        cardType = type;
        button = onScreenButton;

        isPlayable = false;
        isSelected = false;
        isOnScreen = false;
    }





}
