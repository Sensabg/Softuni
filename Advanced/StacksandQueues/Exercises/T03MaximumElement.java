package T01StacksQueues.Exercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class T03MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int commandsAmount = Integer.parseInt(scanner.nextLine());

        while (commandsAmount-- > 0) {
            int[] command = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            switch (command[0]) {
                case 1 -> stack.push(command[1]);
                case 2 -> stack.pop();
                case 3 -> System.out.println(stack.stream().sorted().toList().reversed().getFirst());
            }
        }
    }
}
