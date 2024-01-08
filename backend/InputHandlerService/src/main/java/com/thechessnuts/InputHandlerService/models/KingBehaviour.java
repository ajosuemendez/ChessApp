package com.thechessnuts.InputHandlerService.models;

import java.util.ArrayList;

public class KingBehaviour implements PieceBehaviour{

    @Override
    public ArrayList<Square> getMoves(Chess3Board board, Piece piece){
        ArrayList<Square> list = new ArrayList<>();

        String[] directions = {"up", "left", "down", "right", "topLeft", "topRight", "bottomLeft", "bottomRight"};

        for(String direction : directions){
            Square directedSquare = board.navigation.squaresAdjacent(piece.square).get(direction); 
            if(directedSquare==null)
                continue;
            list.add(directedSquare);
        }

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
