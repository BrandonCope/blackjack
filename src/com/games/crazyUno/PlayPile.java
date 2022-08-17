package com.games.crazyUno;

import java.util.*;

public class PlayPile extends Deck {
    // Fields
    public List<Map<Card, Card.CardValue>> pileList = new ArrayList<>();

    // Constructor
    public PlayPile() {
        super();
    }

    // Methods
    /*
     * add one card to pile from class Deck
     */
    public void createPile() {
        Map<Card, Card.CardValue> newCard = drawCard();
        this.getPile().add(newCard);
    }

    public List<Map<Card, Card.CardValue>> getPile() {
        return this.pileList;
    }

    public void showPile() {
        Map<Card, Card.CardValue> topCard = getPile().get(0);
        Set<Card> colors = topCard.keySet();
        for (Card color : colors) {
            System.out.printf("Play Pile: " + "\033[%sm%s\033[0m", color, topCard.values());
        }
    }

    public void setPileList(List<Map<Card, Card.CardValue>> pileList) {
        this.pileList = pileList;
    }

    // resets playPile
    public void reset() {
        buildDeck();
        this.setPileList(new ArrayList<>());
        createPile();
    }
}