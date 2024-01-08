package com.thechessnuts.InputHandlerService.models;

public class QueenFactory extends PieceFactory {

    public QueenFactory(Chess3Board board, Player player) {
        super(board, player);
    }

    @Override
    Piece createPiece(String squareLabel) {
        Piece queen = new Queen(board, player);
        queen.setSquare(this.board.getSquareAt(squareLabel));
        this.board.getSquareAt(squareLabel).setPiece(queen);

        return queen;
    }
    
}
