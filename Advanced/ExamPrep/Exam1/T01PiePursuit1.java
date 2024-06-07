package ExamPrep.Exam1;

import java.util.*;

public class T01PiePursuit1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> capacityQue = parseInputToDeque(scanner, true);
        ArrayDeque<Integer> piesStack = parseInputToDeque(scanner, false);

        while (!capacityQue.isEmpty() && !piesStack.isEmpty()) {
            int competitorCapacity = capacityQue.poll();
            int piePieces = piesStack.pop();

            if (competitorCapacity < piePieces) {
                piesStack.push(piePieces - competitorCapacity);
            } else if (competitorCapacity > piePieces) {
                capacityQue.offer(competitorCapacity - piePieces);
            }
            if (piePieces - competitorCapacity == 1 && piesStack.size() > 1) {
                piePieces = piesStack.pop();
                int previousPie = piesStack.pop();
                piesStack.push(previousPie + piePieces);
            }
        }

        if (piesStack.isEmpty() && !capacityQue.isEmpty()) {
            System.out.println("We will have to wait for more pies to be baked!");
            System.out.println("Contestants left: " + capacityQue.toString().replace("[", "").replace("]", ""));
        } else if (capacityQue.isEmpty() && piesStack.isEmpty()) {
            System.out.println("We have a champion!");
        } else if (capacityQue.isEmpty() && !piesStack.isEmpty()) {
            System.out.println("Our contestants need to rest!");
            System.out.println("Pies left: " + piesStack.reversed().toString().replace("[", "").replace("]", ""));
        }
    }

    private static ArrayDeque<Integer> parseInputToDeque(Scanner scanner, boolean isQueue) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        if (isQueue) {
            for (String capacity : scanner.nextLine().split("\\s+")) {
                deque.offer(Integer.parseInt(capacity));
            }
            return deque;
        }
        for (String pies : scanner.nextLine().split("\\s+")) {
            deque.push(Integer.parseInt(pies));
        }
        return deque;
    }
}
