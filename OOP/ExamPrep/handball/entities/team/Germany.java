package handball.entities.team;

public class Germany extends BaseTeam {

    private static final int INCREASE = 145;

    public Germany(String name, String country, int advantage) {
        super(name, country, advantage);
    }

    @Override
    public void play() {
        this.increaseAdvantage(INCREASE);
    }
}
