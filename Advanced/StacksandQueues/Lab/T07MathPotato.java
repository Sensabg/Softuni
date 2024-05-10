package StacksQueues.Lab;

import java.util.*;

public class T07MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        int passCount = Integer.parseInt(scanner.nextLine());

        PriorityQueue<String> kidsQue = new PriorityQueue<>();
        Collections.addAll(kidsQue, input);

        int cycles = 1;

        while (kidsQue.size() > 1) {
            for (int i = 1; i < passCount; i++) {
                String previousKid = kidsQue.poll();
                kidsQue.offer(previousKid);
            }
            if (isPrime(cycles)) {
                System.out.printf("Prime %s%n", kidsQue.peek());
            } else {
                System.out.println("Removed " + kidsQue.peek());
                kidsQue.poll();
            }
            cycles++;
        }
        System.out.printf("Last is %s%n", kidsQue.peek());
    }
    private static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}