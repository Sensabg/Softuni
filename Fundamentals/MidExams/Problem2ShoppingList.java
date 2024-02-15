package MidExams;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Problem2ShoppingList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> listOfIProducts = Arrays
                .stream(scanner.nextLine().split("!"))
                .collect(Collectors.toList());

        String command = scanner.nextLine();
        while (!"Go Shopping!".equals(command)) {

            switch (command.split(" ")[0]) {
                case "Urgent":
                    String addProduct = command.split(" ")[1];
                    if (!listOfIProducts.contains(addProduct)) {
                        listOfIProducts.add(0, addProduct);
                    }
                    break;
                case "Unnecessary":
                    String removeProduct = command.split(" ")[1];
                    listOfIProducts.remove(removeProduct);
                    break;
                case "Correct":
                    String oldProduct = command.split(" ")[1];
                    String newProduct = command.split(" ")[2];
                    int getIndex = listOfIProducts.indexOf(oldProduct);
                    if (listOfIProducts.contains(oldProduct)) {
                        listOfIProducts.set(getIndex, newProduct);
                    }
                    break;
                case "Rearrange":
                    String arrangeItem = command.split(" ")[1];
                    if (listOfIProducts.contains(arrangeItem)) {
                        listOfIProducts.remove(arrangeItem);
                        listOfIProducts.add(arrangeItem);
                    }
                    break;
            }
            command = scanner.nextLine();
        }
        System.out.println(listOfIProducts.toString().replaceAll("[\\[\\]]", ""));
    }
}
