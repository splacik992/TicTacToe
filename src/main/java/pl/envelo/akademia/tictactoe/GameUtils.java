package pl.envelo.akademia.tictactoe;

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
