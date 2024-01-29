package com.thechessnuts.gamesessionservice.models;

import org.springframework.web.client.RestTemplate;

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
        this.newGame();
    }

    public void newGame(){
        activePlayer = settings.playerWhite;
        this.board.initialise(settings);
    }

    public void loadGame(MoveHistory moveHistory, Chess3Settings settings){
        this.settings = settings;
        this.moveHistory = moveHistory;
        activePlayer = settings.playerWhite;
        this.board = new Chess3Board();
        this.board.initialise(settings);

        for(int i = 0; i<moveHistory.get().size(); i++){
            Move newMove = new Move(moveHistory.get().get(i), board);
            try{this.executeMove(newMove);}
            catch(Exception e){
                this.board.makeMove(newMove);
                System.out.println("Last move was weirdl loaded");
            }
            this.nextTurn();
        }

        board.checksMarker.markChecks(board);
    }

    void saveGame(){
        String saveState = "";

        saveState += moveHistory.get() + "\n";
        saveState += settings.playerWhite.name + "\n";
        saveState += settings.playerBlack.name + "\n";
        saveState += settings.playerYellow.name + "\n";

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

    public boolean handleEvent(String label, String gameId, RestTemplate restTemplate){
        if(board == null)
            return false;

        if(label.equals("a6")){
            this.undoLastMove();
            this.saveGame();
            return false;
        }

        if(label.equals("a7")){
            this.redoLastUndo();
            this.saveGame();
            return false;
        }

        Square clickedSquare = this.board.getSquareAt(label);

        if(clickedSquare == null){
            this.saveGame();
            return false; 
        }

        if(clickedSquare.piece != null){
            if(clickedSquare.piece.player.color.equals(this.activePlayer.color)){
                this.board.selectSquare(label);
                this.saveGame();
                return false;
            }
        }
       
        if(this.board.selectedSquare != null){
            System.out.println("Is this board selected square?");
            if(this.board.selectedSquare.getPiece().allMoves(board, board.selectedSquare).contains(clickedSquare)){
                Move moveToExecute = new Move(this.board.selectedSquare, clickedSquare, this.board.selectedSquare.getPiece(), clickedSquare.piece);

                // Save-Send the Move to the History Game
                GameEntity res = restTemplate.getForObject("http://game-history-service/" + gameId + "/add/" + moveToExecute.toString(), GameEntity.class);
                // System.out.println(moveToExecute.toString());
                // System.out.println(res);
                System.out.println("This is the response from the Game History Service");
                System.out.println(res.toString());

    
            }
            this.board.selectSquare("");
            return true;
        }

        return false;
    }

    void executeMove(Move move){

        this.moveHistory.add(move);

        if(move.to.piece!=null){
            if(move.to.piece.getSymbol().equals("K")){
                move.to.piece.player.eliminate();
                System.out.println("PLAYER " + move.to.piece.player.color + " WAS ELIMINATED!");
                this.board.markDeaths();
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

        board.checksMarker.markChecks(board);
    }

    private void redoLastUndo(){
        board.checksMarker.unmarkChecks(board);
        boolean successfulRedo = moveHistory.redoLastUndo();
        
        if(successfulRedo){
            Move newMove = new Move(moveHistory.get().get(moveHistory.get().size()-1), board);
            this.board.makeMove(newMove);
            this.nextTurn();
        }

        board.checksMarker.markChecks(board);
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
