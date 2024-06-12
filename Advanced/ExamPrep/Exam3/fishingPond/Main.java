package fishingPond;

public class Main {
    public static void main(String[] args) {

        Pond pond = new Pond(5);

        Fish trout = new Fish("Trout", 5, "winter");
        Fish perch = new Fish("Perch", 2, "summer");
        Fish pike = new Fish("Pike", 4, "spring");
        Fish catfish = new Fish("Catfish", 8, "summer");

        pond.addFish(trout);
        pond.addFish(perch);
        pond.addFish(pike);

        System.out.println(pond.removeFish("Trout"));
        System.out.println(pond.removeFish("Carp"));
        System.out.println(pike.getMatingSeason());

        pond.addFish(catfish);
        System.out.println(pond.getOldestFish().getSpecies());

        System.out.println(pond.getVacancies());
        System.out.println(pond.report());
    }
}