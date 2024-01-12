package com.thechessnuts.InputHandlerService.models;

import java.util.ArrayList;

public class Pawn3Behaviour implements PieceBehaviour{

    @Override
    public ArrayList<Square> getMoves(AbstractChessBoard board, Piece piece){
        
        ArrayList<Square> list = new ArrayList<>();
try{
        if(piece.player.color == Player.colors.WHITE){
            if(piece.square.label.equals("i9")){
                if(board.getSquareAt("e4").piece != null){
                    list.add(board.getSquareAt("e4"));
                }
            }
            if(piece.square.label.equals("e9")){
                if(board.getSquareAt("i5").piece != null){
                    list.add(board.getSquareAt("i5"));
                }
            }
            Square squareAbove = board.navigation.getSquareAbove(piece.square);
            if(squareAbove.isEmpty()){
                list.add(squareAbove);
                Square nextStep = board.navigation.getSquareAbove(squareAbove);
                if(nextStep.isEmpty() && !piece.started){
                    list.add(nextStep);
                }
            }
            Square leftFront = board.navigation.getSquareLeft(squareAbove);
            Square rightFront = board.navigation.getSquareRight(squareAbove);
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
                if(board.getSquareAt("d5").piece != null){
                    list.add(board.getSquareAt("d5"));
                }
            }
            if(piece.square.label.equals("d4")){
                if(board.getSquareAt("e9").piece != null){
                    list.add(board.getSquareAt("e9"));
                }
            }
            }

            if(piece.player.color == Player.colors.YELLOW){
                if(piece.square.label.equals("d5")){
                if(board.getSquareAt("i9").piece != null){
                    list.add(board.getSquareAt("i9"));
                }
            }
            if(piece.square.label.equals("i5")){
                if(board.getSquareAt("d4").piece != null){
                    list.add(board.getSquareAt("d4"));
                }
            }
            }

            if(piece.crossedBorder){
                Square squareAbove = board.navigation.getSquareAbove(piece.square);
                if(squareAbove.isEmpty()){
                    list.add(squareAbove);
                }
                Square leftFront = board.navigation.getSquareLeft(squareAbove);
                Square rightFront = board.navigation.getSquareRight(squareAbove);
                if(leftFront!=null && !leftFront.isEmpty()){
                    list.add(leftFront);
                }
                if(rightFront!=null && !rightFront.isEmpty()){
                    list.add(rightFront);
                }
            }
            else {
                Square squareBelow = board.navigation.getSquareBelow(piece.square);
                if (squareBelow.isEmpty()) {
                    list.add(squareBelow);
                    Square nextStep = board.navigation.getSquareBelow(squareBelow);
                    if(nextStep.isEmpty() && !piece.started){
                        list.add(nextStep);
                    }
                }
                Square leftFront = board.navigation.getSquareLeft(squareBelow);
                Square rightFront = board.navigation.getSquareRight(squareBelow);
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

        

        return list;
    }
    
}
