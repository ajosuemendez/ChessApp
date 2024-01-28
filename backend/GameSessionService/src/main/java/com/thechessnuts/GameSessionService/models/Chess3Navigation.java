package com.thechessnuts.gamesessionservice.models;

import java.util.ArrayList;
import java.util.HashMap;

class Chess3Navigation extends BoardNavigation{

    
    @Override
    Square getSquareAbove(Board board, Square square){
       char columnLetter = square.label.charAt(0);
       int rowNumber = Integer.parseInt(square.label.substring(1));

        if(rowNumber == 1 || rowNumber == 8){
            return null;
        }

        if(rowNumber == 9){
            if(columnLetter>='i'){
                 return board.getSquareAt(Character.toString(columnLetter)+Integer.toString(5));
            }
            else{
                 return board.getSquareAt(Character.toString(columnLetter)+Integer.toString(4));
            }
        }

        if(rowNumber < 8 && rowNumber >= 5){
            return board.getSquareAt(Character.toString(columnLetter)+Integer.toString(rowNumber+1));
        }

        return board.getSquareAt(Character.toString(columnLetter)+Integer.toString(rowNumber-1));

    }

    @Override
    Square getSquareBelow(Board board, Square square){
        char columnLetter = square.label.charAt(0);
        int rowNumber = Integer.parseInt(square.label.substring(1));

        if(rowNumber>=9){
            return board.getSquareAt(Character.toString(columnLetter)+Integer.toString(rowNumber+1));
        }

        if(rowNumber>5){
            return board.getSquareAt(Character.toString(columnLetter)+Integer.toString(rowNumber-1));
        }

        if(rowNumber == 5){
            if(columnLetter>='i'){
                return board.getSquareAt(Character.toString(columnLetter)+"9");
            }
            return board.getSquareAt(Character.toString(columnLetter)+"4");
        }

         if(rowNumber<4){
            return board.getSquareAt(Character.toString(columnLetter)+Integer.toString(rowNumber+1));
        }

        if(rowNumber == 4){
            if(columnLetter>='e'){
                return board.getSquareAt(Character.toString(columnLetter)+"9");
            }
            return board.getSquareAt(Character.toString(columnLetter)+"5");
        }

        return null;

    }

    @Override
    Square getSquareLeft(Board board, Square square){
        char columnLetter = square.label.charAt(0);
        int rowNumber = Integer.parseInt(square.label.substring(1));

        if(columnLetter == 'h')
            return null;

        if(columnLetter == 'i'){
            if(rowNumber>=9){
                return board.getSquareAt("e"+Integer.toString(rowNumber));
            }
            else{
                return board.getSquareAt("d"+Integer.toString(rowNumber));
            }
        }

        if(columnLetter>'i'){
            return board.getSquareAt(Character.toString(columnLetter-1)+Integer.toString(rowNumber));
        }

        if(columnLetter>='e'){
            return board.getSquareAt(Character.toString(columnLetter+1)+Integer.toString(rowNumber));
        }

        if(rowNumber<=4){
            return board.getSquareAt(Character.toString(columnLetter+1)+Integer.toString(rowNumber));
        }
        if(rowNumber>=5){
             return board.getSquareAt(Character.toString(columnLetter-1)+Integer.toString(rowNumber));
        }

        
        return null;
        
    }

    @Override
    Square getSquareRight(Board board, Square square){

    
        char columnLetter = square.label.charAt(0);
        int rowNumber = Integer.parseInt(square.label.substring(1));

        if(columnLetter == 'l')
            return null;

        if(columnLetter == 'e'){
            if(rowNumber>=9){
                return board.getSquareAt("i"+Integer.toString(rowNumber));
            }
            else{
                return board.getSquareAt("d"+Integer.toString(rowNumber));
            }
        }

        if(columnLetter>='i'){
            return board.getSquareAt(Character.toString(columnLetter+1)+Integer.toString(rowNumber));
        }

        if(columnLetter>'e'){
            return board.getSquareAt(Character.toString(columnLetter-1)+Integer.toString(rowNumber));
        }

        if(columnLetter == 'd'){
            if(rowNumber>=5){
                return board.getSquareAt("i"+Integer.toString(rowNumber));
            }
        }

        if(rowNumber<=4){
            return board.getSquareAt(Character.toString(columnLetter-1)+Integer.toString(rowNumber));
        }
        if(rowNumber>=5){
             return board.getSquareAt(Character.toString(columnLetter+1)+Integer.toString(rowNumber));
        }

        
        return null;
    }

    @Override
    ArrayList<Square> getSquaresAbove(Board board, Square square) {

        ArrayList<Square> list = new ArrayList<>();

        Square checkingSquare = this.getSquareAbove(board, square);

        while(checkingSquare!=null){
            list.add(checkingSquare);
            if (checkingSquare.isEmpty()){
                checkingSquare = this.getSquareAbove(board, checkingSquare);
            }
            else{
                break;
            }
        }

        return list;
    }

