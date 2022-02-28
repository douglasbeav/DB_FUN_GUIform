import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Utils {

    //    Declare a connection
    private static Connection connect = null;
    //    Create an SQL statement set -> null
    private static Statement stmt = null;
    //    Declare a ResultSet set -> null
    private static ResultSet rs = null;
    //    Declare a query
    private static String query;

    public static void connect(String usr, String pswrd) {
        connect = DB_Connector.connect(usr, pswrd);
    }

    public boolean checkLogin(String name, String password) {
        boolean check = false;
        query = "select * from users " +
                "where usrName = '" + name + "' and password = '" + password + "';";

        try {
            stmt = connect.createStatement();
            rs = stmt.executeQuery(query);

            while(rs.next()) {
                check = true;
                System.out.println("YOOOOHOOOO!!!!");
            }

            if(check == false) {
                System.out.println("BOOHOOO!!!");
            }
        } catch(SQLException e) {
            e.printStackTrace();
            return check;
        }
        return check;
    }

}
