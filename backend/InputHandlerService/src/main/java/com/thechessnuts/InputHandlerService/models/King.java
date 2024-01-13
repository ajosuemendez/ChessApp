package com.thechessnuts.InputHandlerService.models;
public class King extends Piece
{

    boolean crossedBorder;
    public static short value = 1;

    public King(AbstractChessBoard board, Player player)
    {

        super(board, player, new KingBehaviour());
        this.started = false; // Check if king has made first move
        this.crossedBorder = false;
        this.board = board;
        this.player = player;//this.setImages("Pawn-W.png", "Pawn-B.png");
        this.symbol = "K";
        this.name += "king";
    }
    void promote(Piece newPiece)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
