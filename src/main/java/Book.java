import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Book {
    private int bookId;
    private int authorId;
    private int editionId;
    private int screenadaptId;
    private String bookName;
    private int dateR;
    private static List<Book> booksList = new ArrayList<>();

    public Book() {
        bookId = -1;
        authorId = -1;
        editionId = -1;
        screenadaptId = -1;
        bookName = "Unknown";
        dateR = -1;
    }

    public Book(int bId, int aId, int dr, String bName, int eId, int scId) {
        bookId = bId;
        authorId = aId;
        dateR = dr;
        bookName = bName;
        editionId = eId;
        screenadaptId = scId;
    }

    private static void addDirectory(Book b) {
        booksList.add(b);
    }

    private static void getBooksFromDB() {
        Connection con = Connect.connect();
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM book");
            while (rs.next()) {
                Book nBook = new Book();
                nBook.bookId = rs.getInt(1);
                nBook.authorId = rs.getInt(4);
                nBook.dateR = rs.getInt(3);
                nBook.bookName = rs.getString(2);
                nBook.editionId = rs.getInt(5);
                nBook.screenadaptId = rs.getInt(6);
                if (!booksList.contains(nBook)) {
                    addDirectory(nBook);
                }
            }
            rs.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Problem with getting books");
        } finally {
            Connect.closeConnection(con);
        }
    }

    public static Book getBook(int ID) {
        getBooksFromDB();
        for (Book b : booksList) {
            if (b.bookId == ID) {
                return b;
            }
        }
        return null;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book books = (Book) o;

        if (bookId != books.bookId) return false;
        if (authorId != books.authorId) return false;
        if (editionId != books.editionId) return false;
        if (screenadaptId != books.screenadaptId) return false;
        if (dateR != books.dateR) return false;
        return bookName != null ? bookName.equals(books.bookName) : books.bookName == null;
    }
}

