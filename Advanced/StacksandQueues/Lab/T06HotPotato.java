package StacksQueues.Lab;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.Scanner;

public class T06HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        int passCount = Integer.parseInt(scanner.nextLine());

        Deque<String> kidsQue = new ArrayDeque<>();
        Collections.addAll(kidsQue,input);

        while(kidsQue.size() > 1){
            for (int i = 1; i < passCount; i++) {
                String previousKid = kidsQue.poll();
                kidsQue.offer(previousKid);
            }
            System.out.println("Removed " + kidsQue.peek());
            kidsQue.poll();
        }
        System.out.printf("Last is %s%n", kidsQue.peek());
    }
}