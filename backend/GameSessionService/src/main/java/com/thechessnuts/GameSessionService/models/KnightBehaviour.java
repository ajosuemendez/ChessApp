package com.thechessnuts.gamesessionservice.models;

import java.util.ArrayList;

class KnightBehaviour extends PieceBehaviour {

    KnightBehaviour(){
        this.symbol = "N";
        this.name = "knight";
    }
    
    @Override
    ArrayList<Square> getMoves(Board board, Square square){
        
        ArrayList<Square> list = new ArrayList<>();
        BoardNavigation navigation = board.getNavigation();

        String[] directions = {"up", "left", "down", "right"};

        for(String direction : directions){

            Square adjacentSquare = navigation.getSquaresAdjacent(board, square).get(direction);

            if(adjacentSquare == null)
                continue;
            
            Square secondStep;

            //ABOVE
            if(direction.equals("up")){
                secondStep = navigation.getSquareAbove(board, adjacentSquare);
            }
            //LEFT
            else if(direction.equals("left")){
                 secondStep = navigation.getSquareLeft(board, adjacentSquare);
            }
            //BELOW 
            else if(direction.equals("down")){    
                /* Here we need to deal with the special case at the border between the two sections 
                 * at the squaresTop of the board where the directions up and down become opposite if crossed
                 */

                if(adjacentSquare.isAtBorder()){
                    secondStep = navigation.getSquareAbove(board, adjacentSquare);        
                }

                else{
                    secondStep = navigation.getSquareBelow(board, adjacentSquare);
                }
            }
            //RIGHT
            else{
                secondStep = navigation.getSquareRight(board, adjacentSquare);
            }

            if(secondStep == null)
                    continue;

            //These squares represent the last step in the "L" shaped path that the knight takes
            Square thirdStepLeft;
            Square thirdStepRight;

            //ABOVE OR BELOW
            if(direction.equals("up") || direction.equals("down")){
                thirdStepLeft = navigation.getSquareLeft(board, secondStep);
                thirdStepRight = navigation.getSquareRight(board, secondStep);
            }
            //LEFT OR RIGHT
            else{
                thirdStepLeft = navigation.getSquareAbove(board, secondStep);
                thirdStepRight = navigation.getSquareBelow(board, secondStep);
            
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
