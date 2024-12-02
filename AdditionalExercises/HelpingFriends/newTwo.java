import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class newTwo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, StringBuilder> book = new HashMap<>();
        String[] notes = scanner.nextLine().split(" \\| ");

        for (String note : notes) {
            String[] data = note.split(": ");
            String word = data[0];
            String def = data[1];

            book.putIfAbsent(word, new StringBuilder());
            book.get(word).append(" -").append(def).append(System.lineSeparator());
        }

        notes = scanner.nextLine().split(" \\| ");
        String command = scanner.nextLine();

        for (String currentTopic : notes) {
            boolean itExists = book.containsKey(currentTopic);
            boolean isExamTime = "Test".equals(command);

            String topicFromBook = String.valueOf(book.get(currentTopic));
            String entireTopic = currentTopic + ":" + System.lineSeparator() + topicFromBook;
            String topicTitles = String.join(" ", book.keySet());
            String result = (isExamTime) ? entireTopic : topicTitles;

            if (itExists && isExamTime) {
                System.out.println(result.trim());
            } else if (!isExamTime) {
                System.out.println(result.trim());
                return;
            }
        }
    }
}
// renamed to topicFromBook as its more accurate
// replaced the System.lineSeparator() with "\n"
// although System.lineSeparator() is better
// since it runs on all systems, whereas the "\n"
// might interfere with some systems like Linux
// ->  moved it on line 28
//                String topicFromBook = System.lineSeparator() + book.get(currentTopic);

// split the ternary operator into an if else if statement to be more precise,
// although the task doesn't require it.
// the if else if statement is nested in another if statement
// as we first have to check if our book with past notes contains
// the particular topics our teacher is asking us
// print only the topics saved in your book depending on
//    1.  whether is an exam -> print the
//
//        -> print  everything "Title(s)" ( word ) and Paragraph(s) ( def )
//
//    2.  whether is a just a brief check if you pay attention in Class
//
//        -> print  the "Title(s)" ( word ) and Paragraph ( def )
//
// -> across lines 30 & 36
//                System.out.print(isExamTime ? currentTopic + ":" + topicFromBook : currentTopic + " ");
