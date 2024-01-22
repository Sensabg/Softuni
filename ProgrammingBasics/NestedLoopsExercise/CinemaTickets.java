package NestedLoopsExercise;

import java.util.Scanner;

public class CinemaTickets {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int standardCounter = 0;
        int kidCounter = 0;
        int studentCounter = 0;
        int counter = 0;
        int seatsPerMovie = 0;
        boolean endMovie = false;

        String input = scanner.nextLine();
        while (!input.equals("Finish")) {

            String movie = input;
            int capacity = Integer.parseInt(scanner.nextLine());

            String ticket = scanner.nextLine();
            seatsPerMovie = 0;
            while (!ticket.equals("End")) {
                String ticketType = ticket;
                counter++;
                seatsPerMovie++;
                switch (ticket) {
                    case "standard":
                        standardCounter++;
                        break;
                    case "kid":
                        kidCounter++;
                        break;
                    case "student":
                        studentCounter++;
                        break;
                }
                if (seatsPerMovie == capacity) {
                    break;
                }
                ticket = scanner.nextLine();
            }

            System.out.printf("\n%s - %.2f%% full.", movie, seatsPerMovie * 100.0 / capacity);

            input = scanner.nextLine();
        }
        System.out.printf("\nTotal tickets: %d", counter);
        System.out.printf("\n%.2f%% student tickets.", studentCounter * 100.0 / counter);
        System.out.printf("\n%.2f%% standard tickets.", standardCounter * 100.0 / counter);
        System.out.printf("\n%.2f%% kids tickets.", kidCounter * 100.0 / counter);
    }
}
