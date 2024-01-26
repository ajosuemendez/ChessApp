package com.thechessnuts.gamesessionservice.models;
/**
 * Class to represent a chess board square
 */
public class Square
{
    String label;
    Piece piece = null;

    Square(String label)
    {
        if(label.charAt(0)>= 'a' &&label.charAt(0)<='l') {
            this.label = label;
        }
        else{
            this.label = label.charAt(label.length()-1)+label.substring(0, label.length()-1);
        }
    }

    void setPiece(Piece piece)
    {
        this.piece = piece;
        piece.square = this;
    }

    @Override
    public String toString(){
        return this.label;
    }

    boolean isEmpty(){
        return this.piece==null;
    }

    SquareForSending getSquareState(boolean isSelected){
        return new SquareForSending(this.label, this.piece==null?"":this.piece.name, isSelected, this.piece==null?false:(this.piece.name.equals("king")&&this.piece.check));
    }
    
    boolean isAtBorder(){
        if(label.charAt(0)<= 'd' && (label.charAt(1)=='4' || label.charAt(1)=='5')){
            return true;
        }
        return false;
    }

}
