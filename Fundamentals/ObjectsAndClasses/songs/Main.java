package ObjectsAndClasses.songs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int songsAmount = Integer.parseInt(scanner.nextLine());
        List<Song> songsList = new ArrayList<>();

        for (int i = 1; i <= songsAmount; i++) {
            String data = scanner.nextLine();
            String[] songData = data.split("_");
            String typeList = songData[0];
            String name = songData[1];
            String time = songData[2];

            Song song = new Song(typeList, name, time);
            songsList.add(song);
        }

        String command = scanner.nextLine();
        if (command.equals("all")) {
            for (Song song : songsList) {
                System.out.println(song.getName());
            }
        } else {
            for (Song song : songsList) {
                if (song.getTypeList().equals(command)) {
                    System.out.println(song.getName());
                }
            }
        }
    }
}