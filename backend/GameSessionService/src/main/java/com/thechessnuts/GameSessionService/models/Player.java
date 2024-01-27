package com.thechessnuts.gamesessionservice.models;

import java.io.Serializable;
/**
 * Class representing the player in the game
 */
class Player implements Serializable
{
    boolean eliminated;
    Piece king;
    String name;
    int clock;

    colors getColor() {
        return color;
    }

    enum colors
    {
        WHITE, BLACK, YELLOW, ELIMINATED
    }
    colors color;

    Player()
    {
        this.clock = 600;
        this.eliminated = false;
        this.king = null;
        this.color = colors.YELLOW;
    }

    Player(String name, String color)
    {
        this.king = null;
        this.clock = 600;
        this.eliminated = false;
        this.name = name;
        this.color = colors.valueOf(color);
    }

    /** Method setting the players name
     *  @param name name of player
     */
    void setName(String name)
    {
        this.name = name;
    }

    /** Method getting the players name
     *  @return name of player
     */
    String getName()
    {
        return this.name;
    }

    /** Method setting the players king
     *  @param king king of player
     */
    void setKing(Piece king){
        this.king = king;
    }

    void eliminate(){
        this.eliminated = true;
    }
}
