package com.games.crazyUno.controller;

import com.games.crazyUno.Card;
import com.games.crazyUno.PlayPile;
import com.games.crazyUno.Player;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Game {
    private Player player1;
    private Player player2;
    private Player player3;
    private Player player4;
    private Scanner scanner = new Scanner(System.in);
    private List<String> names;

    private int players;
    private PlayPile pile = new PlayPile();
    private List<List<Map<Card, Card.CardValue>>> playerHands = new ArrayList<>();

    public void execute() throws IOException {
        welcome();
        players = promptForPlayers();
        names = promptForName();
        buildDeck();
        playerHands = buildHand();
        buildPile();
        createPlayer();
        playGame();
    }

    private void welcome() throws IOException {
        System.out.println();
        System.out.println("\033[92m" + Files.readString(Path.of("resources/welcome.txt")) + "\033[0m");
        System.out.println();

    }


    private int promptForPlayers() {
        int players = 0;

        boolean validInput = false;
        while (!validInput) {
            System.out.println("How many players? [2-4]");
            String input = scanner.nextLine().trim().toUpperCase();
            if (input.matches("\\d")) {
                players = Integer.parseInt(input);
                if (players >= 2 && players <= 4) {
                    validInput = true;
                } else {
                    System.out.println("Please input a number [2-4]...");
                }
            } else {
                System.out.println("Please input a number [2-4]...");
            }
        }

        return players;
    }

    private List<String> promptForName() {
        List<String> names = new ArrayList<>();
        boolean validInput = false;
        boolean validInput1 = false;
        boolean validInput2 = false;
        boolean validInput3 = false;
        boolean validInput4 = false;
        while (!validInput) {
            String input1 = null;
            String input2 = null;
            String input3 = null;
            String input4 = null;
            switch (players) {
                case 2:
                    while (!validInput1) {
                        System.out.println("Player 1 enter your name: ");
                        input1 = scanner.nextLine().trim();
                        if (input1.matches("\\w{1,10}")) {
                            names.add(input1);
                            validInput1 = true;
                        } else {
                            System.out.println("Please enter a name...");
                        }
                    }
                    while (!validInput2) {
                        System.out.println("Player 2 enter your name: ");
                        input2 = scanner.nextLine().trim();
                        if (input2.matches("\\w{1,10}")) {
                            names.add(input2);
                            validInput2 = true;
                        } else {
                            System.out.println("Please enter a name...");
                        }
                    }
                    if (input1 != null && input2 != null) {
                        System.out.println("Player1: " + input1);
                        System.out.println("Player2: " + input2);
                        validInput = true;
                        break;
                    }
                case 3:
                    while (!validInput1) {
                        System.out.println("Player 1 enter your name: ");
                        input1 = scanner.nextLine().trim();
                        if (input1.matches("\\w{1,10}")) {
                            names.add(input1);
                            validInput1 = true;
                        } else {
                            System.out.println("Please enter a name...");
                        }
                    }
                    while (!validInput2) {
                        System.out.println("Player 2 enter your name: ");
                        input2 = scanner.nextLine().trim();
                        if (input2.matches("\\w{1,10}")) {
                            names.add(input2);
                            validInput2 = true;
                        } else {
                            System.out.println("Please enter a name...");
                        }
                    }
                    while (!validInput3) {
                        System.out.println("Player 3 enter your name: ");
                        input3 = scanner.nextLine().trim();
                        if (input3.matches("\\w{1,10}")) {
                            names.add(input3);
                            validInput3 = true;
                        } else {
                            System.out.println("Please enter a name...");
                        }
                    }
                    if (input1 != null && input2 != null && input3 != null) {
                        System.out.println("Player1: " + input1);
                        System.out.println("Player2: " + input2);
                        System.out.println("Player2: " + input3);
                        validInput = true;
                        break;
                    }
                case 4:
                    while (!validInput1) {
                        System.out.println("Player 1 enter your name: ");
                        input1 = scanner.nextLine().trim();
                        if (input1.matches("\\w{1,10}")) {
                            names.add(input1);
                            validInput1 = true;
                        } else {
                            System.out.println("Please enter a name...");
                        }
                    }
                    while (!validInput2) {
                        System.out.println("Player 2 enter your name: ");
                        input2 = scanner.nextLine().trim();
                        if (input2.matches("\\w{1,10}")) {
                            names.add(input2);
                            validInput2 = true;
                        } else {
                            System.out.println("Please enter a name...");
                        }
                    }
                    while (!validInput3) {
                        System.out.println("Player 3 enter your name: ");
                        input3 = scanner.nextLine().trim();
                        if (input3.matches("\\w{1,10}")) {
                            names.add(input3);
                            validInput3 = true;
                        } else {
                            System.out.println("Please enter a name...");
                        }
                    }
                    while (!validInput4) {
                        System.out.println("Player 4 enter your name: ");
                        input4 = scanner.nextLine().trim();
                        if (input4.matches("\\w{1,10}")) {
                            names.add(input4);
                            validInput4 = true;
                        } else {
                            System.out.println("Please enter a name...");
                        }
                    }
                    if (input1 != null && input2 != null && input3 != null && input4 != null) {
                        System.out.println("Player1: " + input1);
                        System.out.println("Player2: " + input2);
                        System.out.println("Player2: " + input3);
                        System.out.println("Player2: " + input4);
                        validInput = true;
                        break;
                    }
            }

        }
        return names;
    }

    private void buildDeck() {
        pile.buildDeck();
    }

    private List<List<Map<Card, Card.CardValue>>> buildHand() {
        List<List<Map<Card, Card.CardValue>>> hands = new ArrayList<>();

        List<Map<Card, Card.CardValue>> playerHand1 = new ArrayList<>();
        List<Map<Card, Card.CardValue>> playerHand2 = new ArrayList<>();
        List<Map<Card, Card.CardValue>> playerHand3 = new ArrayList<>();
        List<Map<Card, Card.CardValue>> playerHand4 = new ArrayList<>();
        switch (players) {
            case 2:
                for (int i = 0; i < 7; i++) {
                    Map<Card, Card.CardValue> card1 = pile.drawCard();
                    Map<Card, Card.CardValue> card2 = pile.drawCard();
                    playerHand1.add(card1);
                    playerHand2.add(card2);
                }
                hands.add(playerHand1);
                hands.add(playerHand2);
                break;
            case 3:
                for (int i = 0; i < 7; i++) {
                    Map<Card, Card.CardValue> card1 = pile.drawCard();
                    Map<Card, Card.CardValue> card2 = pile.drawCard();
                    Map<Card, Card.CardValue> card3 = pile.drawCard();
                    playerHand1.add(card1);
                    playerHand2.add(card2);
                    playerHand3.add(card3);
                }
                hands.add(playerHand1);
                hands.add(playerHand2);
                hands.add(playerHand3);
                break;
            case 4:
                for (int i = 0; i < 7; i++) {
                    Map<Card, Card.CardValue> card1 = pile.drawCard();
                    Map<Card, Card.CardValue> card2 = pile.drawCard();
                    Map<Card, Card.CardValue> card3 = pile.drawCard();
                    Map<Card, Card.CardValue> card4 = pile.drawCard();
                    playerHand1.add(card1);
                    playerHand2.add(card2);
                    playerHand3.add(card3);
                    playerHand4.add(card4);
                }
                hands.add(playerHand1);
                hands.add(playerHand2);
                hands.add(playerHand3);
                hands.add(playerHand4);
                break;
        }
        return hands;
    }

    private void buildPile() {
        pile.createPile();
    }


    private void createPlayer() {
        switch (players) {
            case 2:
                player1 = new Player(names.get(0), playerHands.get(0));
                player2 = new Player(names.get(1), playerHands.get(1));
                break;
            case 3:
                player1 = new Player(names.get(0), playerHands.get(0));
                player2 = new Player(names.get(1), playerHands.get(1));
                player3 = new Player(names.get(2), playerHands.get(2));
                break;
            case 4:
                player1 = new Player(names.get(0), playerHands.get(0));
                player2 = new Player(names.get(1), playerHands.get(1));
                player3 = new Player(names.get(2), playerHands.get(2));
                player4 = new Player(names.get(3), playerHands.get(3));
                break;
        }
    }

    private void selectCard(Player player) {
        int cardSelected;
        boolean selectValidCard = false;

        while (!selectValidCard) {
            pile.showPile();
            System.out.println();
            player.showHand(player);
            System.out.println();
            if (pile.validPlayableCards(player.getPlayerHand())) {
                System.out.printf("%s Please Select A Card Between [1-%s]...",
                        player.getPlayerName(), player.getPlayerHand().size());
                String input = scanner.nextLine().trim();
                if (input.matches("\\d{1,2}")) {
                    cardSelected = Integer.parseInt(input) - 1;
                    // if input isValid sets cardSelected
                    Map<Card, Card.CardValue> card = player.getPlayerHand().get(cardSelected);

                    if (pile.cardIsValid(card)) {
                        pile.playCard(card);
                        player.getPlayerHand().remove(cardSelected);
                        if (player.getPlayerHand().size() == 0) {
                            Player.setHasCards(false);
                            System.out.printf("Congratulations %s has won the game!!!", player.getPlayerName());
                        }
                        selectValidCard = true;
                    }
                }
            } else {
                // Draw card
                if (pile.getDeckMap().isEmpty()) {
//                    pile.resetDeck();
                } else {
                    System.out.println("You have no playable cards! Press Enter to Draw a card...");
                    scanner.nextLine();
                    Map<Card, Card.CardValue> newCard = pile.drawCard();
                    player.getPlayerHand().add(newCard);
                }

            }
        }
    }


    private void playGame() {

        switch (players) {
            case 2:
                while (Player.getHasCards()) {
                    selectCard(player1);
                    selectCard(player2);
                }
                break;
            case 3:
                while (Player.getHasCards()) {
                    selectCard(player1);
                    selectCard(player2);
                    selectCard(player3);
                }
                break;
            case 4:
                while (Player.getHasCards()) {
                    selectCard(player1);
                    selectCard(player2);
                    selectCard(player3);
                    selectCard(player4);
                }
                break;
        }
    }
}