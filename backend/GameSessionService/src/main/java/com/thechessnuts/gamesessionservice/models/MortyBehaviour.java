package com.thechessnuts.gamesessionservice.models;

import java.util.ArrayList;

public class MortyBehaviour extends PieceBehaviour {

    MortyBehaviour(){
        this.symbol = "M";
        this.name = "morty";
    }

    @Override
    ArrayList<Square> getMoves(Board board, Square square) {
        ArrayList<Square> list = new ArrayList<>();

        String[] directions = {"up", "left", "down", "right", "topLeft", "topRight", "bottomLeft", "bottomRight"};

        for(String direction : directions){
            Square directedSquare = board.getNavigation().getSquaresAdjacent(board, square).get(direction); 
            if(directedSquare==null)
                continue;
            list.add(directedSquare);
        }

        String[] directionsJump = {"up", "left", "down", "right"};

        for (String direction : directionsJump) {
            Square directedSquare = board.getNavigation().getSquaresAdjacent(board, square).get(direction); 
            if(directedSquare==null){
                continue;
            }
            Square jumpOverSquare = board.getNavigation().getSquaresAdjacent(board, directedSquare).get(direction); 
            Square jumpSquare = board.getNavigation().getSquaresAdjacent(board, jumpOverSquare).get(direction); 
            if(jumpSquare!=null){
                list.add(jumpSquare);
            }
        }
        return list;
    }
    
}
