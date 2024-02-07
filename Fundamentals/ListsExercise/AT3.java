package ListsExercise;

import java.util.*;
import java.util.stream.Collectors;

public class AT3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> elements = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        String command = scanner.nextLine();
        while (!command.equals("3:1")) {

            switch (command.split("\\s")[0]) {
                case "merge":
                    getMergedElements(elements, command);
                    break;
                case "divide":
                    getDividedElements(elements, command);
                    break;
            }
            command = scanner.nextLine();
        }
        System.out.println(String.join(" ", elements));
    }

    private static List<String> getDividedElements(List<String> elements, String command) {
        int index = Integer.parseInt(command.split(" ")[1]);
        int parts = Integer.parseInt(command.split(" ")[2]);

        if (index >= 0 && index <= elements.size() - 1) {

            String textForDivide = elements.get(index);
            elements.remove(index);

            int countSymbolsPerPart = textForDivide.length() / parts;

            int beginIndex = 0;
            for (int part = 1; part < parts; part++) {
                String textPerPart = textForDivide.substring(beginIndex, beginIndex + countSymbolsPerPart);
                elements.add(index, textPerPart);
                index++;
                beginIndex += countSymbolsPerPart;
            }

            String textLastParts = textForDivide.substring(beginIndex, textForDivide.length());
            elements.add(index, textLastParts);

        }
        return elements;
    }

    private static List<String> getMergedElements(List<String> elements, String command) {
        int startIndex = Integer.parseInt(command.split("\\s")[1]);
        int endIndex = Integer.parseInt(command.split("\\s")[2]);

        if (endIndex > elements.size() - 1) {
            endIndex = elements.size() - 1;
        }

        if (startIndex < 0) {
            startIndex = 0;
        } if (startIndex >= 0 && startIndex <= elements.size() - 1 && endIndex >= 0 && endIndex <= elements.size() - 1) {

            String resultMerge = "";
            for (int index = startIndex; index <= endIndex; index++) {
                String current = elements.get(index);
                resultMerge += current;
            }

            for (int index = startIndex; index <= endIndex; index++) {
                elements.remove(startIndex);
            }

            elements.add(startIndex, resultMerge);
        }
        return elements;
    }
}