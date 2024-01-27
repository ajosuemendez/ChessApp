package com.example.apigatewayservice.models;

public class GameEntity extends BaseEntity {

    private String gameName;
    private int numberOfPlayers;

    public GameEntity() {}

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public void setNumberOfPlayers(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }
}