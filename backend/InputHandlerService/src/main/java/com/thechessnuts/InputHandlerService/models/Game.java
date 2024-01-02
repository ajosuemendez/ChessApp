package com.thechessnuts.InputHandlerService.models;

import java.util.ArrayList;

public class Game {
    public Settings settings;
    public Chess3Board board;
    public Player activePlayer;
    //public GameClock gameClock;
    //public Client client;
    public Moves moves;
    public String gameID;
    //public Chat chat;

    public Game(){
        this.moves = new Moves(this);
        this.board = new Chess3Board();
        this.settings = new Settings();
        this.gameID = "";
    }

    public void newGame(){
        this.board.setPieces(settings.playerWhite);
        this.board.setPieces(settings.playerBlack);
        this.board.setPieces(settings.playerYellow);
        activePlayer = settings.playerWhite;
    }

    public void setPlayers(Player player1, Player player2, Player player3){
        settings.playerWhite = player1;
        settings.playerBlack = player2;
        settings.playerYellow = player3;
    }

    public void loadGame(Moves moves, Settings settings){
        this.settings = settings;
        this.moves = moves;
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
        Square clickedSquare = this.board.findSquare(label);

        if(clickedSquare == null){
            return;
        }

        if(clickedSquare.piece != null){
            //if(clickedSquare.piece.player.color.equals(this.activePlayer.color)){
                this.board.selectPiece(label);
                return;
            //}
        }
       
        if(this.board.selectedPiece!=null){
            if(this.board.selectedPiece.allMoves().contains(clickedSquare)){
                System.out.println("was here");
                this.makeMove(new Move(this.board.selectedPiece.square, clickedSquare, this.board.selectedPiece, clickedSquare.piece));
            }
            this.board.selectPiece("");
        }

        //if(clickedSquare.piece)
    }


    public void makeMove(Move move){
        this.moves.add(move);
        this.board.makeMove(move);
        this.nextTurn();
    }

    public ArrayList<SquareForSending> getBoardState(){
        return board.getBoardState();
    }

    public Settings getSettings() {
        return settings;
    }

    public Chess3Board getBoard() {
        return board;
    }

    public Player getActivePlayer() {
        return activePlayer;
    }

    public Moves getMoves() {
        return moves;
    }

    public String getGameID() {
        return gameID;
    }
}
