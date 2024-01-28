package com.thechessnuts.gamesessionservice.models;

public abstract class Board{
    static String[][][] gridReferences;
    static BoardNavigation navigation;

    Board(BoardNavigation navigationSetter){
        navigation = navigationSetter;
    }

    Piece selectedPiece = null;

    abstract Square getSquareAt(String label);

}
