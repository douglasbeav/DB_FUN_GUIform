import java.sql.*;

public class Utils {

    //    Declare a connection
    private static Connection connect = null;
    //    Create an SQL statement set -> null
    private static Statement stmt = null;
//    Create a PreparedStatement set -> null
    private static PreparedStatement pstmt = null;
    //    Declare a ResultSet set -> null
    private static ResultSet rs = null;
    //    Declare a query
    private static String query;

    public static void connect(String usr, String pswrd) {
        connect = DB_Connector.connect(usr, pswrd);
    }


    public void insertInto(String usrName, String password) {
        query = "insert into users(usrName, password) values(?, ?);";

//        query = "insert into users " +
//                "(usrName, password) values" + "('" +
//                userName + "', " + "'" + password + "')";
        try {
            pstmt = connect.prepareStatement(query);
            pstmt.setString(1, usrName);
            pstmt.setString(2, password);
            pstmt.execute();
//            stmt = connect.createStatement();
//            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean addNewUser(String usrName, String password) {
        boolean check = false;

        query = "select * from users where usrName = ?;";
//        query = "select * from users " +
//                "where usrName = '" + name + "';";

        try {
            pstmt = connect.prepareStatement(query);
            pstmt.setString(1, usrName);
            pstmt.execute();
            rs = pstmt.executeQuery();
//            stmt = connect.createStatement();
//            rs = stmt.executeQuery(query);

            while(rs.next()) {
                check = true;
                System.out.println("BOOHOOO!!!!");
            }

            if(check == false) {
                System.out.println("YOOOHOOOO!!!");
                insertInto(usrName, password);
            }
        } catch(SQLException e) {
            e.printStackTrace();
            return check;
        }
        return check;
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
