package T01StacksQueues.Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class T05BalancedParentheses1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Character> stackOne = new ArrayDeque<>();
        String input = scanner.nextLine();

        for (int i = 0; i < input.length(); i++) {
            if (isOpenBracket(input, i)) {
                stackOne.push(input.charAt(i));
            } else {
                char current = input.charAt(i);

                if (!stackOne.isEmpty()) {
                    switch (input.charAt(i)) {
                        case ')' -> current = '(';
                        case ']' -> current = '[';
                        case '}' -> current = '{';
                    }
                    if (current != stackOne.pop()) {
                        System.out.println("NO");
                        return;
                    }
                }
            }
        }
        if(stackOne.isEmpty()){
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }

    private static boolean isOpenBracket(String input, int i) {
        return input.charAt(i) == ('(')
                ||
                input.charAt(i) == ('[')
                ||
                input.charAt(i) == ('{');
    }
}