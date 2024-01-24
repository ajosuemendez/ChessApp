package com.thechessnuts.InputHandlerService.models;

public class SquareForSending {
    private String id;
    private String piece;
    public boolean isValid;
    public boolean isChecked;

    public SquareForSending() {
    }

    public SquareForSending(String id, String piece, boolean isValid, boolean isChecked) {
        this.id = id;
        this.piece = piece;
        this.isValid = isValid;
        this.isChecked = isChecked;
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