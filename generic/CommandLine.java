package generic;

import java.util.Scanner;
import java.util.function.UnaryOperator;

import static generic.AnsiColors.*;

public class CommandLine {

    private static final Scanner in = new Scanner(System.in);

    private static int askForInt() {
        do {
            if (in.hasNextInt()) {
                int returnInt = in.nextInt();
                in.nextLine();
                return returnInt;
            } else {
                in.nextLine();
                System.out.println("Please enter a number");
            }
        } while (true);
    }

    private static int askForInt(int min, int max) {
        do {
            int returnInt = askForInt();
            if (min <= returnInt && returnInt <= max) {
                return returnInt;
            } else {
                System.out.printf("Please enter a number between %d and %d (both inclusive)%n", min, max);
            }
        } while (true);
    }

    public static int askForInt(String prompt) {
        System.out.print(prompt);
        return askForInt();
    }

    public static int askForInt(String prompt, int min, int max) {
        System.out.print(prompt);
        return askForInt(min, max);
    }

    public static String askForString(String prompt) {
        System.out.print(prompt);
        return in.nextLine();
    }

    public static String askForStringFromMenu(String... options) {
        if (options.length < 1)
            throw (new IllegalArgumentException("method askForStringFromMenu needs at least 1 argument"));
        int choice = askForIntFromMenu(options);
        return options[choice - 1];
    }

    public static int askForIntFromMenu(String... options) {
        if (options.length < 1)
            throw (new IllegalArgumentException("method askForIntFromMenu needs at least 1 argument"));
        for (int i = 1; i <= options.length; i++) {
            System.out.println(i + ". " + options[i - 1]);
        }
        return askForInt(1, options.length);
    }

    private static String getStringColored(String text, AnsiColors color) {
        return color.getColor() + text + RESET.getColor();
    }

    public static UnaryOperator<String> red = s -> getStringColored(s, RED);
    public static UnaryOperator<String> green = s -> getStringColored(s, GREEN);
    public static UnaryOperator<String> cyan = s -> getStringColored(s, CYAN);
    public static UnaryOperator<String> yellow = s -> getStringColored(s, YELLOW);
    public static UnaryOperator<String> blue = s -> getStringColored(s, BLUE);
    public static UnaryOperator<String> purple = s -> getStringColored(s, PURPLE);
    public static UnaryOperator<String> white = s -> getStringColored(s, WHITE);
}