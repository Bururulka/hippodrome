import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HippodromeTest {
    @Test
    public void nullIllegalExceptionNullList() {
        Throwable exception = assertThrows( IllegalArgumentException.class, () -> {
            Hippodrome hippodrome = new Hippodrome(null);
        } );
    }
    @Test
    public void nullIllegalExceptionNullListWithMessage() {
        Throwable exception = assertThrows( IllegalArgumentException.class, () -> {
            Hippodrome hippodrome = new Hippodrome(null);
        } );
        assertEquals("Horses cannot be null.", exception.getMessage());
    }
    @Test
    public void nullIllegalExceptionEmptyList(){
        Throwable exception = assertThrows( IllegalArgumentException.class, () -> {
            Hippodrome hippodrome = new Hippodrome(new ArrayList<Horse>());
        });
    }
    @Test
    public void nullIllegalExceptionEmptyListWithMessage(){
        Throwable exception = assertThrows( IllegalArgumentException.class, () -> {
            Hippodrome hippodrome = new Hippodrome(new ArrayList<Horse>());
        });
        assertEquals("Horses cannot be empty.", exception.getMessage());
    }
    @Test
    public void getHorsesTest(){
        List<Horse> horses = new ArrayList<Horse>();
        for (int i = 1; i <=30; i++){
            Horse horse = new Horse(Integer.toString(i),i,i);
            horses.add(horse);
        }
        Hippodrome hippodrome = new Hippodrome(horses);
        assertEquals(horses, hippodrome.getHorses());
    }
    @Test
    public void moveHorsesTest(){
        List<Horse> mockHorses = new ArrayList<Horse>();
        for (int i = 1; i <=50; i++){
            Horse horse = Mockito.mock(Horse.class);
            mockHorses.add(horse);
        }
        Hippodrome hippodrome = new Hippodrome(mockHorses);
        hippodrome.move();
        List<Horse> horses = hippodrome.getHorses();
        for( Horse horse : horses ){
            Mockito.verify(horse, Mockito.times(1)).move();
        }
    }

    @Test
    public void getWinnerTest(){
        List<Horse> horses = new ArrayList<Horse>();
        for (int i = 1; i <=30; i++){
            Horse horse = new Horse(Integer.toString(i),i,i);
            horses.add(horse);
        }
        Horse winner = horses.get(horses.size()-1);
        Hippodrome hippodrome = new Hippodrome(horses);
        assertEquals(winner, hippodrome.getWinner());
    }
}
