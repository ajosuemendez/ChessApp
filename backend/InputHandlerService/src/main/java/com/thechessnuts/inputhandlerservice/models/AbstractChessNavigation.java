package com.thechessnuts.inputhandlerservice.models;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class AbstractChessNavigation {
    AbstractChessBoard board;

    AbstractChessNavigation(AbstractChessBoard board){
        this.board = board;
    }

    abstract Square getSquareAbove(Square square);
 
    abstract Square getSquareBelow(Square square);
 
    abstract Square getSquareLeft(Square square);
 
    abstract Square getSquareRight(Square square);


    abstract ArrayList<Square> getSquaresAbove(Square square);
 
    abstract ArrayList<Square> getSquaresBelow(Square square);
 
    abstract ArrayList<Square> getSquaresLeft(Square square);
 
    abstract ArrayList<Square> getSquaresRight(Square square);

    
    abstract HashMap<String, Square> getSquaresAdjacent(Square square);

    
    abstract ArrayList<Square> getSquaresTopLeftDiagonal(Square square);
    
    abstract ArrayList<Square> getSquaresBottomLeftDiagonal(Square square);
    
    abstract ArrayList<Square> getSquaresTopRightDiagonal(Square square);    

    abstract ArrayList<Square> getSquaresBottomRightDiagonal(Square square);
}
