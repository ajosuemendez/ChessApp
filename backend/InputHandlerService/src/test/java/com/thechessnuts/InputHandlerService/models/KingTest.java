package com.thechessnuts.InputHandlerService.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class KingTest {
    Chess3Board board;
    Player player;
    Player opponent;
    ArrayList<Square> TestList;
    King king;

    @BeforeEach
    void setUp() {
        this.board=new Chess3Board();
        this.player=new Player("ahad","WHITE");
        this.opponent=new Player("alajandro","BLACK");
        this.TestList=new ArrayList<>();
        this.king=new King(board,player);

    }

    @Test
    void allSidesOpenTest() {
    board.sections[2].squares[1][2].setPiece(king);

        //SquareAbove
        TestList.add(board.sections[2].squares[1][1]);
        //SquareBelow
        TestList.add(board.sections[2].squares[1][3]);
        //SquareLeft
        TestList.add(board.sections[2].squares[2][2]);
        //SquareRight
        TestList.add(board.sections[2].squares[0][2]);
        //TopLeft
        TestList.add(board.sections[2].squares[2][1]);
        //TopRight
        TestList.add(board.sections[2].squares[0][1]);
        //bottomLeft
        TestList.add(board.sections[2].squares[2][3]);
        //bottomRight
        TestList.add(board.sections[2].squares[0][3]);

        assertEquals(TestList,king.allMoves());
    }

    @Test
    void AllSidesBlockedTest(){
        Rook rook =new Rook(board,opponent);
        Pawn pawn =new Pawn(board,player);

        board.sections[2].squares[3][3].setPiece(king);
        board.sections[2].squares[2][0].setPiece(rook);
        board.sections[2].squares[3][2].setPiece(pawn);

        assertEquals(TestList,king.allMoves());
    }
    @Test
    void captureTest(){
        Rook rook=new Rook(board,opponent);
        Pawn pawn=new Pawn(board,player);

        board.sections[2].squares[3][3].setPiece(king);
        board.sections[2].squares[2][3].setPiece(rook);
        board.sections[2].squares[3][2].setPiece(pawn);

        TestList.add(board.sections[2].squares[2][3]);

        assertEquals(TestList,king.allMoves());
    }
}