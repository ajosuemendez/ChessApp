package com.thechessnuts.InputHandlerService.models;

class SquareForSending {
    private String id;
    private String piece;
    boolean isValid;
    boolean isChecked;

    SquareForSending() {
    }

    SquareForSending(String id, String piece, boolean isValid, boolean isChecked) {
        this.id = id;
        this.piece = piece;
        this.isValid = isValid;
        this.isChecked = isChecked;
    }


    String getId() {
        return this.id;
    }

    String getPiece() {
        return this.piece;
    }

    boolean getIsValid() {
        return this.isValid;
    }

    @Override
    public String toString(){
        String ret = "\n{"; 
        ret += "id: " + this.id;
        ret += ", piece: \"" + this.piece + "\"";
        ret += ", isValid: " + this.isValid +"}";

        return ret;
    }
}