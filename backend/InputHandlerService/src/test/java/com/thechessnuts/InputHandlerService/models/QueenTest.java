package com.thechessnuts.InputHandlerService.models;

import com.thechessnuts.InputHandlerService.models.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class QueenTest {
    Chess3Board board=new Chess3Board();
    Player player;
    Player opponent;
    Queen queen;
    ArrayList<Square> TestList;
    @BeforeEach
    void setup(){
        this.board =new Chess3Board();
        this.player =new Player("ahad","WHITE");
        this.opponent =new Player("othman","BLACK");
        this.queen=new Queen(board,player);
        this.TestList =new ArrayList<>();
    }
    @Test
    void allSidesOpenTest() {
        Rook rook =new Rook(board,player);
        Bishop bishop=new Bishop(board,player);
        board.sections[2].squares[0][0].setPiece(rook);
        TestList.addAll(rook.allMoves());
        board.sections[2].squares[0][0].setPiece(bishop);
        TestList.addAll(bishop.allMoves());

        board.sections[2].squares[0][0].setPiece(queen);

        assertEquals(TestList,queen.allMoves());
    }

    @Test
    void SidesBlockedTest(){
        Pawn pawn= new Pawn(board,player);

        board.sections[2].squares[3][3].setPiece(queen);
        board.sections[2].squares[3][2].setPiece(pawn);
        board.sections[2].squares[2][2].setPiece(pawn);
        board.sections[2].squares[2][3].setPiece(pawn);

        assertEquals(TestList,queen.allMoves());
    }

    @Test
    void SaveTheKingDoNotMove(){
        Bishop bishop=new Bishop(board,opponent);
        King king =new King(board,player);

        board.sections[2].squares[3][3].setPiece(king);
        board.sections[2].squares[2][2].setPiece(queen);
        board.sections[2].squares[1][1].setPiece(bishop);

        assertEquals(TestList,queen.allMoves());

    }

    @Test
    void SaveTheKingMove(){
        Bishop bishop=new Bishop(board,opponent);
        King king =new King(board,player);

        board.sections[2].squares[3][3].setPiece(king);
        board.sections[2].squares[3][2].setPiece(queen);
        board.sections[2].squares[1][1].setPiece(bishop);

        TestList.add(board.sections[2].squares[2][2]);

        assertEquals(TestList,queen.allMoves());


    }

}