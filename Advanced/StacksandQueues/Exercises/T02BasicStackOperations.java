package T01StacksQueues.Exercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class T02BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        int[] input = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        while (input[0]-- > 0) {
            stack.push(scanner.nextInt());
        }

        while (input[1]-- > 0) {
            stack.pop();
        }

        if(!stack.isEmpty()) {
            if (stack.contains(input[2])) {
                System.out.println(true);
            } else {
                System.out.println(stack.stream().sorted().toList().reversed().getLast());

            }
        } else {
            System.out.println(0);
        }
    }
}