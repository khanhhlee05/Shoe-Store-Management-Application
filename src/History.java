
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

class History {
// variable decleration for class History
    private String action; // the action happenned in the application
    DBConnection connection = new DBConnection(); // an instance object of DBConnection class
    
    public History() {
        connection.connect();
    }

    public History(String action) {
        this.action = action;
    }

    public String getAction() {
        return action;
    }

    public void clearAll() {
         PreparedStatement pst = connection.pst;
                Connection con = connection.con;
                ResultSet rs = connection.rs;
        try {
            String sql = "Delete FROM History WHERE Action > 0 ;";

            pst = con.prepareStatement(sql);
            pst.execute();

        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            try {
                rs.close();
                pst.close();
            } catch (Exception e) {

            }
        }
    }
}
