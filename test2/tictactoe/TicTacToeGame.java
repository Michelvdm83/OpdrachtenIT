package tictactoe;

import static generic.CommandLine.askForString;
import static generic.CommandLine.askYesOrNo;

public class TicTacToeGame {
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
		game.showBoardHelp();
		
		boolean ownNames = askYesOrNo("Do you want to set your own playernames?");
		boolean bestOfFive = askYesOrNo("Do you want to play best out of 5?");
        do {
            if(ownNames){
				String playerX = askForString("Please enter the name for who plays 'X': ");
				game.setPlayerX(playerX);
				String playerY = askForString("Please enter the name for who plays 'O': ");
				game.setPlayerO(playerY);
			}
            //just to make it repeatable
            do {
                game.play(bestOfFive);

            } while (askYesOrNo("Do you want to play another game together, " + game.getPlayerX() + " and " + game.getPlayerO() + "?"));

        } while (askYesOrNo("Do you want to play again with other players? "));
    }
}
