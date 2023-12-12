package com.thechessnuts.InputHandlerService.models;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Game g = new Game();
        g.setPlayers(new Player("PLayer-One", "WHITE"), new Player("Player-Two", "BLACK"),  new Player("Player-Three", "YELLOW"));
        g.newGame();
        g.board.selectPiece("h11");

         ArrayList list = g.getBoardState();
         System.out.println(list);
         System.out.println(g.board.findSquare("h11").piece.allMoves());




    }
}