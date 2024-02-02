package ListsExercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AppendArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        List<List<Integer>> arrays = Arrays.stream(input.split("\\s*\\|\\s*"))
                .filter(s -> !s.isEmpty())
                .map(group -> Arrays.stream(group.split("\\s+"))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList()))
                .collect(Collectors.toList());

        Collections.reverse(arrays);

        List<Integer> result = arrays.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());

        System.out.println(Arrays.toString(result.toArray())
                .replace("[", "")
                .replace(",", "")
                .replace("]", ""));
    }
}