import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class newNEwNew {
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

        boolean isExamTime = "Test".equals(command);

        for (String currentTopic : notes) {
            if (book.containsKey(currentTopic)) {
                String topicFromNotes = System.lineSeparator() + book.get(currentTopic);
                System.out.print(isExamTime ? currentTopic + ":" + topicFromNotes : currentTopic + " ");
            }
        }
    }
}