package com.thechessnuts.InputHandlerService.models;

public class Settings {
    public Player playerWhite;
    public Player playerBlack;
    public Player playerYellow;
    public gameModes gameMode;
    //public GameClock gameClock;
    //public Client client;

    public enum gameModes{
        loadGame, newGame
    }

    public Settings(){
        this.playerWhite = new Player("", "WHITE");
        this.playerBlack = new Player("", "BLACK");
        this.playerYellow = new Player("", "YELLOW");

        this.gameMode = gameModes.newGame;
    }

}
