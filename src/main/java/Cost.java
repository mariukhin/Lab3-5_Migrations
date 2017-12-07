import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;
import java.sql.Statement;

public class Cost {
    private int costId;
    private int editionId;
    private int num;
    private int high;
    private static List<Cost> costs = new ArrayList<>();

    public Cost() {
        costId = -1;
        num = -1;
        high = -1;
        editionId = -1;
    }
    public Cost(int cId, int number, int highg, int eId) {
        costId = cId;
        num = number;
        high = highg;
        editionId = eId;
    }
    private static void addCost(Cost o) {
        costs.add(o);
    }
    private static void getCostsFromDB() {
        Connection con = Connect.connect();
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM cost");
            while(rs.next()) {
                Cost ncost = new Cost();
                ncost.num = rs.getInt(2);
                ncost.high =rs.getInt(3);
                ncost.costId =rs.getInt(1);
                ncost.editionId =rs.getInt(4);
                if(!costs.contains(ncost)) {
                    addCost(ncost);
                }

            }
            rs.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Problem with getting costs");
        } finally {
            Connect.closeConnection(con);
        }
    }
    public static Cost getCost(int ID) {
        getCostsFromDB();
        for(Cost o : costs) {
            if(o.num == ID) {
                return o;
            }
        }
        return null;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cost cost = (Cost) o;

        if (costId != cost.costId) return false;
        if (editionId != cost.editionId) return false;
        if (num != cost.num) return false;
        return high == cost.high;
    }

}