    @Override
    ArrayList<Square> getSquaresBelow(Board board, Square square) {

        ArrayList<Square> list = new ArrayList<>();
        boolean borderWasCrossed = false;
        
        Square checkingSquare = this.getSquareBelow(board, square);
        

        while(checkingSquare!=null){
            list.add(checkingSquare);
            if(square.label.charAt(0) <= 'd' && (square.label.charAt(1) == '4' || square.label.charAt(1) == '5')){
                borderWasCrossed = true;
            }
            if (checkingSquare.isEmpty()){
                if(borderWasCrossed){
                    checkingSquare = this.getSquareAbove(board, checkingSquare);
                }
                else {
                    if (checkingSquare.label.charAt(0) <= 'd' && (checkingSquare.label.charAt(1) == '4' || checkingSquare.label.charAt(1) == '5')) {
                        borderWasCrossed = true;
                        checkingSquare = this.getSquareBelow(board, checkingSquare);
                        continue;
                    }
                    checkingSquare = this.getSquareBelow(board, checkingSquare);
                }
            }
            else{
                break;
            }
        }
        return list;
    }

    @Override
    ArrayList<Square> getSquaresLeft(Board board, Square square) {

        ArrayList<Square> list = new ArrayList<>();

        Square checkingSquare = this.getSquareLeft(board, square);

        while(checkingSquare!=null){
            list.add(checkingSquare);
            if (checkingSquare.isEmpty()){
                checkingSquare = this.getSquareLeft(board, checkingSquare);
            }
            else{
                break;
            }
        }
        return list;

    }

    @Override
    ArrayList<Square> getSquaresRight(Board board, Square square) {

        ArrayList<Square> list = new ArrayList<>();

        Square checkingSquare = this.getSquareRight(board, square);

        while(checkingSquare!=null){
            list.add(checkingSquare);
            if (checkingSquare.isEmpty()){
                checkingSquare = this.getSquareRight(board, checkingSquare);
            }
            else{
                break;
            }
        }

        return list;
    }

    @Override
    HashMap<String, Square> getSquaresAdjacent(Board board, Square square){
        HashMap<String, Square> dictionary = new HashMap<>();

        Square up = this.getSquareAbove(board, square);
        Square down = this.getSquareBelow(board, square);

        dictionary.put("up", up);
        dictionary.put("left", this.getSquareLeft(board, square));
        dictionary.put("down", down);
        dictionary.put("right", this.getSquareRight(board, square));
        
        if(up == null){
            dictionary.put("topLeft", null);
            dictionary.put("topRight", null);
        }
        else{
            dictionary.put("topLeft", this.getSquareLeft(board, up));
            dictionary.put("topRight", this.getSquareRight(board, up));
        }

        if(down == null){
            dictionary.put("bottomLeft", null);
            dictionary.put("bottomRight", null);
        }
        else{
            if(down.isAtBorder()){
                dictionary.put("bottomLeft", this.getSquareLeft(board, down));
                dictionary.put("bottomRight", this.getSquareRight(board, down));
            }
            else{
                dictionary.put("bottomLeft", this.getSquareLeft(board, down));
                dictionary.put("bottomRight", this.getSquareRight(board, down));
            }
        }

        return dictionary;
    }

    @Override
    ArrayList<Square> getSquaresTopLeftDiagonal(Board board, Square square){
        ArrayList<Square> list = new ArrayList<>();
        if(square.label.equals("i9")){
            if(square.isEmpty() || square.piece.isSelected()) {
                list.add(board.getSquareAt("e4"));
                if(board.getSquareAt("e4").isEmpty())
                    list.addAll(getSquaresTopLeftDiagonal(board, board.getSquareAt("e4")));
                list.add(board.getSquareAt("d5"));
                if(board.getSquareAt("d5").isEmpty())
                    list.addAll(getSquaresTopLeftDiagonal(board, board.getSquareAt("d5")));
            }
            return list;
        }
        Square above = getSquareAbove(board, square);
        if(above!=null) {
            Square getSquaresTopLeft = getSquareLeft(board, above);
            if(getSquaresTopLeft!= null){
                list.add(getSquaresTopLeft);
                if(getSquaresTopLeft.isEmpty()){
                    list.addAll(getSquaresTopLeftDiagonal(board, getSquaresTopLeft));
                }
            }
        }
        return list;
    }

