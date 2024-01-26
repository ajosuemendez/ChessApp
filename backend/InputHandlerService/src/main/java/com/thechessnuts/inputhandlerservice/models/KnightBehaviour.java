package com.thechessnuts.inputhandlerservice.models;

import java.util.ArrayList;

class KnightBehaviour extends PieceBehaviour {

    KnightBehaviour(){
        this.symbol = "N";
        this.name = "knight";
    }
    
    @Override
    ArrayList<Square> getMoves(AbstractChessBoard board, Piece piece){
        
        ArrayList<Square> list = new ArrayList<>();

        String[] directions = {"up", "left", "down", "right"};

        for(String direction : directions){

            Square adjacentSquare = board.navigation.getSquaresAdjacent(piece.getSquare()).get(direction);

            if(adjacentSquare == null)
                continue;
            
            Square secondStep;

            //ABOVE
            if(direction.equals("up")){
                secondStep = board.navigation.getSquareAbove(adjacentSquare);
            }
            //LEFT
            else if(direction.equals("left")){
                 secondStep = board.navigation.getSquareLeft(adjacentSquare);
            }
            //BELOW 
            else if(direction.equals("down")){    
                /* Here we need to deal with the special case at the border between the two sections 
                 * at the squaresTop of the board where the directions up and down become opposite if crossed
                 */

                if(adjacentSquare.isAtBorder()){
                    secondStep = board.navigation.getSquareAbove(adjacentSquare);        
                }

                else{
                    secondStep = board.navigation.getSquareBelow(adjacentSquare);
                }
            }
            //RIGHT
            else{
                secondStep = board.navigation.getSquareRight(adjacentSquare);
            }

            if(secondStep == null)
                    continue;

            //These squares represent the last step in the "L" shaped path that the knight takes
            Square thirdStepLeft;
            Square thirdStepRight;

            //ABOVE OR BELOW
            if(direction.equals("up") || direction.equals("down")){
                thirdStepLeft = board.navigation.getSquareLeft(secondStep);
                thirdStepRight = board.navigation.getSquareRight(secondStep);
            }
            //LEFT OR RIGHT
            else{
                thirdStepLeft = board.navigation.getSquareAbove(secondStep);
                thirdStepRight = board.navigation.getSquareBelow(secondStep);
            
            }

            if(thirdStepLeft != null){
                list.add(thirdStepLeft);
            }
            if(thirdStepRight != null){
                list.add(thirdStepRight);
            }
        }

        

        return list;
    }
    
}
