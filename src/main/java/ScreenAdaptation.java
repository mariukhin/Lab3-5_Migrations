import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;
import java.sql.Statement;

public class ScreenAdaptation {
    private int scId;
    private String scName;
    private int yearD;
    private int mark;
    private int bookId;
    private static List<ScreenAdaptation> screenAdaptations = new ArrayList<>();

    public ScreenAdaptation() {
        scId = -1;
        bookId = -1;
        yearD = -1;
        mark = -1;
        scName = "Unknown";
    }
    public ScreenAdaptation(int screenId,int bId, int year, int markS, String scname) {
        scId = screenId;
        bookId = bId;
        yearD = year;
        mark = markS;
        scName = scname;
    }
    private static void addScreenAdaptation(ScreenAdaptation o) {
        screenAdaptations.add(o);
    }
    private static void getOfficesFromDB() {
        Connection con = Connect.connect();
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM screenadaptation");
            while(rs.next()) {
                ScreenAdaptation nScreenA = new ScreenAdaptation();
                nScreenA.yearD = rs.getInt(3);
                nScreenA.mark = rs.getInt(4);
                nScreenA.scId = rs.getInt(1);
                nScreenA.bookId = rs.getInt(5);
                nScreenA.scName = rs.getString(2);
                if(!screenAdaptations.contains(nScreenA)) {
                    addScreenAdaptation(nScreenA);
                }

            }
            rs.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Problem with getting screenAdaptations");
        } finally {
            Connect.closeConnection(con);
        }
    }
    public static ScreenAdaptation getScreenAdaptation(int ID) {
        getOfficesFromDB();
        for(ScreenAdaptation o : screenAdaptations) {
            if(o.scId == ID) {
                return o;
            }
        }
        return null;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ScreenAdaptation screenAdaptation = (ScreenAdaptation) o;

        if (scId != screenAdaptation.scId) return false;
        if (mark != screenAdaptation.mark) return false;
        if (yearD != screenAdaptation.yearD) return false;
        if (bookId != screenAdaptation.bookId) return false;
        return scName != null ? scName.equals(screenAdaptation.scName) : screenAdaptation.scName == null;
    }

}
