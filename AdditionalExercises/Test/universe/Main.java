package universe;


import universe.entities.Human;

public class Main {

    public static void main(String[] args) {

        Human human = new Human("", 21 , "Earth", 123);


        System.out.println(human.getNames());
        System.out.println(human.getAge());
        System.out.println(human.getPlanet());
        System.out.println(human.getHealth());
    }
}
