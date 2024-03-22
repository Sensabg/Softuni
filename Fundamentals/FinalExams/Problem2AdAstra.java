package FinalExams;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem2AdAstra {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        String regex = "([|#])(?<product>[A-Za-z\\s]+)\\1(?<date>\\d{2}/\\d{2}/\\d{2})\\1(?<calories>\\d{1,5})\\1";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        int caloriesPerDay = 2000;
        int totalCalories = 0;

        while (matcher.find()) {
            totalCalories += Integer.parseInt(matcher.group("calories"));
        }

        System.out.printf("You have food to last you for: %d days!\n", totalCalories / caloriesPerDay);

        if(totalCalories> 0) {
            matcher = pattern.matcher(text);
            while (matcher.find()) {
                String product = matcher.group("product");
                String date = matcher.group("date");
                int calories = Integer.parseInt(matcher.group("calories"));
                System.out.printf("Item: %s, Best before: %s, Nutrition: %d\n", product, date, calories);
            }
        }
    }
}