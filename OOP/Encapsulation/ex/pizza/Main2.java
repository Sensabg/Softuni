import pizza.Dough;
import pizza.Pizza;
import pizza.Topping;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] line = scanner.nextLine().split("\\s+");
        Pizza pizza = new Pizza(line[1], Integer.parseInt(line[2]));

        line = scanner.nextLine().split("\\s+");
        pizza.setDough(new Dough(line[1], line[2], Double.parseDouble(line[3])));

        String command;
        while (!"END".equals(command = scanner.nextLine())) {
            line = command.split("\\s+");
            pizza.addTopping(new Topping(line[1], Double.parseDouble(line[2])));
        }

        System.out.printf("%s - %.2f%n", pizza.getName(), pizza.getOverallCalories());
    }
}
