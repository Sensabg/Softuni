package TextProcessingMoreExercise;

import java.util.Scanner;

public class HTML {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String comment;
        int counter = 0;
        while (!"end of comments".equals(comment = scanner.nextLine())){

            if(counter == 0) {
                System.out.println("<h1>");
                System.out.println("    " + comment);
                System.out.println("</h1>");
            }
            if(counter == 1) {
                System.out.println("<article>");
                System.out.println("    " + comment);
                System.out.println("</article>");
            }
            if(counter == 2) {
                System.out.println("<div>");
                System.out.println("    " + comment);
                System.out.println("</div>");
            }
            if(counter == 3) {
                System.out.println("<div>");
                System.out.println("    " + comment);
                System.out.println("</div>");
            }
            if(counter == 4) {
                System.out.println("<div>");
                System.out.println("    " + comment);
                System.out.println("</div>");
            }
            counter++;
        }
    }
}
