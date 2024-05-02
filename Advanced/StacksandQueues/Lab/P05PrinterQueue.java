package StacksQueues.Lab;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class P05PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Deque<String> filesQue = new ArrayDeque<>();
        String input;

        while (!"print".equals(input = scanner.nextLine())) {

            if (!input.equals("cancel")) {

                filesQue.offer(input);

            } else if (!filesQue.isEmpty()) {

                String currentFile = filesQue.peek();
                System.out.println("Canceled " + currentFile);

                filesQue.poll();

            } else {
                System.out.println("Printer is on standby");
            }
        }

        while(!filesQue.isEmpty()){
            System.out.println(filesQue.poll());
        }
    }
}
