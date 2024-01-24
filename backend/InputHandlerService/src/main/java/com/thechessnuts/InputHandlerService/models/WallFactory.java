package com.thechessnuts.InputHandlerService.models;

public class WallFactory extends PieceFactory {

    public WallFactory(AbstractChessBoard board, Player player) {
        super(board, player);
    }

    @Override
    Piece createPiece(String squareLabel) {
        Piece wall = new Wall(board, player);
        wall.setSquare(this.board.getSquareAt(squareLabel));
        this.board.getSquareAt(squareLabel).setPiece(wall);

        return wall;
    }
    
}
