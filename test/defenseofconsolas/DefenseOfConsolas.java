package defenseofconsolas;

import java.awt.*;
import java.util.Scanner;
import static ansicolors.AnsiColors.*;

public class DefenseOfConsolas {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Target row? ");
        int row = input.nextInt();
        System.out.print("Target column? ");
        int column = input.nextInt();
        System.out.println("Deploy to:");
        System.out.printf("%s(%d, %d)%s%n", ANSI_RED, row - 1, column, ANSI_RESET);
        System.out.printf("%s(%d, %d)%s%n", ANSI_BLUE, row + 1, column, ANSI_RESET);
        System.out.printf("%s(%d, %d)%s%n", ANSI_YELLOW, row, column - 1, ANSI_RESET);
        System.out.printf("%s(%d, %d)%s", ANSI_GREEN, row, column + 1, ANSI_RESET);
        Toolkit.getDefaultToolkit().beep();
    }
}
