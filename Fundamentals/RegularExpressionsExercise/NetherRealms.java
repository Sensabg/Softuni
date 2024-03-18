package RegularExpressionsExercise;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NetherRealms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] demons = scanner.nextLine().replace(" ", "").split(",");

        for (String demonName : demons) {

            int health = 0;
            for (char symbol : demonName.toCharArray()) {
                String regexSymbols = "[^\\d+\\-*./]";
                Pattern pattern = Pattern.compile(regexSymbols);
                Matcher matcher = pattern.matcher(Character.toString(symbol));

                if (matcher.find()){
                    health += symbol;
                }
            }
            String regexNumbers = "-?[0-9]+\\.?[0-9]*";
            Pattern pattern = Pattern.compile(regexNumbers);
            Matcher matcher = pattern.matcher(demonName);

            double damage = 0;
            while (matcher.find()) {
                damage += Double.parseDouble(matcher.group());
            }

            for (char operator : demonName.toCharArray()) {
                if (operator == '*') {
                    damage *= 2;
                } else if (operator == '/') {
                    damage /= 2;
                }
            }
            System.out.printf("%s - %d health, %.2f damage%n", demonName, health, damage);
        }
    }
}