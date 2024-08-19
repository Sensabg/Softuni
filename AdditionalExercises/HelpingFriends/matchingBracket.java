import java.util.Scanner;

public class matchingBracket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cycles = Integer.parseInt(scanner.nextLine());

        int countOpenBrackets = 0;
        boolean balanced = true;

        while (cycles-- > 0) {
            String input = scanner.nextLine();

            if (input.equals("(")) {
                countOpenBrackets++;
            } else if (input.equals(")")) {
                countOpenBrackets--;
                if (countOpenBrackets < 0) {
                    balanced = false;
                    break;
                }
            }
        }

        if (countOpenBrackets != 0) {
            balanced = false;
        }

        System.out.println(balanced ? "BALANCED" : "UNBALANCED");

        // if(balanced){
        //     System.out.println("BALANCED");
        // } else {
        //     System.out.println("UNBALANCED");
        // }  
    }
}
