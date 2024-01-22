package FirsStepsInCoding;

import java.util.Scanner;

public class ProjectsCreation {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String Name = scanner.nextLine();
        int amountOfProjects = Integer.parseInt(scanner.nextLine());

        int project = 3;

        int amountOfHoursNeeded = amountOfProjects * project;

        System.out.printf("The architect %s will need %d hours to complete %d project/s.", Name,amountOfHoursNeeded, amountOfProjects);
    }
}
