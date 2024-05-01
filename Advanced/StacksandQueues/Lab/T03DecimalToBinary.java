package StacksQueues.Lab;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;


public class T03DecimalToBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> binaryStack = new ArrayDeque<>();

        int num = Integer.parseInt(scanner.nextLine());

        if(num == 0){
            System.out.println(0);
            return;
        }

        while (num != 0) {
            int r = num % 2;
            binaryStack.push(r);
            num /= 2;
        }

        while (!binaryStack.isEmpty()) {
            System.out.print(binaryStack.pop());
        }
    }
}