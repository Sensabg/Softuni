package FinalExams;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem2DestinationMapper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String regex = "([\\/=])(?<destination>[A-Z][a-z]{3,})\\1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        List<String> destinations = new ArrayList<>();
        int totalSum = 0;

        while (matcher.find()) {
            String destination = matcher.group("destination");
            destinations.add(destination);
        }
        for (String destination : destinations) {
            totalSum += destination.length();
        }
        System.out.println("Destinations: " + destinations.toString()
                .replace("[", "")
                .replace("]", ""));
        System.out.println("Travel Points: " + totalSum);
    }
}