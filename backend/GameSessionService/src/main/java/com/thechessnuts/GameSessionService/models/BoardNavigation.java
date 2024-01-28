package com.thechessnuts.gamesessionservice.models;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class BoardNavigation {

    abstract Square getSquareAbove(Board board, Square square);
 
    abstract Square getSquareBelow(Board board, Square square);
 
    abstract Square getSquareLeft(Board board, Square square);
 
    abstract Square getSquareRight(Board board, Square square);


    abstract ArrayList<Square> getSquaresAbove(Board board, Square square);
 
    abstract ArrayList<Square> getSquaresBelow(Board board, Square square);
 
    abstract ArrayList<Square> getSquaresLeft(Board board, Square square);
 
    abstract ArrayList<Square> getSquaresRight(Board board, Square square);

    
    abstract HashMap<String, Square> getSquaresAdjacent(Board board, Square square);

    
    abstract ArrayList<Square> getSquaresTopLeftDiagonal(Board board, Square square);
    
    abstract ArrayList<Square> getSquaresBottomLeftDiagonal(Board board, Square square);
    
    abstract ArrayList<Square> getSquaresTopRightDiagonal(Board board, Square square);    

    abstract ArrayList<Square> getSquaresBottomRightDiagonal(Board board, Square square);
}
