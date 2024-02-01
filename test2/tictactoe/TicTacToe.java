package tictactoe;

import java.util.Arrays;

import static generic.CommandLine.*;

public class TicTacToe {
    private char[] board;
	private final char playerXChar = 'X';
	private final char playerOChar = 'O';
    private String playerX = "X";
    private String playerO = "O";
	private char roundWinner = ' ';

    public TicTacToe() {
    }

    //to show the board and its values
    public void showBoardHelp() {
        System.out.println("""
                 7 | 8 | 9
                ---+---+---
                 4 | 5 | 6
                ---+---+---
                 1 | 2 | 3
                """);
    }

    //prints the current state of the board
    private void showCurrentBoard() {
		//just showing the board
/*        System.out.printf("""
                 %c | %c | %c
                ---+---+---
                 %c | %c | %c
                ---+---+---
                 %c | %c | %c%n
                """, board[6], board[7], board[8], board[3], board[4], board[5], board[0], board[1], board[2]);
*/		
		//showing the board with color
		String currentBoard = String.format("""
                 %c | %c | %c
                ---+---+---
                 %c | %c | %c
                ---+---+---
                 %c | %c | %c%n
                """, board[6], board[7], board[8], board[3], board[4], board[5], board[0], board[1], board[2]);
		currentBoard = currentBoard.replace((""+playerXChar), yellow.apply(""+playerXChar)).replace((""+playerOChar), blue.apply(""+playerOChar));
		System.out.println(currentBoard);
    }

    //creating a new, empty, board, so you don't have to create a new object of TicTacToe each time you want to play
    private void createBoard() {
        board = new char[]{' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
    }
	
	public void play(boolean bestOfFive){
		if(bestOfFive){
			int rounds = 5;
			int xWinCount = 0, oWinCount = 0;
			
			for(int currentRound = 1; currentRound <= rounds; currentRound++){
				System.out.println("Round: " + currentRound);
				playRound();
				if(roundWinner == playerXChar){
					xWinCount++;
				}
				if(roundWinner == playerOChar){
					oWinCount++;
				}
				if(Math.abs(xWinCount - oWinCount) > (rounds-currentRound)){
					break;
				}
			}
			System.out.println(playerX + " has won " + xWinCount + " rounds.");
			System.out.println(playerO + " has won " + oWinCount + " rounds.");
			if(xWinCount == oWinCount){
				System.out.println("It's a draw!");
			}else{
				System.out.print("Congratulations ");
				
				//short version:
				//System.out.print(xWinCount>oWinCount? playerX:playerO);
				if(xWinCount > oWinCount){
					System.out.print(playerX);
				}
				if(oWinCount > xWinCount){
					System.out.print(playerO);
				}
				
				System.out.println(". You won!");
			}
		}else{
			playRound();
		}
	}
	
	private void playRound() {
        createBoard();
        boolean haveWinner;
        char currentPlayer = ' ';
		roundWinner = ' ';
		
        do{
			currentPlayer = currentPlayer==playerXChar ? playerOChar : playerXChar;
            String player = currentPlayer == playerXChar ? playerX : playerO;
			
            do{
				showCurrentBoard();
				int nextMove = askForInt(player + ", please enter your next move: ", 1, 9) - 1;
				
				if(checkMove(nextMove)){
					board[nextMove] = currentPlayer;
					haveWinner = checkWin(currentPlayer, nextMove);
					break;
				}else{
					System.out.println("This is not a valid move!");
					System.out.println("Please choose an empty spot.");
				}
            }while (true);
			
			if(boardIsFull())break;
        }while (!haveWinner);
		
        showCurrentBoard();
		if(haveWinner){
			String winner = currentPlayer==playerXChar? getPlayerX() : getPlayerO();
			System.out.println("Congratulations " + winner + "!\nYou won!");
			roundWinner = currentPlayer;
		}else{
			System.out.println("Board is full without a winner.");
            System.out.println("Well played! It's a draw!");
		}
    }
	
	private boolean boardIsFull(){
		return !Arrays.toString(board).contains("  ");
	}

    //check if the move is legal
    private boolean checkMove(int nextMove) {
        if (nextMove < 0 || 8 < nextMove || !(board[nextMove] == ' ')) {
            return false;
        }
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
            if (Arrays.stream(win).anyMatch(i -> i == lastMove)) {//if(win[0] == lastMove || win[1] == lastMove || win[2] == lastMove)
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
