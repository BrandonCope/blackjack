package com.games.crazyUno;

import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class PlayerTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void startGame() {
        Player player1 = new Player("NAME", new PlayPile());

        player1.startGame();
        assertEquals(7,player1.getPlayerHand().size());
        assertFalse(player1.getPile().pileList.isEmpty());
        assertFalse(player1.getPile().getDeckMap().isEmpty());
    }

    @Test
    public void playCard() {
        Player player1 = new Player("NAME", new PlayPile());

        player1.startGame();

    }

    @Test
    public void reset() {
        PlayPile pile = new PlayPile();
        //pile.
    }
}