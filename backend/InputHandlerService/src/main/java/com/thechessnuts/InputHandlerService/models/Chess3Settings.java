package com.thechessnuts.InputHandlerService.models;

public class Chess3Settings{
    public Player playerWhite;
    public Player playerBlack;
    public Player playerYellow;

    public gameModes gameMode;

    public enum gameModes{
        CLASSIC, REVOLUTION, VICTORIAN
    }

    public Chess3Settings(){
        this.playerWhite = new Player("", "WHITE");
        this.playerBlack = new Player("", "BLACK");
        this.playerYellow = new Player("", "YELLOW");

        this.gameMode = gameModes.CLASSIC;
    }
}
