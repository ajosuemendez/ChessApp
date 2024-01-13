package com.thechessnuts.InputHandlerService.models;

import java.util.ArrayList;

public class RookBehaviour implements PieceBehaviour{

    @Override
    public ArrayList<Square> getMoves(AbstractChessBoard board, Piece piece){
        
        ArrayList<Square> list = new ArrayList<>();
        
        list.addAll(board.navigation.getSquaresAbove(piece.square));

        list.addAll(board.navigation.getSquaresBelow(piece.square));

        list.addAll(board.navigation.getSquaresLeft(piece.square));

        list.addAll(board.navigation.getSquaresRight(piece.square));

        return list;
    }
    
}
