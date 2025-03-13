import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.concurrent.ThreadLocalRandom;

@ExtendWith(MockitoExtension.class)
class HorseTest {
    @Test
    public void nullIllegalExceptionFirst(){
        Throwable exception = assertThrows( IllegalArgumentException.class, () -> {
            Horse horse = new Horse(null, 0, 0);
        } );
    }
    @Test
    public void nullIllegalExceptionFirstWithMessage(){
        Throwable exception = assertThrows( IllegalArgumentException.class, () -> {
            Horse horse = new Horse(null, 0, 0);
        });
        assertEquals("Name cannot be null.", exception.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = { " ", "\t\t" })
    public void nullIllegalExceptionFirstEmptyOrSpaceName(String name){
        Throwable exception = assertThrows( IllegalArgumentException.class, () -> {
            Horse horse = new Horse(name, 0, 0);
        } );
    }

    @ParameterizedTest
    @ValueSource(strings = { " ", "\t\t" })
    public void nullIllegalExceptionEmptyFirstOrSpaceNameWithMessage(String name){
        Throwable exception = assertThrows( IllegalArgumentException.class, () -> {
            Horse horse = new Horse(name, 0, 0);
        } );
        assertEquals("Name cannot be blank.", exception.getMessage());
    }

    @Test
    public void nullIllegalExceptionSecond(){
        Throwable exception = assertThrows( IllegalArgumentException.class, () -> {
            int randomNum = ThreadLocalRandom.current().nextInt(Integer.MIN_VALUE, 0);
            Horse horse = new Horse(null, randomNum, 0);
        } );
    }

    @Test
    public void nullIllegalExceptionSecondWithMessage(){
        Throwable exception = assertThrows( IllegalArgumentException.class, () -> {
            int randomNum = ThreadLocalRandom.current().nextInt(Integer.MIN_VALUE, 0);
            Horse horse = new Horse("Horse", randomNum, 0);
        } );
        assertEquals("Speed cannot be negative.", exception.getMessage());
    }

    @Test
    public void nullIllegalExceptionThird(){
        Throwable exception = assertThrows( IllegalArgumentException.class, () -> {
            int randomNum = ThreadLocalRandom.current().nextInt(Integer.MIN_VALUE, 0);
            Horse horse = new Horse(null, 0, randomNum);
        } );
    }

    @Test
    public void nullIllegalExceptionThirdWithMessage(){
        Throwable exception = assertThrows( IllegalArgumentException.class, () -> {
            int randomNum = ThreadLocalRandom.current().nextInt(Integer.MIN_VALUE, 0);
            Horse horse = new Horse("Horse", 0, randomNum);
        } );
        assertEquals("Distance cannot be negative.", exception.getMessage());
    }

    @Test
    public void getNameTest(){
        String name = "Horse";
        Horse horse = new Horse(name, 0, 0);
        assertEquals(name, horse.getName());
    }

    @Test
    public void getSpeedTest(){
        int speed = 10;
        Horse horse = new Horse("Horse", speed, 0);
        assertEquals(speed, horse.getSpeed());
    }

    @Test
    public void getDistanceTest(){
        int distance = 10;
        Horse horse = new Horse("Horse", 0, distance);
        assertEquals(distance, horse.getDistance());
    }
    @Test
    public void moveTest(){
        try(MockedStatic<Horse> mockedHorse = Mockito.mockStatic(Horse.class)) {
            new Horse("Horse", 10, 10).move();
            mockedHorse.verify(()->Horse.getRandomDouble(0.2,0.9));
        }
    }


}
