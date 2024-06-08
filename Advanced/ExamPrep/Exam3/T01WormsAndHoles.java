package ExamPrep.Exam3;

import java.util.ArrayDeque;
import java.util.Scanner;

public class T01WormsAndHoles {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> wormsStack = new ArrayDeque<>();
        for (String capacity : scanner.nextLine().split("\\s+")) {
            wormsStack.push(Integer.parseInt(capacity));
        }

        ArrayDeque<Integer> holesQue = new ArrayDeque<>();
        for (String pie : scanner.nextLine().split("\\s+")) {
            holesQue.offer(Integer.parseInt(pie));
        }

        int matches = 0;
        int totalWorms = wormsStack.size();

        while (!wormsStack.isEmpty() && !holesQue.isEmpty()) {
            int currentWorm = wormsStack.peek();
            int hole = holesQue.peek();

            if (currentWorm == hole) {
                wormsStack.pop();
                holesQue.poll();
                matches++;
            } else {
                holesQue.poll();
                wormsStack.pop();
                wormsStack.push(currentWorm - 3);
                if (currentWorm - 3 <= 0) {
                    wormsStack.pop();
                }
            }
        }

        if (matches > 0) {
            System.out.println("Matches: " + matches);
        } else {
            System.out.println("There are no matches.");
        }

        if (matches == totalWorms) {
            System.out.println("Every worm found a suitable hole!");
        } else if (wormsStack.isEmpty()) {
            System.out.println("Worms left: none");
        } else {
            System.out.print("Worms left: ");
            System.out.println(wormsStack.reversed().toString()
                                                    .replace("[", "")
                                                    .replace("]", ""));
        ]
        if (!holesQue.isEmpty()) {
            System.out.print("Holes left: ");
            System.out.println(holesQue.toString()
                                       .replace("[", "")
                                       .replace("]", ""));
        } else {
            System.out.println("Holes left: none");
        }
    }
}
