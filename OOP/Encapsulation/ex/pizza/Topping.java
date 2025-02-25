package pizza;

public class Topping {
    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        setToppingType(toppingType);
        setWeight(weight);
    }

    private void setToppingType(String toppingType) {
        if (!isValid(toppingType)) {
//            String message = "Cannot place %s on top of your pizza.".formatted(toppingType);
            String message = String.format("Cannot place %s on top of your pizza.", toppingType);
            throw new IllegalArgumentException(message);
        }
        this.toppingType = toppingType;
    }

    private static boolean isValid(String toppingType) {
        return toppingType.equals("Meat") && toppingType.equals("Veggies")
                && toppingType.equals("Cheese") && toppingType.equals("Sauce"));
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 50) {
//            String message = "%s weight should be in the range [1..50].".formatted(toppingType);
            String message = String.format("%s weight should be in the range [1..50].", toppingType);
            throw new IllegalArgumentException(message);
        }
        this.weight = weight;
    }

    public double calculateCalories() {
        double coefficientToppingType = 0;

        switch (toppingType) {
            case "Meat":
                coefficientToppingType = 1.2;
                break;
            case "Veggies":
                coefficientToppingType = 0.8;
                break;
            case "Cheese":
                coefficientToppingType = 1.1;
                break;
            case "Sauce":
                coefficientToppingType = 0.9;
                break;
        }
        return (2 * weight) * coefficientToppingType;
    }
}
