package pl.envelo.akademia.tictactoe;

import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;

//stan gry
public class GameService {
    private static boolean firstPlayer = true;
    public static void run() {

        while (true) {
            Scanner scanner = new Scanner(System.in);
                Menu.printChoiceGameModeMenu();
                String choice = scanner.next();

                switch (choice) {
                    case "1":
                        modeWithTwoPlayers(scanner);
                        GameUtils.isGameActive = true;
                        System.out.println("Powodzenia!");
                        while (true) {
                            if(GameUtils.isGameActive) {
                                printGameBoard();
                                System.out.println("Ruch gracza: " + (firstPlayer ? "X" : "O"));
                                playerMove(scanner);
                            } else {
                                break;
                            }
                        }
                        break;
                    case "2":
                        System.out.println("Podaj nazwę gracza : ");
                        Player player = new Player(scanner.next());
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
            System.out.println("Podaj wspolrzedna X:");
            String x = scanner.next();

            System.out.println("Podaj wspolrzedna Y:");
            String y = scanner.next();

            if (StringUtils.isNumeric(x) && StringUtils.isNumeric(y)) {
                // TODO czy x i y mniejsze niz n
                if(GameLogic.makeMove(Integer.parseInt(x), Integer.parseInt(y), firstPlayer)) {
                    if(GameLogic.checkIfWin(firstPlayer)) {
                        GameUtils.isGameActive = false;
                        System.out.println("Wygrał gracz" + (firstPlayer ? "X" : "O"));
                    }
                    firstPlayer = !firstPlayer;
                    break;
                } else {
                    System.out.println("To pole jest już zajęte");
                }
            } else {
                System.out.println("Niepoprawne współrzędne");
            }
        }
    }

    private static void printGameBoard() {
        GameUtils.getBoard().printBoard();
    }

    private static void createBoard(String n) {
        try {
            int size = Integer.parseInt(n);
            GameUtils.setBoard(new Board());
            GameUtils.getBoard().createNewBoard(size);

        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(MessageUtils.INVALID_INPUT_SIZE_MESSAGE);
        }
    }

    private static void modeWithTwoPlayers(Scanner scanner) {

        System.out.println("Podaj nazwę gracza nr 1: ");
        GameUtils.setPlayer1(new Player(scanner.next()));
        System.out.println("Podaj nazwę gracza nr 2: ");
        GameUtils.setPlayer2(new Player(scanner.next()));

        while (true) {
            System.out.println("Podaj rozmiar planszy (rekomendowana 3-5):");
            String choice = scanner.next();
            if (StringUtils.isNumeric(choice)) {
                if (Integer.parseInt(choice) <= 2) {
                    System.out.println(MessageUtils.INVALID_INPUT_SIZE_MESSAGE);
                } else {
                    createBoard(choice);
                    break;
                }
            } else {
                System.out.println("Podana wartość musi być liczbą!");
            }
        }

    }
}
