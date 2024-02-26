package ObjectsAndClassesMoreExercise.salesman;

public class Car {
    String carModel;
    Engine engine;
    String weight;
    String color;

    public Car(String carModel, Engine engine, String weight, String color) {
        this.carModel = carModel;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }

    public String getCarModel() {
        return carModel;
    }

    public String getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

    public String toString() {
        return String.format("%s %s %s %s", this.carModel, this.engine, this.weight, this.color);
    }
}
