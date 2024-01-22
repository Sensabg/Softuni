package ForLoopMoreExercises;

import java.util.Scanner;

public class Hospital {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int period = Integer.parseInt(scanner.nextLine());

        int doctors = 7;

        int servedPatients = 0;
        int unServedPatients = 0;
        int totalPatients = 0;

        for (int i = 1; i <= period; i++) {
            int patients = Integer.parseInt(scanner.nextLine());

            totalPatients += patients;

            if (unServedPatients > servedPatients && i % 3 == 0) {
                doctors++;
            }

            if (patients > doctors) {
                unServedPatients += Math.abs(doctors - patients);
            }
            servedPatients = Math.abs(unServedPatients - totalPatients);
        }


        System.out.printf("Treated patients: %d.", servedPatients);
        System.out.printf("\nUntreated patients: %d.", unServedPatients);
    }
}
