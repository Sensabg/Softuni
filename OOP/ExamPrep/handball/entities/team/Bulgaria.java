package handball.entities.team;

public class Bulgaria extends BaseTeam {

    private static final int INCREASE = 115;
    public Bulgaria(String name, String country, int advantage) {
        super(name, country, advantage);
    }

    @Override
    public void play() {
        this.increaseAdvantage(INCREASE);
    }
}
