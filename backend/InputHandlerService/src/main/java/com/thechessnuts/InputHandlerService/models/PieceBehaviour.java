package com.thechessnuts.InputHandlerService.models;
/*
 * For a list of all behaviours, see documentation
 */
import java.util.ArrayList;

interface PieceBehaviour {
    abstract ArrayList<Square> getMoves(Chess3Board board, Piece piece);
}
