package com.thechessnuts.InputHandlerService.models;

public abstract class AbstractChess3Initializer {
    Chess3Board board;

    AbstractChess3Initializer(Chess3Board board){
        this.board = board;
    }

    abstract void initialize(Chess3Settings settings);

}
