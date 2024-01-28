package com.thechessnuts.gamesessionservice.models;

import java.util.ArrayList;

public class Pawn3Behaviour extends PieceBehaviour{


    Pawn3Behaviour(){
        this.symbol = "";
        this.name = "pawn";
    }

    @Override
    public ArrayList<Square> getMoves(Board board, Square square){
        
        ArrayList<Square> list = new ArrayList<>();
        BoardNavigation navigation = board.getNavigation();
try{
        if(square.getPiece().player.color == Player.colors.WHITE){
            if(square.label.equals("i9")){
                if(board.getSquareAt("e4").piece != null){
                    list.add(board.getSquareAt("e4"));
                }
            }
            if(square.label.equals("e9")){
                if(board.getSquareAt("i5").piece != null){
                    list.add(board.getSquareAt("i5"));
                }
            }
            Square squareAbove = navigation.getSquareAbove(board, square);
            if(squareAbove.isEmpty()){
                list.add(squareAbove);
                Square nextStep = navigation.getSquareAbove(board, squareAbove);
                if(nextStep.isEmpty() && !square.getPiece().started){
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
            if(square.getPiece().player.color == Player.colors.YELLOW && square.label.charAt(1)=='4')
                this.crossedBorder = true;
            if(square.getPiece().player.color == Player.colors.BLACK && square.label.charAt(1)=='5')
                this.crossedBorder = true;
            
            if(square.getPiece().player.color == Player.colors.BLACK){
                if(square.label.equals("e4")){
                if(board.getSquareAt("d5").piece != null){
                    list.add(board.getSquareAt("d5"));
                }
            }
            if(square.label.equals("d4")){
                if(board.getSquareAt("e9").piece != null){
                    list.add(board.getSquareAt("e9"));
                }
            }
            }

            if(square.getPiece().player.color == Player.colors.YELLOW){
                if(square.label.equals("d5")){
                if(board.getSquareAt("i9").piece != null){
                    list.add(board.getSquareAt("i9"));
                }
            }
            if(square.label.equals("i5")){
                if(board.getSquareAt("d4").piece != null){
                    list.add(board.getSquareAt("d4"));
                }
            }
            }

            if(this.crossedBorder){
                Square squareAbove = navigation.getSquareAbove(board, square);
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
                Square squareBelow = navigation.getSquareBelow(board, square);
                if (squareBelow.isEmpty()) {
                    list.add(squareBelow);
                    Square nextStep = navigation.getSquareBelow(board, squareBelow);
                    if(nextStep.isEmpty() && !square.getPiece().started){
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
