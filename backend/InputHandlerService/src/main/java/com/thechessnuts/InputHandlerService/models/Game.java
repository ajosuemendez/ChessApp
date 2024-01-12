package com.thechessnuts.InputHandlerService.models;

import java.util.ArrayList;

public class Game {
    public Chess3Settings settings;
    public Chess3Board board;
    public Player activePlayer;
    //public GameClock gameClock;
    //public Client client;
    public MoveHistory moveHistory;
    public String gameID;

    public Game(){
        this.moveHistory = new MoveHistory();
        this.board = new Chess3Board();
        this.settings = new Chess3Settings();
        this.gameID = "";
    }

    public void newGame(){
        this.board.initialBoardSetup(settings);

        activePlayer = settings.playerWhite;
    }

    public void setPlayers(Player player1, Player player2, Player player3){
        settings.playerWhite = player1;
        settings.playerBlack = player2;
        settings.playerYellow = player3;
    }

    public void loadGame(MoveHistory moveHistory, Chess3Settings settings){
        this.settings = settings;
        this.moveHistory = moveHistory;
    }

    public void saveGame(){}

    public void nextTurn(){
        if (activePlayer.color == Player.colors.WHITE){
            activePlayer = settings.playerBlack;
        }
        else if (activePlayer.color == Player.colors.BLACK){
            activePlayer = settings.playerYellow;
        }
        else{
            activePlayer = settings.playerWhite;
        }
    }

    public void handleEvent(String label){
        Square clickedSquare = this.board.getSquareAt(label);

        if(clickedSquare == null){
            return;
        }

        if(clickedSquare.piece != null){
            if(clickedSquare.piece.player.color.equals(this.activePlayer.color)){
                this.board.selectPiece(label);
                return;
            }
        }
       
        if(this.board.selectedPiece!=null){
            if(this.board.selectedPiece.allMoves().contains(clickedSquare)){
                this.makeMove(new Move(this.board.selectedPiece.square, clickedSquare, this.board.selectedPiece, clickedSquare.piece));
            }
            this.board.selectPiece("");
        }

    }


    public void makeMove(Move move){
        this.moveHistory.add(move);
        this.board.makeMove(move);
        this.nextTurn();
        System.out.println(this.moveHistory.get());
    }

    public ArrayList<SquareForSending> getBoardState(){
        return board.getBoardState();
    }

    public Chess3Settings getSettings() {
        return settings;
    }

    public Chess3Board getBoard() {
        return board;
    }

    public Player getActivePlayer() {
        return activePlayer;
    }

    public MoveHistory getMoves() {
        return moveHistory;
    }

    public String getGameID() {
        return gameID;
    }

    public void undoLastMove(){

        /*TODO : Implement function for undos */
    }

     public void redoLastUndo(){

        /*TODO : Implement function for redos */
    }


}
