package handball.entities.gameplay;

public class Outdoor extends BaseGameplay {
    private static final int CAPACITY = 150;

    public Outdoor(String name) {
        super(name, CAPACITY);
    }
}
