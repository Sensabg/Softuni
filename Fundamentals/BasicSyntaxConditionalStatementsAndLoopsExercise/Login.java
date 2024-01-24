package BasicSyntaxConditionalStatementsAndLoopsExercise;

import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        String password = "";
        String rightPassword = scanner.nextLine();
        int attempts = 0;
        boolean successful = false;

        for (int i = name.length() - 1; i >= 0; i--) {
            password += name.charAt(i);
        }

        while(true){

            attempts++;

            if(!rightPassword.equals(password)) {
                if (attempts == 4){
                    break;
                }
                System.out.println("Incorrect password. Try again.");
            } else {
                successful = true;
                break;
            }

            rightPassword = scanner.nextLine();
        }

        if(successful){
            System.out.printf("User %s logged in.",name);
        } else {
            System.out.printf("User %s blocked!",name);
        }
    }
}
