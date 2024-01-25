package com.thechessnuts.InputHandlerService.models;

public class PieceFactory {
    AbstractChessBoard board;
    Player player;
    PieceBehaviour pieceBehaviour;

    public PieceFactory(AbstractChessBoard board, Player player, PieceBehaviour pieceBehaviour){
        this.board = board;
        this.player = player;
        this.pieceBehaviour = pieceBehaviour;
    }


    Piece createPiece(String squareLabel) {
        Piece piece = new Piece(board, player, this.pieceBehaviour);
        piece.setSquare(this.board.getSquareAt(squareLabel));
        this.board.getSquareAt(squareLabel).setPiece(piece);

        return piece;
    }
    
}
