package ObjectsAndClassesExercise.vehicle;

public class Vehicle {

    private String type;
    private String model;
    private String color;
    private int horsePower;

    public Vehicle(String type, String model, String color, int horsePower) {
        this.type = type;
        this.model = model;
        this.color = color;
        this.horsePower = horsePower;
    }

    public String getType() {
        return type;
    }

    public String getModel() {
        return model;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public String toString() {

        String vehicleType = type.equals("car") ? "Car" : "Truck";
        return "Type: " + vehicleType + "\n" +
                "Model: " + model + "\n" +
                "Color: " + color + "\n" +
                "Horsepower: " + horsePower;
    }
}