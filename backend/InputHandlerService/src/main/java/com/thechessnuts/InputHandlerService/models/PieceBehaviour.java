package com.thechessnuts.InputHandlerService.models;
/*
 * For a list of all behaviours, see documentation
 */
import java.util.ArrayList;

abstract class PieceBehaviour {
    abstract ArrayList<Square> getMoves(AbstractChessBoard board, Piece piece);

    boolean started = false; 
    boolean crossedBorder = false;
    String symbol;
    String name;

    String getName(){
        return this.name;
    }

    String getSymbol(){
        return this.symbol;
    }
}
