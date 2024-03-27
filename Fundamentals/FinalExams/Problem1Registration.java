package FinalExams;

import java.util.Scanner;

public class Problem1Registration {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String username = scanner.nextLine();
        String input;

        while (!"Registration".equals(input = scanner.nextLine())) {
            String[] info = input.split(" ");
            String command = info[0];
            int startIndex;
            int endIndex;
            String getChar;

            switch (command) {

                case "Letters":
                    String direction = info[1];
                    if (direction.equals("Upper")) {
                        username = username.toUpperCase();
                    } else if (direction.equals("Lower")) {
                        username = username.toLowerCase();
                    }
                    System.out.println(username);
                    break;

                case "Reverse":
                    startIndex = Integer.parseInt(info[1]);
                    endIndex = Integer.parseInt(info[2]);
                    if (isValid(startIndex, username) && isValid(endIndex, username)) {
                        StringBuilder substring = new StringBuilder(username.substring(startIndex, endIndex + 1)).reverse();
                        System.out.println(substring);
                    }
                    break;

                case "Substring":
                    String textToRemove = info[1];
                    if (username.contains(textToRemove)) {
                        username = username.replace(textToRemove, "");
                        System.out.println(username);
                    } else {
                        System.out.println("The username " + username + " doesn't contain " + textToRemove + ".");
                    }
                    break;

                case "Replace":
                    getChar = info[1];
                    username = username.replaceAll(getChar, "-");
                    System.out.println(username);
                    break;

                case "IsValid":
                    getChar = info[1];
                    if (username.contains(getChar)) {
                        System.out.println("Valid username.");
                    } else {
                        System.out.println(getChar + " must be contained in your username.");
                    }
                    break;
            }
        }
    }

    public static boolean isValid(int index, String username) {
        return index >= 0 && index < username.length();
    }
}
