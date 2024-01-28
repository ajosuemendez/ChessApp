package com.thechessnuts.gamesessionservice.models;

import java.util.ArrayList;

class RookBehaviour extends PieceBehaviour{

    RookBehaviour(){
        this.symbol = "R";
        this.name = "rook";
    }

    @Override
    ArrayList<Square> getMoves(Board board, BoardNavigation navigation, Piece piece){
        
        ArrayList<Square> list = new ArrayList<>();
        
        list.addAll(navigation.getSquaresAbove(board, piece.getSquare()));

        list.addAll(navigation.getSquaresBelow(board, piece.getSquare()));

        list.addAll(navigation.getSquaresLeft(board, piece.getSquare()));

        list.addAll(navigation.getSquaresRight(board, piece.getSquare()));

        return list;
    }
    
}
