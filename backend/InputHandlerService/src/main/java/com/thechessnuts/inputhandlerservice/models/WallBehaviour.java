package com.thechessnuts.inputhandlerservice.models;

import java.util.ArrayList;

class WallBehaviour extends PieceBehaviour {
    
    WallBehaviour(){
        this.symbol = "W";
        this.name = "wall";
    }

    @Override
    ArrayList<Square> getMoves(AbstractChessBoard board, Piece piece) {
        return new ArrayList<Square>();
    }
    
}
