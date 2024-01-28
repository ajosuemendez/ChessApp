package com.thechessnuts.gamesessionservice.models;

class PieceFactory {
    Board board;
    Player player;
    PieceBehaviour pieceBehaviour;

    PieceFactory(Board board, Player player, PieceBehaviour pieceBehaviour){
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
