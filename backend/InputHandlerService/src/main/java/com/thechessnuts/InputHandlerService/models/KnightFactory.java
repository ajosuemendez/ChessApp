package com.thechessnuts.InputHandlerService.models;

public class KnightFactory extends PieceFactory {

    public KnightFactory(Chess3Board board, Player player) {
        super(board, player);
    }

    @Override
    Piece createPiece(String squareLabel) {
        Piece knight = new Knight(board, player);
        knight.setSquare(this.board.getSquareAt(squareLabel));
        this.board.getSquareAt(squareLabel).setPiece(knight);
        

        return knight;
    }
    
}
