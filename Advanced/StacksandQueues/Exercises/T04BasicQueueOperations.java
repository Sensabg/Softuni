package T01StacksQueues.Exercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class T04BasicQueueOperations {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        int[] input = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        while (input[0]-- > 0) {
            queue.offer(scanner.nextInt());
        }

        while (input[1]-- > 0) {
            queue.poll();
        }

        if(!queue.isEmpty()) {
            if (queue.contains(input[2])) {
                System.out.println(true);
            } else {
                System.out.println(queue.stream().sorted().toList().reversed().getLast());

            }
        } else {
            System.out.println(0);
        }
    }
}