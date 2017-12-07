import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Author {
    private int authorId;
    private String authorName;
    private int numofBooks;
    private int series;
    private static List<Author> authorsList = new ArrayList<Author>();

    public Author() {
        authorId = -1;
        authorName = "Unknown";
        numofBooks = -1;
        series = -1;
    }
    public Author( int aId, String  aName, int nb, int ser) {
        authorId = aId;
        authorName = aName;
        numofBooks = nb;
        series = ser;
    }
    private static void addDirectory(Author a) {
        authorsList.add(a);
    }
    private static void getAuthorsFromDB() {
        Connection con = Connect.connect();
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM author");
            while(rs.next()) {
                Author nAuthor = new Author();
                nAuthor.authorId = rs.getInt(1);
                nAuthor.authorName = rs.getString(2);
                nAuthor.numofBooks = rs.getInt(3);
                nAuthor.series = rs.getInt(4);
                if(!authorsList.contains(nAuthor)) {
                    addDirectory(nAuthor);
                }
            }
            rs.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Problem with getting authors");
        } finally {
            Connect.closeConnection(con);
        }
    }
    public static Author getAuthor(int ID) {
        getAuthorsFromDB();
        for(Author a: authorsList) {
            if(a.authorId == ID) {
                return a;
            }
        }
        return null;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Author author = (Author) o;

        if (authorId != author.authorId) return false;
        if (numofBooks != author.numofBooks) return false;
        if (series != author.series) return false;
        return authorName != null ? authorName.equals(author.authorName) : author.authorName == null;
    }

}

