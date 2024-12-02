import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class newNEwNewT {
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
            boolean isExamTime = "Test".equals(command);
            boolean alreadyExists = !book.containsKey(currentTopic);

            String topicFromNotes = System.lineSeparator() + book.get(currentTopic);
            String result = isExamTime ? currentTopic + ":" + topicFromNotes : currentTopic + " ";

            System.out.println(result.trim());
            if (alreadyExists) {
               break;
            }
        }
    }
}