package MidExams;

import java.util.*;
import java.util.stream.Collectors;

public class Problem3Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<Integer> listOfIntegers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> topIntegers = new ArrayList<>();

        double sum = 0;
        for (int num : listOfIntegers) {
            sum += num;
        }

        double averageNumber = sum / listOfIntegers.size();

        for (int num : listOfIntegers) {
            if (averageNumber < num) {
                topIntegers.add(num);
            }
        }

        Collections.sort(topIntegers, Collections.reverseOrder());
        int topCount = Math.min(5, topIntegers.size());
        List<Integer> topFiveNumbers = topIntegers.subList(0, topCount);

        if (topIntegers.isEmpty()) {
            System.out.println("No");
        } else {
            System.out.println(topFiveNumbers.toString().replaceAll("[\\[\\],]", ""));
        }
    }
}
