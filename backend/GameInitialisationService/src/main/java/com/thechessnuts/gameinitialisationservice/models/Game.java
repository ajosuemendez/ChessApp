package com.thechessnuts.gameinitialisationservice.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Stack;

@Document(collection = "games")
public class Game {
    @Id
    private String id;
    private String gameId;
    private String password;
    private String activePlayer;
    private List<SquareForSending> boardState;
    private Stack<String> history;
    private Stack<String> undos;

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

    public Stack<String> getHistory() {
        return history;
    }

    public void setHistory(Stack<String> history) {
        this.history = history;
    }

    public Stack<String> getUndos() {
        return undos;
    }

    public void setUndos(Stack<String> undos) {
        this.undos = undos;
    }
}
