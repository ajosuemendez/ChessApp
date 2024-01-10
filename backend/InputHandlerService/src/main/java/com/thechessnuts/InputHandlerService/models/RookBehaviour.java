package com.thechessnuts.InputHandlerService.models;

import java.util.ArrayList;

public class RookBehaviour implements PieceBehaviour{

    @Override
    public ArrayList<Square> getMoves(Chess3Board board, Piece piece){
        
        ArrayList<Square> list = new ArrayList<>();
        
        list.addAll(board.navigation.getSquaresAbove(piece.square));

        list.addAll(board.navigation.getSquaresBelow(piece.square));

        list.addAll(board.navigation.getSquaresLeft(piece.square));

        list.addAll(board.navigation.getSquaresRight(piece.square));

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
