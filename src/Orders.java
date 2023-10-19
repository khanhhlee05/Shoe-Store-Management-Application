
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Orders {

    private String ID; //ID of the order
    private String Name; // Name of the customer
    private double Price; // Price of the order
    private String Status; // Status of the order
    private String Email; // Email of the customer
    private String Address; // Address of the customer
    private String ITEM_1; // ID of item 1
    private String ITEM_2; // ID of item 2
    private String ITEM_3; // ID of item 3
    DBConnection connection = new DBConnection(); // an instance object of DBConnection class
    
    public Orders() {
        connection.connect();
    }

    public Orders(String ID, String Name, double Price, String Status, String Email, String Address, String ITEM_1, String ITEM_2, String ITEM_3) {
        this.ID = ID;
        this.Name = Name;
        this.Price = Price;
        this.Status = Status;
        this.Email = Email;
        this.Address = Address;
        this.ITEM_1 = ITEM_1;
        this.ITEM_2 = ITEM_2;
        this.ITEM_3 = ITEM_3;
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

    public String getStatus() {
        return Status;
    }

    public String getEmail() {
        return Email;
    }

    public String getAddress() {
        return Address;
    }

    public String getITEM_1() {
        return ITEM_1;
    }

    public String getITEM_2() {
        return ITEM_2;
    }

    public String getITEM_3() {
        return ITEM_3;
    }

    public boolean deleteOrder(String ID, String Name, String Price) throws SQLException { //delete order function
        boolean flag = false;
        PreparedStatement pst = connection.pst;
                Connection con = connection.con;
                ResultSet rs = connection.rs;
        try {
            String sql = "DELETE FROM order1 WHERE order1.ID LIKE ? AND order1.Name LIKE ? AND order1.Price LIKE ? ;";
            pst = con.prepareStatement(sql);
            pst.setString(1, ID);
            pst.setString(2, Name);
            pst.setString(3, Price);
            pst.execute();
            try {
                String sl = "INSERT INTO History(Action) VALUES (?)";
                pst = con.prepareStatement(sl);
                pst.setString(1, "Delete order id: " + ID);
                pst.execute();
                System.out.println("added");
                flag = true;

            } catch (Exception e) {

            }

        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return flag;

    }

    public boolean updateOrder(String ID, String Name, double Price, String Status) { //update order function in the ORDER window
        boolean flag = false;
        PreparedStatement pst = connection.pst;
                Connection con = connection.con;
                ResultSet rs = connection.rs;
        try {
            String id = ID;
            String name = Name;
            double price = Price;
            String status = Status;
            String sql = "UPDATE order1 SET ID = '" + id + "',Name = '" + name + "', Price = '" + price + "', Status = '" + status + "' WHERE ID = '" + id + "'  ";
            pst = con.prepareStatement(sql);
            pst.execute();

            try {
                String sl = "INSERT INTO History(Action) VALUES (?)";
                pst = con.prepareStatement(sl);
                pst.setString(1, "Update order id: " + id);
                pst.execute();
                System.out.println("added");
              
                    flag = true;
                
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
        } finally {
            try {
                rs.close();
                pst.close();
            } catch (Exception e) {

            }
        }
        return flag;
    }

    public void resetOrder() { //reset order database function
        PreparedStatement pst = connection.pst;
                Connection con = connection.con;
                ResultSet rs = connection.rs;
        try {
            String sql = "Delete FROM order1 WHERE Price > 0 ;";
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

    public boolean updateOrder(String ID, String Email, String Address, String item1, String item2, String item3) { //update order function in the ViewDetails window
        boolean flag = false;
        PreparedStatement pst = connection.pst;
                Connection con = connection.con;
                ResultSet rs = connection.rs;
        try {
            String id = ID;
            String email = Email;
            String address = Address;
            String Item1 = item1;
            String Item2 = item2;
            String Item3 = item3;
            String sql = "UPDATE order1 SET Email = '" + email + "',Address = '" + address + "', ITEM_1 = '" + Item1 + "', ITEM_2 = '" + Item2 + "', ITEM_3 = '" + Item3 + "' WHERE ID = '" + id + "'  ";
            pst = con.prepareStatement(sql);
            pst.execute();
            flag = true;
            try {
                String sl = "INSERT INTO History(Action) VALUES (?)";
                pst = con.prepareStatement(sl);
                pst.setString(1, "Update order id: " + id);
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
        } finally {
            try {
                rs.close();
                pst.close();
            } catch (Exception e) {

            }
        }
        return flag;
    }

    public void createOrder(String id, String name, String price, String email, String address, String item1, String item2, String item3) { //add new order function
        PreparedStatement pst = connection.pst;
                Connection con = connection.con;
                ResultSet rs = connection.rs;
        try {
            String sql = "INSERT OR IGNORE INTO order1(ID, Name, Price, Status, Email, Address, ITEM_1, ITEM_2, ITEM_3) VALUES(?,?,?,?,?,?,?,?,?) ";
            pst = con.prepareStatement(sql);
            pst.setString(1, id);
            pst.setString(2, name);
            pst.setString(3, price);
            pst.setString(4, "Preparing");
            pst.setString(5, email);
            pst.setString(6, address);
            pst.setString(7, item1);
            pst.setString(8, item2);
            pst.setString(9, item3);
            pst.execute();
            System.out.println("Data has been inserted!");
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
