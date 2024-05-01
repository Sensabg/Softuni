package StacksQueues.Lab;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class T04MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<String> expressionStack = new ArrayDeque<>();

        String input = scanner.nextLine();

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(') {
                expressionStack.push(String.valueOf(i));
            } else if (input.charAt(i) == ')') {
                int startIndex = Integer.parseInt(expressionStack.pop());
                String expression = input.substring(startIndex, i + 1);
                System.out.println(expression);
            }
        }
    }
}
