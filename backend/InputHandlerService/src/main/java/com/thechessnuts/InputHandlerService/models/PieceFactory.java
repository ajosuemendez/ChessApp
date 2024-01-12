package com.thechessnuts.InputHandlerService.models;

public abstract class PieceFactory {
    AbstractChessBoard board;
    Player player;

    public PieceFactory(AbstractChessBoard board, Player player){
        this.board = board;
        this.player = player;
    }


    abstract Piece createPiece(String squareLabel);
    
}
