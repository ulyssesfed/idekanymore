package com.company;

import static com.company.Main.menu;

public class Q3 {
    public static void run(){
        main(null);
    }
    public static void main(String[] args) {
        char[][] board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }

        playGame(board);

        menu();
    }

    private static void printBoard(char[][] board) {
        System.out.println("  0 1 2");
        for (int i = 0; i < 3; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void playGame(char[][] board) {
        int turn = 0;
        while (turn < 9) {
            int player = turn % 2 + 1;
            int x = Main.getInt("Player " + player + ", enter the x coordinate: ");
            int y = Main.getInt("Player " + player + ", enter the y coordinate: ");

            if (board[x][y] == ' ') {
                board[x][y] = (player == 1) ? 'X' : 'O';
                turn++;
            } else {
                System.out.println("That space is already taken");
            }

            printBoard(board);

            if (checkWin(board)) {
                System.out.println("Player " + player + " wins");
                break;
            }
        }

        if (turn == 9) {
            System.out.println("It's a draw");
        }
    }

    private static boolean checkWin(char[][] board) {
        // check diagonals
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != ' ') {
            return true;
        }
        if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != ' ') {
            return true;
        }

        // check rows and columns
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != ' ') {
                return true;
            }
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] != ' ') {
                return true;
            }
        }

        return false;
    }




}
