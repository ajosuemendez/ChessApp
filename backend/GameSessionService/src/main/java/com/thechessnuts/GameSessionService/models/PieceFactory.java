package com.thechessnuts.gamesessionservice.models;

class PieceFactory {
    Player player;
    PieceBehaviour pieceBehaviour;

    PieceFactory(Player player, PieceBehaviour pieceBehaviour){
        this.player = player;
        this.pieceBehaviour = pieceBehaviour;
    }

    Piece createPiece(Board board, String squareLabel) {
        Piece piece = new Piece(player, this.pieceBehaviour);
        board.getSquareAt(squareLabel).setPiece(piece);

        return piece;
    }
    
}
