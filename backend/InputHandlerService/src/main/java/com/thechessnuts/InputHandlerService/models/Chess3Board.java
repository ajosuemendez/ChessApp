package com.thechessnuts.InputHandlerService.models;

import java.util.ArrayList;

public class Chess3Board {
    Chess3Section[] sections;
    Piece selectedPiece = null;

    public Chess3Board(){
     sections = new Chess3Section[6];

        sections[0] = new Chess3Section(
                new String[]{"4", "3", "2", "1"},
                new String[]{"d", "c", "b", "a"},
                this
        );

        sections[1] = new Chess3Section(
                new String[]{"e", "f", "g", "h"},
                new String[]{"4", "3", "2", "1"},
                this
        );

        sections[2] = new Chess3Section(
                new String[]{"9", "10", "11", "12"},
                new String[]{"e", "f", "g", "h"},
                this
        );

        sections[3] = new Chess3Section(
                new String[]{"i", "j", "k", "l"},
                new String[]{"9", "10", "11", "12"},
                this
        );

        sections[4] = new Chess3Section(
                new String[]{"5", "6", "7", "8"},
                new String[]{"i", "j", "k", "l"},
                this
        );

        sections[5] = new Chess3Section(
                new String[]{"d", "c", "b", "a"},
                new String[]{"5", "6", "7", "8"},
                this
        );
    }

    public boolean isSquareEmpty(String label)
    {
        if(this.findSquare(label) == null)
            return false;
        return this.findSquare(label).isEmpty();
    }


    public Square findSquare(String label){
        for(int i = 0; i<6; i++){
            if(this.sections[i].findSquare(label)!=null){
                return this.sections[i].findSquare(label);
            }
        }
        return null;
    }

    public void setPieces(Player player){
        int section1/*Queen's Side*/, section2/*King's Side*/;
        if(player.color == Player.colors.BLACK){
            section1 = 0;
            section2 = 1;
        }
        else if(player.color == Player.colors.WHITE){
            section1 = 2;
            section2 = 3;
        }
        else{
            section1 = 4;
            section2 = 5;
        }

        //PAWNS
        for(int i = 0; i<4;i++){
            this.sections[section1].squares[i][2].setPiece(new Pawn(this, player));
            this.sections[section2].squares[2][i].setPiece(new Pawn(this, player));
        }

        //ROOKS
        this.sections[section1].squares[3][3].setPiece(new Rook(this, player));
        this.sections[section2].squares[3][3].setPiece(new Rook(this, player));

        //KNIGHTS
        this.sections[section1].squares[2][3].setPiece(new Knight(this, player));
        this.sections[section2].squares[3][2].setPiece(new Knight(this, player));

        //BISHOPS
        this.sections[section1].squares[1][3].setPiece(new Bishop(this, player));
        this.sections[section2].squares[3][1].setPiece(new Bishop(this, player));

        //QUEEN
        this.sections[section1].squares[0][3].setPiece(new Queen(this, player));

        //KING
        this.sections[section2].squares[3][0].setPiece(new King(this, player));



    }

    public void print(){
        for(int i = 0; i<6; i++){
            System.out.println(sections[i]);
            System.out.println("\n");
        }
    }

    public void selectPiece(String label){
        if(this.selectedPiece!=null){
            this.selectedPiece.isSelected = false;
        }
        Square squareSelected = this.findSquare(label);
        if(squareSelected!=null){
            this.findSquare(label).piece.isSelected = true;
            this.selectedPiece = this.findSquare(label).piece;
        }
        else
            this.selectedPiece = null;
    }

    public Square squareAbove(Square square){
       char letter = square.label.charAt(0);
        int num = Integer.parseInt(square.label.substring(1));

        if(num == 1 || num == 8){
            return null;
        }

        if(num == 9){
            if(letter>='i'){
                 return this.findSquare(Character.toString(letter)+Integer.toString(5));
            }
            else{
                 return this.findSquare(Character.toString(letter)+Integer.toString(4));
            }
        }

        if(num < 8 && num >= 5){
            return this.findSquare(Character.toString(letter)+Integer.toString(num+1));
        }

        return this.findSquare(Character.toString(letter)+Integer.toString(num-1));
        

    }

