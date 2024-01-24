package BasicSyntaxConditionalStatementsAndLoopsMoreExercise;

import java.util.Scanner;

public class Messages {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String word = "";

        for (int i = 1; i <= n; i++) {
            String numbers = scanner.nextLine();
            int numbersLength = numbers.length();
            int parsedNumber = Integer.parseInt(numbers);

            for (int j = 0; j <= numbersLength - 2; j++) {
                parsedNumber = parsedNumber / 10;
            }

            if (parsedNumber == 0) {
                word += " ";
            }

            switch (parsedNumber) {
                case 2:
                    if (numbersLength == 1) {
                        word += "a";
                    } else if (numbersLength == 2) {
                        word += "b";
                    } else if (numbersLength == 3) {
                        word += "c";
                    }
                    break;
                case 3:
                    if (numbersLength == 1) {
                        word += "d";
                    } else if (numbersLength == 2) {
                        word += "e";
                    } else if (numbersLength == 3) {
                        word += "f";
                    }
                    break;
                case 4:
                    if (numbersLength == 1) {
                        word += "g";
                    } else if (numbersLength == 2) {
                        word += "h";
                    } else if (numbersLength == 3) {
                        word += "i";
                    }
                    break;
                case 5:
                    if (numbersLength == 1) {
                        word += "j";
                    } else if (numbersLength == 2) {
                        word += "k";
                    } else if (numbersLength == 3) {
                        word += "l";
                    }
                    break;
                case 6:
                    if (numbersLength == 1) {
                        word += "m";
                    } else if (numbersLength == 2) {
                        word += "n";
                    } else if (numbersLength == 3) {
                        word += "o";
                    }
                    break;
                case 7:
                    if (numbersLength == 1) {
                        word += "p";
                    } else if (numbersLength == 2) {
                        word += "q";
                    } else if (numbersLength == 3) {
                        word += "r";
                    } else if (numbersLength == 4) {
                        word += "s";
                    }
                    break;
                case 8:
                    if (numbersLength == 1) {
                        word += "t";
                    } else if (numbersLength == 2) {
                        word += "u";
                    } else if (numbersLength == 3) {
                        word += "v";
                    }
                    break;
                case 9:
                    if (numbersLength == 1) {
                        word += "w";
                    } else if (numbersLength == 2) {
                        word += "x";
                    } else if (numbersLength == 3) {
                        word += "y";
                    } else if (numbersLength == 4) {
                        word += "z";
                    }
                    break;
            }
        }
        System.out.print(word);
    }
}



