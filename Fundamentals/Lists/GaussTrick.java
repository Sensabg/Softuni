package Lists;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GaussTrick {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays
                .stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
//1 2 3 4 5
        for (int i = 0; i < numbers.size() - 1; i++) {
            int rightElement = numbers.get(numbers.size() - 1);
            int leftElement = numbers.get(i);
            numbers.set(i, leftElement + rightElement);
            numbers.remove(numbers.size() - 1);
        }
        extracted(numbers);
    }

    public static void extracted(List<Integer> numbers) {
        for (int number : numbers) {
            System.out.print(new DecimalFormat("0.####").format(number) + " ");
        }
    }
}
