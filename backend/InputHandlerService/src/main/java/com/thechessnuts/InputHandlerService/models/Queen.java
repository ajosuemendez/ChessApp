package com.thechessnuts.InputHandlerService.models;

import java.util.ArrayList;

public class Queen extends Piece
{
    public static short value = 9;
    public Queen(Chess3Board board, Player player)
    {
        super(board, player);
        this.board = board;
        this.player = player;
        this.symbol = "Q";
        this.name += "queen";
    }
    
    @Override
    public ArrayList<Square> allMoves()
    {
        return this.board.behaviours.queenBehaviour(this);
    }
}
