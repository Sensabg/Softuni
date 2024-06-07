package ExamPrep.Exam1;

import java.util.*;


public class T01PiePursuit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> capacityQue = new ArrayDeque<>();
        for (String capacity : scanner.nextLine().split("\\s+")) {
            capacityQue.offer(Integer.parseInt(capacity));
        }

        ArrayDeque<Integer> piesStack = new ArrayDeque<>();
        for (String pie : scanner.nextLine().split("\\s+")) {
            piesStack.push(Integer.parseInt(pie));
        }

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

        String format;
        if (piesStack.isEmpty() && !capacityQue.isEmpty()) {
            System.out.println("We will have to wait for more pies to be baked!");
            format = String.valueOf(capacityQue);
            System.out.println("Contestants left: " + format.replace("[", "").replace("]", ""));
        } else if (capacityQue.isEmpty() && piesStack.isEmpty()) {
            System.out.println("We have a champion!");
        } else if (capacityQue.isEmpty() && !piesStack.isEmpty()) {
            System.out.println("Our contestants need to rest!");
            format = String.valueOf(piesStack.reversed());
            System.out.println("Pies left: " + format.replace("[", "").replace("]", ""));
        }
    }
}
