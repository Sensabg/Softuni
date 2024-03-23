package FinalExams;

import java.util.Scanner;

public class Problem1WorldTour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder destinations = new StringBuilder(scanner.nextLine());
        String input;

        while (!"Travel".equals(input = scanner.nextLine())) {
            String[] info = input.replaceAll(" ", "").split(":");
            String command = info[0];

            switch (command) {

                case "AddStop":
                    int index = Integer.parseInt(info[1]);
                    String place = info[2];
                    if (isValid(index, destinations)) {
                        destinations.insert(index, place);
                    }
                    System.out.println(destinations);
                    break;

                case "RemoveStop":
                    int startIndex = Integer.parseInt(info[1]);
                    int endIndex = Integer.parseInt(info[2]);
                    if(isValid(startIndex,destinations) && isValid(endIndex,destinations)) {
                        destinations.replace(startIndex, endIndex + 1, "");
                    }
                    System.out.println(destinations);
                    break;

                case "Switch":
                    String textToReplace = info[1];
                    String replacement = info[2];
                    String currentDestination = destinations.toString().replaceAll(textToReplace, replacement);
                    destinations = new StringBuilder(currentDestination);
                    System.out.println(destinations);
                    break;
            }
        }
        System.out.println("Ready for world tour! Planned stops: " + destinations);
    }

    public static boolean isValid(int index, StringBuilder destinations) {
        return index >= 0 && index < destinations.length();
    }
}