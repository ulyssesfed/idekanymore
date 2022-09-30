package com.company;

public class Q3 {
    public static void main(String[] args){
        //tic tac toe
        //create a 3x3 array
        char[][] board = new char[3][3];
        //fill the array with spaces
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                board[i][j] = ' ';
            }
        }
        playGame(board);

        Main.menu();

        
    }
    private static void printBoard(char[][] board){
        System.out.println("  0 1 2");
        for (int i = 0; i < 3; i++){
            System.out.print(i + " ");
            for (int j = 0; j < 3; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        
    }
    private static void playGame(char[][] board){
        //play the game
        int turn = 0;
        while (turn < 9){
            if (turn % 2 == 0){
                //player 1
                int x = Main.getInt("Player 1, enter the x coordinate");
                int y = Main.getInt("Player 1, enter the y coordinate");
                if (board[x][y] == ' '){
                    board[x][y] = 'X';
                    turn++;
                }
                else{
                    System.out.println("That space is already taken");
                }
            }
            else{
                //player 2
                int x = Main.getInt("Player 2, enter the x coordinate");
                int y = Main.getInt("Player 2, enter the y coordinate");
                if (board[x][y] == ' '){
                    board[x][y] = 'O';
                    turn++;
                }
                else{
                    System.out.println("That space is already taken");
                }
            }
            printBoard(board);
            if (checkWin(board)){
                if (turn % 2 == 0){
                    System.out.println("Player 2 wins");
                }
                else{
                    System.out.println("Player 1 wins");
                }
                break;
            }
        }
        if (turn == 9){
            System.out.println("It's a draw");
        }
    }
    private static boolean checkWin(char[][] board) {
        //check if there is a winner
        //check diagonals
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != ' '){
            return true;
        }
        else if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != ' '){
            return true;
        }
        for (int i = 0; i < board.length; i++){
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != ' '){
                return true;
            }
            else if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] != ' '){
                return true;
            }
        }
        return false;
    }

    
    
}
