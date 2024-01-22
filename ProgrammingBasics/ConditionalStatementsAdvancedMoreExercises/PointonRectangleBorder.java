package ConditionalStatementsAdvancedMoreExercises;

import java.util.Scanner;

public class PointonRectangleBorder {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Входните данни се четат от конзолата и се състоят от 6 реда въведени от потребителя:
        //десетичните числа x1, y1, x2, y2, x и y

        int x1 = Integer.parseInt(scanner.nextLine());
        int y1 = Integer.parseInt(scanner.nextLine());
        int x2 = Integer.parseInt(scanner.nextLine());
        int y2 = Integer.parseInt(scanner.nextLine());

        double x = Double.parseDouble(scanner.nextLine());
        double y = Double.parseDouble(scanner.nextLine());

        if ((x >= x1 && y == y1 && x <= x2) || (y >= y1 && x == x1 && y <= y2)) {
            System.out.println("Border");
        } else if ((x >= x1 && y == y2 && x <= x2) || (y >= y1 && x == x2 && y <= y2)) {
            System.out.println("Border");
        } else {
            System.out.println("Inside / Outside");
        }
    }
}
