package com.thechessnuts.InputHandlerService.models;

import java.util.ArrayList;

public class KingBehaviour extends PieceBehaviour{

    KingBehaviour(){
        this.symbol = "K";
        this.name = "king";
    }
    
    @Override
    public ArrayList<Square> getMoves(AbstractChessBoard board, Piece piece){
        ArrayList<Square> list = new ArrayList<>();

        String[] directions = {"up", "left", "down", "right", "topLeft", "topRight", "bottomLeft", "bottomRight"};

        for(String direction : directions){
            Square directedSquare = board.navigation.getSquaresAdjacent(piece.getSquare()).get(direction); 
            if(directedSquare==null)
                continue;
            list.add(directedSquare);
        }

        return list;
    }
}