    public Square squareBelow(Square square){
        char letter = square.label.charAt(0);
        int num = Integer.parseInt(square.label.substring(1));

        if(num>=9){
            return this.findSquare(Character.toString(letter)+Integer.toString(num+1));
        }

        if(num>5){
            return this.findSquare(Character.toString(letter)+Integer.toString(num-1));
        }

        if(num == 5){
            if(letter>='i'){
                return this.findSquare(Character.toString(letter)+"9");
            }
            return this.findSquare(Character.toString(letter)+"4");
        }

         if(num<4){
            return this.findSquare(Character.toString(letter)+Integer.toString(num+1));
        }

        if(num == 4){
            if(letter>='e'){
                return this.findSquare(Character.toString(letter)+"9");
            }
            return this.findSquare(Character.toString(letter)+"5");
        }

        return null;

    }

    public Square squareLeft(Square square){
        char letter = square.label.charAt(0);
        int num = Integer.parseInt(square.label.substring(1));

        if(letter == 'h')
            return null;

        if(letter == 'i'){
            if(num>=9){
                return this.findSquare("e"+Integer.toString(num));
            }
            else{
                return this.findSquare("d"+Integer.toString(num));
            }
        }

        if(letter>'i'){
            return this.findSquare(Character.toString(letter-1)+Integer.toString(num));
        }

        if(letter>='e'){
            return this.findSquare(Character.toString(letter+1)+Integer.toString(num));
        }

        if(num<=4){
            return this.findSquare(Character.toString(letter+1)+Integer.toString(num));
        }
        if(num>=5){
             return this.findSquare(Character.toString(letter-1)+Integer.toString(num));
        }

        
        return null;
        
    }

    public Square squareRight(Square square){
        char letter = square.label.charAt(0);
        int num = Integer.parseInt(square.label.substring(1));

        if(letter == 'l')
            return null;

        if(letter == 'e'){
            if(num>=9){
                return this.findSquare("i"+Integer.toString(num));
            }
            else{
                return this.findSquare("d"+Integer.toString(num));
            }
        }

        if(letter>='i'){
            return this.findSquare(Character.toString(letter+1)+Integer.toString(num));
        }

        if(letter>'e'){
            return this.findSquare(Character.toString(letter-1)+Integer.toString(num));
        }

        if(letter == 'd'){
            if(num>=5){
                return this.findSquare("i"+Integer.toString(num));
            }
        }

        if(num<=4){
            return this.findSquare(Character.toString(letter-1)+Integer.toString(num));
        }
        if(num>=5){
             return this.findSquare(Character.toString(letter+1)+Integer.toString(num));
        }

        
        return null;
    }

    public ArrayList<Square> topLeftDiagonal(Square square){
        ArrayList<Square> list = new ArrayList<>();
        if(square.label.equals("i9")){
            if(square.isEmpty() || square.piece.isSelected) {
                list.add(this.findSquare("e4"));
                if(this.findSquare("e4").isEmpty())
                    list.addAll(this.topLeftDiagonal(this.findSquare("e4")));
                list.add(this.findSquare("d5"));
                if(this.findSquare("d5").isEmpty())
                    list.addAll(this.topLeftDiagonal(this.findSquare("d5")));
            }
            return list;
        }
        Square above = this.squareAbove(square);
        if(above!=null) {
            Square topLeft = this.squareLeft(above);
            if(topLeft!= null){
                list.add(topLeft);
                if(topLeft.isEmpty()){
                    list.addAll(this.topLeftDiagonal(topLeft));
                }
            }
        }
        return list;
    }

    public ArrayList<Square> bottomLeftDiagonal(Square square){
        ArrayList<Square> list = new ArrayList<>();
        if(square.label.equals("d4")){
            if(square.isEmpty() || square.piece.isSelected) {
                list.add(this.findSquare("e9"));
                if(this.findSquare("e9").isEmpty())
                    list.addAll(this.bottomLeftDiagonal(this.findSquare("e9")));
                list.add(this.findSquare("i5"));
                if(this.findSquare("i5").isEmpty())
                    list.addAll(this.topRightDiagonal(this.findSquare("i5")));
            }
            return list;
        }
        if(square.label.equals("i5")){
            if(square.isEmpty() || square.piece.isSelected) {
                list.add(this.findSquare("e9"));
                if(this.findSquare("e9").isEmpty())
                    list.addAll(this.bottomLeftDiagonal(this.findSquare("e9")));
                list.add(this.findSquare("d4"));
                if(this.findSquare("d4").isEmpty())
                    list.addAll(this.topRightDiagonal(this.findSquare("d4")));
            }
            return list;
        }
        Square below = this.squareBelow(square);
        if(below!=null) {
            if(square.label.charAt(0)<='d' && (square.label.charAt(1)=='4' || square.label.charAt(1)=='5')){
                Square bottomLeft = this.squareRight(below);
                if(bottomLeft!=null){
                    list.add(bottomLeft);
                    if(bottomLeft.isEmpty())
                        list.addAll(this.topRightDiagonal(bottomLeft));
                }
                return list;
            }
            Square bottomLeft = this.squareLeft(below);
            if(bottomLeft!= null){
                list.add(bottomLeft);
                if(bottomLeft.isEmpty())
                    list.addAll(this.bottomLeftDiagonal(bottomLeft));
            }
            else{
                System.out.println("Square bottomLeft was null");
            }
        }
        return list;
    }

