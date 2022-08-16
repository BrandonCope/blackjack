package com.games.crazyUno;

import java.util.List;
import java.util.Map;

class ComputerOpponent extends Player{

    public ComputerOpponent(String playerName, List<Map<Card, Card.CardValue>> playerHand) {
        super(playerName, playerHand);
    }
}