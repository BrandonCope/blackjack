package com.games.crazyUno;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Player {

    //Fields
    private String playerName;
    private PlayPile pile;
    private List<Map<Card, Card.CardValue>> playerHand = new ArrayList<>();
    private static Boolean hasCards;
    //Constructor
    public Player(String playerName, List<Map<Card, Card.CardValue>> playerHand) {
        this.pile= pile;
        setPlayerName(playerName);

    }

    //Business Methods
    //We are starting the game. Building a deck with 40cards. Creating a player hands with 7 Cards.
    //
    public void startGame() {
        pile.buildDeck();
        for (int i = 0; i < 7; i++) {
            Map<Card, Card.CardValue> card = pile.drawCard();
            this.playerHand.add(card);

        }
        pile.createPile();
    }

    public void playCard () {


    }

    public void reset () {
        pile.buildDeck();
        this.setPlayerHand(new ArrayList<>());

    }
        //Accessor Methods
    public String getPlayerName () {
        return playerName;
    }

    public void setPlayerName (String playerName){
        this.playerName = playerName;
    }

    public List<Map<Card, Card.CardValue>> getPlayerHand () {
        return playerHand;
    }
    public void setPlayerHand (List < Map < Card, Card.CardValue >> playerHand){
        this.playerHand = playerHand;
    }

    public PlayPile getPile() {
        return pile;
    }

    public void setPile(PlayPile pile) {
        this.pile = pile;
    }

    public static Boolean getHasCards() {
        return hasCards;
    }

    public void setHasCards(Boolean hasCards) {
        this.hasCards = hasCards;
    }
}