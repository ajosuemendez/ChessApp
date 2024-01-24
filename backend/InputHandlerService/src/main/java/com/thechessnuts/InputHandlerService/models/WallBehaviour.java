package com.thechessnuts.InputHandlerService.models;

import java.util.ArrayList;

public class WallBehaviour implements PieceBehaviour {

    @Override
    public ArrayList<Square> getMoves(AbstractChessBoard board, Piece piece) {
        return new ArrayList<Square>();
    }
    
}
