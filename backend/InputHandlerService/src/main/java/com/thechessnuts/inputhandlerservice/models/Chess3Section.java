package com.thechessnuts.inputhandlerservice.models;

import java.util.ArrayList;

class Chess3Section {
    Square[][] squares;//squares of chessboard
    //The top left corner(pos 0,0) is always the square at the center rosette

    protected Chess3Board board;
    protected String[] x_axis, y_axis;

    Square[][] getSquares() {
        return squares;
    }

    Chess3Board getBoard() {
        return board;
    }

    String[] getX_axis() {
        return x_axis;
    }

    String[] getY_axis() {
        return y_axis;
    }


    //CLEAN THE CODE HERE!!!!!!!!!!!!!! IT IS DISGUSTING
    Chess3Section(String[] x_axis, String[] y_axis, Chess3Board board) {

        if (board.equals(null)){
            throw new NullPointerException("Board is Null!!");
        }else this.board = board;

        if(x_axis.length==0||y_axis.length==0){
            throw new IllegalArgumentException("Array is Empty!!");
        } else if (x_axis.length== y_axis.length) {
            this.x_axis = x_axis;
            this.y_axis = y_axis;
        }else {
            throw new IllegalArgumentException(("THE Lenght of x_axis and y_axis does not match!!"));
        }

        this.squares = new Square[4][4];


        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 4; j++)
                this.squares[i][j] = new Square(x_axis[j] + y_axis[i]);

    }

    Square getSquareAt(String label){
        for(int i = 0; i < 4; i++)
            for(int j = 0; j < 4; j++)
                if(squares[j][i].label.equals(label))
                    return squares[j][i];
        return null;
    }

    @Override
    public String toString() {
        String ret = "";
        for(int i = 0; i<4; i++) {
            ret += y_axis[i]+ " " + (y_axis[i].length()>1?"":" ");
            for(int j = 0; j<4;j++){
                if(this.squares[i][j].piece!=null) {
                    ret +=  this.squares[i][j].piece.symbol + "   ";
                }
                else{
                    ret += "    ";
                }
            }
            ret+="\n";
        }
        ret+="   ";
        for(int i = 0; i<4; i++)
            ret+= x_axis[i] + "  " + (x_axis[i].length()>1?"":" ");
            
        return ret;
    }

    ArrayList<SquareForSending> getSectionState(ArrayList<Square> selectedList){
        ArrayList<SquareForSending> list = new ArrayList<>();

        for(int i = 0; i< 4; i++){
            for(int j = 0; j<4; j++){
                if(selectedList.indexOf(squares[i][j])>=0){
                    list.add(squares[i][j].getSquareState(true));
                }
                else{
                    list.add(squares[i][j].getSquareState(false));
                }
            }
        }

        return list;
    }

}
