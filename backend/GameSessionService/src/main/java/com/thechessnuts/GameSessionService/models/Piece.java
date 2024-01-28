package com.thechessnuts.gamesessionservice.models;

import java.util.ArrayList;

/**
Class to represent a piece (any kind) - this class should be extended to represent pawn, bishop etc. using the behaviour class
 */
class Piece
{
    boolean check;
    PieceBehaviour pieceBehaviour;
    boolean crossedBorder;
    Player player;
    Square square;
    boolean started;
    String name;
    String symbol;
    boolean selected;

    Piece(Board board, Player player, PieceBehaviour pieceBehaviour)
    {
        this.check = false;
        this.crossedBorder = false;
        this.pieceBehaviour = pieceBehaviour;
        this.player = player;
        this.selected = false;
        this.started = false; // Check if piece hhas made first move
        this.name = player.color.toString().toLowerCase()+'-'+pieceBehaviour.getName(); 
        this.symbol = pieceBehaviour.getSymbol();
    }

    ArrayList<Square> allMoves(Board board, Square square){

        ArrayList<Square> list = this.pieceBehaviour.getMoves(board, square);

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
  
    String getSymbol(){ return this.symbol;}

    void setSquare(Square square){this.square = square;}

    Square getSquare(){ return this.square;}

    Player.colors getColor(){ return this.player.color;}

    boolean isSelected(){return this.selected;}

    void deselct(){this.selected = false;}

    void select(){this.selected = true;}

    void setChecked(boolean check){
        this.check = check;
    }
}
