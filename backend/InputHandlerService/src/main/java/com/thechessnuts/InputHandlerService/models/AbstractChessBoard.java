package com.thechessnuts.InputHandlerService.models;

public abstract class AbstractChessBoard {
    static String[][][] gridReferences;

    Piece selectedPiece = null;
    AbstractChessNavigation navigation;

    abstract Square getSquareAt(String label);

}
