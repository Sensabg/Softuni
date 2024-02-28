package ObjectsAndClassesMoreExercise.salesman;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Engine> engineList = new ArrayList<>();
        List<Car> carList = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\d{2,}");
        String displacement = "n/a";
        String efficiency = "n/a";
        String weight = "n/a";
        String color = "n/a";

        int enginesAmount = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < enginesAmount; i++) {
            String[] engineInfo = scanner.nextLine().split("\\s+");

            String engineModel = engineInfo[0];
            String power = engineInfo[1];

            if (engineInfo.length == 3) {
                Matcher matcher = pattern.matcher(engineInfo[2]);
                if (matcher.find()) {
                    displacement = engineInfo[2];
                } else {
                    efficiency = engineInfo[2];
                }
            } else if (engineInfo.length == 4) {
                Matcher matcher = pattern.matcher(engineInfo[2]);
                if (matcher.find()) {
                    displacement = engineInfo[2];
                    efficiency = engineInfo[3];
                } else {
                    displacement = engineInfo[3];
                    efficiency = engineInfo[2];
                }
            }
            Engine engine = new Engine(engineModel, power, displacement, efficiency);
            engineList.add(engine);
        }
        int carsAmount = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < carsAmount; i++) {
            String[] carInfo = scanner.nextLine().split("\\s+");
            String carModel = carInfo[0];

            String engineModel = carInfo[1];
            for (Engine existingEngine : engineList) {
                if (existingEngine.getEngineModel().equals(engineModel)) {
                    displacement = existingEngine.getDisplacement();
                    efficiency = existingEngine.getEfficiency();
                    String power = existingEngine.getPower();

                    if (carInfo.length == 3) {
                        Matcher matcher = pattern.matcher(carInfo[2]);
                        if (matcher.find()) {
                            weight = carInfo[2];
                        } else {
                            color = carInfo[2];
                        }
                    } else if (carInfo.length == 4) {
                        Matcher matcher = pattern.matcher(carInfo[2]);
                        if (matcher.find()) {
                            weight = carInfo[2];
                            color = carInfo[3];
                        } else {
                            weight = carInfo[3];
                            color = carInfo[2];
                        }
                    }
                    Engine engine = new Engine(engineModel, power, displacement, efficiency);
                    Car car = new Car(carModel, engine, weight, color);
                    carList.add(car);
                }
            }
        }
        for (Car existingCars : carList) {
            System.out.println(existingCars.getCarModel() + ":");
            System.out.println("  " + existingCars.getEngine().getEngineModel() + ":");
            System.out.println("    Power: " + existingCars.getEngine().getPower());
            System.out.println("    Displacement: " + existingCars.getEngine().getDisplacement());
            System.out.println("    Efficiency: " + existingCars.getEngine().getEfficiency());
            System.out.println("  Weight: " + existingCars.getWeight());
            System.out.println("  Color: " + existingCars.getColor());
        }
    }
}
