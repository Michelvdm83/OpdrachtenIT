package tictactoe;

import java.util.Arrays;
import java.util.Scanner;

public class TicTacToe {
    private char[] board;
    private final Scanner input = new Scanner(System.in);
    private String playerX = "X";
    private String playerO = "O";

    public TicTacToe() {
        showBoard();
    }

    //to show the board and its values
    private void showBoard() {
        System.out.print("""
                 7 | 8 | 9
                ---+---+---
                 4 | 5 | 6
                ---+---+---
                 1 | 2 | 3
                """);
    }

    //prints the current state of the board
    private void showCurrentBoard() {
        System.out.printf("""
                 %c | %c | %c
                ---+---+---
                 %c | %c | %c
                ---+---+---
                 %c | %c | %c
                """, board[6], board[7], board[8], board[3], board[4], board[5], board[0], board[1], board[2]);
    }

    //creating a new, empty, board, so you don't have to create a new object of TicTacToe each time you want to play
    private void createBoard() {
        board = new char[]{' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
    }


    public void play() {
        //for best of 5, this would be 1 round
        //best to rename this to playRound and make another method play() which loops this max 5 times
        //and when either player has won 3 times, declares the winner
        createBoard();
        boolean xWon = false, oWon = false;
        char currentPlayer = 'X';
        while (!xWon && !oWon) {
            showCurrentBoard();
            String player = currentPlayer == 'X' ? getPlayerX() : getPlayerO();
            System.out.print(player + ", please enter your next move: ");
            int nextMove = input.nextInt() - 1;
            while (!doMove(nextMove, currentPlayer)) {
                System.out.println("This is not a valid move!");
                System.out.print("Please choose an empty spot: ");
                nextMove = input.nextInt() - 1;
            }
            if (currentPlayer == 'X') xWon = checkWin(currentPlayer, nextMove);
            if (currentPlayer == 'O') oWon = checkWin(currentPlayer, nextMove);
            currentPlayer = player.equals(getPlayerX()) ? 'O' : 'X';
            boolean emptySpaceLeft = false;
            for (char c : board) {
                if (c == ' ') {
                    emptySpaceLeft = true;
                    break;
                }
            }
            if (!emptySpaceLeft) break;
        }
        showCurrentBoard();
        if (!xWon && !oWon) {
            System.out.println("Board is full without a winner.");
            System.out.println("Well played! It's a draw!");
        } else {
            if (xWon) System.out.println("Congratulations " + getPlayerX() + "!\nYou won!");
            if (oWon) System.out.println("Congratulations " + getPlayerO() + "!\nYou won!");
        }
    }

    //enter the move into the current board
    private boolean doMove(int nextMove, char player) {
        //check for valid move
        if (nextMove < 0 || 8 < nextMove || !(board[nextMove] == ' ')) {
            return false;
        }
        board[nextMove] = player;
        return true;
    }

    private boolean checkWin(char player, int lastMove) {
        //these are the lines which 1 player needs to have to win
        int[][] winCheck = {{6, 7, 8}, {3, 4, 5}, {0, 1, 2}, {6, 3, 0}, {7, 4, 1}, {8, 5, 2}, {6, 4, 2}, {8, 4, 0}};
        //6 7 8
        //3 4 5
        //0 1 2
        for (int[] win : winCheck) {
            //for each line check if the last move is in it
            //if it is, check if the player wins
            //no need to check a line on which nothing has changed
            if (Arrays.stream(win).anyMatch(i -> i == lastMove)) {
                char[] line = {board[win[0]], board[win[1]], board[win[2]]};
                if (Arrays.equals(line, new char[]{player, player, player})) {
                    return true;
                }
            }
        }
        return false;
    }

    public void setPlayerX(String playerX) {
        this.playerX = playerX;
    }

    public void setPlayerO(String playerO) {
        this.playerO = playerO;
    }

    public String getPlayerX() {
        return playerX;
    }

    public String getPlayerO() {
        return playerO;
    }
}
