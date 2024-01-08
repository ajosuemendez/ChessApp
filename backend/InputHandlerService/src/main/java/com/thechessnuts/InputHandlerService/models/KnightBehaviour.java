package com.thechessnuts.InputHandlerService.models;

import java.util.ArrayList;

public class KnightBehaviour implements PieceBehaviour {
    
    @Override
    public ArrayList<Square> getMoves(Chess3Board board, Piece piece){
        
        ArrayList<Square> list = new ArrayList<>();

        String[] directions = {"up", "left", "down", "right"};

        for(String direction : directions){

            Square adjacentSquare = board.navigation.squaresAdjacent(piece.square).get(direction);

            if(adjacentSquare == null)
                continue;
            
            Square secondStep;

            //ABOVE
            if(direction.equals("up")){
                secondStep = board.navigation.squareAbove(adjacentSquare);
            }
            //LEFT
            else if(direction.equals("left")){
                 secondStep = board.navigation.squareLeft(adjacentSquare);
            }
            //BELOW 
            else if(direction.equals("down")){    
                /* Here we need to deal with the special case at the border between the two sections 
                 * at the squaresTop of the board where the directions up and down become opposite if crossed
                 */

                if(adjacentSquare.isAtBorder()){
                    secondStep = board.navigation.squareAbove(adjacentSquare);        
                }

                else{
                    secondStep = board.navigation.squareBelow(adjacentSquare);
                }
            }
            //RIGHT
            else{
                secondStep = board.navigation.squareRight(adjacentSquare);
            }

            if(secondStep == null)
                    continue;

            //These squares represent the last step in the "L" shaped path that the knight takes
            Square thirdStepLeft;
            Square thirdStepRight;

            //ABOVE OR BELOW
            if(direction.equals("up") || direction.equals("down")){
                thirdStepLeft = board.navigation.squareLeft(secondStep);
                thirdStepRight = board.navigation.squareRight(secondStep);
            }
            //LEFT OR RIGHT
            else{
                thirdStepLeft = board.navigation.squareAbove(secondStep);
                thirdStepRight = board.navigation.squareBelow(secondStep);
            
            }

            if(thirdStepLeft != null){
                list.add(thirdStepLeft);
            }
            if(thirdStepRight != null){
                list.add(thirdStepRight);
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
