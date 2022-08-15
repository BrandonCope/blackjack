package com.games.crazyUno;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class DeckTest {



    @Before
    public void setUp() throws Exception {
        Deck newDeck = new Deck();

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

    @Test
    public void drawCard_returnOneCard_whenMethodCalled() {
        Deck newDeck = new Deck();
        Map<Card, Card.CardValue> newCard = new TreeMap<>();
        newDeck.buildDeck();
        List<Map<Card, Card.CardValue>> keys = new ArrayList(newDeck.getDeckMap().keySet());
        Collections.shuffle(keys);
        newCard =  newDeck.getDeckMap().get(keys.get(0));
        assertTrue(newDeck.getDeckMap().containsValue(newCard));

        newDeck.getDeckMap().remove(keys.get(0));

        assertFalse(newDeck.getDeckMap().containsValue(newCard));
    }
//
//    @Test
//    public void getDeckMap() {
//    }
//
//    @Test
//    public void reset() {
//        Deck newDeck = new Deck();
//        newDeck.buildDeck();
//        newDeck.drawCard();
//        Map<Integer, Map<Card, Card.CardValue>> oldDeck = (Map<Integer, Map<Card, Card.CardValue>>) newDeck;
//        newDeck.reset();
//
//    }
}