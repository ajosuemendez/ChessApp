package com.thechessnuts.InputHandlerService.models;

import java.io.Serializable;
/**
 * Class representing the player in the game
 */
public class Player implements Serializable
{

    String name;

    public colors getColor() {
        return color;
    }

    public playerTypes getPlayerType() {
        return playerType;
    }

    public boolean isGoDown() {
        return goDown;
    }

    enum colors
    {

        WHITE, BLACK, YELLOW
    }
    colors color;

    public enum playerTypes
    {

        localUser, networkUser, computer
    }
    public playerTypes playerType;
    boolean goDown;

    public Player()
    {
        this.color = colors.YELLOW;
    }

    public Player(String name, String color)
    {
        this.name = name;
        this.color = colors.valueOf(color);
        this.goDown = false;
    }

    /** Method setting the players name
     *  @param name name of player
     */
    public void setName(String name)
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

    /** Method setting the players type
     *  @param type type of player - enumerate
     */
    public void setType(playerTypes type)
    {
        this.playerType = type;
    }
}
