import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class USER {
    private String User,Pass; 
    DBConnection connection = new DBConnection();
    public Encryptor en = new Encryptor();
public USER(){
    connection.connect();
}

public String getUser(){
    return User;
}
public String getPass(){
    return Pass;
}
public boolean checkLogin(String User, String Pass){ //function to check if login password the same in the database
    boolean flag = false;
     String sql = "SELECT * from User_In4 WHERE User_In4.USER LIKE ? AND User_In4.PASS LIKE?;";
     PreparedStatement pst = connection.pst;
                Connection con = connection.con;
                ResultSet rs = connection.rs;
            try {
                pst = con.prepareStatement(sql);
                pst.setString(1, User);
                pst.setString(2, en.encryptString(Pass));
                rs = pst.executeQuery();
                if (rs.next()) {
                   flag = true;
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
        return flag;
}
   public boolean addRegister(String User, String Pass, String Email){ //function to add new registered information to the database
       boolean flag = false;
       PreparedStatement pst = connection.pst;
                Connection con = connection.con;
                ResultSet rs = connection.rs;
       try {
    String sql = "INSERT OR IGNORE INTO User_In4(User, Pass, Email) VALUES(?,?,?) ";
    pst = con.prepareStatement(sql);
    pst.setString(1, User);
    pst.setString(2, Pass);
    pst.setString(3, Email);
    pst.execute();
    System.out.println("Data has been inserted!");
  } catch(SQLException e) {
    System.out.println(e.toString());
   
  }finally{
            try{
                rs.close();
                pst.close();
            }catch (Exception e){
                
            }
        }
        String sql = "SELECT * from User_In4 WHERE User_In4.EMAIL LIKE? AND User_In4.USER LIKE?;";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1,Email);
            pst.setString(2,User);

         
            rs = pst.executeQuery();
            if (rs.next()) {
                flag = true;
                try {
                    String sl = "INSERT INTO History(Action) VALUES (?)";
                            pst = con.prepareStatement(sl);
                            pst.setString(1,"New account created username "+User);
                            pst.execute();
                            System.out.println("added");
                } catch (Exception e){
                    
                }finally{
            try{
                rs.close();
                pst.close();
            }catch (Exception e){
                
            }
        } 
            } 
        } 
        catch(Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
        }finally{
            try{
                rs.close();
                pst.close();
            }catch (Exception e){
                
            }
        }
        return flag;
   } 
    
}
