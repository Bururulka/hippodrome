import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import java.util.concurrent.TimeUnit;

public class mainTest {
    @Disabled
    @Timeout(value = 22000, unit = TimeUnit.MILLISECONDS)
    @Test
    public void test()  {
        try {
            String[] args = {" ", " "};
            Main.main(args);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
