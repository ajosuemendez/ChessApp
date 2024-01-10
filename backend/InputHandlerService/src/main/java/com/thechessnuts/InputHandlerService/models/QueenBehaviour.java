package com.thechessnuts.InputHandlerService.models;

import java.util.ArrayList;

public class QueenBehaviour implements PieceBehaviour {

    static  BishopBehaviour queenBishopBehaviour = new BishopBehaviour();
    static RookBehaviour queenRookBehaviour = new RookBehaviour();

    @Override
    public ArrayList<Square> getMoves(Chess3Board board, Piece piece){

        ArrayList<Square> list = new ArrayList<>();

        list.addAll(queenBishopBehaviour.getMoves(board, piece));
        list.addAll(queenRookBehaviour.getMoves(board, piece));

        return list;
    }
    
}
