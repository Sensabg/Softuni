package WhileLoopExercise;

import java.util.Scanner;

public class Walking2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        int totalSteps = 0;

        boolean goingHome = false;

        while(totalSteps < 10000){
            String input = scanner.nextLine();

            if(input.equals("Going home")){
                goingHome = true;
                int steps = Integer.parseInt(scanner.nextLine());
                totalSteps = totalSteps + steps;
                break;
            } else {
                int steps = Integer.parseInt(input);
                totalSteps = totalSteps + steps;
            }
        }

       int diff = Math.abs(10000 - totalSteps);

        if(goingHome && totalSteps < 10000){
            System.out.printf("%d more steps to reach goal.", diff);
        } else {
            System.out.println("Goal reached! Good job!");
            System.out.printf("%d steps over the goal!", diff);
        }
    }
}
