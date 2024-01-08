package com.thechessnuts.InputHandlerService.models;

import com.thechessnuts.InputHandlerService.models.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BishopTest {
    Chess3Board board=new Chess3Board();
    Player player;
    Bishop bishop;
    ArrayList<Square> TestList;
    @BeforeEach
    void setUp() {
       this.board=new Chess3Board();
       this.player=new Player("Ahad","WHITE");
       this.bishop=new Bishop(board,player);
       this.TestList =new ArrayList<>();
    }

    @Test
    void allMovesFourDirectionTest() {
        board.sections[2].squares[1][1].setPiece(bishop);
        this.TestList.addAll(board.navigation.squaresTopRightDiagonal(board.sections[2].squares[1][1]));
        this.TestList.addAll(board.navigation.squaresTopLeftDiagonal(board.sections[2].squares[1][1]));
        this.TestList.addAll(board.navigation.squaresBottomRightDiagonal(board.sections[2].squares[1][1]));
        this.TestList.addAll(board.navigation.squaresBottomLeftDiagonal(board.sections[2].squares[1][1]));

        assertEquals(TestList,bishop.allMoves());

    }

    @Test
    void allDiagonalsBlocked(){
        Pawn pawn=new Pawn(board,player);
        board.sections[2].squares[1][3].setPiece(bishop);
        board.sections[2].squares[2][2].setPiece(pawn);
        board.sections[2].squares[0][2].setPiece(pawn);

        assertEquals(TestList,bishop.allMoves());

    }
    @Test
    void CaptureOpponentTest(){
        Player opponent =new Player("ahad","YELLOW");
        Pawn pawn=new Pawn(board,opponent);
        board.sections[2].squares[1][3].setPiece(bishop);
        board.sections[2].squares[0][2].setPiece(pawn);
        TestList.add(board.sections[2].squares[0][2]);
        TestList.addAll(board.navigation.squaresTopLeftDiagonal(board.sections[2].squares[1][3]));

        assertEquals(TestList,bishop.allMoves());
    }

    @Test
    void SaveTheKingTest(){
        Player opponent =new Player("ahad","YELLOW");
        Queen queen =new Queen(board,opponent);
        King king =new King(board,player);

        board.sections[2].squares[2][3].setPiece(king);
        board.sections[2].squares[2][2].setPiece(bishop);
        board.sections[2].squares[2][1].setPiece(queen);

        assertEquals(TestList,bishop.allMoves());


    }

    @Test
    void SaveTheKingMoveTest(){
        Player opponent =new Player("ahad","YELLOW");
        Queen queen =new Queen(board,opponent);
        King king =new King(board,player);

        board.sections[2].squares[2][3].setPiece(king);
        board.sections[2].squares[1][3].setPiece(bishop);
        board.sections[2].squares[2][1].setPiece(queen);
        TestList.add(board.sections[2].squares[2][2]);
        assertEquals(TestList,bishop.allMoves());

    }

}