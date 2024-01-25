package com.thechessnuts.InputHandlerService.models;

import java.util.ArrayList;
import java.util.stream.IntStream;


public class Chess3Board extends AbstractChessBoard{

    private Chess3Initializer initializer;
    ChecksManager checksManager;
    static String[][][] gridReferences = {

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

    public Chess3Section[] sections;

    public Chess3Board() {
        this.navigation = new Chess3Navigation(this);
        this.initializer = new Chess3Initializer(this);
        this.checksManager = new ChecksManager(this);
    }

    @Override
    public Square getSquareAt(String label)
    {
        
        for(int i = 0; i<6; i++){
            if(this.sections[i].getSquareAt(label)!=null){
                return this.sections[i].getSquareAt(label);
            }
        }
        return null;
    }
    
    @Override
    public String toString(){
        String ret = "";

        for(int i = 0; i<6; i++)
            ret+=sections[i]+"\n\n\n";
        return ret;
    }
    
    public void initialise(Chess3Settings settings){
        sections = new Chess3Section[6];
        IntStream.range(0, 6).forEach(i -> {
            String[] rowValues = gridReferences[i][0];
            String[] colValues = gridReferences[i][1];

            sections[i] = new Chess3Section(rowValues, colValues, this);
        });
        initializer.initialize(settings);
    }

    //----------------- clean code below -----------------------//

    public void selectPiece(String label){
        if(this.selectedPiece!=null){
            this.selectedPiece.deselct();
        }
        Square squareSelected = this.getSquareAt(label);
        if(squareSelected!=null){
            this.getSquareAt(label).piece.select();
            this.selectedPiece = this.getSquareAt(label).piece;
        }
        else
            this.selectedPiece = null;
    }



    public void makeMove(Move move){
        checksManager.unmarkChecks();
        this.getSquareAt(move.to.label).setPiece(move.movedPiece);
        move.from.piece = null;
        if(move.movedPiece.symbol == ""){
            move.movedPiece.started = true;
        }
        checksManager.markChecks();
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

    public void eliminatePlayer(){
        
    }
    //--------------------------------------------------------//

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
    

        //CLEAN THE CODE HERE!!!!!!!!!!!!!! IT IS DISGUSTING
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

