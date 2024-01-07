package com.thechessnuts.InputHandlerService.models;

import java.util.ArrayList;

/**
 * Class to represent a chess piece "Knight"
 * A Knight can, on a normal Chessboard, move as below:
 *      
|_|_|_|_|_|_|_|_|7
|_|_|_|_|_|_|_|_|6
|_|_|X|_|X|_|_|_|5
|_|X|_|_|_|X|_|_|4
|_|_|_|N|_|_|_|_|3
|_|X|_|_|_|X|_|_|2
|_|_|X|_|X|_|_|_|1
|_|_|_|_|_|_|_|_|0
 0 1 2 3 4 5 6 7

For details on how it moves in this game, see documentation
""
 */

public class Knight extends Piece
{

    public static short value = 3;

    public Knight(Chess3Board board, Player player)
    {
        super(board, player);
        this.board = board;
        this.player = player;
        this.symbol = "N";
        this.name += "knight";
    }


    @Override
    public ArrayList<Square> allMoves() {
        return this.board.behaviours.knightBehaviour(this);
    }
}

