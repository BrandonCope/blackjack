package com.games.crazyUno.domain;

public enum Card {
    RED("31"),
    BLUE("34"),
    YELLOW("33"),
    GREEN("32");

    public enum CardValue {
        ZERO("0"),
        ONE("1"),
        TWO("2"),
        THREE("3"),
        FOUR("4"),
        FIVE("5"),
        SIX("6"),
        SEVEN("7"),
        EIGHT("8"),
        NINE("9"),
        ;

        private final String cardValue;

        CardValue(String cardValue) {
            this.cardValue = cardValue;

        }

        public String cardValue() {
            return cardValue;
        }

        public String toString() {
            return cardValue();
        }
    }
    private final String card;

    Card(String cardValue) {
        this.card = cardValue;

    }

    public String card() {
        return card;
    }

    public String toString() {
        return card();
    }
}