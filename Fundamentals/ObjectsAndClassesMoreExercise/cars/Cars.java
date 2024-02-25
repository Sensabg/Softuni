package ObjectsAndClassesMoreExercise.cars;

public class Cars {
    String model;
    int engineSpeed;
    int enginePower;
    int cargoWeight;
    String cargoType;
    double tireOnePressure;
    int tireOneAge;
    double tireTwoPressure;
    int tireTwoAge;
    double tireThreePressure;
    int tireThreeAge;
    double tireFourPressure;
    int tireFourAge;

    public Cars(String model, int engineSpeed, int enginePower,
                int cargoWeight, String cargoType, double tireOnePressure,
                int tireOneAge, double tireTwoPressure, int tireTwoAge,
                double tireThreePressure, int tireThreeAge, double tireFourPressure, int tireFourAge) {

        this.model = model;
        this.engineSpeed = engineSpeed;
        this.enginePower = enginePower;
        this.cargoWeight = cargoWeight;
        this.cargoType = cargoType;
        this.tireOnePressure = tireOnePressure;
        this.tireOneAge = tireOneAge;
        this.tireTwoPressure = tireTwoPressure;
        this.tireTwoAge = tireTwoAge;
        this.tireThreePressure = tireThreePressure;
        this.tireThreeAge = tireThreeAge;
        this.tireFourPressure = tireFourPressure;
        this.tireFourAge = tireFourAge;
    }
    
    public String getModel() {
        return model;
    }
    
    public int getEnginePower() {
        return enginePower;
    }
    
    public String getCargoType() {
        return cargoType;
    }
    
    public double getTireOnePressure() {
        return tireOnePressure;
    }
    
    public double getTireTwoPressure() {
        return tireTwoPressure;
    }
    
    public double getTireThreePressure() {
        return tireThreePressure;
    }
    
    public double getTireFourPressure() {
        return tireFourPressure;
    }
}
