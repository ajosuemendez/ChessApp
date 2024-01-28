package com.thechessnuts.gamehistoryservice.services;

import com.thechessnuts.gamehistoryservice.models.Game;
import com.thechessnuts.gamehistoryservice.repositories.GameRepository;
import com.thechessnuts.gamehistoryservice.services.GameHistoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class GameHistoryServiceTest {

    @InjectMocks
    private GameHistoryService gameHistoryService;

    @Mock
    private GameRepository gameRepository;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddMove() {
        String gameId = "game1";
        String move = "e4";

        Game game = new Game();
        game.setGameId(gameId);
        game.setHistory(new Stack<>());

        when(gameRepository.findByGameId(gameId)).thenReturn(Optional.of(game));

        Game result = gameHistoryService.addMove(gameId, move);

        verify(gameRepository, times(1)).findByGameId(gameId);
        verify(gameRepository, times(1)).save(game);

        assertEquals(gameId, result.getGameId());
        assertEquals(1, result.getHistory().size());
        assertEquals(move, result.getHistory().peek());
    }

    @Test
    public void testUndoMove() {
        String gameId = "game1";
        String move = "e4";

        Game game = new Game();
        game.setGameId(gameId);
        game.setHistory(new Stack<>());
        game.getHistory().push(move);

        when(gameRepository.findByGameId(gameId)).thenReturn(Optional.of(game));

        Game result = gameHistoryService.undoMove(gameId);

        verify(gameRepository, times(1)).findByGameId(gameId);
        verify(gameRepository, times(1)).save(game);

        assertEquals(gameId, result.getGameId());
        assertEquals(0, result.getHistory().size());
        assertEquals(1, result.getUndos().size());
        assertEquals(move, result.getUndos().peek());
    }

    @Test
    public void testRedoMove() {
        String gameId = "game1";
        String move = "e4";

        Game game = new Game();
        game.setGameId(gameId);
        game.setHistory(new Stack<>());
        game.setUndos(new Stack<>());
        game.getUndos().push(move);

        when(gameRepository.findByGameId(gameId)).thenReturn(Optional.of(game));

        Game result = gameHistoryService.redoMove(gameId);

        verify(gameRepository, times(1)).findByGameId(gameId);
        verify(gameRepository, times(1)).save(game);

        assertEquals(gameId, result.getGameId());
        assertEquals(1, result.getHistory().size());
        assertEquals(move, result.getHistory().peek());
        assertEquals(0, result.getUndos().size());
    }
}
