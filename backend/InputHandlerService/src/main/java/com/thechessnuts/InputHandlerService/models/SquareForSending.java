package com.thechessnuts.InputHandlerService.models;

public class SquareForSending {
    private String id;
    private String piece;
    public boolean isValid;

    public SquareForSending() {
    }

    public SquareForSending(String id, String piece, boolean isValid) {
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

    public String toString(){
        String ret = "\n{"; 
        ret += "id: " + this.id;
        ret += ", piece: \"" + this.piece + "\"";
        ret += ", isValid: " + this.isValid +"}";

        return ret;
    }
}