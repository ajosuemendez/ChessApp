package com.thechessnuts.InputHandlerService.models;

import java.util.ArrayList;
import java.util.HashMap;

public class Chess3Navigation extends AbstractChessNavigation{

    Chess3Navigation(Chess3Board board){
        super(board);
    }
    
    @Override
    public Square getSquareAbove(Square square){
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
    public Square getSquareBelow(Square square){
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
    public Square getSquareLeft(Square square){
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
    public Square getSquareRight(Square square){

    
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
    public ArrayList<Square> getSquaresAbove(Square square) {

        ArrayList<Square> list = new ArrayList<>();

        Square checkingSquare = board.navigation.getSquareAbove(square);

        while(checkingSquare!=null){
            list.add(checkingSquare);
            if (checkingSquare.isEmpty()){
                checkingSquare = board.navigation.getSquareAbove(checkingSquare);
            }
            else{
                break;
            }
        }

        return list;
    }

    @Override
    public ArrayList<Square> getSquaresBelow(Square square) {

        ArrayList<Square> list = new ArrayList<>();
        boolean borderWasCrossed = false;
        
        Square checkingSquare = board.navigation.getSquareBelow(square);

        while(checkingSquare!=null){
            list.add(checkingSquare);
            if (checkingSquare.isEmpty()){
                if(borderWasCrossed){
                    checkingSquare = board.navigation.getSquareAbove(checkingSquare);
                }
                else {
                    if (checkingSquare.label.charAt(0) <= 'd' && (checkingSquare.label.charAt(1) == '4' || checkingSquare.label.charAt(1) == '5')) {
                        borderWasCrossed = true;
                        checkingSquare = board.navigation.getSquareBelow(checkingSquare);
                        continue;
                    }
                    checkingSquare = board.navigation.getSquareBelow(checkingSquare);
                }
            }
            else{
                break;
            }
        }
        return list;
    }

    @Override
    public ArrayList<Square> getSquaresLeft(Square square) {

        ArrayList<Square> list = new ArrayList<>();

        Square checkingSquare = board.navigation.getSquareLeft(square);

        while(checkingSquare!=null){
            list.add(checkingSquare);
            if (checkingSquare.isEmpty()){
                checkingSquare = board.navigation.getSquareLeft(checkingSquare);
            }
            else{
                break;
            }
        }
        return list;

    }

    @Override
    public ArrayList<Square> getSquaresRight(Square square) {

        ArrayList<Square> list = new ArrayList<>();

        Square checkingSquare = board.navigation.getSquareRight(square);

        while(checkingSquare!=null){
            list.add(checkingSquare);
            if (checkingSquare.isEmpty()){
                checkingSquare = board.navigation.getSquareRight(checkingSquare);
            }
            else{
                break;
            }
        }

        return list;
    }

    @Override
    public HashMap<String, Square> getSquaresAdjacent(Square square){
        HashMap<String, Square> dictionary = new HashMap<>();

        Square up = board.navigation.getSquareAbove(square);
        Square down = board.navigation.getSquareBelow(square);

        dictionary.put("up", up);
        dictionary.put("left", board.navigation.getSquareLeft(square));
        dictionary.put("down", down);
        dictionary.put("right", board.navigation.getSquareRight(square));
        
        if(up == null){
            dictionary.put("topLeft", null);
            dictionary.put("topRight", null);
        }
        else{
            dictionary.put("topLeft", board.navigation.getSquareLeft(up));
            dictionary.put("topRight", board.navigation.getSquareRight(up));
        }

        if(down == null){
            dictionary.put("bottomLeft", null);
            dictionary.put("bottomRight", null);
        }
        else{
            if(down.isAtBorder()){
                dictionary.put("bottomLeft", board.navigation.getSquareLeft(down));
                dictionary.put("bottomRight", board.navigation.getSquareRight(down));
            }
            else{
                dictionary.put("bottomLeft", board.navigation.getSquareLeft(down));
                dictionary.put("bottomRight", board.navigation.getSquareRight(down));
            }
        }

        return dictionary;
    }

    @Override
    public ArrayList<Square> getSquaresTopLeftDiagonal(Square square){
        ArrayList<Square> list = new ArrayList<>();
        if(square.label.equals("i9")){
            if(square.isEmpty() || square.piece.isSelected()) {
                list.add(board.getSquareAt("e4"));
                if(board.getSquareAt("e4").isEmpty())
                    list.addAll(getSquaresTopLeftDiagonal(board.getSquareAt("e4")));
                list.add(board.getSquareAt("d5"));
                if(board.getSquareAt("d5").isEmpty())
                    list.addAll(getSquaresTopLeftDiagonal(board.getSquareAt("d5")));
            }
            return list;
        }
        Square above = getSquareAbove(square);
        if(above!=null) {
            Square getSquaresTopLeft = getSquareLeft(above);
            if(getSquaresTopLeft!= null){
                list.add(getSquaresTopLeft);
                if(getSquaresTopLeft.isEmpty()){
                    list.addAll(getSquaresTopLeftDiagonal(getSquaresTopLeft));
                }
            }
        }
        return list;
    }

    @Override
    public ArrayList<Square> getSquaresBottomLeftDiagonal(Square square){
        ArrayList<Square> list = new ArrayList<>();
        if(square.label.equals("d4")){
            if(square.isEmpty() || square.piece.isSelected()) {
                list.add(board.getSquareAt("e9"));
                if(board.getSquareAt("e9").isEmpty())
                    list.addAll(getSquaresBottomLeftDiagonal(board.getSquareAt("e9")));
                list.add(board.getSquareAt("i5"));
                if(board.getSquareAt("i5").isEmpty())
                    list.addAll(getSquaresTopRightDiagonal(board.getSquareAt("i5")));
            }
            return list;
        }
        if(square.label.equals("i5")){
            if(square.isEmpty() || square.piece.isSelected()) {
                list.add(board.getSquareAt("e9"));
                if(board.getSquareAt("e9").isEmpty())
                    list.addAll(getSquaresBottomLeftDiagonal(board.getSquareAt("e9")));
                list.add(board.getSquareAt("d4"));
                if(board.getSquareAt("d4").isEmpty())
                    list.addAll(getSquaresTopRightDiagonal(board.getSquareAt("d4")));
            }
            return list;
        }
        Square below = getSquareBelow(square);
        if(below!=null) {
            if(square.label.charAt(0)<='d' && (square.label.charAt(1)=='4' || square.label.charAt(1)=='5')){
                Square getSquaresBottomLeft = getSquareRight(below);
                if(getSquaresBottomLeft!=null){
                    list.add(getSquaresBottomLeft);
                    if(getSquaresBottomLeft.isEmpty())
                        list.addAll(getSquaresTopRightDiagonal(getSquaresBottomLeft));
                }
                return list;
            }
            Square getSquaresBottomLeft = getSquareLeft(below);
            if(getSquaresBottomLeft!= null){
                list.add(getSquaresBottomLeft);
                if(getSquaresBottomLeft.isEmpty())
                    list.addAll(getSquaresBottomLeftDiagonal(getSquaresBottomLeft));
            }
        }
        return list;
    }

    @Override
    public ArrayList<Square> getSquaresTopRightDiagonal(Square square){
        ArrayList<Square> list = new ArrayList<>();
        if(square.label.equals("e9")){
            if(square.isEmpty() || square.piece.isSelected()){
                list.add(board.getSquareAt("d4"));
                if(board.getSquareAt("d4").isEmpty())
                    list.addAll(getSquaresTopRightDiagonal(board.getSquareAt("d4")));
                list.add(board.getSquareAt("i5"));
                if(board.getSquareAt("i5").isEmpty())
                    list.addAll(getSquaresTopRightDiagonal(board.getSquareAt("i5")));
            }
            return list; 
        }
        Square above = getSquareAbove(square);
        if(above!=null) {
            Square getSquaresTopRight = getSquareRight(above);
            if(getSquaresTopRight!= null){
                list.add(getSquaresTopRight);
                if(getSquaresTopRight.isEmpty())
                    list.addAll(getSquaresTopRightDiagonal(getSquaresTopRight));
            }
        }
        return list;
    }

    @Override
    public ArrayList<Square> getSquaresBottomRightDiagonal(Square square){
        ArrayList<Square> list = new ArrayList<>();
        if(square.label.equals("e4")){
            list.add(board.getSquareAt("i9"));
            if(board.getSquareAt("i9").isEmpty())
                list.addAll(getSquaresBottomRightDiagonal(board.getSquareAt("i9")));
            list.add(board.getSquareAt("d5"));
            if(board.getSquareAt("d5").isEmpty())
                list.addAll(getSquaresTopLeftDiagonal(board.getSquareAt("d5")));
            return list;
        }
        if(square.label.equals("d5")){
            list.add(board.getSquareAt("i9"));
            if(board.getSquareAt("i9").isEmpty())
                list.addAll(getSquaresBottomRightDiagonal(board.getSquareAt("i9")));
            list.add(board.getSquareAt("e4"));
            if(board.getSquareAt("e4").isEmpty())
                list.addAll(getSquaresTopLeftDiagonal(board.getSquareAt("e4")));
            return list;
        }
        Square below = getSquareBelow(square);
        if(below!=null) {
            if(square.label.charAt(0)<='d' && (square.label.charAt(1)=='4' || square.label.charAt(1)=='5')){
                Square getSquaresBottomRight = getSquareLeft(below);
                if(getSquaresBottomRight!=null) {
                    list.add(getSquaresBottomRight);
                    if(getSquaresBottomRight.isEmpty())
                        list.addAll(getSquaresTopLeftDiagonal(getSquaresBottomRight));
                }
                return list;
            }
            Square getSquaresBottomRight = getSquareRight(below);
            if(getSquaresBottomRight!= null){
                list.add(getSquaresBottomRight);
                if(getSquaresBottomRight.isEmpty())
                    list.addAll(getSquaresBottomRightDiagonal(getSquaresBottomRight));
            }
        }
        return list;
    }


}