    @Override
    ArrayList<Square> getSquaresBottomLeftDiagonal(Board board, Square square){
        ArrayList<Square> list = new ArrayList<>();
        if(square.label.equals("d4")){
            if(square.isEmpty() || square.piece.isSelected()) {
                list.add(board.getSquareAt("e9"));
                if(board.getSquareAt("e9").isEmpty())
                    list.addAll(getSquaresBottomLeftDiagonal(board, board.getSquareAt("e9")));
                list.add(board.getSquareAt("i5"));
                if(board.getSquareAt("i5").isEmpty())
                    list.addAll(getSquaresTopRightDiagonal(board, board.getSquareAt("i5")));
            }
            return list;
        }
        if(square.label.equals("i5")){
            if(square.isEmpty() || square.piece.isSelected()) {
                list.add(board.getSquareAt("e9"));
                if(board.getSquareAt("e9").isEmpty())
                    list.addAll(getSquaresBottomLeftDiagonal(board, board.getSquareAt("e9")));
                list.add(board.getSquareAt("d4"));
                if(board.getSquareAt("d4").isEmpty())
                    list.addAll(getSquaresTopRightDiagonal(board, board.getSquareAt("d4")));
            }
            return list;
        }
        Square below = getSquareBelow(board, square);
        if(below!=null) {
            if(square.label.charAt(0)<='d' && (square.label.charAt(1)=='4' || square.label.charAt(1)=='5')){
                Square getSquaresBottomLeft = getSquareRight(board, below);
                if(getSquaresBottomLeft!=null){
                    list.add(getSquaresBottomLeft);
                    if(getSquaresBottomLeft.isEmpty())
                        list.addAll(getSquaresTopRightDiagonal(board, getSquaresBottomLeft));
                }
                return list;
            }
            Square getSquaresBottomLeft = getSquareLeft(board, below);
            if(getSquaresBottomLeft!= null){
                list.add(getSquaresBottomLeft);
                if(getSquaresBottomLeft.isEmpty())
                    list.addAll(getSquaresBottomLeftDiagonal(board, getSquaresBottomLeft));
            }
        }
        return list;
    }

    @Override
    ArrayList<Square> getSquaresTopRightDiagonal(Board board, Square square){
        ArrayList<Square> list = new ArrayList<>();
        if(square.label.equals("e9")){
            if(square.isEmpty() || square.piece.isSelected()){
                list.add(board.getSquareAt("d4"));
                if(board.getSquareAt("d4").isEmpty())
                    list.addAll(getSquaresTopRightDiagonal(board, board.getSquareAt("d4")));
                list.add(board.getSquareAt("i5"));
                if(board.getSquareAt("i5").isEmpty())
                    list.addAll(getSquaresTopRightDiagonal(board, board.getSquareAt("i5")));
            }
            return list; 
        }
        Square above = getSquareAbove(board, square);
        if(above!=null) {
            Square getSquaresTopRight = getSquareRight(board, above);
            if(getSquaresTopRight!= null){
                list.add(getSquaresTopRight);
                if(getSquaresTopRight.isEmpty())
                    list.addAll(getSquaresTopRightDiagonal(board, getSquaresTopRight));
            }
        }
        return list;
    }

    @Override
    ArrayList<Square> getSquaresBottomRightDiagonal(Board board, Square square){
        ArrayList<Square> list = new ArrayList<>();
        if(square.label.equals("e4")){
            list.add(board.getSquareAt("i9"));
            if(board.getSquareAt("i9").isEmpty())
                list.addAll(getSquaresBottomRightDiagonal(board, board.getSquareAt("i9")));
            list.add(board.getSquareAt("d5"));
            if(board.getSquareAt("d5").isEmpty())
                list.addAll(getSquaresTopLeftDiagonal(board, board.getSquareAt("d5")));
            return list;
        }
        if(square.label.equals("d5")){
            list.add(board.getSquareAt("i9"));
            if(board.getSquareAt("i9").isEmpty())
                list.addAll(getSquaresBottomRightDiagonal(board, board.getSquareAt("i9")));
            list.add(board.getSquareAt("e4"));
            if(board.getSquareAt("e4").isEmpty())
                list.addAll(getSquaresTopLeftDiagonal(board, board.getSquareAt("e4")));
            return list;
        }
        Square below = getSquareBelow(board, square);
        if(below!=null) {
            if(square.label.charAt(0)<='d' && (square.label.charAt(1)=='4' || square.label.charAt(1)=='5')){
                Square getSquaresBottomRight = getSquareLeft(board, below);
                if(getSquaresBottomRight!=null) {
                    list.add(getSquaresBottomRight);
                    if(getSquaresBottomRight.isEmpty())
                        list.addAll(getSquaresTopLeftDiagonal(board, getSquaresBottomRight));
                }
                return list;
            }
            Square getSquaresBottomRight = getSquareRight(board, below);
            if(getSquaresBottomRight!= null){
                list.add(getSquaresBottomRight);
                if(getSquaresBottomRight.isEmpty())
                    list.addAll(getSquaresBottomRightDiagonal(board, getSquaresBottomRight));
            }
        }
        return list;
    }


}
