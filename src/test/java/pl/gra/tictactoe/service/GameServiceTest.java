package pl.gra.tictactoe.service;

import org.junit.jupiter.api.Test;
import pl.gra.tictactoe.model.Board;
import pl.gra.tictactoe.utils.GameUtils;

import static org.junit.jupiter.api.Assertions.*;

class GameServiceTest {

    @Test
    void shouldReturnFalseForInputBiggerThanBoardSize() {
        Board board = new Board();
        board.createNewBoard(3);
        GameUtils.setBoard(board);
        assertFalse(GameService.tryToMakeMove("1", "12"));
    }

    @Test
    void shouldReturnTrueForCorrectInput() {
        Board board = new Board();
        board.createNewBoard(3);
        GameUtils.setBoard(board);
        assertTrue(GameService.tryToMakeMove("1", "1"));
    }
}