package com.games.crazyUno;

import java.util.Map;
import java.util.TreeMap;

class PlayPile extends Deck {
    // Fields
    public Map<Integer, Card> pileMap = new TreeMap<>();

    // Constructor
    public PlayPile() {
        super();
        createPile();
    }

    // Methods
    /*
     * add one card to pile from class Deck
     */
    public void createPile() {
//        pileMap = Deck.drawCard();
    }

    public Map<Integer, Card> getPileMap() {
        return pileMap;
    }

    // resets playPile
    public void reset() {
        pileMap = new TreeMap<>();
        createPile();
    }
}