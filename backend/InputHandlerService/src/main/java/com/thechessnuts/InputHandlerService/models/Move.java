package com.thechessnuts.InputHandlerService.models;

class Move {
    Square from;
    Square to;
    Piece movedPiece;
    Piece takenPiece = null;
    Piece promotedTo = null;

    Move(Square from, Square to, Piece movedPiece, Piece takenPiece)
    {
        this.from = from;
        this.to = to;

        this.movedPiece = movedPiece;
        this.takenPiece = takenPiece;
    }

    Move(Square from, Square to, Piece movedPiece, Piece takenPiece, Piece promotedTo)
    {
        this.from = from;
        this.to = to;

        this.movedPiece = movedPiece;
        this.takenPiece = takenPiece;
        this.promotedTo = promotedTo;
    }

    protected Move(String moveString, AbstractChessBoard board){
        
        int separatorIndex = moveString.indexOf('-');
        int fromSquareStart = 0;
        if(Character.isUpperCase(moveString.charAt(0))){
            fromSquareStart = 1;
        }
        this.from = board.getSquareAt(moveString.substring(fromSquareStart, separatorIndex));
        
        int toSquareStart = separatorIndex+1;

        if(Character.isUpperCase(separatorIndex+1)){
            toSquareStart = separatorIndex + 2;
        }

        this.to = board.getSquareAt(moveString.substring(toSquareStart, moveString.length()));

        this.movedPiece = this.from.piece;
        this.takenPiece = this.to.piece;
    }
    
    @Override
    public String toString(){
        String ret = "";
        if(movedPiece!=null){
            ret+= movedPiece.getSymbol();
        }
        ret+= from.toString() + "-";

        if(promotedTo!=null){
            ret+= promotedTo.getSymbol();
        }
        ret+= to.toString();
        return ret;
    }

}
