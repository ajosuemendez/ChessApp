package com.thechessnuts.InputHandlerService.models;

import java.util.ArrayList;

public class BishopBehaviour implements PieceBehaviour {    


    @Override
    public ArrayList<Square> getMoves(Chess3Board board, Piece piece) {
        ArrayList<Square> list = new ArrayList<>();

        list.addAll(board.navigation.squaresTopRightDiagonal(piece.square));
        list.addAll(board.navigation.squaresTopLeftDiagonal(piece.square));
        list.addAll(board.navigation.squaresBottomRightDiagonal(piece.square));
        list.addAll(board.navigation.squaresBottomLeftDiagonal(piece.square));
        
        for(int i = 0; i<list.size(); i++){
            if(list.get(i).piece!=null){
                if(list.get(i).piece.player.color == piece.player.color){
                    list.remove(i);
                    i--;
                }
            }
        }
        return list;
    }
}
