package T01StacksQueues.Exercise;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class T07SimpleTextEditor2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int commandsAmount = Integer.parseInt(scanner.nextLine());
        StringBuilder currentText = new StringBuilder();
        Deque<String> stack = new ArrayDeque<>();
        stack.push("");

        while (commandsAmount-- > 0) {
            String[] command = scanner.nextLine().split("\\s+");
            switch (command[0]) {
                case "1":
                    stack.push(currentText.append(command[1]).toString());
                    break;
                case "2":
                    int count = Integer.parseInt(command[1]);
                    stack.push(currentText.delete(currentText.length() - count, currentText.length()).toString());
                    break;
                case "3":
                    System.out.println(currentText.charAt(Integer.parseInt(command[1]) - 1));
                    break;
                case "4":
                    currentText.setLength(0);
                    currentText.append(stack.pop());
                    break;
            }
        }
    }
}