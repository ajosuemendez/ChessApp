package com.thechessnuts.InputHandlerService.models;

import java.util.ArrayList;

public class KingBehaviour implements PieceBehaviour{

    @Override
    public ArrayList<Square> getMoves(AbstractChessBoard board, Piece piece){
        ArrayList<Square> list = new ArrayList<>();

        String[] directions = {"up", "left", "down", "right", "topLeft", "topRight", "bottomLeft", "bottomRight"};

        for(String direction : directions){
            Square directedSquare = board.navigation.getSquaresAdjacent(piece.square).get(direction); 
            if(directedSquare==null)
                continue;
            list.add(directedSquare);
        }

        return list;
    }
    
}
