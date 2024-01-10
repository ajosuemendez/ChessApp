package com.thechessnuts.InputHandlerService.models;

public abstract class PieceFactory {
    Chess3Board board;
    Player player;

    public PieceFactory(Chess3Board board, Player player){
        this.board = board;
        this.player = player;
    }


    abstract Piece createPiece(String squareLabel);
    
}
