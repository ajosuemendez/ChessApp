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

    public void setPlayers(Player player1, Player player2, Player player3){
        this.playerWhite = player1;
        this.playerBlack = player2;
        this.playerYellow = player3;
    }
}
