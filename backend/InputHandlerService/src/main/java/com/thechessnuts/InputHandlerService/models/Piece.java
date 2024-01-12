package com.thechessnuts.InputHandlerService.models;

import java.util.ArrayList;

/**
Class to represent a piece (any kind) - this class should be extended to represent pawn, bishop etc.
 */
public abstract class Piece
{
    PieceBehaviour pieceBehaviour;
    Player player;
    AbstractChessBoard board;
    public Square square;
    public boolean started;
    String name;
    protected String symbol;
    boolean selected;
    boolean crossedBorder;

    Piece(AbstractChessBoard board, Player player, PieceBehaviour pieceBehaviour)
    {
        this.pieceBehaviour = pieceBehaviour;
        this.board = board;
        this.player = player;
        this.selected = false;
        this.name = player.color.toString().toLowerCase()+'-'; 
    }

    public ArrayList<Square> allMoves(){

        ArrayList<Square> list = this.pieceBehaviour.getMoves(this.board, this);

        for(int i = 0; i<list.size(); i++){
            if(list.get(i).piece!=null){
                if(list.get(i).piece.player.color == this.player.color){
                    list.remove(i);
                    i--;
                }
            }
        }

        return list;
    }
  
    public String getSymbol(){ return this.symbol;}

    public void setSquare(Square square){this.square = square;}

    public Square getSquare(Square square){ return this.square;}

    public boolean isSelected(){return this.selected;}

    public void deselct(){this.selected = false;}

    public void select(){this.selected = true;}
}
