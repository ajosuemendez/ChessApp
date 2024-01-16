package com.thechessnuts.InputHandlerService.models;

import java.io.Serializable;
/**
 * Class representing the player in the game
 */
public class Player implements Serializable
{

    String name;
    int clock;

    public colors getColor() {
        return color;
    }


    public boolean isGoDown() {
        return goDown;
    }

    enum colors
    {

        WHITE, BLACK, YELLOW
    }
    colors color;

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

}
