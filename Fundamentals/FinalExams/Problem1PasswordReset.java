package FinalExams;

import java.util.Scanner;

public class Problem1PasswordReset {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder password = new StringBuilder(scanner.nextLine());
        String input;

        while (!"Done".equals(input = scanner.nextLine())) {
            String[] info = input.split(" ");
            String command = info[0];

            switch (command) {

                case "TakeOdd":
                    StringBuilder oddChars = new StringBuilder();
                    for (int i = 0; i < password.length(); i++) {
                        if (i % 2 != 0) {
                            oddChars.append(password.charAt(i));
                        }
                    }
                    password = new StringBuilder(oddChars);
                    System.out.println(password);
                    break;

                case "Cut":
                    int startIndex = Integer.parseInt(info[1]);
                    int endIndex = Integer.parseInt(info[2]);
                    password.replace(startIndex,startIndex + endIndex, "");
                    System.out.println(password);
                    break;

                case "Substitute":
                    String textToRemove = info[1];
                    String replacement = info[2];
                    if (password.toString().contains(textToRemove)) {
                        password = new StringBuilder(password.toString().replaceAll(textToRemove, replacement));
                        System.out.println(password);
                    } else {
                        System.out.println("Nothing to replace!");
                    }
                    break;

            }
        }
        System.out.println("Your password is: " + password);
    }
}
