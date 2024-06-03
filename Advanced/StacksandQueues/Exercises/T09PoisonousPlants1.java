package T01StacksQueues.Exercise;

import java.util.*;

public class T09PoisonousPlants1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[] plants = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int[] days = new int[n];

        int maxDays = 0;
        for (int i = 0; i < n; i++) {
            int day = 0;
            while (!stack.isEmpty() && plants[stack.peek()] >= plants[i]) {
                day = Math.max(day, days[stack.pop()]);
            }
            if (!stack.isEmpty()) {
                days[i] = day + 1;
            }
            maxDays = Math.max(maxDays, days[i]);
            stack.push(i);
        }
        System.out.println(maxDays);
    }
}