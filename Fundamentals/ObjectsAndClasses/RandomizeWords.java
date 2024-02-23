package ObjectsAndClasses;

import java.util.*;
import java.util.stream.Collectors;

public class RandomizeWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> listOfWords = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        Collections.shuffle(listOfWords);

        for (int i = 0; i < listOfWords.size(); i++) {
            System.out.println(listOfWords.get(i));
        }
    }
}