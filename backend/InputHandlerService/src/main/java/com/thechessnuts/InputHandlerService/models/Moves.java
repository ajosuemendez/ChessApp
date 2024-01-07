package com.thechessnuts.InputHandlerService.models;

import java.util.ArrayList;

public class Moves{
    private ArrayList<String> moves = new ArrayList<>();

    private Game game;
    //protected Stack<Move> moveBackStack = new Stack<>();
    //protected Stack<Move> moveForwardStack = new Stack<>();

    public Moves(Game game){
        this.game = game;
    }

    public void add(Move move){
        moves.add(move.toString());
    }

    public Move moveFromString(String moveString){
        Move move = new Move();
        move.to = new Square(moveString.substring(moveString.indexOf('-')+1));
        move.from =  new Square(moveString.substring(moveString.indexOf('-')-2, moveString.indexOf('-')));
        if(Character.isUpperCase(moveString.charAt(0))){

        }
        else {
            move.movedPiece = new Pawn(this.game.board, new Player());
        }
        return move;
    }








}
