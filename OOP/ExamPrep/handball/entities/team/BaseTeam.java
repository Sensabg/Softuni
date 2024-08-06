package handball.entities.team;

import static handball.common.ExceptionMessages.*;

public abstract  class BaseTeam implements Team {


    private String name;

    private String country;

    private int advantage;

    protected BaseTeam(String name, String country, int advantage) {
        setName(name);
        setCountry(country);
        setAdvantage(advantage);
    }

    protected void increaseAdvantage(int increment) {
        this.setAdvantage(this.getAdvantage() + increment);
    }

    @Override
    public void setName(String name) {
        if(name == null || name.isBlank()){
            throw new NullPointerException(TEAM_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    public void setCountry(String country) {
        if(country == null || country.isBlank()){
            throw new NullPointerException(TEAM_COUNTRY_NULL_OR_EMPTY);
        }
        this.country = country;
    }

    public void setAdvantage(int advantage) {
        if(advantage <= 0){
            throw new IllegalArgumentException(TEAM_ADVANTAGE_BELOW_OR_EQUAL_ZERO);
        }
        this.advantage = advantage;
    }

    @Override
    public String getName() {
        return this.name;
    }

    public String getCountry() {
        return this.country;
    }

    @Override
    public int getAdvantage() {
        return this.advantage;
    }
}
