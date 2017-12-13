package data.scraping.yelp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
//import com.my

public class Yelp {

    private static Connection conn;

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Class.forName("com.mysql.jdbc.Driver");

        YelpActions actions = new YelpActions();

        conn = DriverManager.getConnection("jdbc:mysql://localhost/hotel_reviews", "root", "root");

        ResultSet results = conn.createStatement().executeQuery("SELECT DISTINCT(concat(lat,',',lng)), lat,lng FROM hotel_reviews WHERE `Yelp_Business_100m` IS NULL");

        while (results.next()) {
            String lat = results.getString(2);
            String lng = results.getString(3);

            if(!lat.equals("NA") && !lng.equals("NA")) {
                String countA = actions.getDataByCords(lat, lng, 100);
                String countB = actions.getDataByCords(lat, lng, 1000);
                String countC = actions.getDataByCords(lat, lng, 5000);

                String updateSql = String.format("UPDATE hotel_reviews SET Yelp_Business_100m = %s, Yelp_Business_1km = %s, Yelp_Business_5km = %s WHERE lat = %s AND lng = %s",
                        countA, countB, countC, lat, lng);
                System.out.println(countA);

                conn.createStatement()
                        .executeUpdate(updateSql);
            }
        }

        conn.close();

    }

    /*


    https://api.yelp.com/v3/businesses/search
        ?radius=1000
        &latitude=51.5100910
        &longitude=-0.1345680

     */


}
