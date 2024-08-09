package stuntClimb;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ClimbingTests {

    @Test
    public void whenNameNull_thenExceptionIsThrown() {

        Assertions.assertThrows(NullPointerException.class, () -> {
            Climbing climbing = new Climbing(null, 10);
        });
    }
    @Test
    public void whenNameEmptyString_thenExceptionIsThrown() {

        Assertions.assertThrows(NullPointerException.class, () -> {
            Climbing climbing = new Climbing("", 10);
        });
    }
    @Test
    public void whenCapacityIsNegativeNumber_thenExceptionIsThrown() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Climbing climbing = new Climbing("Gosho", -10);
        });
    }

    @Test
    public void whenNameAndCapacityAreValidValues_thenClimbingtIsCreated() {

        Climbing climbing = new Climbing("Gosho", 10);

        Assertions.assertEquals("Gosho", climbing.getName());
        Assertions.assertEquals(10, climbing.getCapacity());
        Assertions.assertEquals(climbing.getCount(), 0);
        Assertions.assertEquals(0, climbing.getCount());
    }

    @Test
    public void whenNoCapacity_thenExceptionIsThrown(){

        Climbing climbing = new Climbing("Gosho", 0);

        RockClimber climber = new RockClimber("Pesho", 12);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            climbing.addRockClimber(climber);
        });
    }

    public void whenWaiterWithThisNameExist_thenExceptionIsThrown(){

        Climbing climbing = new Climbing("Gosho", 5);

        RockClimber climber = new RockClimber("Pesho", 12);
        climbing.addRockClimber(climber);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            climbing.addRockClimber(climber);
        });
    }
    @Test
    public void whenWaiterExistByThisName_thenReturnTrue(){

        Climbing climbing = new Climbing("Gosho", 5);

        RockClimber climber = new RockClimber("Pesho", 12);
        climbing.addRockClimber(climber);

        boolean result = climbing.removeRockClimber("Pesho");
        Assertions.assertTrue(result);
    }
    @Test
    public void whenWaiterDoesNotExistByThisName_thenReturnFalse(){

        Climbing climbing = new Climbing("Gosho", 5);

        boolean result = climbing.removeRockClimber("Pesho");
        Assertions.assertFalse(result);
    }
}
