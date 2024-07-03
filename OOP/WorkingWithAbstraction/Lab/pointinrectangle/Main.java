package WorkingWithAbstraction.Lab.pointinrectangle;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);

        int bottomLeftX = scanner.nextInt();
        int bottomLeftY = scanner.nextInt();
        int topRightX = scanner.nextInt();
        int topRightY = scanner.nextInt();

        Point bottomLeft = new Point(bottomLeftX, bottomLeftY);
        Point topRight = new Point(topRightX, topRightY);
        Rectangle rectangle = new Rectangle(bottomLeft, topRight);

        int n = scanner.nextInt();

        while (n-- > 0){
            int pointX = scanner.nextInt();
            int pointY = scanner.nextInt();
            Point point = new Point(pointX, pointY);
            System.out.println(rectangle.contains(point));
        }
    }
}