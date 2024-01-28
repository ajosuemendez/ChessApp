package com.thechessnuts.gamesessionservice.models;

import java.util.ArrayList;

class BishopBehaviour extends PieceBehaviour {   
    
    BishopBehaviour(){
        this.symbol = "B";
        this.name = "bishop";
    }


    @Override
    ArrayList<Square> getMoves(Board board, BoardNavigation navigation, Piece piece) {
        ArrayList<Square> list = new ArrayList<>();

        list.addAll(navigation.getSquaresTopRightDiagonal(board, piece.getSquare()));
        list.addAll(navigation.getSquaresTopLeftDiagonal(board, piece.getSquare()));
        list.addAll(navigation.getSquaresBottomRightDiagonal(board, piece.getSquare()));
        list.addAll(navigation.getSquaresBottomLeftDiagonal(board, piece.getSquare()));
        
        return list;
    }
}
