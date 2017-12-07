import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Edition {
    private int editionId;
    private int bookId;
    private int costId;
    private String editionName;
    private int numOfCopies;
    private static List<Edition> editionsList = new ArrayList<Edition>();

    public Edition() {
        editionId = -1;
        bookId = -1;
        costId = -1;
        editionName = "Unknown";
        numOfCopies = -1;
    }

    public Edition(int eId, int bId, int cId, int noc, String eName) {
        editionId = eId;
        bookId = bId;
        costId = cId;
        numOfCopies = noc;
        editionName = eName;
    }

    private static void addDirectory(Edition e) {
        editionsList.add(e);
    }

    private static void getEditionsFromDB() {
        Connection con = Connect.connect();
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM edition");
            while (rs.next()) {
                Edition nEdition = new Edition();
                nEdition.editionId = rs.getInt(1);
                nEdition.bookId = rs.getInt(4);
                nEdition.costId = rs.getInt(5);
                nEdition.numOfCopies = rs.getInt(3);
                nEdition.editionName = rs.getString(2);
                if (!editionsList.contains(nEdition)) {
                    addDirectory(nEdition);
                }
            }
            rs.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Problem with getting editions");
        } finally {
            Connect.closeConnection(con);
        }
    }

    public static Edition getEdition(int ID) {
        getEditionsFromDB();
        for (Edition e : editionsList) {
            if (e.editionId == ID) {
                return e;
            }
        }
        return null;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Edition editions = (Edition) o;

        if (editionId != editions.editionId) return false;
        if (bookId != editions.bookId) return false;
        if (costId != editions.costId) return false;
        if (numOfCopies != editions.numOfCopies) return false;
        return editionName != null ? editionName.equals(editions.editionName) : editions.editionName == null;
    }
}
