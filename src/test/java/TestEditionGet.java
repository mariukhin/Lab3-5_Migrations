import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TestEditionGet {
    @Test
    public void testGetEdition() {
        Edition executeEdition = new Edition(1, 2, 1, 12807 ,"Фолио");
        Edition textEdition = Edition.getEdition(1);
        assertTrue(executeEdition.equals(textEdition));
    }
}
