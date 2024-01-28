package com.thechessnuts.gamehistoryservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thechessnuts.gamehistoryservice.models.Game;
import com.thechessnuts.gamehistoryservice.models.SquareForSending;
import com.thechessnuts.gamehistoryservice.repositories.GameRepository;

import java.util.Optional;
import java.util.Stack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Service
public class GameHistoryService implements IGameHistoryService {

    private final GameRepository gameRepository;

    public GameHistoryService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Override
    public Game addMove(String gameId, String move) {

        Optional<Game> requestedGame = gameRepository.findByGameId(gameId);

        if (!requestedGame.isPresent()) {
            return null;
        }

        Game game = requestedGame.get();

        initializeStacks(game);

        // Add the move to the history stack
        game.getHistory().push(move);

        // Clear the Undos Stack
        game.setUndos(new Stack<>());

        // Save the updated game
        gameRepository.save(game);

        return game;
    }

    @Override
    public Game undoMove(String gameId) {
        Optional<Game> requestedGame = gameRepository.findByGameId(gameId);

        if (!requestedGame.isPresent()) {
            return null;
        }

        Game game = requestedGame.get();

        initializeStacks(game);

        // Check if there are any moves done
        if (game.getHistory().size() == 0) {
            return null;
        }

        // Remove the last move and add it to the undo stack
        game.getUndos().add(game.getHistory().pop());

        // Save the updated game
        gameRepository.save(game);

        return game;
    }

    @Override
    public Game redoMove(String gameId) {
        Optional<Game> requestedGame = gameRepository.findByGameId(gameId);

        if (!requestedGame.isPresent()) {
            return null;
        }

        Game game = requestedGame.get();

        initializeStacks(game);

        // Check if there are any undos
        if (game.getUndos().size() == 0) {
            return null;
        }

        // Redo the last undo and add it back to the history stack
        game.getHistory().add(game.getUndos().pop());

        // Save the updated game
        gameRepository.save(game);

        return game;
    }

    private void initializeStacks(Game game) {
        if (game.getHistory() == null) {
            game.setHistory(new Stack<>());
        }
        if (game.getUndos() == null) {
            game.setUndos(new Stack<>());
        }
    }
}