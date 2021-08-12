package pl.envelo.akademia.tictactoe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {


    @Test
    void shouldThrowIllegalArgumentExceptionWhenBoardSizeIsLessThan3() {

        Board board = new Board();

        assertThrows(IllegalArgumentException.class, () -> board.createNewBoard(2));
    }

}