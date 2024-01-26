package com.thechessnuts.inputhandlerservice.models;

import java.util.ArrayList;

class ChecksManager {

    Chess3Board board;

    ChecksManager(Chess3Board board){
        this.board = board;
    }
    

    protected void markChecks(){

        for (Chess3Section section : board.sections) {
            for (Square[] arr: section.squares) {
                for (Square square : arr) {
                    if(square.piece!=null){
                        ArrayList<Square> list = square.piece.allMoves();
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

    protected void unmarkChecks(){
        for (Chess3Section section : this.board.sections) {
            
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
