package ObjectsAndClassesMoreExercise.salesman;

public class Car {
    private  String carModel;
    private  Engine engine;
    private  String weight;
    private  String color;

    public Car(String carModel, Engine engine, String weight, String color) {
        this.carModel = carModel;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public void setColor(String color) {
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

    public Engine getEngine() {
        return engine;
    }
}
