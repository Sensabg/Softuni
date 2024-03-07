package TextProcessingExercise;

import java.util.Scanner;

public class ExtractFile2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String path = scanner.nextLine();
        int lastSlashIndex = path.lastIndexOf("\\");
        int dotIndex = path.lastIndexOf(".");

        String fileName = path.substring(lastSlashIndex + 1, dotIndex);
        String extension = path.substring(dotIndex + 1);

        System.out.println("File name: " + fileName);
        System.out.println("File extension: " + extension);
    }
}