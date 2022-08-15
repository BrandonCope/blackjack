package com.games.crazyUno;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import static org.junit.Assert.*;

public class DeckTest {



    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void buildDeck_returnTreeMapOfCards_whenCardsMatchingSuccess() {
        Map<Integer, Map<Card, Card.CardValue>> expected = new TreeMap<>();
        Deck result = new Deck();
        int cardCount = 0;

        for (Card card : Card.values()) {
            for (Card.CardValue value : Card.CardValue.values()) {
                Map<Card, Card.CardValue> newCard = new HashMap<>();
                newCard.put(card, value);

                cardCount += 1;

                expected.put(cardCount, newCard);
            }
        }
        assertEquals(expected, result.buildDeck());
    }

//    @Test
//    public void drawCard() {
//    }
//
//    @Test
//    public void getDeckMap() {
//    }
//
//    @Test
//    public void reset() {
//    }
}