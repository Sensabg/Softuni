package Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MergingLists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> list1 = Arrays
                .stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> list2 = Arrays
                .stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> result = new ArrayList<>();
        int lastIndex = 0;

        int getLowestSize = Math.min(list1.size(), list2.size());

        while (lastIndex <= getLowestSize - 1) {
            result.add(list1.get(lastIndex));
            result.add(list2.get(lastIndex));

            lastIndex++;
        }

        for (int i = lastIndex; i <= list1.size() - 1; i++) {
            result.add(list1.get(i));
        }

        for (int i = lastIndex; i <= list2.size() - 1; i++) {
            result.add(list2.get(i));

        }
        extracted(result);
    }

    public static void extracted(List<Integer> result) {
        for (int number : result) {
            System.out.print(number + " ");
        }
    }
}