package com.thechessnuts.gamesessionservice.models;

public class Main {
    public static void main(String[] args) {
        Game g = new Game();
        g.setPlayers(new Player("PLayer-One", "WHITE"), new Player("Player-Two", "BLACK"),  new Player("Player-Three", "YELLOW"));
        g.newGame();
        return;
    }
}