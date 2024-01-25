package com.thechessnuts.InputHandlerService.models;

import java.util.ArrayList;

public class QueenBehaviour extends PieceBehaviour {

    QueenBehaviour(){
        this.symbol = "Q";
        this.name = "queen";
    }

    static  BishopBehaviour queenBishopBehaviour = new BishopBehaviour();
    static RookBehaviour queenRookBehaviour = new RookBehaviour();

    @Override
    public ArrayList<Square> getMoves(AbstractChessBoard board, Piece piece){

        ArrayList<Square> list = new ArrayList<>();

        list.addAll(queenBishopBehaviour.getMoves(board, piece));
        list.addAll(queenRookBehaviour.getMoves(board, piece));

        return list;
    }
    
}
