package TextProcessingMoreExercise;

import java.util.Scanner;

public class MorseCodeTranslator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder decodedText = new StringBuilder();
        String codeParts;
        String text;
        String code = scanner.nextLine();
        String[] morseChars = code.split(" ");
        for (int i = 0; i < morseChars.length; i++) {
            codeParts = morseChars[i];
            text = decode(codeParts);

            decodedText.append(text);
        }
        System.out.println(decodedText);
    }

    public static String decode(String selectedEnglish) {
        String morse = selectedEnglish;

        switch (selectedEnglish.toLowerCase()) {
            case ".-":
                morse = "A";
                break;
            case "-...":
                morse = "B";
                break;
            case "-.-.":
                morse = "C";
                break;
            case "-..":
                morse = "D";
                break;
            case ".":
                morse = "E";
                break;
            case "..-.":
                morse = "F";
                break;
            case "--.":
                morse = "G";
                break;
            case "....":
                morse = "H";
                break;
            case "..":
                morse = "I";
                break;
            case ".---":
                morse = "J";
                break;
            case "-.-":
                morse = "K";
                break;
            case ".-..":
                morse = "L";
                break;
            case "--":
                morse = "M";
                break;
            case "-.":
                morse = "N";
                break;
            case "---":
                morse = "O";
                break;
            case ".--.":
                morse = "P";
                break;
            case "--.-":
                morse = "Q";
                break;
            case ".-.":
                morse = "R";
                break;
            case "...":
                morse = "S";
                break;
            case "-":
                morse = "T";
                break;
            case "..-":
                morse = "U";
                break;
            case "...-":
                morse = "V";
                break;
            case ".--":
                morse = "W";
                break;
            case "-..-":
                morse = "X";
                break;
            case "-.--":
                morse = "Y";
                break;
            case "--..":
                morse = "Z";
                break;
            case "-----":
                morse = "0";
                break;
            case ".----":
                morse = "1";
                break;
            case "..---":
                morse = "2";
                break;
            case "...--":
                morse = "3";
                break;
            case "....-":
                morse = "4";
                break;
            case ".....":
                morse = "5";
                break;
            case "-....":
                morse = "6";
                break;
            case "--...":
                morse = "7";
                break;
            case "---..":
                morse = "8";
                break;
            case "----.":
                morse = "9";
                break;
            case "|":
                morse = " ";
                break;
        }
        return morse;
    }
}