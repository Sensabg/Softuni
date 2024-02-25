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

    public void setModel(String model) {
        this.model = model;
    }

    public int getEngineSpeed() {
        return engineSpeed;
    }

    public void setEngineSpeed(int engineSpeed) {
        this.engineSpeed = engineSpeed;
    }

    public int getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(int enginePower) {
        this.enginePower = enginePower;
    }

    public int getCargoWeight() {
        return cargoWeight;
    }

    public void setCargoWeight(int cargoWeight) {
        this.cargoWeight = cargoWeight;
    }

    public String getCargoType() {
        return cargoType;
    }

    public void setCargoType(String cargoType) {
        this.cargoType = cargoType;
    }

    public double getTireOnePressure() {
        return tireOnePressure;
    }

    public void setTireOnePressure(double tireOnePressure) {
        this.tireOnePressure = tireOnePressure;
    }

    public int getTireOneAge() {
        return tireOneAge;
    }

    public void setTireOneAge(int tireOneAge) {
        this.tireOneAge = tireOneAge;
    }

    public double getTireTwoPressure() {
        return tireTwoPressure;
    }

    public void setTireTwoPressure(double tireTwoPressure) {
        this.tireTwoPressure = tireTwoPressure;
    }

    public int getTireTwoAge() {
        return tireTwoAge;
    }

    public void setTireTwoAge(int tireTwoAge) {
        this.tireTwoAge = tireTwoAge;
    }

    public double getTireThreePressure() {
        return tireThreePressure;
    }

    public void setTireThreePressure(double tireThreePressure) {
        this.tireThreePressure = tireThreePressure;
    }

    public int getTireThreeAge() {
        return tireThreeAge;
    }

    public void setTireThreeAge(int tireThreeAge) {
        this.tireThreeAge = tireThreeAge;
    }

    public double getTireFourPressure() {
        return tireFourPressure;
    }

    public void setTireFourPressure(double tireFourPressure) {
        this.tireFourPressure = tireFourPressure;
    }

    public int getTireFourAge() {
        return tireFourAge;
    }

    public void setTireFourAge(int tireFourAge) {
        this.tireFourAge = tireFourAge;
    }
}
