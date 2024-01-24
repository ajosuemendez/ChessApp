package com.thechessnuts.InputHandlerService.models;

public class KingFactory extends PieceFactory {

    public KingFactory(AbstractChessBoard board, Player player) {
        super(board, player);
    }

    @Override
    Piece createPiece(String squareLabel) {
        King king = new King(board, player);
        king.setSquare(this.board.getSquareAt(squareLabel));
        this.board.getSquareAt(squareLabel).setPiece(king);
        player.setKing(king);

        return king;
    }
    
}
