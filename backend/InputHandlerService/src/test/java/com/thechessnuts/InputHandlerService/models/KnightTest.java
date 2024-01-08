package com.thechessnuts.InputHandlerService.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KnightTest {
    Chess3Board board;
    Player player;
    Player opponent;
    Knight knight;
    ArrayList<Square> TestList;

    @BeforeEach
    void setup(){
        this.board=new Chess3Board();
        this.player=new Player("ahad","WHITE");
        this.opponent=new Player("Janakan","BLACK");
        this.knight=new Knight(board,player);
        this.TestList=new ArrayList<>();

    }

    @Test
    void allSidesOpenTest(){

        board.sections[2].squares[1][1].setPiece(knight);
        TestList.add(board.sections[1].squares[0][2]);
        TestList.add(board.sections[1].squares[0][0]);
        TestList.add(board.sections[2].squares[3][0]);
        TestList.add(board.sections[2].squares[3][2]);
        TestList.add(board.sections[2].squares[2][3]);
        TestList.add(board.sections[2].squares[0][3]);
        TestList.add(board.sections[3].squares[0][0]);
        TestList.add(board.sections[3].squares[2][0]);

        assertEquals(TestList,knight.allMoves());


    }

    @Test
    void SidesBlockedTest(){
        Pawn pawn =new Pawn(board,player);

        board.sections[2].squares[3][3].setPiece(knight);
        board.sections[2].squares[3][1].setPiece(pawn);
        board.sections[2].squares[1][2].setPiece(pawn);

        TestList.add(board.sections[2].squares[3][3]);
        TestList.add(board.sections[2].squares[3][1]);
        TestList.add(board.sections[2].squares[1][2]);

    }
}
