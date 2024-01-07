package com.thechessnuts.InputHandlerService.models;

import java.util.ArrayList;

public class Chess3Board {
    public Chess3Section[] sections;
    Piece selectedPiece = null;
    Navigation navigation;
    Behaviours behaviours;

    public Chess3Board()
    {

     sections = new Chess3Section[6];

        sections[0] = new Chess3Section(
                new String[]{"4", "3", "2", "1"},
                new String[]{"d", "c", "b", "a"},
                this
        );

        sections[1] = new Chess3Section(
                new String[]{"e", "f", "g", "h"},
                new String[]{"4", "3", "2", "1"},
                this
        );

        sections[2] = new Chess3Section(
                new String[]{"9", "10", "11", "12"},
                new String[]{"e", "f", "g", "h"},
                this
        );

        sections[3] = new Chess3Section(
                new String[]{"i", "j", "k", "l"},
                new String[]{"9", "10", "11", "12"},
                this
        );

        sections[4] = new Chess3Section(
                new String[]{"5", "6", "7", "8"},
                new String[]{"i", "j", "k", "l"},
                this
        );

        sections[5] = new Chess3Section(
                new String[]{"d", "c", "b", "a"},
                new String[]{"5", "6", "7", "8"},
                this
        );
        this.navigation = new Navigation(this);
        this.behaviours = new Behaviours(this);
    }

    public Square getSquare(String label)
    {
        
        for(int i = 0; i<6; i++){
            if(this.sections[i].getSquare(label)!=null){
                return this.sections[i].getSquare(label);
            }
        }
        return null;
    }
    
    //CLEAN
    public boolean isSquareEmpty(String label)
    {
        if(this.getSquare(label) == null)
            return false;
        return this.getSquare(label).isEmpty();
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

    public void selectPiece(String label){
        if(this.selectedPiece!=null){
            this.selectedPiece.isSelected = false;
        }
        Square squareSelected = this.getSquare(label);
        if(squareSelected!=null){
            this.getSquare(label).piece.isSelected = true;
            this.selectedPiece = this.getSquare(label).piece;
        }
        else
            this.selectedPiece = null;
    }

    public void makeMove(Move move){
        this.getSquare(move.to.label).setPiece(this.getSquare(move.from.label).piece);
        this.getSquare(move.from.label).piece = null;
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

    
}

