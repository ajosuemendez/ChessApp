package com.thechessnuts.InputHandlerService.models;

public class Queen extends Piece
{
    public static short value = 9;
    public Queen(Chess3Board board, Player player)
    {
        super(board, player, new QueenBehaviour());
        this.board = board;
        this.player = player;
        this.symbol = "Q";
        this.name += "queen";
    }
}
