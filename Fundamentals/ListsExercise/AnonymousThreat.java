package ListsExercise;

import java.util.*;
import java.util.stream.Collectors;

public class AnonymousThreat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> elements = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        String command = scanner.nextLine();
        while (!command.equals("3:1")) {

            switch (command.split("\\s")[0]) {
                case "merge":
                    elements = getMergedElements(elements, command);
                    break;
                case "divide":
                    elements = getDividedElements(elements, command);
                    break;
            }
            command = scanner.nextLine();
        }
        for (String element : elements) {
            System.out.print(element + " ");
        }
    }

    private static List<String> getDividedElements(List<String> elements, String command) {
        int startIndex = Integer.parseInt(command.split("\\s")[1]);
        int endIndex = Integer.parseInt(command.split("\\s")[2]);

        int start = startIndex;

        if (endIndex > elements.size() - 1) {
            endIndex = elements.size() - 1;
        }

        if (startIndex > elements.size() - 1) {
            startIndex = 0;
        }

        List<String> newArray = new ArrayList<>();

        for (int i = startIndex; i <= endIndex; i++) {
            String getElement = elements.get(i);

            String concatenatedElements = "";
            int getSecondHalf = 0;

            for (int j = 0; j < getElement.length(); j++) {
                int step = getElement.length();

                for (int k = 0; k < step; k++) {
                    concatenatedElements = concatenatedElements + getElement.charAt(getSecondHalf);
                    step /= 2;
                    getSecondHalf++;
                }
                j = getSecondHalf;
                newArray.add(0, concatenatedElements);
                concatenatedElements = "";
            }

            if (getElement.length() % 2 != 0) {
                for (int j = getSecondHalf; j < getElement.length(); j++) {
                    concatenatedElements = concatenatedElements + getElement.charAt(getSecondHalf);
                }
                newArray.add(0, concatenatedElements);
            }
        }
        if(start > 0) {
            Collections.reverse(newArray);
        }

        if (startIndex > 0) {
            for (int i = startIndex - 1; i >= 0; i--) {
                newArray.add(0, elements.get(i));
            }
        }
        return newArray;
    }

    private static List<String> getMergedElements(List<String> elements, String command) {
        int startIndex = Integer.parseInt(command.split("\\s")[1]);
        int endIndex = Integer.parseInt(command.split("\\s")[2]);

        if (endIndex > elements.size() - 1) {
            endIndex = elements.size() - 1;
        }

        if (startIndex > elements.size() - 1) {
            startIndex = 0;
        }

        String concatenatedElements = elements.get(startIndex);
        List<String> newArray = new ArrayList<>();

        for (int i = startIndex; i < endIndex; i++) {
            concatenatedElements += elements.get(i + 1);
        }
        newArray.add(concatenatedElements);

        for (int i = endIndex; i < elements.size() - 1; i++) {
            newArray.add(elements.get(i + 1));
        }
        if (startIndex > 0) {
            for (int i = startIndex - 1; i >= 0; i--) {
                newArray.add(0, elements.get(i));
            }
        }
        return newArray;
    }
}
