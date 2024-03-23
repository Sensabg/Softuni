package FinalExams;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem2FancyBarcodes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String regex = "(@#+)(?<productGroup>[A-Z][A-Za-z0-9]{4,}[A-Z])(@#+)";
        Pattern pattern = Pattern.compile(regex);

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            Matcher matcher = pattern.matcher(input);
            StringBuilder productGroup = new StringBuilder();

            if (!matcher.find()) {
                System.out.println("Invalid barcode");
            } else {
                String barcode = matcher.group("productGroup");
                for (char c : barcode.toCharArray()) {
                    if (Character.isDigit(c)) {
                        productGroup.append(c);
                    }
                }
                if (productGroup.length() == 0) {
                    System.out.println("Product group: 00");
                } else {
                    System.out.println("Product group: " + productGroup);
                }
            }
        }
    }
}