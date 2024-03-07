package TextProcessingExercise;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] usernames = scanner.nextLine().split(", ");

        for (String username : usernames) {
            if (isValidUsername(username)) {
                System.out.println(username);
            }
        }
    }

    private static boolean isValidUsername(String username) {
        String regex = "^[a-zA-Z0-9_-]{3,16}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(username);

        return matcher.matches();
    }
}