package com.games.crazyUno;

public enum Card {
        RED, BLUE, YELLOW, GREEN;
    public enum CardValue{
        ZERO("0"),
        ONE("1"),
        TWO("2"),
        THREE("3"),
        FOUR("4"),
        FIVE("5"),
        SIX("6"),
        SEVEN("7"),
        EIGHT("8"),
        NINE("9"),;

        private final String cardValue;

        CardValue(String cardValue) {
            this.cardValue = cardValue;

        }
        public String cardValue(){
            return cardValue;
        }
        public String toString(){
            return cardValue();
        }
    }
}