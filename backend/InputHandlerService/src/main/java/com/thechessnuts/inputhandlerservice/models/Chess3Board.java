package com.thechessnuts.inputhandlerservice.models;

import java.util.ArrayList;
import java.util.stream.IntStream;


class Chess3Board extends AbstractChessBoard{

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

    Chess3Section[] sections;

    Chess3Board() {
        this.navigation = new Chess3Navigation(this);
        this.initializer = new Chess3Initializer(this);
        this.checksManager = new ChecksManager(this);
    }

    @Override
    Square getSquareAt(String label)
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
    
    void initialise(Chess3Settings settings){
        sections = new Chess3Section[6];
        IntStream.range(0, 6).forEach(i -> {
            String[] rowValues = gridReferences[i][0];
            String[] colValues = gridReferences[i][1];

            sections[i] = new Chess3Section(rowValues, colValues, this);
        });
        initializer.initialize(settings);
    }

    void wallify(){

        PieceFactory wallFactory = new PieceFactory(this, new Player("", "ELIMINATED"), new WallBehaviour());

        for (Chess3Section section : sections) {
            for (Square[] squareArr : section.squares) {
                for (Square square : squareArr) {
                    if (square.piece!=null){
                        if(square.piece.player.eliminated){
                            square.setPiece(wallFactory.createPiece(square.label));
                        }
                    }
                }
                
            }
            
        }
    }

    //----------------- clean code below -----------------------//

    void selectPiece(String label){
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



    void makeMove(Move move){
        checksManager.unmarkChecks();
        this.getSquareAt(move.to.label).setPiece(move.movedPiece);
        move.from.piece = null;
        if(move.movedPiece.symbol == ""){
            move.movedPiece.started = true;
        }
        checksManager.markChecks();
    }

    ArrayList<SquareForSending> getBoardState(){
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

    void eliminatePlayer(){
        
    }
    //--------------------------------------------------------//
    
}

