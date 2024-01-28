package com.thechessnuts.gamesessionservice.models;

import java.util.ArrayList;

class BishopBehaviour extends PieceBehaviour {   
    
    BishopBehaviour(){
        this.symbol = "B";
        this.name = "bishop";
    }


    @Override
    ArrayList<Square> getMoves(Board board, Square square) {
        ArrayList<Square> list = new ArrayList<>();
        BoardNavigation navigation = board.getNavigation();

        list.addAll(navigation.getSquaresTopRightDiagonal(board, square));
        list.addAll(navigation.getSquaresTopLeftDiagonal(board, square));
        list.addAll(navigation.getSquaresBottomRightDiagonal(board, square));
        list.addAll(navigation.getSquaresBottomLeftDiagonal(board, square));
        
        return list;
    }
}
