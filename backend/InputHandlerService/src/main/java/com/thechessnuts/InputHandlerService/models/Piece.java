
/*
 * Authors:
 * Othman and Janakan
 */

package com.thechessnuts.InputHandlerService.models;

import java.util.ArrayList;

/**
Class to represent a piece (any kind) - this class should be extended to represent pawn, bishop etc.
 */
public abstract class Piece
{
    PieceBehaviour pieceBehaviour;
    Player player;
    Chess3Board board;
    public Square square;
    public boolean started;
    String name;
    protected String symbol;
    boolean isSelected;
    boolean crossedBorder;

    Piece(Chess3Board board, Player player, PieceBehaviour pieceBehaviour)
    {
        this.pieceBehaviour = pieceBehaviour;
        this.board = board;
        this.player = player;
        this.isSelected = false;
        this.name = player.color.toString().toLowerCase()+'-'; 
    }

    public ArrayList<Square> allMoves(){
        return this.pieceBehaviour.getMoves(this.board, this);
    }
  
    public String getSymbol()
    {
        return this.symbol;
    }

    public void setSquare(Square square){
        this.square = square;
    }
}
