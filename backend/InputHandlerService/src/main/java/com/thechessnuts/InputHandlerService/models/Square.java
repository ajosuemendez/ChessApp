package com.thechessnuts.InputHandlerService.models;

public class Square {
    private String id;
    private String piece;
    private boolean isValid;

    public Square() {
    }

    public Square(String id, String piece, boolean isValid) {
        this.id = id;
        this.piece = piece;
        this.isValid = isValid;
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
}