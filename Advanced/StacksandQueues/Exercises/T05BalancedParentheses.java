package T01StacksQueues.Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class T05BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ArrayDeque<Character> stackOne = new ArrayDeque<>();
        ArrayDeque<Character> stackTwo = new ArrayDeque<>();

        for (int i = 0; i < input.length(); i++) {
            if (isOpenBracket(input, i)) {
                stackOne.push(input.charAt(i));
            } else {
                switch (input.charAt(i)) {
                    case ')' -> stackTwo.push('(');
                    case ']' -> stackTwo.push('[');
                    case '}' -> stackTwo.push('{');
                }
            }
        }

        if (stackOne.size() != stackTwo.size()) {
            System.out.println("NO");
        } else {
            while (!stackOne.isEmpty() && !stackTwo.isEmpty()) {
                int left = stackOne.pop();
                int right = stackTwo.reversed().pop();
                if (left != right) {
                    System.out.println("NO");
                    return;
                }
            }
            System.out.println("YES");
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