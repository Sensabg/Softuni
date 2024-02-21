package ListsMoreExercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TakeSkipRope {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder message = new StringBuilder(scanner.nextLine());
        Pattern pattern = Pattern.compile("\\d");
        Matcher matcher = pattern.matcher(message);

        List<Integer> takeList = new ArrayList<>();
        List<Integer> skipList = new ArrayList<>();

        int counter = 0;
        while (matcher.find()) {
            String digit = matcher.group();
            if (counter % 2 == 0) {
                takeList.add(Integer.parseInt(digit));
            } else {
                skipList.add(Integer.parseInt(digit));
            }
            counter++;
        }
        StringBuilder textWithoutNumbers = new StringBuilder(message.toString().replaceAll("\\d", ""));
        StringBuilder saveText = new StringBuilder();

        int saveLastIndex = 0;

        for (int i = 0; i < takeList.size(); i++) {
            int takeChars = takeList.get(i);
            int lastIndex = takeChars + saveLastIndex;
            if (lastIndex > textWithoutNumbers.length()) {
                lastIndex = textWithoutNumbers.length();
                saveLastIndex = textWithoutNumbers.length() - takeChars + 1;
            }
            saveText.append(textWithoutNumbers.substring(saveLastIndex, lastIndex));
            saveLastIndex = skipList.get(i) + lastIndex;
        }
        System.out.println(saveText);
    }
}