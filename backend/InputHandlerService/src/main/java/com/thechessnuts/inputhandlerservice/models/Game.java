package com.thechessnuts.inputhandlerservice.models;

import java.util.ArrayList;
import java.util.List;


public class Game {
    
    Chess3Settings settings;
     Chess3Board board;
     Player activePlayer;
     MoveHistory moveHistory;
     String id;

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

    void loadGame(MoveHistory moveHistory, Chess3Settings settings){
        this.settings = settings;
        this.moveHistory = moveHistory;
    }

    void saveGame(){
        String saveState = "";

        saveState += moveHistory.get() + "\n";
        saveState += settings.playerWhite.name + "\n" + settings.playerWhite.clock + "\n";
        saveState += settings.playerBlack.name + "\n" + settings.playerBlack.clock + "\n";
        saveState += settings.playerYellow.name + "\n" + settings.playerYellow.clock + "\n";

        System.out.println(saveState);
    }

    private void nextTurn(){
        if (activePlayer.color == Player.colors.WHITE){
            activePlayer = settings.playerBlack;
            if(settings.playerBlack.eliminated){
                activePlayer = settings.playerYellow;
            }
        }
        else if (activePlayer.color == Player.colors.BLACK){
            activePlayer = settings.playerYellow;
            if(settings.playerYellow.eliminated){
                activePlayer = settings.playerWhite;
            }
        }
        else{
            activePlayer = settings.playerWhite;
            if(settings.playerWhite.eliminated){
                activePlayer = settings.playerBlack;
            }
        }
    }

    private void previousTurn(){
        if (activePlayer.color == Player.colors.WHITE){
            activePlayer = settings.playerYellow;
            if(settings.playerYellow.eliminated){
                activePlayer = settings.playerBlack;
            }
        }
        else if (activePlayer.color == Player.colors.BLACK){
            activePlayer = settings.playerWhite;
            if(settings.playerWhite.eliminated){
                activePlayer = settings.playerYellow;
            }
        }
        else{
            activePlayer = settings.playerBlack;
            if(settings.playerBlack.eliminated){
                activePlayer = settings.playerWhite;
            }
        }
    }

    public void handleEvent(String label){
        if(board == null)
            return;

        if(label.equals("a6")){
            this.undoLastMove();
            this.saveGame();
            return;
        }

        if(label.equals("a7")){
            this.redoLastUndo();
            this.saveGame();
            return;
        }

        Square clickedSquare = this.board.getSquareAt(label);

        if(clickedSquare == null){
            this.saveGame();
            return;
        }

        if(clickedSquare.piece != null){
            if(clickedSquare.piece.player.color.equals(this.activePlayer.color)){
                this.board.selectPiece(label);
                this.saveGame();
                return;
            }
        }
       
        if(this.board.selectedPiece != null){
            if(this.board.selectedPiece.allMoves().contains(clickedSquare)){
                this.executeMove(new Move(this.board.selectedPiece.square, clickedSquare, this.board.selectedPiece, clickedSquare.piece));
            }
            this.board.selectPiece("");
            this.saveGame();
            return;
        }

    }

    void executeMove(Move move){

        this.moveHistory.add(move);

        if(move.to.piece!=null){
            if(move.to.piece.getSymbol().equals("K")){
                move.to.piece.player.eliminate();
                System.out.println("PLAYER " + move.to.piece.player.color + " WAS ELIMINATED!");
                this.board.wallify();
            }
        }

        this.board.makeMove(move);
        this.nextTurn();
    }

    private void undoLastMove(){
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

    private void redoLastUndo(){
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

    Chess3Settings getSettings() {
        return settings;
    }

    Chess3Board getBoard() {
        return board;
    }

    Player getActivePlayer() {
        return activePlayer;
    }

    MoveHistory getMoves() {
        return moveHistory;
    }

    String getId() {
        return id;
    }

     void setPlayers(Player player1, Player player2, Player player3){
        settings.playerWhite = player1;
        settings.playerBlack = player2;
        settings.playerYellow = player3;
    }

     void setSettings(){}
}
