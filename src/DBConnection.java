import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DBConnection {

    
public Connection con = null;
public PreparedStatement pst = null;
public ResultSet rs = null;
   
  public void  connect() { //function to connect the application to local database
      if (con != null) 
          return;
    try {
      Class.forName("org.sqlite.JDBC");
      con = DriverManager.getConnection("jdbc:sqlite:User_In4.db"); // connecting to our database
      System.out.println("Connected!");
     
    } catch (Exception e ) {
      // TODO Auto-generated catch block
      System.out.println(e+"");
    }
    
  }
}
 
  
