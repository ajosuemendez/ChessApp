package com.thechessnuts.gamesessionservice.models;

public abstract class Board{
    static String[][][] gridReferences;

    Piece selectedPiece = null;
    BoardNavigation navigation;

    abstract Square getSquareAt(String label);

}
