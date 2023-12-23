package com.thechessnuts.InputHandlerService.models;

import java.util.ArrayList;


/**
 * Class to represent a chess piece "Bishop"
 * A Bishop can, on a normal Chessboard, move as shown below:
 
|_|_|_|_|_|_|_|X|7
|X|_|_|_|_|_|X|_|6
|_|X|_|_| |X|_|_|5
|_|_|X|_|X|_|_|_|4
|_|_|_|B|_|_|_|_|3
|_| |X|_|X|_|_|_|2
|_|X|_|_|_|X|_|_|1
|X|_|_|_|_|_|X|_|0
 0 1 2 3 4 5 6 7

For details on how it moves in this game, see documentation
""
 */
public class Bishop extends Piece
{

    public static short value = 3;

    Bishop(Chess3Board board, Player player)
    {
        super(board, player);
        this.board = board;
        this.player = player;
        this.symbol = "B";
        this.name += "bishop";
    }

    @Override
    public ArrayList<Square> allMoves()
    {
       return this.board.behaviours.bishopBehaviour(this);
    }
}
