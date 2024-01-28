package com.example.apigatewayservice.models;

import java.util.List;

public class Game {

    private String id;
    private String gameId;
    private String password;
    private String activePlayer;
    private List<SquareForSending> boardState;

    public Game() {}

    public Game(String gameId, String password, String activePlayer) {
        this.gameId = gameId;
        this.password = password;
        this.activePlayer = activePlayer;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getActivePlayer() {
        return activePlayer;
    }

    public void setActivePlayer(String activePlayer) {
        this.activePlayer = activePlayer;
    }

    public List<SquareForSending> getBoardState() {
        return boardState;
    }

    public void setBoardState(List<SquareForSending> boardState) {
        this.boardState = boardState;
    }
}
