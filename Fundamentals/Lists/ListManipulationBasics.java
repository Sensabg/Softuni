package Lists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationBasics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays
                .stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String command = scanner.nextLine();
        while (!command.equals("end")) {
            String[] possibilities = command.split(" ");

            switch (possibilities[0]) {
                case "Add":
                    int addNumber = Integer.parseInt(possibilities[1]);
                    numbers.add(addNumber);
                    break;
                case "Remove":
                    int removeNumber = Integer.parseInt(possibilities[1]);
                    for (int i = 0; i < numbers.size(); i++) {
                        if (numbers.get(i) == removeNumber) {
                            numbers.remove(i);
                            break;
                        }
                    }
                    break;
                case "RemoveAt":
                    int removeAtIndex = Integer.parseInt(possibilities[1]);
                    numbers.remove(removeAtIndex);
                    break;
                case "Insert":
                    int insertNumber = Integer.parseInt(possibilities[1]);
                    int insertIndex = Integer.parseInt(possibilities[2]);
                    numbers.add(insertIndex, insertNumber);
                    break;

            }
            command = scanner.nextLine();
        }
        System.out.println(numbers.toString().replaceAll("[\\[\\],]", ""));
    }
}