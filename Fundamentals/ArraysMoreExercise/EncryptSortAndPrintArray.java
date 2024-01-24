package ArraysMoreExercise;

import java.util.Arrays;
import java.util.Scanner;

public class EncryptSortAndPrintArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[] sum = new int[n];

        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            String[] characters = new String[name.length()];

            for (int j = 0; j < name.length(); j++) {
                characters[j] = String.valueOf(name.charAt(j));
                if (characters[j].equals("a")
                        || characters[j].equals("e")
                        || characters[j].equals("i")
                        || characters[j].equals("o")
                        || characters[j].equals("u")
                        || characters[j].equals("A")
                        || characters[j].equals("E")
                        || characters[j].equals("I")
                        || characters[j].equals("O")
                        || characters[j].equals("U")) {

                    sum[i] += characters[j].charAt(0) * name.length();
                } else {
                    sum[i] += characters[j].charAt(0) / name.length();
                }
            }
        }
        Arrays.sort(sum);
        for (int i : sum) {
            System.out.println(i);
        }
    }
}