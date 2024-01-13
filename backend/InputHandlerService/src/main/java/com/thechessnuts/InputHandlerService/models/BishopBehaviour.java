package com.thechessnuts.InputHandlerService.models;

import java.util.ArrayList;

public class BishopBehaviour implements PieceBehaviour {    


    @Override
    public ArrayList<Square> getMoves(AbstractChessBoard board, Piece piece) {
        ArrayList<Square> list = new ArrayList<>();

        list.addAll(board.navigation.getSquaresTopRightDiagonal(piece.square));
        list.addAll(board.navigation.getSquaresTopLeftDiagonal(piece.square));
        list.addAll(board.navigation.getSquaresBottomRightDiagonal(piece.square));
        list.addAll(board.navigation.getSquaresBottomLeftDiagonal(piece.square));
        
        return list;
    }
}
