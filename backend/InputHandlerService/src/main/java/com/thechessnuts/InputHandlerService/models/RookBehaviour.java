package com.thechessnuts.InputHandlerService.models;

import java.util.ArrayList;

public class RookBehaviour implements PieceBehaviour{

    @Override
    public ArrayList<Square> getMoves(Chess3Board board, Piece piece){
        
        ArrayList<Square> list = new ArrayList<>();
        boolean borderWasCrossed = false;

        Square checkingSquare = board.navigation.squareAbove(piece.square);

        while(checkingSquare!=null){
            list.add(checkingSquare);
            if (checkingSquare.isEmpty()){
                checkingSquare = board.navigation.squareAbove(checkingSquare);
            }
            else{
                break;
            }
        }
        if(piece.square.label.charAt(0) <= 'd' && (piece.square.label.charAt(1) == '4' || piece.square.label.charAt(1) == '5')){
            borderWasCrossed = true;
        }

        checkingSquare = board.navigation.squareBelow(piece.square);

        while(checkingSquare!=null){
            list.add(checkingSquare);
            if (checkingSquare.isEmpty()){
                if(borderWasCrossed){
                    checkingSquare = board.navigation.squareAbove(checkingSquare);
                }
                else {
                    if (checkingSquare.label.charAt(0) <= 'd' && (checkingSquare.label.charAt(1) == '4' || checkingSquare.label.charAt(1) == '5')) {
                        borderWasCrossed = true;
                         checkingSquare = board.navigation.squareBelow(checkingSquare);
                        continue;
                    }
                    checkingSquare = board.navigation.squareBelow(checkingSquare);
                }
            }
            else{
                break;
            }
        }

        checkingSquare = board.navigation.squareLeft(piece.square);

        while(checkingSquare!=null){
            list.add(checkingSquare);
            if (checkingSquare.isEmpty()){
                checkingSquare = board.navigation.squareLeft(checkingSquare);
            }
            else{
                break;
            }
        }

        checkingSquare = board.navigation.squareRight(piece.square);

        while(checkingSquare!=null){
            list.add(checkingSquare);
            if (checkingSquare.isEmpty()){
                checkingSquare = board.navigation.squareRight(checkingSquare);
            }
            else{
                break;
            }
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
