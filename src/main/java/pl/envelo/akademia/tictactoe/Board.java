package pl.envelo.akademia.tictactoe;

import java.util.Arrays;

//tablica
public class Board {

    private int[][] board;


    public void createNewBoard(int n) {
        int[][] arr = new int[n + 1][n + 1];
        arr[0][0] = 0;
        for (int i = 1; i < arr.length; i++) {
            arr[i][0] = i;
            arr[0][i] = i;
        }
        this.board = arr;
    }

    public void printBoard() {
        for (int i = 0; i < board.length; i++) {
            StringBuilder line = new StringBuilder();
            for (int j = 0; j < board.length; j++) {
                if (i == 0 || j == 0) {
                    line.append(board[i][j]).append(" ");
                } else {
                    line.append(changeDigitToSymbol(board[i][j]));
                }
            }
            System.out.println(line);
        }
    }

    private String changeDigitToSymbol(int i) {
        if (i == 1) {
            return "X ";
        } else if (i == 2) {
            return "O ";
        } else {
            return "- ";
        }
    }



    public int[][] getBoard() {
        return board;
    }

    public void setBoard(int[][] board) {
        this.board = board;
    }
}
