import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class TestScreenAdaptationsGet {
    @Test
    public void testGetScreenAdaptation() {
        ScreenAdaptation executeSc = new ScreenAdaptation(1, 2, 1979, 8,"Stalker");
        ScreenAdaptation textSc = ScreenAdaptation.getScreenAdaptation(1);
        assertTrue(executeSc.equals(textSc));
    }
}
