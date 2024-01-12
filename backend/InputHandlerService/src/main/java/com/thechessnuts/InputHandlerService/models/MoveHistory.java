package com.thechessnuts.InputHandlerService.models;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class MoveHistory{

    private Stack<String> history = new Stack<String>();
    private Stack<String> undos = new Stack<String>();

    public void add(Move move){
        history.add(move.toString());
        undos.clear();
    }

    public List<String> get(){
        return Arrays.asList(history.toArray(new String[0]));
    }

    public void undoLastMove(){
        undos.add(history.pop());
    }

    public void redoLastUndo(){
        history.add(undos.pop());
    }
}
