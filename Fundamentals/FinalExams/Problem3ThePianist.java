package FinalExams;

import java.util.*;

public class Problem3ThePianist {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, String> authorSongs = new LinkedHashMap<>();
        LinkedHashMap<String, String> songsKeys = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        String input;
        String[] info;

        for (int i = 0; i < n; i++) {
            input = scanner.nextLine();
            info = input.split("\\|");
            String piece = info[0];
            String composer = info[1];
            String key = info[2];

            authorSongs.put(piece, composer);
            songsKeys.put(piece, key);
        }

        while (!"Stop".equals(input = scanner.nextLine())) {
            info = input.split("\\|");
            String command = info[0];
            String piece = info[1];

            switch (command) {

                case "Add":
                    String composer = info[2];
                    String key = info[3];
                    if (songsKeys.containsKey(piece)) {
                        System.out.printf("%s is already in the collection!\n", piece);
                    } else {
                        System.out.printf("%s by %s in %s added to the collection!\n", piece, composer, key);
                        authorSongs.put(piece, composer);
                        songsKeys.put(piece, key);
                    }
                    break;

                case "Remove":
                    if (!songsKeys.containsKey(piece)) {
                        System.out.printf("Invalid operation! %s does not exist in the collection.\n", piece);
                    } else {
                        System.out.printf("Successfully removed %s!\n",piece);
                        songsKeys.remove(piece);
                        authorSongs.remove(piece);
                    }
                    break;

                case "ChangeKey":
                    String newKey = info[2];
                    if (!songsKeys.containsKey(piece)) {
                        System.out.printf("Invalid operation! %s does not exist in the collection.\n", piece);
                    } else {
                        System.out.printf("Changed the key of %s to %s!\n", piece, newKey);
                        songsKeys.put(piece, newKey);
                    }
                    break;
            }
        }
        for (Map.Entry<String, String> songs : songsKeys.entrySet()) {
            String song = songs.getKey();
            String composer = authorSongs.get(songs.getKey());
            String key = songs.getValue();
            System.out.printf("%s -> Composer: %s, Key: %s\n", song, composer, key);
        }
    }
}