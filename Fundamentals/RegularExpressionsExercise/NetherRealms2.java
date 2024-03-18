package RegularExpressionsExercise;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NetherRealms2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] demons = scanner.nextLine().replace(" ", "").split(",");

        Pattern healthPattern = Pattern.compile("[^\\d+\\-*./]");
        Pattern damagePattern = Pattern.compile("-?[0-9]+\\.?[0-9]*");

        for (String demonName : demons) {
            int health = 0;
            double damage = 0;

            Matcher healthMatcher = healthPattern.matcher(demonName);
            while (healthMatcher.find()) {
                health += healthMatcher.group().charAt(0);
            }

            Matcher damageMatcher = damagePattern.matcher(demonName);
            while (damageMatcher.find()) {
                damage += Double.parseDouble(damageMatcher.group());
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