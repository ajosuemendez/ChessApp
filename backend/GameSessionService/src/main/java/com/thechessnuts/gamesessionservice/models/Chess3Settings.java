package com.thechessnuts.gamesessionservice.models;

public class Chess3Settings{
    Player playerWhite;
    Player playerBlack;
    Player playerYellow;

    public Chess3Settings(){
        this.playerWhite = new Player("", "WHITE");
        this.playerBlack = new Player("", "BLACK");
        this.playerYellow = new Player("", "YELLOW");
    }

    void setPlayers(String player1, String player2, String player3){
        this.playerWhite = new Player(player1, "WHITE");
        this.playerBlack = new Player(player2, "BLACK");
        this.playerYellow = new Player(player3, "YELLOW");
    }
}
