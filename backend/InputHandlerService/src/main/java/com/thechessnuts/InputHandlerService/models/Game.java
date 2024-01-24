package com.thechessnuts.InputHandlerService.models;

import java.util.ArrayList;
import java.util.List;

public class Game {
    
    public Chess3Settings settings;
    public Chess3Board board;
    public Player activePlayer;
    public MoveHistory moveHistory;
    public String id;
    private Chess3Initializer initializer;

    public Game(){
        this.moveHistory = new MoveHistory();
        this.board = new Chess3Board();
        this.settings = new Chess3Settings();
        this.id = "";
        if(settings.gameMode == Chess3Settings.gameModes.CLASSIC){
            this.initializer = new Chess3Initializer(this.board);
        }
    }

    public void newGame(){
        this.initializer.initialize(settings);
        activePlayer = settings.playerWhite;
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
        if(board == null)
            return;

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
       
        if(this.board.selectedPiece != null){
            if(this.board.selectedPiece.allMoves().contains(clickedSquare)){
                this.executeMove(new Move(this.board.selectedPiece.square, clickedSquare, this.board.selectedPiece, clickedSquare.piece));
            }
            this.board.selectPiece("");
            return;
        }
    }

    public void executeMove(Move move){
        this.moveHistory.add(move);
        if(move.to.piece!=null){
            if(move.to.piece.name.equals("king")){
                move.to.piece.player.eliminate();
            }
        }
        this.board.makeMove(move);
        this.nextTurn();
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

    public String getId() {
        return id;
    }

    public void setPlayers(Player player1, Player player2, Player player3){
        settings.playerWhite = player1;
        settings.playerBlack = player2;
        settings.playerYellow = player3;
    }

    public void setSettings(){}

    public void undoLastMove(){
        moveHistory.undoLastMove();
        List<String> currentMoves = this.moveHistory.get(); 

        board = new Chess3Board();
        this.initializer.initialize(settings);

        for(int i = 0; i<currentMoves.size(); i++){
            Move newMove = new Move(currentMoves.get(i), board);
            this.executeMove(newMove);
        }
    }

     public void redoLastUndo(){

        /*TODO : Implement function for redos */
    }


}
