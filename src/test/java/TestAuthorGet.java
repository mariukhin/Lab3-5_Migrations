import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class TestAuthorGet {
    @Test
    public void testGetAuthor() {
        Author executeAuthor = new Author(1,"Alexandre Dumas",80, 4);
        Author textAuthor = Author.getAuthor(1);
        assertTrue(executeAuthor.equals(textAuthor));
    }
}
