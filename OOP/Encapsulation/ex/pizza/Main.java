package pizza;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] pizzaInput = scanner.nextLine().replace("Pizza", "").trim().split("\\s+");
        String pizzaName = pizzaInput[0];
        int numberOfToppings = Integer.parseInt(pizzaInput[1]);

        Pizza pizza = new Pizza(pizzaName, numberOfToppings);

        String[] doughInput = scanner.nextLine().replace("Dough", "").trim().split("\\s+");
        String flourType = doughInput[0];
        String bakingTechnique = doughInput[1];
        double doughWeight = Double.parseDouble(doughInput[2]);

        Dough dough = new Dough(flourType, bakingTechnique, doughWeight);

        pizza.setDough(dough);

        String command;
        while (!"END".equals(command = scanner.nextLine())){
            String[] toppingInput = command.replace("Topping", "").trim().split("\\s+");

            String toppingType = toppingInput[0];
            double toppingWeight = Double.parseDouble(toppingInput[1]);

            Topping topping = new Topping(toppingType, toppingWeight);
            pizza.addTopping(topping);
        }
        System.out.printf("%s - %.2f%n", pizza.getName(), pizza.getOverallCalories());
    }
}