package pl.gra.tictactoe.utils;

import pl.gra.tictactoe.model.Board;

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
