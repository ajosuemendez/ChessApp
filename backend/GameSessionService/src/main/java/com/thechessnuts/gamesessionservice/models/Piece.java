package com.thechessnuts.gamesessionservice.models;

import java.util.ArrayList;

/**
Class to represent a piece (any kind) - this class should be extended to represent pawn, bishop etc. using the behaviour class
 */
class Piece
{
    boolean check;
    int moveCounter;
    PieceBehaviour pieceBehaviour;
    boolean crossedBorder;
    Player player;
    boolean started;
    String name;
    String symbol;

    Piece(Player player, PieceBehaviour pieceBehaviour)
    {
        this.check = false;
        this.moveCounter = 0;
        this.crossedBorder = false;
        this.pieceBehaviour = pieceBehaviour;
        this.player = player;
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

    Player.colors getColor(){ return this.player.color;}

    void setChecked(boolean check){
        this.check = check;
    }
}
