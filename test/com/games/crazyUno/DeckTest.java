package com.games.crazyUno;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class DeckTest {





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
    public void buildDeck_returnsNewDeck_whenCalledAfterDeckHasBeenAltered() {
        Deck newDeck = new Deck();
        newDeck.buildDeck();
        Map<Card, Card.CardValue> newCard = newDeck.drawCard();

        assertFalse(newDeck.getDeckMap().containsValue(newCard));
        newDeck.buildDeck();
        assertTrue(newDeck.getDeckMap().containsValue(newCard));

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

    @Test
    public void getDeckMap_shouldReturnEmpty_whenDeckHasNotBeenBuilt() {
        Deck newDeck = new Deck();
        assertEquals(new TreeMap<>() , newDeck.getDeckMap());
    }

    @Test
    public void getDeckMap_shouldReturnFullDeck_whenDeckHasBeenBuilt() {
        Deck newDeck = new Deck();
        assertEquals(newDeck.buildDeck(), newDeck.getDeckMap());
    }

}