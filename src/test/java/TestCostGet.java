import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class TestCostGet {
    @Test
    public void testGetCost() {
        Cost executeCost = new Cost(1, 150, 5, 1);
        Cost textCost = Cost.getCost(1);
        assertTrue(executeCost.equals(textCost));
    }
}
