package com.company;

public class Q3 {
    public static void main(String[] args){
        char[][] board = new char[3][3]; //creates a 3x3 array
        for (int i = 0; i < 3; i++){ //loops through the rows
            for (int j = 0; j < 3; j++){ //loops through the columns
                board[i][j] = ' '; //sets the value of the array to a space
            }
        }
        playGame(board); //calls the playGame method

        Main.menu(); //calls the menu method

        
    }
    private static void printBoard(char[][] board){ //prints the board
        System.out.println("  0 1 2"); //prints the column numbers
        for (int i = 0; i < 3; i++){ //loops through the rows
            System.out.print(i + " "); //prints the row numbers
            for (int j = 0; j < 3; j++){ //loops through the columns
                System.out.print(board[i][j] + " "); //prints the value of the array
            }
            System.out.println(); //prints a new line
        }
        
    }
    private static void playGame(char[][] board){ //the playGame method
        int turn = 0; //sets the turn to 0
        while (turn < 9){ //loops until the turn is 9
            if (turn % 2 == 0){ //if the turn is even
                //player 1
                int x = Main.getInt("Player 1, enter the x coordinate"); //gets the x coordinate
                int y = Main.getInt("Player 1, enter the y coordinate");//gets the y coordinate
                if (board[x][y] == ' '){ //if the value of the array is a space
                    board[x][y] = 'X'; //sets the value of the array to an X
                    turn++;//adds 1 to the turn
                }
                else{
                    System.out.println("That space is already taken");//prints that the space is already taken
                }
            }
            else{
                //player 2
                int x = Main.getInt("Player 2, enter the x coordinate"); //all the same as player 1
                int y = Main.getInt("Player 2, enter the y coordinate");
                if (board[x][y] == ' '){
                    board[x][y] = 'O'; //sets the value to O instead of X
                    turn++;
                }
                else{
                    System.out.println("That space is already taken");
                }
            }
            printBoard(board); //calls the printBoard method
            if (checkWin(board)){ //if checkWin returns true
                if (turn % 2 == 0){ //if the turn is even
                    System.out.println("Player 2 wins"); //prints that player 2 wins
                }
                else{
                    System.out.println("Player 1 wins"); //prints that player 1 wins
                }
                break;//breaks the loop
            }
        }
        if (turn == 9){ //if the turn is 9
            System.out.println("It's a draw"); //prints that it's a draw
        }
    }
    private static boolean checkWin(char[][] board) { 
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != ' '){ //checks the diagonal from top left to bottom right
            return true;
        }
        else if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != ' '){ //checks the diagonal from top right to bottom left
            return true;
        }
        for (int i = 0; i < board.length; i++){ //loops through the rows
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != ' '){ //checks the rows
                return true;
            }
            else if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] != ' '){//checks the columns
                return true;
            }
        }
        return false; //returns false if there is no winner
    }

    
    
}
