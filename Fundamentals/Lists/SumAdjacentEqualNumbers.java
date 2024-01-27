package Lists;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class SumAdjacentEqualNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Double> numbers = Arrays
                .stream(scanner.nextLine().split(" "))
                .map(Double::parseDouble)
                .collect(Collectors.toList());

        for (int i = 0; i < numbers.size() - 1; i++) {
            double leftElement = numbers.get(i);
            double rightElement = numbers.get(i + 1);
            if (leftElement == rightElement) {
                double newElement = leftElement + rightElement;
                numbers.remove(i + 1);
                numbers.set(i, newElement);
                i = -1;
            }
        }
        extracted(numbers);
    }
    public static void extracted(List<Double> numbers) {
        for (double number : numbers) {
            System.out.print(new DecimalFormat("0.####").format(number) + " ");
        }
    }
}
