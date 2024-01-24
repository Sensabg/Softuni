package DataTypesAndVariablesMoreExercise;

import java.util.Scanner;

public class DataTypeFinder3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command;
        do {
            command = scanner.nextLine();

            if (command.matches("-?\\d+")) {
                System.out.printf("%s is an Integer type%n", command);
            } else if (command.matches("-?\\d+(\\.\\d+)?")) {
                System.out.printf("%s is a Double type%n", command);
            } else if ("true".equalsIgnoreCase(command) || "false".equalsIgnoreCase(command)) {
                System.out.printf("%s is a boolean type%n", command);
            } else if (command.length() == 1) {
                System.out.printf("%s is a char type%n", command);
            } else if (!command.matches("-?\\d+") && !command.matches
                    ("-?\\d+(\\.\\d+)?") && !"true".equalsIgnoreCase(command)
                    && !"false".equalsIgnoreCase(command)) {
                System.out.printf("%s is a String type%n", command);
            }

        } while (!"END".equals(command));
    }
}