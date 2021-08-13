package pl.envelo.akademia.tictactoe;

import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;

public class GameService {
    private static boolean firstPlayer = true;

    public static void run() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Wybierz: \n" +
                    "1. Rozpocznij gre \n" +
                    "0. Zakończ gre");
            String choice = scanner.next();
            switch (choice) {
                case "1":
                    modeWithTwoPlayers(scanner);
                    GameUtils.isGameActive = true;
                    System.out.println("Powodzenia!");
                    while (true) {
                        if (GameUtils.isGameActive) {
                            printGameBoard();
                            System.out.println("Ruch gracza: " + (firstPlayer ? "X" : "O"));
                            playerMove(scanner);
                        } else {
                            break;
                        }
                    }
                    break;
                case "0":
                    System.exit(0);
                    System.out.println("Dzięki za gre :)");
                default:
                    System.out.println("Podana opcja nie istnieje");
            }
        }
    }

    private static void playerMove(Scanner scanner) {
        while (true) {
            System.out.println("Podaj wspolrzedna Y:");
            String x = scanner.next();

            System.out.println("Podaj wspolrzedna X:");
            String y = scanner.next();

            if (StringUtils.isNumeric(x) && StringUtils.isNumeric(y)) {
                if (Integer.parseInt(x) > GameUtils.getGameBoardObject().getBoard().length - 1 ||
                        Integer.parseInt(y) > GameUtils.getGameBoardObject().getBoard().length - 1
                        || Integer.parseInt(x) < 1 || Integer.parseInt(y) < 1) {
                    System.out.println(MessageUtils.COORDINATES_OUT_OF_RANGE);
                } else {
                    if (GameLogic.makeMove(Integer.parseInt(x), Integer.parseInt(y), firstPlayer)) {
                        GameStatus status = GameLogic.checkIfWin(firstPlayer);
                        if (status == GameStatus.WIN) {
                            GameUtils.isGameActive = false;
                            System.out.println("Wygrał gracz " + (firstPlayer ? "X" : "O"));
                        } else if (status == GameStatus.DRAW) {
                            GameUtils.isGameActive = false;
                            System.out.println("REMIS");
                        }
                        firstPlayer = !firstPlayer;
                        break;

                    } else {
                        System.out.println(MessageUtils.THE_FIELD_IS_OCCUPIED);
                    }
                }
            } else {
                System.out.println(MessageUtils.INVALID_COORDINATES);
            }
        }
    }

    private static void printGameBoard() {
        GameUtils.getGameBoardObject().printBoard();
    }

    private static void createBoard(String n) {
        try {
            int size = Integer.parseInt(n);
            GameUtils.setBoard(new Board());
            GameUtils.getGameBoardObject().createNewBoard(size);

        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(MessageUtils.INVALID_INPUT_SIZE);
        }
    }

    private static void modeWithTwoPlayers(Scanner scanner) {

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
}
