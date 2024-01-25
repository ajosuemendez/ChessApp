package com.thechessnuts.InputHandlerService.models;

import java.util.ArrayList;

public class BishopBehaviour extends PieceBehaviour {   
    
    BishopBehaviour(){
        this.symbol = "B";
        this.name = "bishop";
    }


    @Override
    public ArrayList<Square> getMoves(AbstractChessBoard board, Piece piece) {
        ArrayList<Square> list = new ArrayList<>();

        list.addAll(board.navigation.getSquaresTopRightDiagonal(piece.getSquare()));
        list.addAll(board.navigation.getSquaresTopLeftDiagonal(piece.getSquare()));
        list.addAll(board.navigation.getSquaresBottomRightDiagonal(piece.getSquare()));
        list.addAll(board.navigation.getSquaresBottomLeftDiagonal(piece.getSquare()));
        
        return list;
    }
}
