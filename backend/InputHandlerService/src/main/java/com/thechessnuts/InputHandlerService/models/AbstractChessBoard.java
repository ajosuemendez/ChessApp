package com.thechessnuts.InputHandlerService.models;

public abstract class AbstractChessBoard {
    Piece selectedPiece = null;
    AbstractNavigation navigation;

    abstract Square getSquareAt(String label);
}
