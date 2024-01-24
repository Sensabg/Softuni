package DataTypesAndVariablesMoreExercise;

import java.util.Scanner;

public class BalancedBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int foundOne = 0;
        int foundTwo = 0;

        boolean check = false;

        for (int i = 1; i <= n; i++) {
            String input = scanner.nextLine();
            if(input.equals("(")){
              foundOne++;
                check = true;
            }
            if(input.equals(")") && check){
                foundTwo++;
                check = false;
            }
        }
        if(foundTwo == foundOne){
            System.out.println("BALANCED");
        } else {
            System.out.println("UNBALANCED");
        }
    }
}
