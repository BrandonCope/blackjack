package com.games.crazyUno.domain.client;

import com.games.crazyUno.domain.controller.Game;

import java.io.IOException;

class Main {
    public static void main(String[] args) throws IOException {
        Game app = new Game();
        app.execute();
    }
}