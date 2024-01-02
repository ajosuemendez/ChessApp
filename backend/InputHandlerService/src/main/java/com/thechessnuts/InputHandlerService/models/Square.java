/*
#    This program is free software: you can redistribute it and/or modify
#    it under the terms of the GNU General Public License as published by
#    the Free Software Foundation, either version 3 of the License, or
#    (at your option) any later version.
#
#    This program is distributed in the hope that it will be useful,
#    but WITHOUT ANY WARRANTY; without even the implied warranty of
#    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
#    GNU General Public License for more details.
#
#    You should have received a copy of the GNU General Public License
#    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

/*
 * Authors:
 * Jankan
 * Othman
 * Alejandro
 * Ahad
 */
package com.thechessnuts.InputHandlerService.models;
/**
 * Class to represent a chess board square
 */
public class Square
{
    String label;
    Piece piece = null;
    int pozX; // 0-7, because 8 squares for row/column
    int pozY; // 0-7, because 8 squares for row/column
    Chess3Section section;

   public Square(String label, int pozX, int pozY, Chess3Section section)
    {

//added error handling for 0>x>7
        if (7>=pozX&&pozX>=0 && 7>=pozY&&pozY>=0) {
            this.pozX = pozX;
            this.pozY = pozY;
        } else {
            this.pozX= -1;
            this.pozY =-1;
        }
        this.section = section;
        if(label.charAt(0)>= 'a' &&label.charAt(0)<='l') {
            this.label = label;
        }
        else{
            this.label = label.charAt(label.length()-1)+label.substring(0, label.length()-1);
        }
    }

    public Square(String label){
        this.label = label;
    }

    public void setPiece(Piece piece)
    {
        this.piece = piece;
        this.piece.square = this;
    }


    public String toString(){
        return this.label;
    }

    public boolean isEmpty(){
        return this.piece==null;
    }

    public SquareForSending getSquareState(boolean isSelected){
        return new SquareForSending(this.label, this.piece==null?"":this.piece.name, isSelected);
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Piece getPiece() {
        return piece;
    }

    public int getPozX() {
        return pozX;
    }

    public void setPozX(int pozX) {
        this.pozX = pozX;
    }

    public int getPozY() {
        return pozY;
    }

    public void setPozY(int pozY) {
        this.pozY = pozY;
    }

    public Chess3Section getSection() {
        return section;
    }

    public void setSection(Chess3Section section) {
        this.section = section;
    }
}
