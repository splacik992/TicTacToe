package pl.envelo.akademia.tictactoe.utils;

import pl.envelo.akademia.tictactoe.model.Board;

public class GameUtils {
    public static boolean isGameActive;

    private static Board board;

    public static Board getGameBoardObject() {
        return board;
    }

    public static void setBoard(Board board) {
        GameUtils.board = board;
    }
}
