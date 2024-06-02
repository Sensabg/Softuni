package T01StacksQueues.Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class T07SimpleTextEditor1 {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            StringBuilder s = new StringBuilder();
            ArrayDeque<StringBuilder> stack = new ArrayDeque<>();
            stack.push(s);

            while (n-- > 0) {
                switch (scanner.nextInt()) {
                    case 1 -> stack.push(new StringBuilder(stack.peek()).append(scanner.next()));
                    case 2 -> stack.push(new StringBuilder(stack.peek()).delete(stack.peek().length() - scanner.nextInt(), stack.peek().length()));
                    case 3 -> System.out.println(stack.peek().charAt(scanner.nextInt() - 1));
                    case 4 -> stack.pop();
                }
            }
        }
    }