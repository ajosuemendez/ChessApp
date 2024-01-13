package com.thechessnuts.InputHandlerService.models;
/**
 * Class to represent a chess piece "Rook"
 * Rook can, on a normal Chessboard, move as below:
 *      
|_|_|_|X|_|_|_|_|7
|_|_|_|X|_|_|_|_|6
|_|_|_|X|_|_|_|_|5
|_|_|_|X|_|_|_|_|4
|X|X|X|R|X|X|X|X|3
|_|_|_|X|_|_|_|_|2
|_|_|_|X|_|_|_|_|1
|_|_|_|X|_|_|_|_|0
 0 1 2 3 4 5 6 7

For details on how it moves in this game, see documentation
""
 */

public class Rook extends Piece
{

    public static short value = 5;

    public Rook(AbstractChessBoard board, Player player)
    {
        super(board, player, new RookBehaviour());
        this.board = board;
        this.player = player;
        this.symbol = "R";
        this.name += "rook";
    }
}
