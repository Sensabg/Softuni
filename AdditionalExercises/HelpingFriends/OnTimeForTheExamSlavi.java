package PersonalTasks;

import java.util.Scanner;

public class OnTimeForTheExamSlavi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1.
        // will be reading hours and minutes

        // Pointless to create 10 variables especially when
        // the logic is always the same for reading hours and minutes from the console

        // so why creating 10 variables when you can create abstract reusable variables?

        // It doesn't matter if you read
        // hours and minutes for the Exam start hour
        // or hours and minutes for the arrival hour

        // only define that they will exist in the code
        // consider them like 2 tools that we put in our suitcase ( program )

        int hours;
        int minutes;

        // 2.
        // Read the exam start Hour FROM THE CONSOLE

        // In this case the hours and minutes variables read 2 numbers from the console

        // use the defined values that in this case are instruments that we use
        // in order to gain info saved from the console

        // hours variable read a new line from the input filled in the console
        // minutes variable read another new line from the input filled in the console

        // convert logic from hours Into minutes

        hours = Integer.parseInt(scanner.nextLine());
        minutes = Integer.parseInt(scanner.nextLine());
        int examMinutes = hours * 60 + minutes;


        // 3.
        // Read arrival Hour from the console the same way

        // use the same variables in order to read the hours and the minute
        // by reading from the console again using the same variables
        // we overwrite the initial values read from the console

        // however we already saved the result  in the examMinutes variable
        // so its safe to reuse them in order to calculate the minutes for the arrivalMinutes

        hours = Integer.parseInt(scanner.nextLine());
        minutes = Integer.parseInt(scanner.nextLine());
        int arrivalMinutes = hours * 60 + minutes;

        // 4.
        // Time difference calculation
        // diff between arrival hour and required hour for arrival

        // if the diff is positive it means that we are either on time or earlier than expected

        // if diff is negative it means that we are late

        // this happens because the arrival hours should be LESS THAN or EQUALS to the exam hour

        // we do not use Math Abs here
        // that's because later on in the code we will benefit from the info from the calculation
        // if the product is negative or 0, we are not late for sure.

        int timeDifference = arrivalMinutes - examMinutes;

        // 5.
        // hours difference
        // minutes difference

        // We do this in order to create a variable "time"
        // the variable will have different behaviour depending on the time diff

        // is the time difference an hour more or just a few minutes?

        // Convert the difference in normal format - Hour and Minutes

        // for the calculation of the hours and minutes we need absolute values
        // we get the time diff between the arrival and the exam hour

        // we need this since if the diff is not 0 we have different cases
        // Earlier and Later

        // Reuse the variables again as this is why we crreated them
        // why create another variables?

        // use the tools from the suitcase, that's why we bring them with us
        // they did their job previously but now they have other responsibilites

        // Kato si kupish kleshti edva li kato gi pozlvash edin put i si kupuvash novi ?
        // hours and minutes sa nashte kleshti i chuk
        // veche gi polzvahme po rano no sgea imat druga otgovornost

        hours = Math.abs(timeDifference / 60);
        minutes = Math.abs(timeDifference % 60);

        // 6.
        // defining time

        // is the difference a few hours or just a few minutes?

        // variable acts differently depending on the time difference
        // so that we can print different things based on the time difference

        // define that time will exist in our program ( another isntrument )

        // aide vzimame i edna otverka na stroeja

        String time;

        if (hours == 0) {

            // if  the hours are 0, the diff is less than an hour obviously
            // so we force the variable to show only the minutes without the hours since they are 0

            // this is required by the Task

            // tuka otverkata q polzvam da otviq edno bolt4e

            time = String.format("%01d minutes", minutes);
        } else {

            // IF the hours are not 0
            // the diff is either an hour or more

            // so we properly adjust the variable to display the hours as well
            // since there is a values that we can display

            // %02d -> %d int placeholder for fomratted printing

            //02 -> we force the minutes to always display 2 digits for the minutes

            // the 0 specifies that if we have minutes less than 10 we will always have a leading 0
            // this means that we will print the minutes from 0 to 9 with 2 digits
            // simple example - 1 hour and 7 minutues will be printed like that
            // 1:07

            //the 2 from ( %02d ) specifies that we always want 2 digits when we format the int in the printing

            // KAZAH TI CHE IMA SHABLON ( %02d )

            // tuka polzvame otverkata da otvurtim drug vid bolt4e

            time = String.format("%d:%02d hours", hours, minutes);
        }

        // 7.
        // if the difference is positive or equals to 0, this means that we are either right on time or earlier

        if (timeDifference <= 0) {

            //If we reached this point it means that the number is positive
            // if the user arrives no more than 30 minutes earlier , it's on time

            // we use math abs here because we already established that the number is positive
            // considering that we passed through the above if statement

            // this means that we are not late for sure
            // so we need to use the timeDifference as a positive value instead

            // in our case every outcome between 1 - 30 should be printed

            // If we do not use math abs?
            // the time difference will be calculated incorrectly

            if (Math.abs(timeDifference) <= 30) {
                System.out.println("On time");

                //if the difference is 0 it means that we are right on time
                // !! WILL PRINT ONLY ON TIME

                // if we arrive earlier than expected BUT no more than 30 minutes earlier
                // we are still on time BUT print the minutes difference of hour arrival earlier

                if (timeDifference != 0) {

                    //if difference is anything but 0 and at the same time less than 30 we are still on time
                    // However we need to print how many minutes before the exam we arrived.

                    System.out.printf("%s before the start", time);
                }

            } else {

                // 8.
                // if we arrive more than 30 minutes before the exam - we print that its Early

                System.out.printf("Early %s before the start", time);
            }

        } else {

            // 9.
            // if the difference is negative it means that we are late

            System.out.printf("Late %s after the start", time);
        }
    }
}

//        int hours;
//        int minutes;
//
//        hours = Integer.parseInt(scanner.nextLine());
//        minutes = Integer.parseInt(scanner.nextLine());
//
//        int examMinutes = hours * 60 + minutes;
//
//        hours = Integer.parseInt(scanner.nextLine());
//        minutes = Integer.parseInt(scanner.nextLine());
//
//        int arrivalMinutes = hours * 60 + minutes;
//
//        int timeDifference = arrivalMinutes - examMinutes;
//
//        hours = Math.abs(timeDifference / 60);
//        minutes = Math.abs(timeDifference % 60);
//
//        String time;
//        if (hours == 0) {
//            time = String.format("%01d minutes", minutes);
//        } else {
//            time = String.format("%d:%02d hours", hours, minutes);
//        }
//
//        if (timeDifference <= 0) {
//            if (Math.abs(timeDifference) <= 30) {
//                System.out.println("On time");
//                if (timeDifference != 0) {
//                    System.out.printf("%s before the start", time);
//                }
//
//            } else {
//                System.out.printf("Early %s before the start", time);
//            }
//
//        } else {
//            System.out.printf("Late %s after the start", time);
//        }
//    }
//}

// bonus -> https://prnt.sc/cfNXai8Xbo2E -> extract the method

//    private static int parseTimeIntoMinutes(int hours, int minutes) {
//        return hours * 60 + minutes;
//    }
 // int examMinutes = parseTimeIntoMinutes(hours, minutes);  --> BONUS / skip for now
// int arrivalMinutes = parseTimeIntoMinutes(hours, minutes); --> BONUS / skip for now