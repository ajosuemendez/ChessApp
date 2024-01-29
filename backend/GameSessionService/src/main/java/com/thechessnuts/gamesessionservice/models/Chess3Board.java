package com.thechessnuts.gamesessionservice.models;

import java.util.ArrayList;
import java.util.stream.IntStream;


class Chess3Board extends Board{

    static Chess3Navigation navigation = new Chess3Navigation();
    ChecksMarker checksMarker;
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
        super(Chess3Board.navigation);
        this.checksMarker = new ChecksMarker();
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

            sections[i] = new Chess3Section(rowValues, colValues);
        });
        Chess3Initializer.initialize(this, settings);
    }

    void markDeaths(){

        PieceFactory skullFactory = new PieceFactory(new Player("", "ELIMINATED"), new SkullBehaviour());

        for (Chess3Section section : sections) {
            for (Square[] squareArr : section.squares) {
                for (Square square : squareArr) {
                    if (square.piece!=null){
                        if(square.piece.player.eliminated){
                            square.setPiece(skullFactory.createPiece(this, square.label));
                        }
                    }
                }
                
            }
            
        }
    }

    //----------------- clean code below -----------------------//

    void selectSquare(String label){
        Square squareSelected = this.getSquareAt(label);
        if(squareSelected!=null){
            this.selectedSquare = this.getSquareAt(label);
        }
        else
            this.selectedSquare = null;
    }



    void makeMove(Move move){
        checksMarker.unmarkChecks(this);
        move.to.setPiece(move.movedPiece);
        move.from.setPiece(null);
        move.movedPiece.moveCounter++;
        move.movedPiece.started = true;
        if(move.movedPiece.getSymbol().equals("")){
            if(!Chess3Board.navigation.getSquaresAdjacent(this, move.from).containsValue(move.to)){
                move.movedPiece.moveCounter++;
            }
            if(move.movedPiece.moveCounter == 6){
                move.to.setPiece(new Piece(move.movedPiece.player, new MortyBehaviour()));
            }
        }
        checksMarker.markChecks(this);
    }

    ArrayList<SquareForSending> getBoardState(){
        ArrayList<SquareForSending> list = new ArrayList<>();
        ArrayList<Square> selectList = new ArrayList<>();

        if(this.selectedSquare!=null){
            //selectList.add(board.selectedPiece.square);
            selectList.addAll(this.getMoves());
        }

        for(int i = 0; i< 6; i++){
            list.addAll(this.sections[i].getSectionState(selectList));
        }

        return list;
    }

    void eliminatePlayer(){
        
    }
    //--------------------------------------------------------//

    @Override
    ArrayList<Square> getMoves() {
        ArrayList<Square> list = new ArrayList<Square>();
        Piece piece = selectedSquare.getPiece();
        if(piece==null){
            return list;
        }

        return piece.allMoves(this, selectedSquare);
    }

    ArrayList<Square> getMoves(Square square) {
        ArrayList<Square> list = new ArrayList<Square>();
        Piece piece = square.getPiece();
        if(piece==null){
            return list;
        }

        return piece.allMoves(this, square);
    }

    @Override
    BoardNavigation getNavigation(){
        return navigation;
    }
    
}

