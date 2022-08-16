package com.games.crazyUno;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static org.junit.Assert.*;

public class PlayPileTest {

//    @Before
//    public void setUp() {
//        Map<Integer, Map<Card, Card.CardValue>> pileMap = new TreeMap<>();
//    }

    @Test
    public void createPile_shouldAddOneCardFromDeckToPileMap_whenDeckIsNotEmpty() {
//        Deck newDeck = new Deck();
        PlayPile pile = new PlayPile();
        pile.buildDeck();
//        System.out.println("DeckMap: " + newDeck.getDeckMap());
        System.out.println(pile.getPile());

        assertTrue(pile.getPile().isEmpty());
        pile.createPile();
        assertFalse(pile.getPile().isEmpty());
    }

    @Test
    public void getPileMap_shouldReturnEmpty_whenPileHasNotBeenBuilt() {
        PlayPile pile = new PlayPile();
        assertTrue(pile.getPile().isEmpty());
    }

    @Test
    public void getPileMap_shouldReturnPileList_whenPileHasBeenBuilt() {
        PlayPile pile = new PlayPile();
        pile.buildDeck();
        pile.createPile();
        assertFalse(pile.getPile().isEmpty());
    }

//    @Test
//    public void reset() {
//        PlayPile pile = new PlayPile();
//        pile.buildDeck();
//        pile.createPile();
//
//        assertFalse(pile.getPile().isEmpty());
//        pile.reset();
//        assertTrue(pile.getPile().isEmpty());
//    }
}