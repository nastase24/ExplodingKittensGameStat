package com.example.explodingkittensgamestat;

import android.content.Context;
import android.widget.ImageButton;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class Card extends ImageButton{

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

    public final Type TYPE{

    }
    //Unique ID for each specific card
    public int ID;

    //Button to link with the Model
    public ImageButton button;

    //Booleans to track whether a card is selcted and playable, both required to
    //actually play a card
    public boolean isSelected;
    public boolean isPlayable;

    //Description of what the card does
    public String description;


    public Card(Context context) {
        super(context);

    }

    ArrayList<ArrayList<Card>> playerHand;
    ArrayList<Card> discard;
    ArrayList<Card> draw;


    //move to gameState? Neeed this for all players
    public void Player{
        public String ID;
        public ArrayList<Card>;
        public boolean inGame;
        public boolean isTurn;
        //startTurn();
        //endTurn();
    }
}
