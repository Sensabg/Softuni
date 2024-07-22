package universe.entities;


public class Human implements IntelligentLifeForm {

    String name;
    int age;
    String planet;
    int health;

    public Human(String name, int age, String planet, int health) {
        this.name = name;
        this.age = age;
        this.planet = planet;
        this.health = health;
    }

    @Override
    public String getNames() {
        boolean isValid = !name.trim().isEmpty() && Character.isLetter(name.charAt(0));

        if(!isValid){
           throw new IllegalArgumentException("\n1. Minimum 3 characters\n2. Always starts with letter\n ");
        }

        return name;
    }

    @Override
    public int getAge() {

        if(age <= 5){
            throw new IllegalArgumentException("\nToo Young\n");
        } 

        return age;
    }

    @Override
    public String getPlanet() {
        return planet;
    }

    @Override
    public int getHealth() {
        return Math.min(100 , health);
    }
}
