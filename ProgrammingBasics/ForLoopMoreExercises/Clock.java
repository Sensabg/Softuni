package ForLoopMoreExercises;

public class Clock {
    public static void main(String[] args) {


        for (int minutes = 0; minutes < 1440; minutes++) {
            int hours = minutes / 60;
            int mins = minutes % 60;
            System.out.printf("%01d : %01d\n", hours, mins);
        }
    }
}




