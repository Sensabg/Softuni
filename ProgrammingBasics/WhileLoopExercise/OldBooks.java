package WhileLoopExercise;

import java.util.Scanner;

public class OldBooks {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String desiredBook = scanner.nextLine();
        int bookCount = 0;

        boolean theBookIsFound = false;

        String command = scanner.nextLine();
        while (true) {
            String currentBook = command;

            if(currentBook.equals("No More Books")){
                break;
            }

            if (currentBook.equals(desiredBook)) {
                theBookIsFound = true;
                break;
            }
            bookCount++;

            command = scanner.nextLine();
        }

        if(theBookIsFound){
            System.out.printf("You checked %d books and found it.",bookCount);
        } else {
            System.out.println("The book you search is not here!");
            System.out.printf("You checked %d books.",bookCount);
        }

    }
}
