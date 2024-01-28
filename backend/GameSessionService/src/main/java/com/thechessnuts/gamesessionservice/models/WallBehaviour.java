package com.thechessnuts.gamesessionservice.models;

import java.util.ArrayList;

class WallBehaviour extends PieceBehaviour {
    
    WallBehaviour(){
        this.symbol = "W";
        this.name = "wall";
    }

    @Override
    ArrayList<Square> getMoves(Board board, Square square) {
        return new ArrayList<Square>();
    }
}
