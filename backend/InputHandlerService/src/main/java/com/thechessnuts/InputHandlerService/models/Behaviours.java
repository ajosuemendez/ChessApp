package com.thechessnuts.InputHandlerService.models;

import java.util.ArrayList;

public class Behaviours {
    Chess3Board board;

    Behaviours(Chess3Board board){
        this.board = board;
    }

    public ArrayList<Square> bishopBehaviour(Piece piece)
    {
        ArrayList<Square> list = new ArrayList<>();

        list.addAll(this.board.navigation.squaresTopRightDiagonal(piece.square));
        list.addAll(this.board.navigation.squaresTopLeftDiagonal(piece.square));
        list.addAll(this.board.navigation.squaresBottomRightDiagonal(piece.square));
        list.addAll(this.board.navigation.squaresBottomLeftDiagonal(piece.square));
        
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

    public ArrayList<Square> rookBehaviour(Piece piece)

    {
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

    public ArrayList<Square> queenBehaviour(Piece piece)
    {
        ArrayList<Square> list = this.bishopBehaviour(piece);
        list.addAll(this.rookBehaviour(piece));
        return list;
    }

    public ArrayList<Square> pawnBehaviour(Pawn piece)
    {


        ArrayList<Square> list = new ArrayList<>();
try{
        if(piece.player.color == Player.colors.WHITE){
            if(piece.square.label.equals("i9")){
                if(this.board.getSquare("e4").piece != null){
                    list.add(this.board.getSquare("e4"));
                }
            }
            if(piece.square.label.equals("e9")){
                if(this.board.getSquare("i5").piece != null){
                    list.add(this.board.getSquare("i5"));
                }
            }
            Square squareAbove = board.navigation.squareAbove(piece.square);
            if(squareAbove.isEmpty()){
                list.add(squareAbove);
                Square nextStep = board.navigation.squareAbove(squareAbove);
                if(nextStep.isEmpty() && !piece.started){
                    list.add(nextStep);
                }
            }
            Square leftFront = board.navigation.squareLeft(squareAbove);
            Square rightFront = board.navigation.squareRight(squareAbove);
            if(leftFront!=null && !leftFront.isEmpty()){
                list.add(leftFront);
            }
            if(rightFront!=null && !rightFront.isEmpty()){
                list.add(rightFront);
            }
        }
        else{
            if(piece.player.color == Player.colors.YELLOW && piece.square.label.charAt(1)=='4')
                piece.crossedBorder = true;
            if(piece.player.color == Player.colors.BLACK && piece.square.label.charAt(1)=='5')
                piece.crossedBorder = true;
            
            if(piece.player.color == Player.colors.BLACK){
                if(piece.square.label.equals("e4")){
                if(this.board.getSquare("d5").piece != null){
                    list.add(this.board.getSquare("d5"));
                }
            }
            if(piece.square.label.equals("d4")){
                if(this.board.getSquare("e9").piece != null){
                    list.add(this.board.getSquare("e9"));
                }
            }
            }

            if(piece.player.color == Player.colors.YELLOW){
                if(piece.square.label.equals("d5")){
                if(this.board.getSquare("i9").piece != null){
                    list.add(this.board.getSquare("i9"));
                }
            }
            if(piece.square.label.equals("i5")){
                if(this.board.getSquare("d4").piece != null){
                    list.add(this.board.getSquare("d4"));
                }
            }
            }

            if(piece.crossedBorder){
                Square squareAbove = board.navigation.squareAbove(piece.square);
                if(squareAbove.isEmpty()){
                    list.add(squareAbove);
                }
                Square leftFront = board.navigation.squareLeft(squareAbove);
                Square rightFront = board.navigation.squareRight(squareAbove);
                if(leftFront!=null && !leftFront.isEmpty()){
                    list.add(leftFront);
                }
                if(rightFront!=null && !rightFront.isEmpty()){
                    list.add(rightFront);
                }
            }
            else {
                Square squareBelow = board.navigation.squareBelow(piece.square);
                if (squareBelow.isEmpty()) {
                    list.add(squareBelow);
                    Square nextStep = board.navigation.squareBelow(squareBelow);
                    if(nextStep.isEmpty() && !piece.started){
                        list.add(nextStep);
                    }
                }
                Square leftFront = board.navigation.squareLeft(squareBelow);
                Square rightFront = board.navigation.squareRight(squareBelow);
                if (leftFront != null && !leftFront.isEmpty()) {
                    list.add(leftFront);
                }
                if (rightFront != null && !rightFront.isEmpty()) {
                    list.add(rightFront);
                }
            }
            
        }
    }
    catch(Exception e){
        System.out.println(e);
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

    public ArrayList<Square> knightBehaviour(Piece piece)
    {
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

    public ArrayList<Square> kingBehaviour(King piece){
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
