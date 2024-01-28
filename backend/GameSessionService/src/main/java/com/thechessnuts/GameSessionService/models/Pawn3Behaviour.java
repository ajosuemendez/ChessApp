package com.thechessnuts.gamesessionservice.models;

import java.util.ArrayList;

public class Pawn3Behaviour extends PieceBehaviour{

    Pawn3Behaviour(){
        this.symbol = "";
        this.name = "pawn";
    }

    @Override
    public ArrayList<Square> getMoves(Board board, BoardNavigation navigation, Piece piece){
        
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
            Square squareAbove = navigation.getSquareAbove(board, piece.square);
            if(squareAbove.isEmpty()){
                list.add(squareAbove);
                Square nextStep = navigation.getSquareAbove(board, squareAbove);
                if(nextStep.isEmpty() && !piece.started){
                    list.add(nextStep);
                }
            }
            Square leftFront = navigation.getSquareLeft(board, squareAbove);
            Square rightFront = navigation.getSquareRight(board, squareAbove);
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
                Square squareAbove = navigation.getSquareAbove(board, piece.square);
                if(squareAbove.isEmpty()){
                    list.add(squareAbove);
                }
                Square leftFront = navigation.getSquareLeft(board, squareAbove);
                Square rightFront = navigation.getSquareRight(board, squareAbove);
                if(leftFront!=null && !leftFront.isEmpty()){
                    list.add(leftFront);
                }
                if(rightFront!=null && !rightFront.isEmpty()){
                    list.add(rightFront);
                }
            }
            else {
                Square squareBelow = navigation.getSquareBelow(board, piece.square);
                if (squareBelow.isEmpty()) {
                    list.add(squareBelow);
                    Square nextStep = navigation.getSquareBelow(board, squareBelow);
                    if(nextStep.isEmpty() && !piece.started){
                        list.add(nextStep);
                    }
                }
                Square leftFront = navigation.getSquareLeft(board, squareBelow);
                Square rightFront = navigation.getSquareRight(board, squareBelow);
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
