package com.thechessnuts.InputHandlerService.models;

public class KingFactory extends PieceFactory {

    public KingFactory(AbstractChessBoard board, Player player) {
        super(board, player);
    }

    @Override
    Piece createPiece(String squareLabel) {
        Piece king = new King(board, player);
        king.setSquare(this.board.getSquareAt(squareLabel));
        this.board.getSquareAt(squareLabel).setPiece(king);

        return king;
    }
    
}
