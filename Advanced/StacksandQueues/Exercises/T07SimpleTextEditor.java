package T01StacksQueues.Exercise;

import java.util.*;

public class T07SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int commandsAmount = Integer.parseInt(scanner.nextLine());

        List<Character> chars = new ArrayList<>();
        ArrayDeque<String> stack = new ArrayDeque<>();

        while (commandsAmount-- > 0) {
            String[] command = scanner.nextLine().split("\\s+");

            switch (command[0]) {
                case "1":
                    String text = command[1];
                    for (int i = 0; i < text.length(); i++) {
                        chars.add(text.charAt(i));
                    }
                    stack.push(getPush(chars));
                    break;

                case "2":
                    int remove = Integer.parseInt(command[1]);
                    while (remove-- > 0) {
                        chars.remove(chars.size() - 1);
                    }
                    stack.push(getPush(chars));
                    break;

                case "3":
                    int index = Integer.parseInt(command[1]);
                    System.out.println(chars.get(index - 1));
                    break;

                case "4":
                    if (!stack.isEmpty()) {
                        stack.pop();
                        if (!stack.isEmpty()) {
                            String ok = stack.peek();
                            chars.clear();
                            for (int i = 0; i < ok.length(); i++) {
                                chars.add(ok.charAt(i));
                            }
                        } else {
                            chars.clear();
                        }
                    }
                    break;
            }
        }
    }

    private static String getPush(List<Character> chars) {
        StringBuilder sb = new StringBuilder();
        for (Character ch : chars) {
            sb.append(ch);
        }
        return sb.toString();
    }
}