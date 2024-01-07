package com.thechessnuts.InputHandlerService.models;

public class Main {
    public static void main(String[] args) {
        Game g = new Game();
        g.setPlayers(new Player("PLayer-One", "WHITE"), new Player("Player-Two", "BLACK"),  new Player("Player-Three", "YELLOW"));
        g.newGame();
        g.board.selectPiece("h11");
        return;
    }
}