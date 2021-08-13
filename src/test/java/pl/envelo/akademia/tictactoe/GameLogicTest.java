package pl.envelo.akademia.tictactoe;

import org.junit.jupiter.api.Test;
import pl.envelo.akademia.tictactoe.model.Board;
import pl.envelo.akademia.tictactoe.service.GameLogic;
import pl.envelo.akademia.tictactoe.utils.GameStatus;
import pl.envelo.akademia.tictactoe.utils.GameUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GameLogicTest {

    @Test
    void shouldInsertPlayerOneAtFirstRowAndFirstColumn() {
        Board testBoard = new Board();
        testBoard.createNewBoard(3);
        testBoard.getBoard()[1][1] = 1;

        Board board = new Board();
        board.createNewBoard(3);
        GameUtils.setBoard(board);
        GameLogic.makeMove(1, 1, true);
        assertEquals(testBoard.getBoard()[1][1], GameUtils.getGameBoardObject().getBoard()[1][1]);
    }

    @Test
    void shouldInsertPlayerTwoAtFirstRowAndFirstColumn() {
        Board testBoard = new Board();
        testBoard.createNewBoard(3);
        testBoard.getBoard()[1][1] = 2;

        Board board = new Board();
        board.createNewBoard(3);
        GameUtils.setBoard(board);
        GameLogic.makeMove(1, 1, false);
        assertEquals(testBoard.getBoard()[1][1], GameUtils.getGameBoardObject().getBoard()[1][1]);
    }

    @Test
    void shouldReturnWinForDiagonal(){
        Board board = new Board();
        board.createNewBoard(3);
        GameUtils.setBoard(board);
        GameLogic.makeMove(1, 1, true);
        GameLogic.makeMove(2, 2, true);
        GameLogic.makeMove(3, 3, true);
        assertEquals(GameStatus.WIN, GameLogic.checkIfWin(true));
    }

    @Test
    void shouldReturnWinForHorizontal() {
        Board board = new Board();
        board.createNewBoard(3);
        GameUtils.setBoard(board);
        GameLogic.makeMove(1, 1, true);
        GameLogic.makeMove(1, 2, true);
        GameLogic.makeMove(1, 3, true);
        assertEquals(GameStatus.WIN, GameLogic.checkIfWin(true));
    }

    @Test
    void shouldReturnWinForVertical() {
        Board board = new Board();
        board.createNewBoard(3);
        GameUtils.setBoard(board);
        GameLogic.makeMove(1, 1, true);
        GameLogic.makeMove(2, 1, true);
        GameLogic.makeMove(3, 1, true);
        assertEquals(GameStatus.WIN, GameLogic.checkIfWin(true));
    }

    @Test
    void shouldReturnDraw() {
        Board board = new Board();
        board.createNewBoard(3);
        GameUtils.setBoard(board);
        GameLogic.makeMove(1, 1, true);
        GameLogic.makeMove(1, 2, false);
        GameLogic.makeMove(1, 3, true);
        GameLogic.makeMove(2, 1, false);
        GameLogic.makeMove(2, 2, false);
        GameLogic.makeMove(2, 3, true);
        GameLogic.makeMove(3, 1, true);
        GameLogic.makeMove(3, 2, true);
        GameLogic.makeMove(3, 3, false);
        assertEquals(GameStatus.DRAW, GameLogic.checkIfWin(true));
    }
}