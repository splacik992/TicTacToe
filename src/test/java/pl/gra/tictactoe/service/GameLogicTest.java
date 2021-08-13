package pl.gra.tictactoe.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.gra.tictactoe.model.Board;
import pl.gra.tictactoe.utils.GameStatus;
import pl.gra.tictactoe.utils.GameUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

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
        Assertions.assertEquals(testBoard.getBoard()[1][1], GameUtils.getGameBoardObject().getBoard()[1][1]);
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
        Assertions.assertEquals(testBoard.getBoard()[1][1], GameUtils.getGameBoardObject().getBoard()[1][1]);
    }

    @Test
    void shouldReturnFalseWhenPlayerTryToChooseTakenPoint() {
        Board board = new Board();
        board.createNewBoard(3);
        GameUtils.setBoard(board);
        GameLogic.makeMove(1, 1, true);

        assertFalse(GameLogic.makeMove(1, 1, true));
    }

    @Test
    void shouldReturnWinForLeftDiagonal(){
        Board board = new Board();
        board.createNewBoard(3);
        GameUtils.setBoard(board);
        GameLogic.makeMove(1, 1, true);
        GameLogic.makeMove(2, 2, true);
        GameLogic.makeMove(3, 3, true);
        Assertions.assertEquals(GameStatus.WIN, GameLogic.checkIfWin(true));
    }

    @Test
    void shouldReturnWinForRightDiagonal(){
        Board board = new Board();
        board.createNewBoard(3);
        GameUtils.setBoard(board);
        GameLogic.makeMove(1, 3, true);
        GameLogic.makeMove(2, 2, true);
        GameLogic.makeMove(3, 1, true);
        Assertions.assertEquals(GameStatus.WIN, GameLogic.checkIfWin(true));
    }

    @Test
    void shouldReturnWinForHorizontal() {
        Board board = new Board();
        board.createNewBoard(3);
        GameUtils.setBoard(board);
        GameLogic.makeMove(1, 1, true);
        GameLogic.makeMove(1, 2, true);
        GameLogic.makeMove(1, 3, true);
        Assertions.assertEquals(GameStatus.WIN, GameLogic.checkIfWin(true));
    }

    @Test
    void shouldReturnWinForVertical() {
        Board board = new Board();
        board.createNewBoard(3);
        GameUtils.setBoard(board);
        GameLogic.makeMove(1, 1, true);
        GameLogic.makeMove(2, 1, true);
        GameLogic.makeMove(3, 1, true);
        Assertions.assertEquals(GameStatus.WIN, GameLogic.checkIfWin(true));
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
        Assertions.assertEquals(GameStatus.DRAW, GameLogic.checkIfWin(true));
    }
}