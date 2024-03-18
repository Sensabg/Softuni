package RegularExpressionsExercise;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StarEnigma {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String bannedChars = "[^@!:>-]*";
        String regex = "@(?<planetName>[A-Za-z]+)" + bannedChars
                + ":(?<population>[0-9]+)" + bannedChars
                + "!(?<attackType>[AD])!" + bannedChars
                + "->(?<soldiersCount>[0-9]+)";

        Pattern pattern = Pattern.compile(regex);

        List<String> attackersPlanets = new ArrayList<>();
        List<String> destroyedPlanets = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String message = scanner.nextLine();
            StringBuilder decrypted = new StringBuilder();
            int countLetters = 0;

            for (char letters : message.toCharArray()) {
                if (containsStar(letters)) {
                    countLetters++;
                }
            }
            for (char letters : message.toCharArray()) {
                char decrypt = (char) (letters - countLetters);
                decrypted.append(decrypt);
            }
            Matcher matcher = pattern.matcher(decrypted);

            if (matcher.find()) {
                String planetName = matcher.group("planetName");
                String attackType = matcher.group("attackType");

                if (attackType.equals("A")) {
                    attackersPlanets.add(planetName);
                } else if (attackType.equals("D")) {
                    destroyedPlanets.add(planetName);
                }
            }
        }
        System.out.println("Attacked planets: " + attackersPlanets.size());
        Collections.sort(attackersPlanets);
        attackersPlanets.forEach(planet -> System.out.println("-> " + planet));

        System.out.println("Destroyed planets: " + destroyedPlanets.size());
        Collections.sort(destroyedPlanets);
        destroyedPlanets.forEach(planet -> System.out.println("-> " + planet));
    }

    private static boolean containsStar(char letters) {
        String convert = String.valueOf(letters);
        return convert.equalsIgnoreCase("s")
                || convert.equalsIgnoreCase("t")
                || convert.equalsIgnoreCase("a")
                || convert.equalsIgnoreCase("r");
    }
}