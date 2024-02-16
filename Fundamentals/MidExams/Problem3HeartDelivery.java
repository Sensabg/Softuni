package MidExams;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Problem3HeartDelivery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> listOfEvenIntegers = Arrays.stream(scanner.nextLine().split("@"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int saveLastIndex = -1;

        String command = scanner.nextLine();
        while (!"Love!".equals(command)) {

            int step = Integer.parseInt(command.split(" ")[1]);
            int jumpOnIndex = saveLastIndex + step;

            if (saveLastIndex < 0) {
                jumpOnIndex++;
            }

            if (jumpOnIndex > listOfEvenIntegers.size() - 1) {
                jumpOnIndex = 0;
            }

            if (listOfEvenIntegers.get(jumpOnIndex) != 0) {
                int getNumber = listOfEvenIntegers.get(jumpOnIndex);
                listOfEvenIntegers.set(jumpOnIndex, getNumber - 2);
                if (listOfEvenIntegers.get(jumpOnIndex) == 0) {
                    System.out.printf("Place %d has Valentine's day.\n", jumpOnIndex);
                }
            } else {
                System.out.printf("Place %d already had Valentine's day.\n", jumpOnIndex);
            }

            saveLastIndex = jumpOnIndex;

            command = scanner.nextLine();
        }

        System.out.printf("Cupid's last position was %d.\n", saveLastIndex);

        int count = listOfEvenIntegers.stream()
                 .mapToInt(value -> value == 0 ? 1 : 0)
                 .sum();

        if (count == listOfEvenIntegers.size()) {
            System.out.println("Mission was successful.");
        } else {
            System.out.printf("Cupid has failed %d places.", listOfEvenIntegers.size() - count);
        }
    }
}
