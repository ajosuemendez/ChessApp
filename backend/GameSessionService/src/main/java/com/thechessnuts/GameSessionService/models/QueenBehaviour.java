package com.thechessnuts.gamesessionservice.models;

import java.util.ArrayList;

class QueenBehaviour extends PieceBehaviour {

    QueenBehaviour(){
        this.symbol = "Q";
        this.name = "queen";
    }

    static  BishopBehaviour queenBishopBehaviour = new BishopBehaviour();
    static RookBehaviour queenRookBehaviour = new RookBehaviour();

    @Override
    ArrayList<Square> getMoves(Board board, BoardNavigation navigation, Piece piece){

        ArrayList<Square> list = new ArrayList<>();

        list.addAll(queenBishopBehaviour.getMoves(board, navigation, piece));
        list.addAll(queenRookBehaviour.getMoves(board, navigation, piece));

        return list;
    }
    
}
