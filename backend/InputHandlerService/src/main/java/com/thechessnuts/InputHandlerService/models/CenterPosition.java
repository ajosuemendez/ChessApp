package com.thechessnuts.InputHandlerService.models;

public class CenterPosition {
    private int x;
    private int y;

    public CenterPosition() {
    }

    public CenterPosition(int x, int y) {
        this.x = x;
        this.y = y;
        
    }


    public int getx() {
        return this.x;
    }

    public int gety() {
        return this.y;
    }
}