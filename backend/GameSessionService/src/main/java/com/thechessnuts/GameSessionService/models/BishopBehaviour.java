package com.thechessnuts.gamesessionservice.models;

import java.util.ArrayList;

class BishopBehaviour extends PieceBehaviour {   
    
    BishopBehaviour(){
        this.symbol = "B";
        this.name = "bishop";
    }


    @Override
    ArrayList<Square> getMoves(Board board, Piece piece) {
        ArrayList<Square> list = new ArrayList<>();

        list.addAll(board.navigation.getSquaresTopRightDiagonal(piece.getSquare()));
        list.addAll(board.navigation.getSquaresTopLeftDiagonal(piece.getSquare()));
        list.addAll(board.navigation.getSquaresBottomRightDiagonal(piece.getSquare()));
        list.addAll(board.navigation.getSquaresBottomLeftDiagonal(piece.getSquare()));
        
        return list;
    }
}
