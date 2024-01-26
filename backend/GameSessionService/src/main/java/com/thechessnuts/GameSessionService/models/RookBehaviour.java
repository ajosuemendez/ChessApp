package com.thechessnuts.gamesessionservice.models;

import java.util.ArrayList;

class RookBehaviour extends PieceBehaviour{

    RookBehaviour(){
        this.symbol = "R";
        this.name = "rook";
    }

    @Override
    ArrayList<Square> getMoves(Board board, Piece piece){
        
        ArrayList<Square> list = new ArrayList<>();
        
        list.addAll(board.navigation.getSquaresAbove(piece.getSquare()));

        list.addAll(board.navigation.getSquaresBelow(piece.getSquare()));

        list.addAll(board.navigation.getSquaresLeft(piece.getSquare()));

        list.addAll(board.navigation.getSquaresRight(piece.getSquare()));

        return list;
    }
    
}
