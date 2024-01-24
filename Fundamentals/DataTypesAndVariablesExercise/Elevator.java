package DataTypesAndVariablesExercise;

import java.util.Scanner;

public class Elevator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int peopleAmount = Integer.parseInt(scanner.nextLine());
        int capacity = Integer.parseInt(scanner.nextLine());

        int coursesNeeded = peopleAmount / capacity;

        if (peopleAmount % capacity != 0) {
            coursesNeeded++;
        }
        System.out.println(coursesNeeded);
    }
}