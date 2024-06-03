package T01StacksQueues.Exercise;

import java.util.*;

public class T09PoisonousPlants {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Integer> plants = new ArrayList<>();

        while (n-- > 0) {
            plants.add(scanner.nextInt());
        }

        int[] days = new int[n];
        Stack<Integer> stack = new Stack<>();
        int maxDays = 0;

        for (int i = 0; i < n; i++) {
            int maxDaysForCurrentPlant = 0;

            while (!stack.isEmpty() && plants.get(stack.peek()) >= plants.get(i)) {
                maxDaysForCurrentPlant = Math.max(maxDaysForCurrentPlant, days[stack.pop()]);
            }

            if (!stack.isEmpty()) {
                days[i] = maxDaysForCurrentPlant + 1;
            }
            
            stack.push(i);
            maxDays = Math.max(maxDays, days[i]);
        }
        System.out.println(maxDays);
    }
}