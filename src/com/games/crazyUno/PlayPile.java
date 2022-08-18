package com.games.crazyUno;

import java.util.*;

public class PlayPile extends Deck {
    // Fields
    private List<Map<Card, Card.CardValue>> pileList = new ArrayList<>();

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
        Map<Card, Card.CardValue> topCard = getPile().get(getPile().size() - 1);
        Set<Card> colors = topCard.keySet();
        for (Card color : colors) {
            System.out.printf("Play Pile: " + "\033[%sm%s\033[0m", color, topCard.values());
        }
    }

    public  boolean validPlayableCards(List<Map<Card, Card.CardValue>> playerHand) {
        boolean result = false;
        Map<Card, Card.CardValue> topCard = getPile().get(getPile().size() - 1);
        for (Map<Card, Card.CardValue> card : playerHand) {
            String topCardValue = topCard.values().toString();
            String cardValue = card.values().toString();
            if (topCard.keySet().equals(card.keySet()) || topCardValue.equals(cardValue)) {
                result = true;
            }
        }
        return result;
    }

    public boolean cardIsValid(Map<Card, Card.CardValue> card) {
        // check if players selected card matches playPile
        boolean result = false;
        Map<Card, Card.CardValue> topCard = getPile().get(getPile().size() - 1);
        String topCardValue = topCard.values().toString();
        String cardValue = card.values().toString();
        if (topCard.keySet().equals(card.keySet()) || topCardValue.equals(cardValue)) {
            result = true;
        }
        return result;
    }

    public void playCard (Map<Card, Card.CardValue> card) {
        pileList.add(card);
    }


    public void setPileList(List<Map<Card, Card.CardValue>> pileList) {
        this.pileList = pileList;
    }

    // resets playPile
    public void resetDeck() {
        int cardCount = 0;
        List<Map<Card, Card.CardValue>> resetPile = getPile();
        for (int i = 0; i < resetPile.size() - 1; i++) {
            Map<Card, Card.CardValue> card = resetPile.get(i);
            cardCount += 1;
            this.getDeckMap().put(cardCount, card);
        }
    }
}

// while (!validInput) {
//         System.out.println("How many players? [2-4]");
//         String input = scanner.nextLine().trim().toUpperCase();
//         if (input.matches("\\d")) {
    //         players = Integer.parseInt(input);
    //         if (players >= 2 && players <= 4) {
        //         validInput = true;
        //         } else {
        //         System.out.println("Please input a number [2-4]...");
        //         }
    //     } else {
    //         System.out.println("Please input a number [2-4]...");
    //     }
//     }