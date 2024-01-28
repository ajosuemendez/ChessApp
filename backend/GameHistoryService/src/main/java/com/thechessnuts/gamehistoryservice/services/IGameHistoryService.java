package com.thechessnuts.gamehistoryservice.services;

import org.springframework.stereotype.Service;

import com.thechessnuts.gamehistoryservice.models.Game;

@Service
public interface IGameHistoryService {
    Game addMove(String gameId, String move);
    Game undoMove(String gameId);
    Game redoMove(String gameId);
}