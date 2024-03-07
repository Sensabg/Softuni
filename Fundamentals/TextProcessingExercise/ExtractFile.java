package TextProcessingExercise;

import java.util.Scanner;

public class ExtractFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] path = scanner.nextLine().split("\\\\");
        String file = path[path.length - 1];
        int index = file.indexOf(".");
        String extension = file.substring(index);
        file = file.replaceAll(extension, "");
        extension = extension.replace(".","");

        System.out.println("File name: " + file);
        System.out.println("File extension: " + extension);
    }
}
