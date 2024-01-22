package WhileLoopExercise;

import java.util.Scanner;

public class Moving {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int width = Integer.parseInt(scanner.nextLine());
        int length = Integer.parseInt(scanner.nextLine());
        int height = Integer.parseInt(scanner.nextLine());

        int totalSize = width * length * height;
//На следващите редове (до получаване на команда "Done") -
// брой кашони, които се пренасят в квартирата - цяло число в интервала [1...10000]
        int totalBoxSize = 0;

        boolean noMoreSpace = false;

        String input = scanner.nextLine();
        while (!input.equals("Done")) {
            int boxes = Integer.parseInt(input);

            totalBoxSize+=boxes;

            if(totalSize < totalBoxSize){
                noMoreSpace = true;
                break;
            }

            input = scanner.nextLine();
        }
        int diff =Math.abs(totalSize - totalBoxSize);

        if(noMoreSpace){
            System.out.printf("No more free space! You need %d Cubic meters more.",diff);
        } else {
            System.out.printf("%d Cubic meters left.",diff);
        }
    }
}
