
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TestBookGet {
    @Test
    public void testGetBook() {
        Book executeBook = new Book(1,1 ,1844, "The Count of Monte Cristo", 3,2);
        Book textBook = Book.getBook(1);
        assertTrue(executeBook.equals(textBook));
    }
}
