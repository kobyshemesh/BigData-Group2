//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {

//    private static Log log = LogFactory.getLog(Main.class);

    private static Connection conn;

    public static void main(String[] args){

        try {
            PreparedStatement ps = conn.prepareCall("SELECT * FROM hotel_reviews LIMIT 1");
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

}
