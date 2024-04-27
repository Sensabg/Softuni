package StacksQueues.Lab.T01;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<String> historyStack = new ArrayDeque<>();
        String URL;

        while (!"Home".equals(URL = scanner.nextLine())) {
            if (URL.equals("back")) {
                if (historyStack.size() <= 1) {
                    System.out.println("no previous URLs");
                } else {
                    historyStack.pop();
                    System.out.println(historyStack.peek());
                }
            } else{
                historyStack.push(URL);
                System.out.println(historyStack.peek());
            }
        }
    }
}
