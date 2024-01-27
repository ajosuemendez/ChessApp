// package com.thechessnuts.InputHandlerService.models;

// import com.thechessnuts.InputHandlerService.models.*;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;

// import java.util.ArrayList;

// import static org.junit.jupiter.api.Assertions.*;

// class RookTest {
// //   Chess3Board board;
// //   Player player;
// //   Player opponent;
// //   ArrayList<Square> TestList;
// //   Rook rook;
  
// //     @BeforeEach
// //     void setUp() {
// //         this.board=new Chess3Board();
// //         this.player=new Player("ahad","WHITE");
// //         this.TestList=new ArrayList<>();
// //         this.rook=new Rook(board,player);
// //         this.opponent =new Player("Othman","BLACK");
        
// //     }

// //     @Test
// //     void allSidesOpenTest() {
// //         board.sections[2].squares[0][0].setPiece(rook);
// //         // above
// //         TestList.add(board.sections[1].squares[0][0]);
// //         TestList.add(board.sections[1].squares[1][0]);
// //         TestList.add(board.sections[1].squares[2][0]);
// //         TestList.add(board.sections[1].squares[3][0]);
// //         //down
// //         TestList.add(board.sections[2].squares[0][1]);
// //         TestList.add(board.sections[2].squares[0][2]);
// //         TestList.add(board.sections[2].squares[0][3]);
// //         //left
// //         TestList.add(board.sections[2].squares[1][0]);
// //         TestList.add(board.sections[2].squares[2][0]);
// //         TestList.add(board.sections[2].squares[3][0]);
// //         // right
// //         TestList.add(board.sections[3].squares[0][0]);
// //         TestList.add(board.sections[3].squares[0][1]);
// //         TestList.add(board.sections[3].squares[0][2]);
// //         TestList.add(board.sections[3].squares[0][3]);

// //         assertEquals(TestList,rook.allMoves());
// //     }

// //     @Test
// //     void AllSidesBlockedTest(){

// //         Pawn pawn =new Pawn(board,player);

// //         board.sections[2].squares[3][3].setPiece(rook);
// //         board.sections[2].squares[3][2].setPiece(pawn);
// //         board.sections[2].squares[2][3].setPiece(pawn);

// //         assertEquals(TestList,rook.allMoves());



// //     }

// //     @Test
// //     void CaptureEnemyTest(){

// //         Pawn pawn =new Pawn(board,opponent);

// //         board.sections[2].squares[3][3].setPiece(rook);
// //         board.sections[2].squares[3][2].setPiece(pawn);
// //         board.sections[2].squares[2][3].setPiece(pawn);

// //         TestList.add(board.sections[2].squares[3][2]);
// //         TestList.add(board.sections[2].squares[2][3]);

// //         assertEquals(TestList,rook.allMoves());


// //     }
// //     @Test
// //     void SaveTheKingDoNotMoveTest(){
// //         King king =new King(board,player);
// //         Bishop bishop=new Bishop(board,opponent);

// //         board.sections[2].squares[3][3].setPiece(king);
// //         board.sections[2].squares[2][2].setPiece(rook);
// //         board.sections[2].squares[1][1].setPiece(bishop);

// //         assertEquals(TestList,rook.allMoves());



// //     }

// //     @Test
// //     void SaveTheKingByMoving(){
// //         King king =new King(board,player);
// //         Bishop bishop=new Bishop(board,opponent);

// //         board.sections[2].squares[3][3].setPiece(king);
// //         board.sections[2].squares[2][0].setPiece(rook);
// //         board.sections[2].squares[1][1].setPiece(bishop);

// //         TestList.add(board.sections[2].squares[2][2]);
// //         assertEquals(TestList,rook.allMoves());
// //     }


// }