package com.thechessnuts.InputHandlerService.models;

import java.util.ArrayList;

public class WallBehaviour extends PieceBehaviour {
    
    WallBehaviour(){
        this.symbol = "W";
        this.name = "wall";
    }

    @Override
    public ArrayList<Square> getMoves(AbstractChessBoard board, Piece piece) {
        return new ArrayList<Square>();
    }
    
}
