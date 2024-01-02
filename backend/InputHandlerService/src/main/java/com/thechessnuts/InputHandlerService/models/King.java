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

        Square squareAbove = board.squareAbove(this.square);
        if(squareAbove != null){
            list.add(squareAbove);
        }
        Square squareBelow = board.squareBelow(this.square);
        if (squareBelow != null) {
                list.add(squareBelow);
        }
         Square squareLeft = board.squareLeft(this.square);
        if (squareBelow != null) {
                list.add(squareLeft);
        }
         Square squareRight = board.squareRight(this.square);
        if (squareBelow != null) {
                list.add(squareRight);
        }

        Square squareTopLeft = board.squareLeft(squareAbove);
        if(squareTopLeft != null){
            list.add(squareTopLeft);
        }
        Square squareTopRight = board.squareRight(squareAbove);
        if (squareTopRight != null) {
                list.add(squareTopRight);
        }
        Square squareBottomLeft = board.squareLeft(squareBelow);
        if(squareBottomLeft != null){
            list.add(squareBottomLeft);
        }
        Square squareBottomRight = board.squareRight(squareBelow);
        if (squareBottomRight != null) {
                list.add(squareBottomRight);
        }


        for(int i = 0; i<list.size(); i++){
            if(list.get(i).piece!=null){
                if(list.get(i).piece.player.color == this.player.color){
                    list.remove(i);
                    i--;
                }
            }
        }

        return list;
    }
    void promote(Piece newPiece)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
