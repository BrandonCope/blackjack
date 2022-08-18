package com.games.crazyUno.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Player {

    //Fields
    private String playerName;
    private PlayPile pile;
    private List<Map<Card, Card.CardValue>> playerHand = new ArrayList<>();
    private static Boolean hasCards = true;

    //Constructor
    public Player(String playerName, List<Map<Card, Card.CardValue>> playerHand) {
        this.playerName = playerName;
        this.playerHand = playerHand;
    }

    //Business Methods
    public void showHand(Player player) {
        System.out.printf("%s's Hand: ", player.getPlayerName());
        for (Map<Card, Card.CardValue> card : playerHand) {
            Set<Card> colors = card.keySet();
            for (Card color : colors) {
                System.out.printf("\033[%sm%s\033[0m", color, card.values());
            }
        }
    }

    //Accessor Methods
    public String getPlayerName() {
        return playerName;
    }

    public List<Map<Card, Card.CardValue>> getPlayerHand() {
        return playerHand;
    }

    public static void setHasCards(boolean value) {
        hasCards = value;
    }

    public static Boolean getHasCards() {
        return hasCards;
    }
}