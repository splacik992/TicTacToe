package pl.gra.tictactoe.service;

import pl.gra.tictactoe.utils.GameStatus;
import pl.gra.tictactoe.utils.GameUtils;

public class GameLogic {

    private static int moveCounter = 0;

    public static boolean makeMove(int x, int y, boolean firstPlayer) {
        int[][] board = GameUtils.getGameBoardObject().getBoard();

        if (board[x][y] == 0) {
            int currentPlayer = firstPlayer ? 1 : 2;
            board[x][y] = currentPlayer;
            GameUtils.getGameBoardObject().setBoard(board);
            ++moveCounter;
            return true;
        } else {
            return false;
        }
    }

    public static GameStatus checkIfWin(boolean firstPlayer) {
        int currentPlayer = firstPlayer ? 1 : 2;

        if (checkDiagonals(currentPlayer) ||
                checkHorizontal(currentPlayer) ||
                checkVertical(currentPlayer)) {
            moveCounter = 0;
            return GameStatus.WIN;
        } else if (checkIfDraw()) {
            moveCounter = 0;
            return GameStatus.DRAW;
        }

        return null;
    }

    private static boolean checkIfDraw() {
        int[][] board = GameUtils.getGameBoardObject().getBoard();

        return moveCounter == Math.pow(board.length - 1, 2);
    }

    private static boolean checkVertical(int currentPlayer) {
        int[][] board = GameUtils.getGameBoardObject().getBoard();

        int counter = 0;

        for (int i = 1; i < board.length; i++) {
            for (int j = 1; j < board.length; j++) {
                if (board[j][i] == currentPlayer) {
                    ++counter;
                }
            }
            if (counter == board.length - 1) {
                return true;
            }
            counter = 0;
        }

        return false;
    }

    private static boolean checkHorizontal(int currentPlayer) {
        int[][] board = GameUtils.getGameBoardObject().getBoard();

        int counter = 0;

        for (int i = 1; i < board.length; i++) {
            for (int j = 1; j < board.length; j++) {
                if (board[i][j] == currentPlayer) {
                    ++counter;
                }
            }
            if (counter == board.length - 1) {
                return true;
            }
            counter = 0;
        }
        return false;
    }

    private static boolean checkDiagonals(int currentPlayer) {
        int[][] board = GameUtils.getGameBoardObject().getBoard();

        int leftDiagonal = 0;
        int rightDiagonal = 0;

        for (int i = 1; i < board.length; i++) {
            if (board[i][i] == currentPlayer) {
                ++leftDiagonal;
            }
            if (board[board.length - i][i] == currentPlayer) {
                ++rightDiagonal;
            }
        }

        return rightDiagonal == board.length - 1 || leftDiagonal == board.length - 1;
    }
}
