package WhileLoopExercise;

import java.util.Scanner;

public class Walking {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int requiredGoal = 10000;
        int totalSteps = 0;
        int diff = 0;
        boolean goalReached = false;


        String input = scanner.nextLine();

        while (true) {

            int parseInput = 0;

            if (!input.equals("Going home")) {
                parseInput = Integer.parseInt(input);
            }
            totalSteps += parseInput;

            if (input.equals("Going home")) {
                input = scanner.nextLine();
                parseInput = Integer.parseInt(input);
                totalSteps = totalSteps + parseInput;
                break;

            }
            if(requiredGoal < totalSteps) {
                goalReached = true;
                break;
            }

                input = scanner.nextLine();
        }
        diff = Math.abs(requiredGoal - totalSteps);

        if(requiredGoal < totalSteps) {
            goalReached = true;
        }

            if (goalReached) {
                System.out.println("Goal reached! Good job!");
                System.out.printf("%d steps over the goal!", diff);
            } else {
                System.out.printf("%d more steps to reach goal.", diff);
            }
        }
    }
