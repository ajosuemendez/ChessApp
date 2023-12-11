package com.thechessnuts.InputHandlerService.models;

public class Square {
    private String id;
    private String piece;
    private boolean isValid;
    private CenterPosition centerPos;
    private String shape;

    public Square() {
    }

    public Square(String id, String piece, boolean isValid, CenterPosition centerPos, String shape) {
        this.id = id;
        this.piece = piece;
        this.isValid = isValid;
        this.centerPos = centerPos;
        this.shape = shape;
    }


    public String getId() {
        return this.id;
    }

    public String getPiece() {
        return this.piece;
    }

    public boolean getIsValid() {
        return this.isValid;
    }

    public CenterPosition getCenterPos() {
        return this.centerPos;
    }

    public String getShape() {
        return this.shape;
    }
}