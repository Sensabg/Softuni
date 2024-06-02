package T01StacksQueues.Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class T01ReverseNumbersWithStack {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);

        ArrayDeque <Integer> stack = new ArrayDeque<>();
        Scanner lineScanner = new Scanner(scanner.nextLine());

        while (lineScanner.hasNextInt()) {
            stack.push(lineScanner.nextInt());
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}
