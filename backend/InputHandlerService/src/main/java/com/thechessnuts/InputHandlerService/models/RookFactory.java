package com.thechessnuts.InputHandlerService.models;

public class RookFactory extends PieceFactory {

    public RookFactory(AbstractChessBoard board, Player player) {
        super(board, player);
    }

    @Override
    Piece createPiece(String squareLabel) {
        Piece rook = new Rook(board, player);
        rook.setSquare(this.board.getSquareAt(squareLabel));
        this.board.getSquareAt(squareLabel).setPiece(rook);

        return rook;
    }
    
}
