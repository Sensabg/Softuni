package DataTypesAndVariablesMoreExercise;

import java.util.Scanner;

public class DataTypeFinder2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String input = scanner.nextLine();

            if (input.equals("END")) {
                break;
            }

            try {
                Integer.parseInt(input);
                System.out.printf("%s is integer type.%n", input);
            } catch (NumberFormatException e1) {
                try {
                    Double.parseDouble(input);
                    System.out.printf("%s is floating point type.%n", input);
                } catch (NumberFormatException e2) {
                    if (input.length() == 1 && Character.isLetter(input.charAt(0))) {
                        System.out.printf("%s is character type.%n", input);
                    } else if (input.equalsIgnoreCase("true") || input.equalsIgnoreCase("false")) {
                        System.out.printf("%s is boolean type.%n", input);
                    } else {
                        System.out.printf("%s is string type.%n", input);
                    }
                }
            }
        }
    }
}
