package pl.gra.tictactoe.service;

import org.apache.commons.lang3.StringUtils;
import pl.gra.tictactoe.model.Board;
import pl.gra.tictactoe.utils.GameStatus;
import pl.gra.tictactoe.utils.GameUtils;
import pl.gra.tictactoe.utils.MessageUtils;

import java.util.Scanner;

public class GameService {

    private static boolean firstPlayer = true;
    private static Scanner scanner = new Scanner(System.in);

    public static void run() {
        while (true) {
            System.out.println("""
                    Wybierz:\s
                    1. Rozpocznij gre\s
                    0. Zakończ gre""");

            switch (scanner.next()) {
                case "1" -> runGame();
                case "0" -> {
                    System.out.println("Dzięki za gre :)");
                    scanner.close();
                    System.exit(0);
                }
                default -> System.out.println("Podana opcja nie istnieje");
            }
        }
    }

    private static void runGame() {
        selectBoard();
        GameUtils.isGameActive = true;
        System.out.println("Powodzenia!");
        while (true) {
            if (GameUtils.isGameActive) {
                playRound();
            } else {
                break;
            }
        }
    }

    private static void selectBoard() {
        while (true) {
            System.out.println("Podaj rozmiar planszy (rekomendowana 3-5):");
            String choice = scanner.next();
            if (StringUtils.isNumeric(choice)) {
                if (Integer.parseInt(choice) <= 2) {
                    System.out.println(MessageUtils.INVALID_INPUT_SIZE);
                } else {
                    createBoard(choice);
                    break;
                }
            } else {
                System.out.println(MessageUtils.INVALID_INPUT_SIZE);
            }
        }
    }

    private static void createBoard(String n) {
        int size = Integer.parseInt(n);
        GameUtils.setBoard(new Board());
        GameUtils.getGameBoardObject().createNewBoard(size);
    }

    private static void playRound() {
        printGameBoard();
        System.out.println("Ruch gracza: " + (firstPlayer ? "X" : "O"));
        playerMove();
    }

    private static void playerMove() {
        while (true) {
            scanner = new Scanner(System.in);

            System.out.println("Podaj wspolrzedna Y:");
            String x = scanner.next();

            System.out.println("Podaj wspolrzedna X:");
            String y = scanner.next();

            if (StringUtils.isNumeric(x) && StringUtils.isNumeric(y)) {
                if (tryToMakeMove(x, y)) {
                    break;
                }
            } else {
                System.out.println(MessageUtils.INVALID_COORDINATES);
            }
        }
    }

    private static boolean tryToMakeMove(String x, String y) {
        if (Integer.parseInt(x) > GameUtils.getGameBoardObject().getBoard().length - 1 ||
                Integer.parseInt(y) > GameUtils.getGameBoardObject().getBoard().length - 1
                || Integer.parseInt(x) < 1 || Integer.parseInt(y) < 1) {
            System.out.println(MessageUtils.COORDINATES_OUT_OF_RANGE);
        } else {
            if (GameLogic.makeMove(Integer.parseInt(x), Integer.parseInt(y), firstPlayer)) {
                return checkGameStatus();
            } else {
                System.out.println(MessageUtils.THE_FIELD_IS_OCCUPIED);
            }
        }
        return false;
    }

    private static boolean checkGameStatus() {
        GameStatus status = GameLogic.checkIfWin(firstPlayer);
        if (status == GameStatus.WIN) {
            printGameBoard();
            GameUtils.isGameActive = false;
            System.out.println("Wygrał gracz " + (firstPlayer ? "X" : "O"));
        } else if (status == GameStatus.DRAW) {
            printGameBoard();
            GameUtils.isGameActive = false;
            System.out.println("REMIS");
        }
        firstPlayer = !firstPlayer;
        return true;
    }

    private static void printGameBoard() {
        GameUtils.getGameBoardObject().printBoard();
    }
}
