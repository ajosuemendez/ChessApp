// // package com.thechessnuts.InputHandlerService.models;

// // import com.thechessnuts.InputHandlerService.models.Chess3Board;
// // import com.thechessnuts.InputHandlerService.models.Square;
// // import org.junit.jupiter.api.Test;
// // import org.junit.jupiter.api.function.Executable;

// // import static org.junit.jupiter.api.Assertions.*;

// // class Chess3SectionTest {
//     // String[] x_axis;
//     // String[] y_axis;
//     // Chess3Board board;

//     // @Test
//     // void ValidInputChess3SectionTest(){
//     //     this.x_axis = new String[]{"a", "b", "c", "d"};
//     //     this.y_axis = new String[]{"1","2","3","4"};
//     //     this.board  = new Chess3Board();
//     //     Chess3Section section= new Chess3Section(x_axis,y_axis,board);

//     //     assertEquals(x_axis,section.getX_axis());
//     //     assertEquals(y_axis,section.getY_axis());
//     //     assertEquals(board,section.getBoard());


//     //     for (int i = 0; i < 4; i++) {
//     //         for (int j = 0; j < 4; j++) {
//     //             Square square = section.squares[i][j];
//     //             assertEquals(x_axis[j] + y_axis[i], square.getLabel());
//     //             assertEquals(j, square.getPozX());
//     //             assertEquals(i, square.getPozY());
//     //             assertSame(section, square.getSection());
//     //         }
//     //     }



//     // }
//     // @Test
//     // void NullChessBoradTest(){
//     //     this.x_axis = new String[]{"a", "b", "c", "d"};
//     //     this.y_axis = new String[]{"1","2","3","4"};
//     //     assertThrows(NullPointerException.class,()->new Chess3Section(x_axis,y_axis,null));

//     // }

//     // @Test
//     // void InvalidInputChess3SectionTest(){
//     //     this.x_axis = new String[]{"a", "b", "c", "d"};
//     //     this.y_axis = new String[]{"1","2","3","4","5"};
//     //     this.board  = new Chess3Board();
//     //    assertThrows(IllegalArgumentException.class,()->new Chess3Section(x_axis,y_axis,board));

//     // }

//     // @Test
//     // void EmptyAxisTest(){
//     //     this.x_axis=new String[]{};
//     //     this.y_axis=new String[]{};
//     //     this.board=new Chess3Board();
//     //     assertThrows(IllegalArgumentException.class,()->new Chess3Section(x_axis,y_axis,board));
//     // }
//     // @Test
//     // void findSquareTest() {
//     //     this.x_axis = new String[]{"a", "b", "c", "d"};
//     //     this.y_axis = new String[]{"1","2","3","4"};
//     //     this.board  = new Chess3Board();
//     //     Chess3Section section =new Chess3Section(x_axis,y_axis,board);
//     //     assertNull(section.findSquare("a5"));
//     //     assertNull(section.findSquare("e1"));
//     // }

//     // @Test
//     // void getSectionState() {
//     // }
// }