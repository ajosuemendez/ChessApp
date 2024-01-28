package com.thechessnuts.gamesessionservice.models;

import java.util.ArrayList;

class WallBehaviour extends PieceBehaviour {
    
    WallBehaviour(){
        this.symbol = "W";
        this.name = "wall";
    }

    @Override
    ArrayList<Square> getMoves(Board board, BoardNavigation navigation, Piece piece) {
        return new ArrayList<Square>();
    }
}
