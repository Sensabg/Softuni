package FirsStepsInCoding;

import java.util.Scanner;

public class InchestoCentimeters {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double inch = 2.54;
        double cm = Double.parseDouble(scanner.nextLine());
        double cmResult = cm * 2.54;

        System.out.println(cmResult);
    }
}
