package com.thechessnuts.gamehistoryservice.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

@Document(collection = "gameHistories")
public class History{
    @Id
    private String id;
    private String gameId;
    private List<String> history;
    private List<String> undos;

    public History(String gameId) {
        this.gameId = gameId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String id) {
        this.id = id;
    }

    public List<String> getHistory() {
        return history;
    }

    public void setHistory(List<String> history) {
        this.history = history;
    }

    public List<String> getUndos() {
        return undos;
    }

    public void setUndos(List<String> undos) {
        this.undos = undos;
    }

    // void add(Move move){
    //     history.add(move.toString());
    //     undos.clear();
    // }

    // List<String> get(){
    //     return Arrays.asList(history.toArray(new String[0]));
    // }

    // boolean undoLastMove(){
    //     if(history.size() == 0)
    //         return false;
    //     undos.add(history.pop());
    //     return true;
        
    // }

    // boolean redoLastUndo(){
    //     if(undos.size() == 0)
    //         return false;
    //     history.add(undos.pop());
    //     return true;
    // }
}
