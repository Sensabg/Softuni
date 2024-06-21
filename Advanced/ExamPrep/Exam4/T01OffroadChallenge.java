package ExamPrep.Exam4;

import java.util.*;
import java.util.function.Consumer;

public class T01OffroadChallenge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> fuelStack = new ArrayDeque<>();
        fillArrayDeque(scanner, fuelStack::push);

        ArrayDeque<Integer> consumptionQue = new ArrayDeque<>();
        fillArrayDeque(scanner, consumptionQue::offer);

        ArrayDeque<Integer> neededFuelQue = new ArrayDeque<>();
        fillArrayDeque(scanner, neededFuelQue::offer);

        boolean enoughFuel = true;

        int altitude = 0;
        List<String> altitudes = new ArrayList<>();

        while (!areEmpty(fuelStack, consumptionQue, neededFuelQue)) {
            if (fuelStack.peek() - consumptionQue.peek() >= neededFuelQue.peek()) {
                fuelStack.pop();
                consumptionQue.poll();
                neededFuelQue.poll();
                altitude++;
                altitudes.add("Altitude " + altitude);
                System.out.printf("John has reached: Altitude %d\n", altitude);
            } else {
                enoughFuel = false;
                break;
            }
        }

        if (!enoughFuel) {
            System.out.printf("John did not reach: Altitude %d\n", altitude + 1);
        }

        if (fuelStack.isEmpty()) {
            System.out.println("John has reached all the altitudes and managed to reach the top!");
        } else {
            System.out.println("John failed to reach the top.");
        }

        if (altitude == 0) {
            System.out.println("John didn't reach any altitude.");
        } else {
            System.out.printf("Reached altitudes: %s",String.valueOf(altitudes).replace("[","").replace("]",""));
        }
    }

    private static void fillArrayDeque(Scanner scanner, Consumer<Integer> insertion) {
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(insertion);
    }

    public static boolean areEmpty(ArrayDeque<Integer> fuel, ArrayDeque<Integer> consumption, ArrayDeque<Integer> required) {
        return fuel.isEmpty() || consumption.isEmpty() || required.isEmpty();
    }
}
