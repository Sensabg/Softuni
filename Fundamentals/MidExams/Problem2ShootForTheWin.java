package MidExams;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Problem2ShootForTheWin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> listOfIntegersTargets = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int counter = 0;

        String command = scanner.nextLine();
        while (!"End".equals(command)) {
            int index = Integer.parseInt(command);

            if(index >= 0 && index <= listOfIntegersTargets.size() - 1) {
                int saveItem = listOfIntegersTargets.get(index);
                listOfIntegersTargets.set(index, -1);
                counter++;
                for (int i = 0; i < listOfIntegersTargets.size(); i++) {
                    if (saveItem >= listOfIntegersTargets.get(i) && listOfIntegersTargets.get(i) != -1) {
                        int increaseValues = listOfIntegersTargets.get(i);
                        increaseValues += saveItem;
                        listOfIntegersTargets.set(i, increaseValues);
                    } else if (saveItem < listOfIntegersTargets.get(i) && listOfIntegersTargets.get(i) != -1) {
                        int decreaseValues = listOfIntegersTargets.get(i);
                        decreaseValues -= saveItem;
                        listOfIntegersTargets.set(i, decreaseValues);
                    }
                }
            }
            command = scanner.nextLine();
        }
        System.out.print("Shot targets: " + counter + " -> ");
        System.out.print(listOfIntegersTargets.toString().replace("[", "")
                .replace(", ", " ")
                .replace("]", ""));
    }
}