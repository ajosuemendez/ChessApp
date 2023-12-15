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
 * Mateusz Sławomir Lach ( matlak, msl )
 * Damian Marciniak
 */

package com.thechessnuts.InputHandlerService.models;

import java.util.ArrayList;


/**
 * Class to represent a chess piece rook
 * Rook can move:
 *       |_|_|_|X|_|_|_|_|7
|_|_|_|X|_|_|_|_|6
|_|_|_|X|_|_|_|_|5
|_|_|_|X|_|_|_|_|4
|X|X|X|B|X|X|X|X|3
|_|_|_|X|_|_|_|_|2
|_|_|_|X|_|_|_|_|1
|_|_|_|X|_|_|_|_|0
0 1 2 3 4 5 6 7
 *
 */
public class Rook extends Piece
{

    public static short value = 5;

    Rook(Chess3Board board, Player player)
    {
        super(board, player);
        this.board = board;
        this.player = player;//call initializer of super type: Piece
        //this.setImages("Rook-W.png", "Rook-B.png");
        this.symbol = "R";
        this.name += "rook";
    }

    /**
     *  Annotation to superclass Piece changing pawns location
     * @return  ArrayList with new position of piece
     */
    @Override
    public ArrayList<Square> allMoves()
    {
        ArrayList<Square> list = new ArrayList<>();
        boolean borderWasCrossed = false;

        Square checkingSquare = board.squareAbove(this.square);
        while(checkingSquare!=null){
            list.add(checkingSquare);
            if (checkingSquare.isEmpty()){
                checkingSquare = board.squareAbove(checkingSquare);
            }
            else{
                break;
            }
        }
        if(this.square.label.charAt(0) <= 'd' && (this.square.label.charAt(1) == '4' || this.square.label.charAt(1) == '5')){
            borderWasCrossed = true;
        }
        checkingSquare = board.squareBelow(this.square);

        while(checkingSquare!=null){
            list.add(checkingSquare);
            if (checkingSquare.isEmpty()){
                if(borderWasCrossed){
                    checkingSquare = board.squareAbove(checkingSquare);
                }
                else {
                    if (checkingSquare.label.charAt(0) <= 'd' && (checkingSquare.label.charAt(1) == '4' || checkingSquare.label.charAt(1) == '5')) {
                        borderWasCrossed = true;
                         checkingSquare = board.squareBelow(checkingSquare);
                        continue;
                    }
                    checkingSquare = board.squareBelow(checkingSquare);
                }
            }
            else{
                break;
            }
        }
        checkingSquare = board.squareLeft(this.square);

        while(checkingSquare!=null){
            list.add(checkingSquare);
            if (checkingSquare.isEmpty()){
                checkingSquare = board.squareLeft(checkingSquare);
            }
            else{
                break;
            }
        }
        checkingSquare = board.squareRight(this.square);

        while(checkingSquare!=null){
            list.add(checkingSquare);
            if (checkingSquare.isEmpty()){
                checkingSquare = board.squareRight(checkingSquare);
            }
            else{
                break;
            }
        }

        for(int i = 0; i<list.size(); i++){
            if(list.get(i).piece!=null){
                if(list.get(i).piece.player.color == this.player.color){
                    list.remove(i);
                    i--;
                }
            }
        }

        return list;
    }
}