    public ArrayList<Square> topRightDiagonal(Square square){
        ArrayList<Square> list = new ArrayList<>();
        if(square.label.equals("e9")){
            if(square.isEmpty() || square.piece.isSelected){
                list.add(this.findSquare("d4"));
                if(this.findSquare("d4").isEmpty())
                    list.addAll(this.topRightDiagonal(this.findSquare("d4")));
                list.add(this.findSquare("i5"));
                if(this.findSquare("i5").isEmpty())
                    list.addAll(this.topRightDiagonal(this.findSquare("i5")));
            }
            return list; 
        }
        Square above = this.squareAbove(square);
        if(above!=null) {
            Square topRight = this.squareRight(above);
            if(topRight!= null){
                list.add(topRight);
                if(topRight.isEmpty())
                    list.addAll(this.topRightDiagonal(topRight));
            }
            else{
                System.out.println("Top right was null:" + above);
            }
        }
        return list;
    }

    public ArrayList<Square> bottomRightDiagonal(Square square){
        ArrayList<Square> list = new ArrayList<>();
        //working
        System.out.println("Attempted bottom RightDiagonal : " + square);
        if(square.label.equals("e4")){
            list.add(this.findSquare("i9"));
            if(this.findSquare("i9").isEmpty())
                list.addAll(this.bottomRightDiagonal(this.findSquare("i9")));
            list.add(this.findSquare("d5"));
            if(this.findSquare("d5").isEmpty())
                list.addAll(this.topLeftDiagonal(this.findSquare("d5")));
            return list;
        }
        if(square.label.equals("d5")){
            list.add(this.findSquare("i9"));
            if(this.findSquare("i9").isEmpty())
                list.addAll(this.bottomRightDiagonal(this.findSquare("i9")));
            list.add(this.findSquare("e4"));
            if(this.findSquare("e4").isEmpty())
                list.addAll(this.topLeftDiagonal(this.findSquare("e4")));
            return list;
        }
        Square below = this.squareBelow(square);
        if(below!=null) {
            if(square.label.charAt(0)<='d' && (square.label.charAt(1)=='4' || square.label.charAt(1)=='5')){
                Square bottomRight = this.squareLeft(below);
                if(bottomRight!=null) {
                    list.add(bottomRight);
                    if(bottomRight.isEmpty())
                        list.addAll(this.topLeftDiagonal(bottomRight));
                }
                return list;
            }
            Square bottomRight = this.squareRight(below);
            if(bottomRight!= null){
                list.add(bottomRight);
                if(bottomRight.isEmpty())
                    list.addAll(this.bottomRightDiagonal(bottomRight));
            }
        }
        return list;
    }

    public void makeMove(Move move){
        this.findSquare(move.to.label).setPiece(this.findSquare(move.from.label).piece);
        this.findSquare(move.from.label).piece = null;
        if(move.movedPiece.symbol == ""){
            move.movedPiece.started = true;
        }

    }

    public ArrayList<SquareForSending> getBoardState(){
        ArrayList<SquareForSending> list = new ArrayList<>();
        ArrayList<Square> selectList = new ArrayList<>();

        if(this.selectedPiece!=null){
            //selectList.add(this.selectedPiece.square);
            selectList.addAll(this.selectedPiece.allMoves());
        }

        for(int i = 0; i< 6; i++){
            list.addAll(this.sections[i].getSectionState(selectList));
        }

        return list;
    }

    


}

