
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

class Storages {

    private String ID; 
    private String Name;
    private double Price;
    private double Quantity;
    private double Size;
    DBConnection connection = new DBConnection();
    
    public Storages() {
        connection.connect(); // use the connection from DBConnection class
    }

    public Storages(String ID, String Name, double Price, double Quantity, double Size) {
        // variable decleration for the constructor
        this.ID = ID; // ID of the item
        this.Name = Name; // Name of the item
        this.Price = Price; // Price of the item
        this.Quantity = Quantity; // Quantity of the item
        this.Size = Size; // Size of the item
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return Name;
    }

    public double getPrice() {
        return Price;
    }

    public double getQuantity() {
        return Quantity;
    }

    public double getSize() {
        return Size;
    }

    public void addStorage(String ID, String Name, String Price, String Quantity, String Size) {
        // function to add new item to the database
                PreparedStatement pst = connection.pst;
                Connection con = connection.con;
                ResultSet rs = connection.rs;
        try {
            // query to insert item to the local database
            String sq = "INSERT OR IGNORE INTO storage(ID, Name, Price, Quantity, Size) VALUES (?, ?, ?, ?,?)";
            pst = con.prepareStatement(sq);
            pst.setString(1, ID); // set the value for the item's ID
            pst.setString(2, Name); // set the value for the item's Name
            pst.setString(3, Price); // set the value for the item's Price
            pst.setString(4, Quantity); // set the value for the item's Quantity
            pst.setString(5, Size); // set the value for the item's Size
            pst.execute(); // execute the query

        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
        } finally {
            try {
                rs.close(); // clear the result set
                pst.close(); // clear the prepared statement
            } catch (Exception e) {

            }
        }

    }

    public void deleteStorage(String ID, String Name, String Price, String Quantity, String Size) { //delete order function
                PreparedStatement pst = connection.pst;
                Connection con = connection.con;
                ResultSet rs = connection.rs;
        try {
            String sql = "DELETE FROM storage WHERE storage.ID LIKE ? AND storage.Name LIKE ? AND storage.Price LIKE ? AND storage.Quantity LIKE ? AND storage.Size LIKE ?;";
            pst = con.prepareStatement(sql);
            pst.setString(1, ID);
            pst.setString(2, Name);
            pst.setString(3, Price);
            pst.setString(4, Quantity);
            pst.setString(5, Size);
            pst.execute();

            try {
                String sl = "INSERT INTO History(Action) VALUES (?)";
                pst = con.prepareStatement(sl);
                pst.setString(1, "Delete from storage item: " + ID);
                pst.execute();
                System.out.println("added");

            } catch (Exception e) {

            } finally {
                try {
                    rs.close();
                    pst.close();
                } catch (Exception e) {

                }
            }

        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                pst.close();
            } catch (Exception e) {

            }
        }
    }

    public void updateStorage(String ID, String Name, double Price, double Quantity, double Size) { //update the items in the storage function
                PreparedStatement pst = connection.pst;
                Connection con = connection.con;
                ResultSet rs = connection.rs;
        try {
            String id = ID;
            String name = Name;
            double price = Price;
            double quantity = Quantity;
            double size = Size;

            String sql = "UPDATE storage SET ID = '" + id + "',Name = '" + name + "', Price = '" + price + "', Quantity = '" + quantity + "', Size = '" + size + "' WHERE ID = '" + id + "'  ";
            pst = con.prepareStatement(sql);
            pst.execute();

            try {
                String sl = "INSERT INTO History(Action) VALUES (?)";
                pst = con.prepareStatement(sl);
                pst.setString(1, "Update item " + id + " from the storage");
                pst.execute();
                System.out.println("added");
            } catch (Exception e) {

            } finally {
                try {
                    rs.close();
                    pst.close();
                } catch (Exception e) {

                }
            }

        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                pst.close();
            } catch (Exception e) {

            }
        }

    }
}
