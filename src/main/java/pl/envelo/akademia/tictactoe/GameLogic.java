package pl.envelo.akademia.tictactoe;


public class GameLogic {

    private static int moveCouter = 0;

    public static boolean makeMove(int x, int y, boolean firstPlayer) {
        int[][] board = GameUtils.getGameBoardObject().getBoard();

        if (board[x][y] == 0) {
            int currentPlayer = firstPlayer ? 1 : 2;
            board[x][y] = currentPlayer;
            GameUtils.getGameBoardObject().setBoard(board);
            moveCouter++;
            return true;
        } else {
            return false;
        }
    }

    //zmian na actual player
    public static GameStatus checkIfWin(boolean firstPlayer) {
        int currentPlayer = firstPlayer ? 1 : 2;

        if (checkBiases(currentPlayer) ||
                checkHorizontal(currentPlayer) ||
                checkVertical(currentPlayer)) {
            return GameStatus.WIN;
        } else if (checkIfDraw()) {
            return GameStatus.DRAW;
        }

        return null;
    }

    private static boolean checkIfDraw() {
        int[][] board = GameUtils.getGameBoardObject().getBoard();

        return moveCouter == Math.pow(board.length - 1, 2);
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

    private static boolean checkBiases(int currentPlayer) {
        int[][] board = GameUtils.getGameBoardObject().getBoard();

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
