package BasicSyntaxConditionalStatementsAndLoopsLab;

import java.util.Scanner;

public class MultiplicationTable2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());
        int m = Integer.parseInt(scanner.nextLine());

        do{
            System.out.printf("%d X %d = %d\n",n , m , n * m);
            m++;
        } while (m <= 10);






    }
}
