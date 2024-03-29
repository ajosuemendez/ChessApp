package com.thechessnuts.gamesessionservice.models;

import java.util.ArrayList;

class ChecksMarker {
    

    protected void markChecks(Chess3Board board){

        for (Chess3Section section : board.sections) {
            for (Square[] arr: section.squares) {
                for (Square square : arr) {
                    if(square.piece!=null){
                        ArrayList<Square> list = board.getMoves(square);
                        for (Square squareAttack : list) {
                            if(squareAttack.piece != null){
                                if(squareAttack.piece.pieceBehaviour instanceof KingBehaviour && !squareAttack.piece.player.color.equals(square.piece.player.color)){
                                    squareAttack.piece.setChecked(true);
                                }
                            }
                            
                        }
                    }
                    
                }
                
            }
        }
    }

    protected void unmarkChecks(Chess3Board board){
        for (Chess3Section section : board.sections) {
            
            for (Square[] arr: section.squares) {
                for (Square square : arr) {
                    if(square.piece!=null){
                        square.piece.setChecked(false);
                    }
                }
            }
        }
    }
}
