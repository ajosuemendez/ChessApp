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

    public boolean undoLastMove(){
        if(history.size() == 0)
            return false;
        undos.add(history.pop());
        return true;
        
    }

    public boolean redoLastUndo(){
        if(undos.size() == 0)
            return false;
        history.add(undos.pop());
        return true;
    }
}
