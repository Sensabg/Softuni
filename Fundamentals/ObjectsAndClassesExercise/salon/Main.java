package ObjectsAndClassesExercise.salon;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        GroomingSalon salon = new GroomingSalon(20);

        Pet dog = new Pet("Ellias", 5, "Tim");

        System.out.println(dog);

        salon.add(dog);

        System.out.println(salon.remove("Ellias"));
        System.out.println(salon.remove("Pufa"));

        Pet cat = new Pet("Bella", 2, "Mia");
        Pet bunny = new Pet("Zak", 4, "Jon");

        salon.add(cat);
        salon.add(bunny);

        Pet pet = salon.getPet("Bella", "Mia");

        System.out.println(pet);
        System.out.println(salon.getCount()); // 2
        System.out.println(salon.getStatistics());
    }
}