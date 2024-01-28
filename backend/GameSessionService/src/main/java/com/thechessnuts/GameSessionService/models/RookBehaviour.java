package com.thechessnuts.gamesessionservice.models;

import java.util.ArrayList;

class RookBehaviour extends PieceBehaviour{

    RookBehaviour(){
        this.symbol = "R";
        this.name = "rook";
    }

    @Override
    ArrayList<Square> getMoves(Board board, Square square){
        
        ArrayList<Square> list = new ArrayList<>();
        BoardNavigation navigation = board.getNavigation();
        
        list.addAll(navigation.getSquaresAbove(board, square));

        list.addAll(navigation.getSquaresBelow(board, square));

        list.addAll(navigation.getSquaresLeft(board, square));

        list.addAll(navigation.getSquaresRight(board, square));

        return list;
    }
    
}
