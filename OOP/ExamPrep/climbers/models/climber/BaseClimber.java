package climbers.models.climber;

import climbers.models.roster.Roster;

import static climbers.common.ExceptionMessages.CLIMBER_NAME_NULL_OR_EMPTY;
import static climbers.common.ExceptionMessages.CLIMBER_STRENGTH_LESS_THAN_ZERO;


public abstract class BaseClimber implements Climber {

    private String name;
    private double strength;

    private Roster roster;


    protected BaseClimber(String name, double strength) {
        setName(name);
        setStrength(strength);
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {

        if(name == null || name.trim().isEmpty()){
            throw new NullPointerException(CLIMBER_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    public void setStrength(double strength) {

        if (strength < 0) {
            throw new IllegalArgumentException(CLIMBER_STRENGTH_LESS_THAN_ZERO);
        }
        this.strength = strength;
    }


    @Override
    public double getStrength() {
        return strength;
    }

    @Override
    public boolean canClimb() {
        return strength > 0 ;
    }

    @Override
    public Roster getRoster() {
        return roster;
    }

    @Override
    abstract public void climb();

}