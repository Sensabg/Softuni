package MidExams;

import java.util.Scanner;

public class Problem2SoftUniReception {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int employeeOne = Integer.parseInt(scanner.nextLine());
        int employeeTwo = Integer.parseInt(scanner.nextLine());
        int employeeThree = Integer.parseInt(scanner.nextLine());

        int students = Integer.parseInt(scanner.nextLine());

        int totalServedStudentsPerHour = employeeOne + employeeTwo + employeeThree;

        int countHours = 0;

        while(students > 0){
            countHours++;
            students -= totalServedStudentsPerHour;
            if(countHours % 4 == 0){
                countHours++;
            }
        }
        System.out.printf("Time needed: %dh.",countHours);
    }
}