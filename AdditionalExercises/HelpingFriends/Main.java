import java.util.Arrays;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        int startIndex = Integer.parseInt(scanner.nextLine());
        int count = Integer.parseInt(scanner.nextLine());

        int endIndex = startIndex + count;

//        CharSequence subString = input.substring(startIndex, endIndex);
//        String firstWay = input.replace(subString, "");

        String textToRemove = input.substring(startIndex, endIndex);
        String secondWay = input.replace(textToRemove, "");
//
//        String thirdWay = input.replace(input.subSequence(startIndex, endIndex), "");
//        String fourthWay = input.substring(0, startIndex) + input.substring(endIndex);
//
//        StringBuilder sb = new StringBuilder(input);
//        String fifthWay = sb.delete(startIndex, endIndex).toString();
//
//        String chars = input.substring(startIndex, endIndex);
//        String sixthWay = input.split(chars)[0] + input.split(chars)[1];
////
//        String[] charsModified = input.split(input.substring(startIndex, endIndex));
//        String seventhWay = charsModified[0] + charsModified[1];


//        String eightWay = Arrays.toString(input.split(input.substring(startIndex, endIndex)))
//                .replace("[", "")
//                .replace("]", "")
//                .replace(", ", "");

 //         String ninthWay = String.join("", input.split(input.substring(startIndex, endIndex)));

        System.out.println(secondWay);
    }
}
