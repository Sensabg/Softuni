package ForLoopMoreExercises;

public class Clock2 {
    public static void main(String[] args) {

        for (int hours = 0; hours < 24; hours++) {
            for (int minutes = 0; minutes < 60; minutes++) {
                System.out.printf("%01d : %01d\n", hours, minutes);
            }
        }
    }
}
