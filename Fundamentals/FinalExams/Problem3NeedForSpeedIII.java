package FinalExams;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Problem3NeedForSpeedIII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, Integer> carsMileage = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> carsFuel = new LinkedHashMap<>();

        int numberOfCars = Integer.parseInt(scanner.nextLine());
        String input;
        String[] info;

        for (int i = 0; i < numberOfCars; i++) {
            input = scanner.nextLine();
            info = input.split("\\|");
            String car = info[0];
            int mileage = Integer.parseInt(info[1]);
            int fuel = Integer.parseInt(info[2]);

            carsMileage.put(car, mileage);
            carsFuel.put(car, fuel);
        }

        while (!"Stop".equals(input = scanner.nextLine())) {
            info = input.split(" : ");
            String command = info[0];
            String car = info[1];

            switch (command) {

                case "Drive":
                    int targetDistance = Integer.parseInt(info[2]);
                    int neededFuel = Integer.parseInt(info[3]);

                    if (carsFuel.get(car) - neededFuel < 0) {
                        System.out.println("Not enough fuel to make that ride");
                    } else {
                        System.out.println(car + " driven for " + targetDistance + " kilometers. " + neededFuel + " liters of fuel consumed.");
                        carsFuel.put(car, carsFuel.get(car) - neededFuel);
                        carsMileage.put(car, carsMileage.get(car) + targetDistance);

                        if (carsMileage.get(car) >= 100000) {
                            System.out.printf("Time to sell the %s!\n", car);
                            carsMileage.remove(car);
                            carsFuel.remove(car);
                        }
                    }
                    break;

                case "Refuel":
                    int addFuel = Integer.parseInt(info[2]);

                    if (carsFuel.get(car) + addFuel >= 75) {
                        System.out.printf("%s refueled with %d liters\n", car,75 - carsFuel.get(car));
                        carsFuel.put(car, 75);
                    } else {
                        carsFuel.put(car, carsFuel.get(car) + addFuel);
                        System.out.printf("%s refueled with %d liters\n", car,addFuel);
                    }
                    break;

                case "Revert":
                    int kilometers = Integer.parseInt(info[2]);

                    if (carsMileage.get(car) - kilometers < 10000) {
                        carsMileage.put(car, 10000);
                    } else {
                        carsMileage.put(car, carsMileage.get(car) - kilometers);
                        System.out.printf("%s mileage decreased by %d kilometers\n", car, kilometers);
                    }
                    break;
            }
        }
        for (Map.Entry<String, Integer> carsInfo : carsMileage.entrySet()) {
            String car = carsInfo.getKey();
            int mileage = carsInfo.getValue();
            int fuel = carsFuel.get(car);

            System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.\n", car, mileage, fuel);
        }
    }
}
