package com.thechessnuts.InputHandlerService.models;

public class Wall extends Piece {

    Wall(AbstractChessBoard board, Player player) {
        super(board, player, new WallBehaviour());
        this.board = board;
        this.player = player;
        this.symbol = "W";
        this.name += "wall";
    }
    
}
