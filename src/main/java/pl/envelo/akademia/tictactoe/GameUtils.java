package pl.envelo.akademia.tictactoe;

public class GameUtils {
    public static boolean isGameActive;
    private static Player player1;
   private static Player player2;
   private static Board board;


    public static Player getPlayer1() {
        return player1;
    }

    public static void setPlayer1(Player player1) {
        GameUtils.player1 = player1;
    }

    public static Player getPlayer2() {
        return player2;
    }

    public static void setPlayer2(Player player2) {
        GameUtils.player2 = player2;
    }

    public static Board getBoard() {
        return board;
    }

    public static void setBoard(Board board) {
        GameUtils.board = board;
    }
}
