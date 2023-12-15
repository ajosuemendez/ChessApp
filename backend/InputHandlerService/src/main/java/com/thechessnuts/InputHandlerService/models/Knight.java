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
        Square up = this.board.squareAbove(this.square);
        Square down = this.board.squareBelow(this.square);
        Square left = this.board.squareLeft(this.square);
        Square right = this.board.squareRight(this.square);
        String num = this.square.label.substring(1);

      if(up !=null)
      {
         list=upwards(list,this.square);
        System.out.println(list);}
      if(down!=null)
         {list=downwards(list, this.square, num);
        System.out.println(list);}
      if(left!=null)
        { list=leftwards(list, this.square,num);
        System.out.println(list);}
      if(right!=null)
       { list=rightwards(list, this.square, num);
     
    System.out.println(list);}


         return list;
    }

    public boolean isInSection(int sectionNumber) {
        if (this.board.sections[sectionNumber].findSquare(this.square.label) != null) {
            // System.out.println("In sec 1");
            return true;
        } else
            return false;
    }

    public ArrayList<Square> upwards(ArrayList<Square> list, Square square) {
        
            Square up = this.board.squareAbove(square);
            System.out.println("enter");
            Square up2 = this.board.squareAbove(up);
            if (this.board.findSquare(up2.label) != null) {
                if (this.board.squareRight(up2) != null)
                    list.add(this.board.squareRight(up2));
                if (this.board.squareLeft(up2) != null)
                    list.add(this.board.squareLeft(up2));

            }

            if (this.board.squareRight(up) != null) {
                if (this.board.squareRight(this.board.squareRight(up)).label != null) {
                      Square right2= this.board.squareRight(up);
                      System.out.println(right2);
                      System.out.println(this.board.squareRight(right2));
                      list.add(this.board.squareRight(right2));

                }
            }
            if (this.board.squareLeft(up) != null) {
                if (this.board.squareLeft(this.board.squareLeft(up)) != null)
                    list.add(this.board.squareLeft(this.board.squareLeft(up)));
            }
        
        return list;
    }

    public ArrayList<Square> downwards(ArrayList<Square> list, Square square, String num) {
        if (this.board.squareBelow(square) != null) {
            Square down = this.board.squareBelow(square);
            Square down2=null;
            if ((this.isInSection(0) && (num.equals("4"))) || (this.isInSection(5) && (num.equals("5")))) 
                    down2 = this.board.squareAbove(down);
                else
                 down2 = this.board.squareBelow(down);
               

                if (this.board.findSquare(down2.label) != null) {
                    if (this.board.squareRight(down2) != null) {
                        // System.out.println(this.board.squareRight(down2).label);
                        list.add(this.board.squareRight(down2));
                    }
                    if (this.board.squareLeft(down2) != null) {
                        // System.out.println(this.board.squareLeft(down2));
                        list.add(this.board.squareLeft(down2));
                    }
                }
                if (this.board.squareRight(down) != null) {
                    if (this.board.squareRight(this.board.squareRight(down)) != null) {
                        System.out.println(this.board.squareRight(this.board.squareRight(down)));
                        System.out.println(this.board.squareRight(down));
                        list.add(this.board.squareRight(this.board.squareRight(down)));
                    }
                }
                if (this.board.squareLeft(down) != null) {
                    if (this.board.squareLeft(this.board.squareLeft(down)) != null)
                        list.add(this.board.squareLeft(this.board.squareLeft(down)));

                }
            
            
}
       
        return list;
    }
     public ArrayList<Square> leftwards(ArrayList<Square> list, Square square,String num)
        {
            Square left=this.board.squareLeft(square);
            if (this.board.findSquare(left.label) != null) {
            Square left2 = this.board.squareLeft(left);
            if (left2 != null) {
                if (this.board.squareAbove(left2) != null && !list.contains(this.board.squareAbove(left2)))
                    list.add(this.board.squareAbove(left2));

                if (this.board.squareBelow(left2) != null && !list.contains(this.board.squareBelow(left2)))
                    list.add(this.board.squareBelow(left2));
            }
            else{
            if ((this.isInSection(0) && (num.equals("4"))) || (this.isInSection(5) && (num.equals("5")))) {
                if (this.board.squareAbove(left) != null) {
                    if (this.board.squareAbove(this.board.squareAbove(left)) != null
                            && !list.contains(this.board.squareAbove(this.board.squareAbove(left))))
                        list.add(this.board.squareAbove(this.board.squareAbove(left)));
                }
                if (this.board.squareBelow(left) != null) {
                    if (this.board.squareAbove(this.board.squareBelow(left)) != null
                            && !list.contains(this.board.squareAbove(this.board.squareBelow(left))))
                        list.add(this.board.squareAbove(this.board.squareBelow(left)));
                }
            } else {
                if (this.board.squareAbove(left) != null) {
                    if (this.board.squareAbove(this.board.squareAbove(left)) != null
                            && !list.contains(this.board.squareAbove(this.board.squareAbove(left))))
                        list.add(this.board.squareAbove(this.board.squareAbove(left)));
                }
                if (this.board.squareBelow(left) != null) {
                    if (this.board.squareBelow(this.board.squareBelow(left)) != null
                            && !list.contains(this.board.squareBelow(this.board.squareBelow(left))))
                        list.add(this.board.squareBelow(this.board.squareBelow(left)));
                }
            }
        }
        }
        return list;
    }

       public ArrayList<Square> rightwards(ArrayList<Square> list, Square square,String num)
       { Square right=this.board.squareRight(square);
         if (this.board.findSquare(right.label) != null) {
            Square right2 = this.board.squareRight(right);
            if (right2 != null) {
                if (this.board.squareAbove(right2) != null && !list.contains(this.board.squareAbove(right2)))
                    list.add(this.board.squareAbove(right2));

                if (this.board.squareBelow(right2) != null && !list.contains(this.board.squareBelow(right2)))
                    list.add(this.board.squareBelow(right2));
            }
            else{
            if ((this.isInSection(0) && (num.equals("4"))) || (this.isInSection(5) && (num.equals("5")))) {
                if (this.board.squareAbove(right) != null) {
                    if (this.board.squareAbove(this.board.squareAbove(right)) != null
                            && !list.contains(this.board.squareAbove(this.board.squareAbove(right))))
                        list.add(this.board.squareAbove(this.board.squareAbove(right)));
                }
                if (this.board.squareBelow(right) != null) {
                    if (this.board.squareAbove(this.board.squareBelow(right)) != null
                            && !list.contains(this.board.squareAbove(this.board.squareBelow(right))))
                        list.add(this.board.squareAbove(this.board.squareBelow(right)));
                }
            } else {
                if (this.board.squareAbove(right) != null) {
                    if (this.board.squareAbove(this.board.squareAbove(right)) != null
                            && !list.contains(this.board.squareAbove(this.board.squareAbove(right))))
                        list.add(this.board.squareAbove(this.board.squareAbove(right)));
                }
                if (this.board.squareBelow(right) != null) {
                    if (this.board.squareBelow(this.board.squareBelow(right)) != null
                            && !list.contains(this.board.squareBelow(this.board.squareBelow(right))))
                        list.add(this.board.squareBelow(this.board.squareBelow(right)));
                }
            }
        }
    }
        return list;
    }

}

