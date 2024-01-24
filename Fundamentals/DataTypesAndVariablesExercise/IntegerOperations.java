package DataTypesAndVariablesExercise;

import java.util.Scanner;

public class IntegerOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sum = 0;

        for (int i = 1; i <= 4; i++) {
            int n = Integer.parseInt(scanner.nextLine());
            if (i <= 2) {
                sum += n;
            } else if (i == 3) {
                sum /= n;
            } else {
                sum *= n;
            }
        }
        System.out.println(sum);
    }
}
