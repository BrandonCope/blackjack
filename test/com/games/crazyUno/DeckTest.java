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
        for (int i = 0; i < 2; i++) {
            for (Card card : Card.values()) {
                for (Card.CardValue value : Card.CardValue.values()) {
                    Map<Card, Card.CardValue> newCard = new HashMap<>();
                    newCard.put(card, value);

                    cardCount += 1;

                    expected.put(cardCount, newCard);
                }
            }
        }
        assertEquals(expected, result.buildDeck());
    }

    @Test
    public void buildDeck_returnsNewDeck_whenCalledAfterDeckHasBeenAltered() {
        Deck newDeck = new Deck();
        newDeck.buildDeck();
        Map<Card, Card.CardValue> newCard = newDeck.drawCard();
        assertTrue(newDeck.getDeckMap().size() == 79);
        newDeck.buildDeck();
        assertTrue(newDeck.getDeckMap().size() == 80);
    }

    @Test
    public void drawCard_returnOneCard_whenMethodCalled() {
        Deck newDeck = new Deck();
        Map<Card, Card.CardValue> newCard = new HashMap<>();
        newDeck.buildDeck();
        List<Map<Card, Card.CardValue>> keys = new ArrayList(newDeck.getDeckMap().keySet());
        Collections.shuffle(keys);
        newCard =  newDeck.getDeckMap().get(keys.get(0));

        assertTrue(newDeck.getDeckMap().containsValue(newCard));

        newDeck.getDeckMap().remove(keys.get(0));
        assertFalse(newDeck.getDeckMap().containsKey(keys.get(0)));
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