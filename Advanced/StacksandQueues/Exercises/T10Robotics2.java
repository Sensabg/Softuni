package T01StacksQueues.Exercise;

import java.util.*;
public class T10Robotics2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] robotsInfo = scanner.nextLine().split(";");
        List<Robot> robots = new ArrayList<>();

        for (String robotInfo : robotsInfo) {
            String[] parts = robotInfo.split("-");
            String name = parts[0];
            int processTime = Integer.parseInt(parts[1]);
            robots.add(new Robot(name, processTime));
        }

        String startTime = scanner.nextLine();
        Queue<Product> productQueue = new LinkedList<>();

        String product;
        while (!(product = scanner.nextLine()).equals("End")) {
            productQueue.add(new Product(product));
        }

        String[] timeParts = startTime.split(":");
        int hours = Integer.parseInt(timeParts[0]);
        int minutes = Integer.parseInt(timeParts[1]);
        int seconds = Integer.parseInt(timeParts[2]);

        int currentTime = hours * 3600 + minutes * 60 + seconds;

        while (!productQueue.isEmpty()) {
            Product currentProduct = productQueue.poll();
            Robot currentRobot = robots.remove(0);
            currentRobot.process(currentProduct, formatTime(currentTime));
            currentTime += currentRobot.getProcessTime();
            robots.add(currentRobot);
        }
    }

    private static String formatTime(int seconds) {
        int hours = seconds / 3600;
        int minutes = (seconds % 3600) / 60;
        int secs = seconds % 60;
        return String.format("%02d:%02d:%02d", hours, minutes, secs);
    }
}
class Robot {
    private String name;
    private int processTime;

    public Robot(String name, int processTime) {
        this.name = name;
        this.processTime = processTime;
    }

    public int getProcessTime() {
        return processTime;
    }

    public void process(Product product, String startTime) {
        System.out.println(name + " - " + product.getName() + " [" + startTime + "]");
    }
}

class Product {
    private String name;

    public Product(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
