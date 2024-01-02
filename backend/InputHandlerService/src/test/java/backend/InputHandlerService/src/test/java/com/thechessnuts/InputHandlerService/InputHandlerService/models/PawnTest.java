package backend.InputHandlerService.src.test.java.com.thechessnuts.InputHandlerService.InputHandlerService.models;

import com.thechessnuts.InputHandlerService.models.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class PawnTest{
    Chess3Board board;
    Player Whiteplayer;
    Player BlackPlayer;
    Player YellowPlayer;
    ArrayList<Square> TestList;
    Pawn pawn;


    @BeforeEach
    void setup(){
        this.board=new Chess3Board();
        this.Whiteplayer =new Player("ahad","WHITE");
        this.BlackPlayer =new Player("Othman","BLACK");
        this.YellowPlayer =new Player("Alajandro","YELLOW");
        this.TestList=new ArrayList<>();
        this.pawn=new Pawn(board, Whiteplayer);

    }

    @Test
    void allMovesTest(){
        board.sections[2].squares[2][2].setPiece(pawn);


        TestList.add(board.sections[2].squares[2][1]);
        TestList.add(board.sections[2].squares[2][0]);

        assertEquals(TestList,pawn.allMoves());

        this.pawn.started =true;
        TestList.remove(1);

        assertEquals(TestList,pawn.allMoves());


    }
    @Test
    void BlockedTest(){
        Pawn enemy =new Pawn(board, BlackPlayer);

        board.sections[2].squares[2][2].setPiece(pawn);
        board.sections[2].squares[2][1].setPiece(enemy);

        assertEquals(TestList,pawn.allMoves());
    }
    @Test
    void CaptureTest(){
        Bishop bishop =new Bishop(board, BlackPlayer);
        board.sections[2].squares[2][2].setPiece(pawn);
        board.sections[2].squares[1][1].setPiece(bishop);
        board.sections[2].squares[3][1].setPiece(bishop);

        TestList.add(board.sections[2].squares[2][1]);
        TestList.add(board.sections[2].squares[2][0]);
        TestList.add(board.sections[2].squares[3][1]);
        TestList.add(board.sections[2].squares[1][1]);

        assertEquals(TestList,pawn.allMoves());

        board.sections[2].squares[2][1].setPiece(bishop);
        TestList.remove(0);
        TestList.remove(0);
        assertEquals(TestList,pawn.allMoves());

    }
    @Test
    void BlackPawnCrossborderTest(){
        Pawn pawn =new Pawn(board, BlackPlayer);
        board.sections[5].squares[0][0].setPiece(pawn);


        TestList.add(board.sections[5].squares[1][0]);
        assertEquals(TestList,pawn.allMoves());

        Bishop bishop =new Bishop(board,Whiteplayer);
        board.sections[5].squares[1][1].setPiece(bishop);

        TestList.add( board.sections[5].squares[1][1]);
        assertEquals(TestList,pawn.allMoves());



    }
    @Test
    void BlackPawnTest(){
        Pawn pawn1=new Pawn(board,BlackPlayer);
        board.sections[0].squares[0][2].setPiece(pawn1);

        TestList.add(board.sections[0].squares[0][1]);
        TestList.add(board.sections[0].squares[0][0]);
        assertEquals(TestList,pawn1.allMoves());
    }
    @Test
    void YellowPawnTest(){
        Pawn pawn =new Pawn(board, YellowPlayer);
        board.sections[0].squares[0][0].setPiece(pawn);

        TestList.add(board.sections[0].squares[0][1]);
        assertEquals(TestList,pawn.allMoves());

        Bishop bishop =new Bishop(board,Whiteplayer);
        board.sections[0].squares[1][1].setPiece(bishop);

        TestList.add( board.sections[0].squares[1][1]);
        assertEquals(TestList,pawn.allMoves());
    }

    @Test
    void SaveTheKing(){
        King king=new King(board,Whiteplayer);
        Rook rook =new Rook(board,BlackPlayer);

        board.sections[2].squares[3][1].setPiece(king);
        board.sections[2].squares[2][1].setPiece(pawn);
        board.sections[2].squares[1][1].setPiece(rook);

        assertEquals(TestList,pawn.allMoves());

    }

    @Test
    void SaveTheKingMove(){
        King king=new King(board,Whiteplayer);
        Rook rook =new Rook(board,BlackPlayer);

        board.sections[2].squares[3][2].setPiece(king);
        board.sections[2].squares[2][2].setPiece(pawn);
        board.sections[2].squares[0][1].setPiece(rook);

        TestList.add(board.sections[2].squares[2][1]);

        assertEquals(TestList,pawn.allMoves());
    }

}
