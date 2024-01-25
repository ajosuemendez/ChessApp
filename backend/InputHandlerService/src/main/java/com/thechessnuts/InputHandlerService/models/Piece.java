package com.thechessnuts.InputHandlerService.models;

import java.util.ArrayList;

/**
Class to represent a piece (any kind) - this class should be extended to represent pawn, bishop etc.
 */
public class Piece
{
    boolean check;
    PieceBehaviour pieceBehaviour;
    Player player;
    AbstractChessBoard board;
    Square square;
    boolean started;
    String name;
    String symbol;
    boolean selected;
    boolean crossedBorder;

    Piece(AbstractChessBoard board, Player player, PieceBehaviour pieceBehaviour)
    {
        this.check = false;
        this.pieceBehaviour = pieceBehaviour;
        this.board = board;
        this.player = player;
        this.selected = false;
        this.started = false; // Check if piece has made first move
        this.crossedBorder = false;
        this.name = player.color.toString().toLowerCase()+'-'+pieceBehaviour.getName(); 
        this.symbol = pieceBehaviour.getSymbol();
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

    public Square getSquare(){ return this.square;}

    public Player.colors getColor(){ return this.player.color;}

    public boolean isSelected(){return this.selected;}

    public void deselct(){this.selected = false;}

    public void select(){this.selected = true;}

    public void setChecked(boolean check){
        this.check = check;
    }
}
