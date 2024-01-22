package ForLoopMoreExercises;

import java.util.Scanner;

public class Logistics {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int cargoAmount = Integer.parseInt(scanner.nextLine());

        int totalCargo = 0;
        int microBus = 0;
        int truck = 0;
        int train = 0;

        for (int i = 0; i < cargoAmount; i++) {
            int cargo = Integer.parseInt(scanner.nextLine());

            totalCargo += cargo;

            if (cargo <= 3) {
                microBus += cargo;
            } else if (cargo <= 11) {
                truck += cargo;
            } else {
                train += cargo;
            }
        }
        
        int totalMicroBus = microBus * 200;
        int totalTruck = truck * 175;
        int totalTrain = train * 120;

        double combinedAverage = ((totalMicroBus + totalTruck + totalTrain) * 1.0) / totalCargo;

        double microBusPercent = (microBus * 100.0) / totalCargo;
        double truckPercent = (truck * 100.0) / totalCargo;
        double trainPercent = (train * 100.0) / totalCargo;

        System.out.printf("%.2f\n",combinedAverage);
        System.out.printf("%.2f%%\n",microBusPercent);
        System.out.printf("%.2f%%\n",truckPercent);
        System.out.printf("%.2f%%\n",trainPercent);

    }
}
