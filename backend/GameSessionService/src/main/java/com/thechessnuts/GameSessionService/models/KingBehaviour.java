package com.thechessnuts.gamesessionservice.models;

import java.util.ArrayList;

class KingBehaviour extends PieceBehaviour{

    KingBehaviour(){
        this.symbol = "K";
        this.name = "king";
    }
    
    @Override
    ArrayList<Square> getMoves(Board board, Square square){
        ArrayList<Square> list = new ArrayList<>();

        String[] directions = {"up", "left", "down", "right", "topLeft", "topRight", "bottomLeft", "bottomRight"};

        for(String direction : directions){
            Square directedSquare = board.getNavigation().getSquaresAdjacent(board, square).get(direction); 
            if(directedSquare==null)
                continue;
            list.add(directedSquare);
        }

        return list;
    }
}
