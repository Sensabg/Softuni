package ForLoopMoreExercises;

public class ClockPart2_2 {
    public static void main(String[] args) {


        for (int time = 0; time < 24 * 3600; time++) {
            int hours = time / 3600;
            int minutes = (time % 3600) / 60;
            int seconds = time % 60;

            System.out.printf("%01d : %01d : %01d\n", hours, minutes, seconds);
        }
    }
}

