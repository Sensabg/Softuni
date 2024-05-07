package StacksQueues.Lab;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class T08BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<String> historyPreviousURLStack = new ArrayDeque<>();
        Deque<String> historyNextURLStack = new ArrayDeque<>();
        String URL;

        while (!"Home".equals(URL = scanner.nextLine())) {

            if (URL.equals("back")) {
                if (historyPreviousURLStack.size() <= 1) {
                    System.out.println("no previous URLs");
                } else {
                    historyNextURLStack.push(historyPreviousURLStack.pop());
                    System.out.println(historyPreviousURLStack.peek());
                }
            } else if (URL.equals("forward")) {
                if (historyNextURLStack.isEmpty()) {
                    System.out.println("no next URLs");
                } else {
                    historyPreviousURLStack.push(historyNextURLStack.peek());
                    System.out.println(historyNextURLStack.pop());
                }
            } else {
                historyPreviousURLStack.push(URL);
                System.out.println(historyPreviousURLStack.peek());
                historyNextURLStack.clear();
            }
        }
    }
}