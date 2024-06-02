package T01StacksQueues.Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class T05BalancedParentheses2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        System.out.println(isBalanced(input) ? "YES" : "NO");
    }

    private static boolean isBalanced(String input) {
        ArrayDeque<Character> stack = new ArrayDeque<>();

        for (char ch : input.toCharArray()) {
            if (isOpenBracket(ch)) {
                stack.push(ch);
            } else {
                if (stack.isEmpty() || !isMatching(stack.pop(), ch)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private static boolean isOpenBracket(char ch) {
        return ch == '(' || ch == '[' || ch == '{';
    }

    private static boolean isMatching(char open, char close) {
        return (open == '(' && close == ')') ||
                (open == '[' && close == ']') ||
                (open == '{' && close == '}');
    }
}