package com.thechessnuts.InputHandlerService.models;

public class PawnFactory extends PieceFactory {

    public PawnFactory(Chess3Board board, Player player) {
        super(board, player);
    }

    @Override
    Piece createPiece(String squareLabel) {
        Piece pawn = new Pawn(board, player);
        pawn.setSquare(this.board.getSquareAt(squareLabel));
        this.board.getSquareAt(squareLabel).setPiece(pawn);

        return pawn;
    }
    
}
