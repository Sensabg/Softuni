package ObjectsAndClassesMoreExercise.cars;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Cars> cars = new ArrayList<>();
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] carInfo = scanner.nextLine().split("\\s+");
            String model = carInfo[0];

            int engineSpeed = Integer.parseInt(carInfo[1]);
            int enginePower = Integer.parseInt(carInfo[2]);
            int cargoWeight = Integer.parseInt(carInfo[3]);

            String cargoType = carInfo[4];

            double tireOnePressure = Double.parseDouble(carInfo[5]);
            int tireOneAge = Integer.parseInt(carInfo[6]);
            double tireTwoPressure = Double.parseDouble(carInfo[7]);
            int tireTwoAge = Integer.parseInt(carInfo[8]);
            double tireThreePressure = Double.parseDouble(carInfo[9]);
            int tireThreeAge = Integer.parseInt(carInfo[10]);
            double tireFourPressure = Double.parseDouble(carInfo[11]);
            int tireFourAge = Integer.parseInt(carInfo[12]);

            Cars newCar = new Cars(model, engineSpeed, enginePower,
                    cargoWeight, cargoType, tireOnePressure,
                    tireOneAge, tireTwoPressure, tireTwoAge,
                    tireThreePressure, tireThreeAge, tireFourPressure, tireFourAge);

            cars.add(newCar);
        }

        String filterByType = scanner.nextLine();

        if(filterByType.equals("fragile")){

            List<String> fragileCarModels = cars.stream()
                    .filter(car -> "fragile".equalsIgnoreCase(car.getCargoType())
                            && (car.getTireOnePressure() < 1
                            || car.getTireTwoPressure() < 1
                            || car.getTireThreePressure() < 1
                            || car.getTireFourPressure() < 1))
                    .map(Cars::getModel)
                    .collect(Collectors.toList());

            fragileCarModels.forEach(System.out::println);
        } else {

            List<String> flamableCarModels = cars.stream()
                    .filter(car -> "flamable".equalsIgnoreCase(car.getCargoType())
                            && car.getEnginePower() > 250)
                    .map(Cars::getModel)
                    .collect(Collectors.toList());

            flamableCarModels.forEach(System.out::println);
        }
    }
}
