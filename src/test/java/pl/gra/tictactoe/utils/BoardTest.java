package pl.gra.tictactoe.utils;

import org.junit.jupiter.api.Test;
import pl.gra.tictactoe.model.Board;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @Test
    void shouldCreateNewBoard() {
        Board board = new Board();
        board.createNewBoard(5);

        int sizeOfTable = board.getBoard().length;

        assertEquals(6, sizeOfTable);
    }

}