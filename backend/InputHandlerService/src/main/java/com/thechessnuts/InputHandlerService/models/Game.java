package com.thechessnuts.InputHandlerService.models;

import java.util.ArrayList;
import java.util.List;


public class Game {
    
    public Chess3Settings settings;
    public Chess3Board board;
    public Player activePlayer;
    public MoveHistory moveHistory;
    public String id;

    public Game(){
        this.moveHistory = new MoveHistory();
        this.board = new Chess3Board();
        this.settings = new Chess3Settings();
        this.id = "";
    }

    public void newGame(){
        activePlayer = settings.playerWhite;
        this.board.initialise(settings);
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

    public void previousTurn(){
        if (activePlayer.color == Player.colors.WHITE){
            activePlayer = settings.playerYellow;
        }
        else if (activePlayer.color == Player.colors.BLACK){
            activePlayer = settings.playerWhite;
        }
        else{
            activePlayer = settings.playerBlack;
        }
    }

    public void handleEvent(String label){
        if(board == null)
            return;

        if(label.equals("a6")){
            this.undoLastMove();
            System.out.println(this.moveHistory.get());
            return;
        }
        if(label.equals("a7")){
            this.redoLastUndo();
            System.out.println(this.moveHistory.get());
            return;
        }
        Square clickedSquare = this.board.getSquareAt(label);

        if(clickedSquare == null){
            System.out.println(this.moveHistory.get());
            return;
        }

        if(clickedSquare.piece != null){
            if(clickedSquare.piece.player.color.equals(this.activePlayer.color)){
                this.board.selectPiece(label);
                System.out.println(this.moveHistory.get());
                return;
            }
        }
       
        if(this.board.selectedPiece != null){
            if(this.board.selectedPiece.allMoves().contains(clickedSquare)){
                this.executeMove(new Move(this.board.selectedPiece.square, clickedSquare, this.board.selectedPiece, clickedSquare.piece));
            }
            this.board.selectPiece("");
            System.out.println(this.moveHistory.get());
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

    public void undoLastMove(){
        boolean successfulUndo  = moveHistory.undoLastMove();

        if(successfulUndo){
            List<String> currentMoves = this.moveHistory.get(); 

            board = new Chess3Board();
            this.board.initialise(settings);

            for(int i = 0; i<currentMoves.size(); i++){
                Move newMove = new Move(currentMoves.get(i), board);
                this.board.makeMove(newMove);
            }
            this.previousTurn();
        }

        board.checksManager.markChecks();
    }

     public void redoLastUndo(){
        board.checksManager.unmarkChecks();
        boolean successfulRedo = moveHistory.redoLastUndo();
        
        if(successfulRedo){
            Move newMove = new Move(moveHistory.get().get(moveHistory.get().size()-1), board);
            this.board.makeMove(newMove);
            this.nextTurn();
        }

        board.checksManager.markChecks();
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
}
