package com.thechessnuts.InputHandlerService.models;

import java.util.ArrayList;
import java.util.stream.IntStream;

import com.thechessnuts.InputHandlerService.models.Chess3Board.Chess3Section;

public class Chess3Board {
    public Chess3Section[] sections;
    Piece selectedPiece = null;
    Navigation navigation;

    public Chess3Board() {
        sections = new Chess3Section[6];

        // Define pairs of string arrays as arrays of arrays
        String[][][] sectionData = {
            {
                {"4", "3", "2", "1"},
                {"d", "c", "b", "a"}
            },

            {
                {"e", "f", "g", "h"}, 
                {"4", "3", "2", "1"}
            },

            {
                {"9", "10", "11", "12"}, 
                {"e", "f", "g", "h"}
            },

            {   
                {"i", "j", "k", "l"}, 
                {"9", "10", "11", "12"}
            },

            {
                {"5", "6", "7", "8"}, 
                {"i", "j", "k", "l"}
            },

            {
                {"d", "c", "b", "a"}, 
                {"5", "6", "7", "8"}
            },
        };

        IntStream.range(0, 6).forEach(i -> {
            String[] rowValues = sectionData[i][0];
            String[] colValues = sectionData[i][1];

            sections[i] = new Chess3Section(rowValues, colValues, this);
        });

        this.navigation = new Navigation(this);
    }

    public Square getSquareAt(String label)
    {
        
        for(int i = 0; i<6; i++){
            if(this.sections[i].getSquareAt(label)!=null){
                return this.sections[i].getSquareAt(label);
            }
        }
        return null;
    }

    public void setPieces(Player player){
        int section1/*Queen's Side*/, section2/*King's Side*/;
        if(player.color == Player.colors.BLACK){
            section1 = 0;
            section2 = 1;
        }
        else if(player.color == Player.colors.WHITE){
            section1 = 2;
            section2 = 3;
        }
        else{
            section1 = 4;
            section2 = 5;
        }

        //PAWNS
        for(int i = 0; i<4;i++){
            this.sections[section1].squares[i][2].setPiece(new Pawn(this, player));
            this.sections[section2].squares[2][i].setPiece(new Pawn(this, player));
        }

        //ROOKS
        this.sections[section1].squares[3][3].setPiece(new Rook(this, player));
        this.sections[section2].squares[3][3].setPiece(new Rook(this, player));

        //KNIGHTS
        this.sections[section1].squares[2][3].setPiece(new Knight(this, player));
        this.sections[section2].squares[3][2].setPiece(new Knight(this, player));

        //BISHOPS
        this.sections[section1].squares[1][3].setPiece(new Bishop(this, player));
        this.sections[section2].squares[3][1].setPiece(new Bishop(this, player));

        //QUEEN
        this.sections[section1].squares[0][3].setPiece(new Queen(this, player));

        //KING
        this.sections[section2].squares[3][0].setPiece(new King(this, player));



    }

    public void print(){
        for(int i = 0; i<6; i++){
            System.out.println(sections[i]);
            System.out.println("\n");
        }
    }

    //----------------- clean code below -----------------------//

    public void selectPiece(String label){
        if(this.selectedPiece!=null){
            this.selectedPiece.isSelected = false;
        }
        Square squareSelected = this.getSquareAt(label);
        if(squareSelected!=null){
            this.getSquareAt(label).piece.isSelected = true;
            this.selectedPiece = this.getSquareAt(label).piece;
        }
        else
            this.selectedPiece = null;
    }


    public void makeMove(Move move){
        this.getSquareAt(move.to.label).setPiece(this.getSquareAt(move.from.label).piece);
        this.getSquareAt(move.from.label).piece = null;
        if(move.movedPiece.symbol == ""){
            move.movedPiece.started = true;
        }

    }

    public ArrayList<SquareForSending> getBoardState(){
        ArrayList<SquareForSending> list = new ArrayList<>();
        ArrayList<Square> selectList = new ArrayList<>();

        if(this.selectedPiece!=null){
            //selectList.add(board.selectedPiece.square);
            selectList.addAll(this.selectedPiece.allMoves());
        }

        for(int i = 0; i< 6; i++){
            list.addAll(this.sections[i].getSectionState(selectList));
        }

        return list;
    }

    class Chess3Section {
        public Square[][] squares;//squares of chessboard
        //The top left corner(pos 0,0) is always the square at the center rosette
    
        protected Chess3Board board;
        protected String[] x_axis, y_axis;
    
        public Square[][] getSquares() {
            return squares;
        }
    
        public Chess3Board getBoard() {
            return board;
        }
    
        public String[] getX_axis() {
            return x_axis;
        }
    
        public String[] getY_axis() {
            return y_axis;
        }
    
        public Chess3Section(String[] x_axis, String[] y_axis, Chess3Board board) {
    
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
    
        public Square getSquareAt(String label){
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
    
        public ArrayList<SquareForSending> getSectionState(ArrayList<Square> selectedList){
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

    
}

