package com.games.crazyUno;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class PlayPileTest {

//    @Before
//    public void setUp() {
//        Map<Integer, Map<Card, Card.CardValue>> pileMap = new TreeMap<>();
//    }

    @Test
    public void createPile_shouldAddOneCardFromDeckToPileMap_whenDeckIsNotEmpty() {
        PlayPile pile = new PlayPile();
        pile.buildDeck();

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
//    public void cardIsValid() {
//        Map<Card, Card.CardValue> card = new HashMap<Card, Card.CardValue>(Card.BLUE, Card.CardValue.EIGHT);
//        PlayPile pile = new PlayPile();
////        pile.cardIsValid();
//    }
}