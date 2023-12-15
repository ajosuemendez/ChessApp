package com.thechessnuts.InputHandlerService.models;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
       /*  Game g = new Game();
        g.setPlayers(new Player("PLayer-One", "WHITE"), new Player("Player-Two", "BLACK"),  new Player("Player-Three", "YELLOW"));
        g.newGame();
        g.board.selectPiece("h11");
        return;*/
        Chess3Board board=new Chess3Board();
        board.findSquare("d6").setPiece(new Knight(board,new Player()));
        ArrayList<Square> list=board.findSquare("d6").piece.allMoves();
        System.out.println(list);
    }
}