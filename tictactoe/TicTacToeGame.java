package tictactoe;

import java.util.Scanner;
import static generic.CommandLine.*;

public class TicTacToeGame {
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        Scanner input = new Scanner(System.in);
        do {
            String playerX = askForString("Please enter the name for who plays 'X': ");
            game.setPlayerX(playerX);
            System.out.print("Please enter the name for who plays 'O': ");
            game.setPlayerO(input.next());
            //just to make it repeatable
            do {
                game.play();
                System.out.print("Do you want to play another game together, " + game.getPlayerX() + " and " + game.getPlayerO() + "?");

            } while (input.next().equalsIgnoreCase("yes"));

            System.out.print("Do you want to play again with other players? ");
        } while (input.next().equalsIgnoreCase("yes"));
    }
}
