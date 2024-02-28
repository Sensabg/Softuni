package ObjectsAndClassesMoreExercise.salesman;

public class Engine {
    private  String engineModel;
    private   String power;
    private  String displacement;
    private   String efficiency;

    public Engine(String engineModel, String power, String displacement, String efficiency) {
        this.engineModel = engineModel;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    public String getEngineModel() {
        return engineModel;
    }

    public String getPower() {
        return power;
    }

    public String getDisplacement() {
        return displacement;
    }

    public String getEfficiency() {
        return efficiency;
    }


    public String toString() {
        return String.format("%s %s %s %s", this.engineModel, this.power, this.displacement, this.efficiency);
    }
}
