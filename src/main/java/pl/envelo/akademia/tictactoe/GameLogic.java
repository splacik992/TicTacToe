package pl.envelo.akademia.tictactoe;
//sprawdzanie wygranej np wykonanie ruchow
public class GameLogic {

    public static boolean makeMove(int x, int y, boolean firstPlayer) {
        int[][] board = GameUtils.getBoard().getBoard();

        if (board[x][y] == 0) {
            int currentPlayer = firstPlayer ? 1 : 2;
            board[x][y] = currentPlayer;
            GameUtils.getBoard().setBoard(board);
            return true;
        } else {
            return false;
        }
    }

    public static boolean checkIfWin(boolean firstPlayer) {
        int currentPlayer = firstPlayer ? 1 : 2;

        return checkBiases(currentPlayer) ||
                checkHorizontal(currentPlayer) ||
                checkVertical(currentPlayer);
    }

    private static boolean checkVertical(int currentPlayer) {
        int[][] board = GameUtils.getBoard().getBoard();

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
        int[][] board = GameUtils.getBoard().getBoard();

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

    private static boolean checkBiases(int currentPlayer) {
        int[][] board = GameUtils.getBoard().getBoard();

        int leftBias = 0;
        int rightBias = 0;

        for (int i = 1; i < board.length; i++) {
            if (board[i][i] == currentPlayer) {
                ++leftBias;
            }
            if (board[board.length - i][i] == currentPlayer) {
                ++rightBias;
            }
        }

        return rightBias == board.length - 1 || leftBias == board.length - 1;
    }
}
