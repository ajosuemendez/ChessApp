package com.thechessnuts.gamesessionservice.models;

import java.util.ArrayList;

class SkullBehaviour extends PieceBehaviour {
    
    SkullBehaviour(){
        this.symbol = "S";
        this.name = "skull";
    }

    @Override
    ArrayList<Square> getMoves(Board board, Square square) {
        return new ArrayList<Square>();
    }
}
