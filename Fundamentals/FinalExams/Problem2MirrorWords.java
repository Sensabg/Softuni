package FinalExams;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem2MirrorWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        String regex = "([@#])(?<word>[A-Za-z]{3,})\\1\\1(?<reverseWord>[A-Za-z]{3,})\\1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        List<String> words = new ArrayList<>();
        int counter = 0;

        while (matcher.find()) {
            StringBuilder word = new StringBuilder(matcher.group("word"));
            StringBuilder reverseWord = new StringBuilder(matcher.group("reverseWord"));
            counter++;

            if (word.toString().contentEquals(reverseWord.reverse())) {
                words.add(word.append("=").append(reverseWord.reverse()).toString());
            }
        }
        if(counter != 0){
            System.out.println(counter + " word pairs found!");
        } else {
            System.out.println("No word pairs found!");
        }

        if(!words.isEmpty()) {
            System.out.println("The mirror words are:");
            System.out.println(words.toString()
                    .replaceAll("=", " <=> ")
                    .replace("[", "")
                    .replace("]", ""));
        } else {
            System.out.println("No mirror words!");
        }
    }
}
