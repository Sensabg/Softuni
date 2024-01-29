package ListsExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ChangeList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays
                .stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String command = scanner.nextLine();
        while (!command.equals("end")) {
            String action = command.split(" ")[0];
            if (action.equals("Delete")) {
                int element = (Integer.parseInt(command.split(" ")[1]));
                for (int i = 0; i < numbers.size(); i++) {
                    if (element == numbers.get(i)) {
                        numbers.remove(numbers.get(i));
                    }
                }
            } else if (action.equals("Insert")) {
                int element = (Integer.parseInt(command.split(" ")[1]));
                int position = (Integer.parseInt(command.split(" ")[2]));
                numbers.add(position, element);
            }
            command = scanner.nextLine();
        }
        System.out.println(numbers.toString().replaceAll("[\\[\\],]", ""));
    }
}