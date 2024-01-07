package com.thechessnuts.InputHandlerService.models;

import java.util.ArrayList;
import java.util.HashMap;

public class Navigation {
    Chess3Board board;

    /*
     * 
     */

    Navigation(Chess3Board board){
        this.board = board;
    }
    
    public Square squareAbove(Square square){
       char columnLetter = square.label.charAt(0);
       int rowNumber = Integer.parseInt(square.label.substring(1));

        if(rowNumber == 1 || rowNumber == 8){
            return null;
        }

        if(rowNumber == 9){
            if(columnLetter>='i'){
                 return board.getSquare(Character.toString(columnLetter)+Integer.toString(5));
            }
            else{
                 return board.getSquare(Character.toString(columnLetter)+Integer.toString(4));
            }
        }

        if(rowNumber < 8 && rowNumber >= 5){
            return board.getSquare(Character.toString(columnLetter)+Integer.toString(rowNumber+1));
        }

        return board.getSquare(Character.toString(columnLetter)+Integer.toString(rowNumber-1));
        

    }

    public Square squareBelow(Square square){
        char columnLetter = square.label.charAt(0);
        int rowNumber = Integer.parseInt(square.label.substring(1));

        if(rowNumber>=9){
            return board.getSquare(Character.toString(columnLetter)+Integer.toString(rowNumber+1));
        }

        if(rowNumber>5){
            return board.getSquare(Character.toString(columnLetter)+Integer.toString(rowNumber-1));
        }

        if(rowNumber == 5){
            if(columnLetter>='i'){
                return board.getSquare(Character.toString(columnLetter)+"9");
            }
            return board.getSquare(Character.toString(columnLetter)+"4");
        }

         if(rowNumber<4){
            return board.getSquare(Character.toString(columnLetter)+Integer.toString(rowNumber+1));
        }

        if(rowNumber == 4){
            if(columnLetter>='e'){
                return board.getSquare(Character.toString(columnLetter)+"9");
            }
            return board.getSquare(Character.toString(columnLetter)+"5");
        }

        return null;

    }

    public Square squareLeft(Square square){
        char columnLetter = square.label.charAt(0);
        int rowNumber = Integer.parseInt(square.label.substring(1));

        if(columnLetter == 'h')
            return null;

        if(columnLetter == 'i'){
            if(rowNumber>=9){
                return board.getSquare("e"+Integer.toString(rowNumber));
            }
            else{
                return board.getSquare("d"+Integer.toString(rowNumber));
            }
        }

        if(columnLetter>'i'){
            return board.getSquare(Character.toString(columnLetter-1)+Integer.toString(rowNumber));
        }

        if(columnLetter>='e'){
            return board.getSquare(Character.toString(columnLetter+1)+Integer.toString(rowNumber));
        }

        if(rowNumber<=4){
            return board.getSquare(Character.toString(columnLetter+1)+Integer.toString(rowNumber));
        }
        if(rowNumber>=5){
             return board.getSquare(Character.toString(columnLetter-1)+Integer.toString(rowNumber));
        }

        
        return null;
        
    }

    public Square squareRight(Square square){

    
        char columnLetter = square.label.charAt(0);
        int rowNumber = Integer.parseInt(square.label.substring(1));

        if(columnLetter == 'l')
            return null;

        if(columnLetter == 'e'){
            if(rowNumber>=9){
                return board.getSquare("i"+Integer.toString(rowNumber));
            }
            else{
                return board.getSquare("d"+Integer.toString(rowNumber));
            }
        }

        if(columnLetter>='i'){
            return board.getSquare(Character.toString(columnLetter+1)+Integer.toString(rowNumber));
        }

        if(columnLetter>'e'){
            return board.getSquare(Character.toString(columnLetter-1)+Integer.toString(rowNumber));
        }

        if(columnLetter == 'd'){
            if(rowNumber>=5){
                return board.getSquare("i"+Integer.toString(rowNumber));
            }
        }

        if(rowNumber<=4){
            return board.getSquare(Character.toString(columnLetter-1)+Integer.toString(rowNumber));
        }
        if(rowNumber>=5){
             return board.getSquare(Character.toString(columnLetter+1)+Integer.toString(rowNumber));
        }

        
        return null;
    }

    public HashMap<String, Square> squaresAdjacent(Square square){
        HashMap<String, Square> dictionary = new HashMap<>();

        Square up = board.navigation.squareAbove(square);
        Square down = board.navigation.squareBelow(square);

        dictionary.put("up", up);
        dictionary.put("left", board.navigation.squareLeft(square));
        dictionary.put("down", down);
        dictionary.put("right", board.navigation.squareRight(square));
        
        if(up == null){
            dictionary.put("topLeft", null);
            dictionary.put("topRight", null);
        }
        else{
            dictionary.put("topLeft", board.navigation.squareLeft(up));
            dictionary.put("topRight", board.navigation.squareRight(up));
        }

        if(down == null){
            dictionary.put("bottomLeft", null);
            dictionary.put("bottomRight", null);
        }
        else{
            if(down.isAtBorder()){
                dictionary.put("bottomLeft", board.navigation.squareLeft(down));
                dictionary.put("bottomRight", board.navigation.squareRight(down));
            }
            else{
                dictionary.put("bottomLeft", board.navigation.squareLeft(down));
                dictionary.put("bottomRight", board.navigation.squareRight(down));
            }
        }

        return dictionary;
    }

