package com.thechessnuts.InputHandlerService.models;

import java.util.ArrayList;


/**
 * Class to represent a chess pawn knight
 */
public class Knight extends Piece
{

    public static short value = 3;

    Knight(Chess3Board board, Player player)
    {
        super(board, player);
        this.board = board;
        this.player = player;//call initializer of super type: Piece
        //this.setImages("Knight-W.png", "Knight-B.png");
        this.symbol = "N";
        this.name += "knight";
    }


    /**
     *  Annotation to superclass Piece changing pawns location
     * @return  ArrayList with new possition of pawn
     */
    @Override
    public ArrayList allMoves()
    {
        ArrayList<Square> list = new ArrayList();
        Square up=this.board.squareAbove(this.square);
        Square down=this.board.squareBelow(this.square);
        Square left=this.board.squareLeft(this.square);
        Square right=this.board.squareRight(this.square);

        if(this.board.findSquare(up.label)!=null)
        {
            Square up2=this.board.squareAbove(up);
            if(this.board.findSquare(up2.label)!=null)
            {
                if(this.board.squareRight(up2)!=null)
                    list.add(this.board.squareRight(up2));
                if (this.board.squareLeft(up2)!=null)
                    list.add(this.board.squareLeft(up2));

            }
            Square r1=this.board.squareRight(up);
            if(r1!=null) {
                if (this.board.squareRight(r1) != null) {
                    System.out.println(r1.label);
                    System.out.println(this.board.squareRight(r1).label);
                    list.add(this.board.squareRight(r1));
                    System.out.println(this.board.squareRight(this.board.squareRight(up)).label);
                }
            }
            if(this.board.squareLeft(this.board.squareLeft(up))!=null) {
                Square l1=this.board.squareLeft(up);
                // System.out.println(l1.label);
                 list.add(this.board.squareLeft(l1));
            }
        }

       /*
        else if(this.board.findSquare(down.label)!=null)
        {

        }
        else if(this.board.findSquare(left.label)!=null)
        {

        }
        else if (this.board.findSquare(left.label)!=null)
        {

        }


        public boolean isInSection(int sectionNumber){
            return this.board.sections[sectionNumber].findSquare(this.square.label)!=null;
    }
*/
        System.out.println(list);
        return list;
    }
    }

