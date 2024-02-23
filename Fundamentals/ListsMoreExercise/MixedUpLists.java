package ListsMoreExercise;

import java.util.*;
import java.util.stream.Collectors;

public class MixedUpLists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> sequenceOne = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> sequenceTwo = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> mergedLists = new ArrayList<>();
        List<Integer> rangeList = new ArrayList<>();

        int minSize = Math.min(sequenceOne.size(), sequenceTwo.size());
        int maxSize = Math.max(sequenceOne.size(), sequenceTwo.size());
        int range = maxSize - minSize;

        for (int i = 0; i < minSize; i++) {
            mergedLists.add(sequenceOne.get(i));
            mergedLists.add(sequenceTwo.get(sequenceTwo.size() - 1 - i));
        }

        for (int i = 0; i < range; i++) {
            if (sequenceOne.size() > sequenceTwo.size()) {
                rangeList.add(0,sequenceOne.get(sequenceOne.size() - range + i));
            } else {
                rangeList.add(0,sequenceTwo.get(i));
            }
        }

        Collections.sort(rangeList);
        Collections.sort(mergedLists);

        String result = mergedLists.stream()
                .filter(n -> n > rangeList.get(0) && n < rangeList.get(1))
                .map(Object::toString)
                .collect(Collectors.joining(" "));

        System.out.println(result);
    }
}