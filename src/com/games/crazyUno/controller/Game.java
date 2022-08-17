package com.games.crazyUno.controller;

import com.games.crazyUno.Card;
import com.games.crazyUno.PlayPile;
import com.games.crazyUno.Player;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

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
//    private List<Map<Card, Card.CardValue>> playerHand2 = new ArrayList<>();
//    private List<Map<Card, Card.CardValue>> playerHand3 = new ArrayList<>();
//    private List<Map<Card, Card.CardValue>> playerHand4 = new ArrayList<>();

    public void execute() throws IOException {
        welcome();
//        color();
        players = promptForPlayers();
        names = promptForName();
        playerHands = buildHand();
        buildHand();
        buildPile();
        createPlayer();


    }
    // Logic for printing players hand with color
//  for (Map<Card, Card.CardValue> card : playerHand) {
//            Set<Card> colors = card.keySet();
//            for (Card color : colors) {
//                System.out.printf("\033[%sm%s\033[0m", color ,card.values());
//            }
//        }


    private void welcome() throws IOException {

        System.out.println();
        System.out.println(Files.readString(Path.of("resources/welcome.txt")));
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
                }
            }
        }

        return players;
    }

    private List<String> promptForName() {
        List<String> names = new ArrayList<>();
        switch (players) {
            case 2:
                System.out.println("Player 1 enter your name: ");
                String input1 = scanner.nextLine().trim().toUpperCase();
                System.out.println("Player 2 enter your name: ");
                String input2 = scanner.nextLine().trim().toUpperCase();
                names.add(input1);
                names.add(input2);
                break;
            case 3:
                System.out.println("Player 1 enter your name: ");
                String input3 = scanner.nextLine().trim().toUpperCase();
                System.out.println("Player 2 enter your name: ");
                String input4 = scanner.nextLine().trim().toUpperCase();
                System.out.println("Player 3 enter your name: ");
                String input5 = scanner.nextLine().trim().toUpperCase();
                names.add(input3);
                names.add(input4);
                names.add(input5);
                break;
            case 4:
                System.out.println("Player 1 enter your name: ");
                String input6 = scanner.nextLine().trim().toUpperCase();
                System.out.println("Player 2 enter your name: ");
                String input7 = scanner.nextLine().trim().toUpperCase();
                System.out.println("Player 3 enter your name: ");
                String input8 = scanner.nextLine().trim().toUpperCase();
                System.out.println("Player 4 enter your name: ");
                String input9 = scanner.nextLine().trim().toUpperCase();
                names.add(input6);
                names.add(input7);
                names.add(input8);
                names.add(input9);
                break;
        }
//        System.out.println("Player 1 enter your name: ");
//        String input = scanner.nextLine().trim().toUpperCase();
        return names;
    }

    private void buildDeck() {
        pile.buildDeck();
        System.out.println("Deck: " + pile.getDeckMap());
    }

    private List<List<Map<Card, Card.CardValue>>> buildHand() {
        List<List<Map<Card, Card.CardValue>>> hands = new ArrayList<>();
        switch (players) {
            case 2:
                List<Map<Card, Card.CardValue>> playerHand1 = new ArrayList<>();
                List<Map<Card, Card.CardValue>> playerHand2 = new ArrayList<>();

            for (int i = 0; i < 7; i++) {
                Map<Card, Card.CardValue> card1 = pile.drawCard();
                Map<Card, Card.CardValue> card2 = pile.drawCard();
                playerHand1.add(card1);
                playerHand2.add(card2);
                System.out.println(player1.getPlayerHand());
                System.out.println(player2.getPlayerHand());
            }
            hands.add(playerHand1);
            hands.add(playerHand2);
            break;
            case 3:
                for (int i = 0; i < 7; i++) {
                    Map<Card, Card.CardValue> card1 = pile.drawCard();
                    Map<Card, Card.CardValue> card2 = pile.drawCard();
                    Map<Card, Card.CardValue> card3 = pile.drawCard();
//                    playerHand1.add(card1);
//                    playerHand2.add(card2);
//                    playerHand3.add(card3);
                }
                break;
            case 4:
                for (int i = 0; i < 7; i++) {
                    Map<Card, Card.CardValue> card1 = pile.drawCard();
                    Map<Card, Card.CardValue> card2 = pile.drawCard();
                    Map<Card, Card.CardValue> card3 = pile.drawCard();
                    Map<Card, Card.CardValue> card4 = pile.drawCard();
//                    playerHand1.add(card1);
//                    playerHand2.add(card2);
//                    playerHand3.add(card3);
//                    playerHand4.add(card4);
                }
                break;
        }
        return hands;
    }

    private void buildPile() {
        pile.createPile();
        System.out.println(pile.getPile());
    }

    private void createPlayer() {
        switch (players) {
            case 2:
                player1 = new Player(names.get(0), playerHands.get(0));
                player2 = new Player(names.get(1), playerHands.get(1));
                break;
            case 3:
//                player1 = new Player(names.get(0), playerHand1);
//                player2 = new Player(names.get(1), playerHand2);
//                player3 = new Player(names.get(2), playerHand3);
                break;
            case 4:
//                player1 = new Player(names.get(0), playerHand1);
//                player2 = new Player(names.get(1), playerHand2);
//                player3 = new Player(names.get(2), playerHand3);
//                player4 = new Player(names.get(3), playerHand4);
                break;
        }
    }

    private void playGame() {
        while (Player.getHasCards()) {
            switch (players) {
                case 2:
                    player1.playCard();
                    player2.playCard();
                case 3:
                    player1.playCard();
                    player2.playCard();
                    player3.playCard();
                case 4:
                    player1.playCard();
                    player2.playCard();
                    player3.playCard();
                    player4.playCard();
            }
        }
        System.out.println("Congratulations player you won.");
    }
}