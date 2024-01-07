package com.thechessnuts.InputHandlerService.models;

import java.util.ArrayList;

public class King extends Piece
{

    boolean crossedBorder;
    public static short value = 1;

    public King(Chess3Board board, Player player)
    {

        super(board, player);
        this.started = false; // Check if king has made first move
        this.crossedBorder = false;
        this.board = board;
        this.player = player;//this.setImages("Pawn-W.png", "Pawn-B.png");
        this.symbol = "K";
        this.name += "king";
    }

    /**
     * Annotation to superclass Piece changing pawns location
     * @return  ArrayList with new position of piece
     */

    @Override
    public ArrayList<Square> allMoves()
    {

        ArrayList<Square> list = new ArrayList<>();
        list.addAll(this.board.behaviours.kingBehaviour(this));

        return list;
    }
    void promote(Piece newPiece)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
