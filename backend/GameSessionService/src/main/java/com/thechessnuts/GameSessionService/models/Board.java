package com.thechessnuts.gamesessionservice.models;

import java.util.ArrayList;

public abstract class Board{
    static String[][][] gridReferences;
    static BoardNavigation navigation;

    Board(BoardNavigation navigationSetter){
        navigation = navigationSetter;
    }

    Square selectedSquare = null;

    abstract Square getSquareAt(String label);

    abstract ArrayList<Square> getMoves();

    abstract BoardNavigation getNavigation();
}