    public ArrayList<Square> squaresTopLeftDiagonal(Square square){
        ArrayList<Square> list = new ArrayList<>();
        if(square.label.equals("i9")){
            if(square.isEmpty() || square.piece.isSelected) {
                list.add(board.getSquare("e4"));
                if(board.getSquare("e4").isEmpty())
                    list.addAll(squaresTopLeftDiagonal(board.getSquare("e4")));
                list.add(board.getSquare("d5"));
                if(board.getSquare("d5").isEmpty())
                    list.addAll(squaresTopLeftDiagonal(board.getSquare("d5")));
            }
            return list;
        }
        Square above = squareAbove(square);
        if(above!=null) {
            Square squaresTopLeft = squareLeft(above);
            if(squaresTopLeft!= null){
                list.add(squaresTopLeft);
                if(squaresTopLeft.isEmpty()){
                    list.addAll(squaresTopLeftDiagonal(squaresTopLeft));
                }
            }
        }
        return list;
    }

    public ArrayList<Square> squaresBottomLeftDiagonal(Square square){
        ArrayList<Square> list = new ArrayList<>();
        if(square.label.equals("d4")){
            if(square.isEmpty() || square.piece.isSelected) {
                list.add(board.getSquare("e9"));
                if(board.getSquare("e9").isEmpty())
                    list.addAll(squaresBottomLeftDiagonal(board.getSquare("e9")));
                list.add(board.getSquare("i5"));
                if(board.getSquare("i5").isEmpty())
                    list.addAll(squaresTopRightDiagonal(board.getSquare("i5")));
            }
            return list;
        }
        if(square.label.equals("i5")){
            if(square.isEmpty() || square.piece.isSelected) {
                list.add(board.getSquare("e9"));
                if(board.getSquare("e9").isEmpty())
                    list.addAll(squaresBottomLeftDiagonal(board.getSquare("e9")));
                list.add(board.getSquare("d4"));
                if(board.getSquare("d4").isEmpty())
                    list.addAll(squaresTopRightDiagonal(board.getSquare("d4")));
            }
            return list;
        }
        Square below = squareBelow(square);
        if(below!=null) {
            if(square.label.charAt(0)<='d' && (square.label.charAt(1)=='4' || square.label.charAt(1)=='5')){
                Square squaresBottomLeft = squareRight(below);
                if(squaresBottomLeft!=null){
                    list.add(squaresBottomLeft);
                    if(squaresBottomLeft.isEmpty())
                        list.addAll(squaresTopRightDiagonal(squaresBottomLeft));
                }
                return list;
            }
            Square squaresBottomLeft = squareLeft(below);
            if(squaresBottomLeft!= null){
                list.add(squaresBottomLeft);
                if(squaresBottomLeft.isEmpty())
                    list.addAll(squaresBottomLeftDiagonal(squaresBottomLeft));
            }
        }
        return list;
    }

    public ArrayList<Square> squaresTopRightDiagonal(Square square){
        ArrayList<Square> list = new ArrayList<>();
        if(square.label.equals("e9")){
            if(square.isEmpty() || square.piece.isSelected){
                list.add(board.getSquare("d4"));
                if(board.getSquare("d4").isEmpty())
                    list.addAll(squaresTopRightDiagonal(board.getSquare("d4")));
                list.add(board.getSquare("i5"));
                if(board.getSquare("i5").isEmpty())
                    list.addAll(squaresTopRightDiagonal(board.getSquare("i5")));
            }
            return list; 
        }
        Square above = squareAbove(square);
        if(above!=null) {
            Square squaresTopRight = squareRight(above);
            if(squaresTopRight!= null){
                list.add(squaresTopRight);
                if(squaresTopRight.isEmpty())
                    list.addAll(squaresTopRightDiagonal(squaresTopRight));
            }
        }
        return list;
    }

    public ArrayList<Square> squaresBottomRightDiagonal(Square square){
        ArrayList<Square> list = new ArrayList<>();
        if(square.label.equals("e4")){
            list.add(board.getSquare("i9"));
            if(board.getSquare("i9").isEmpty())
                list.addAll(squaresBottomRightDiagonal(board.getSquare("i9")));
            list.add(board.getSquare("d5"));
            if(board.getSquare("d5").isEmpty())
                list.addAll(squaresTopLeftDiagonal(board.getSquare("d5")));
            return list;
        }
        if(square.label.equals("d5")){
            list.add(board.getSquare("i9"));
            if(board.getSquare("i9").isEmpty())
                list.addAll(squaresBottomRightDiagonal(board.getSquare("i9")));
            list.add(board.getSquare("e4"));
            if(board.getSquare("e4").isEmpty())
                list.addAll(squaresTopLeftDiagonal(board.getSquare("e4")));
            return list;
        }
        Square below = squareBelow(square);
        if(below!=null) {
            if(square.label.charAt(0)<='d' && (square.label.charAt(1)=='4' || square.label.charAt(1)=='5')){
                Square squaresBottomRight = squareLeft(below);
                if(squaresBottomRight!=null) {
                    list.add(squaresBottomRight);
                    if(squaresBottomRight.isEmpty())
                        list.addAll(squaresTopLeftDiagonal(squaresBottomRight));
                }
                return list;
            }
            Square squaresBottomRight = squareRight(below);
            if(squaresBottomRight!= null){
                list.add(squaresBottomRight);
                if(squaresBottomRight.isEmpty())
                    list.addAll(squaresBottomRightDiagonal(squaresBottomRight));
            }
        }
        return list;
    }

}
