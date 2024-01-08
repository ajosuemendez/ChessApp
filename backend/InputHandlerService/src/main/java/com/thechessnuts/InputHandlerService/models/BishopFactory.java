package com.thechessnuts.InputHandlerService.models;

public class BishopFactory extends PieceFactory {

    public BishopFactory(Chess3Board board, Player player) {
        super(board, player);
    }

    @Override
    Piece createPiece(String squareLabel) {
        Piece bishop = new Bishop(board, player);
        bishop.setSquare(this.board.getSquareAt(squareLabel));
        this.board.getSquareAt(squareLabel).setPiece(bishop);

        return bishop;
    }
    
}
