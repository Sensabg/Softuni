package DataTypesAndVariablesMoreExercise;

import java.util.Scanner;

public class DataTypeFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        var command = scanner.nextLine();

        while (true) {

            if (command.equals("END")) {
                break;
            }

            if (command.matches("-?\\d+")) {
                System.out.printf("%s is integer type%n", command);
            } else if (command.matches("-?\\d*\\.\\d+")) {
                System.out.printf("%s is floating point type%n", command);
            } else if (command.length() == 1 && Character.isLetter(command.charAt(0))) {
                System.out.printf("%s is character type%n", command);
            } else if (command.equalsIgnoreCase("true") || command.equalsIgnoreCase("false")) {
                System.out.printf("%s is boolean type%n", command);
            } else {
                System.out.printf("%s is string type%n", command);
            }
            command = scanner.nextLine();
        }
    }
}




