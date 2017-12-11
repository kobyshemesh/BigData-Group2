package data.scraping.yelp;

public class Yelp {


    public static void main(String[] args) {

        YelpActions actions = new YelpActions();
        actions.getDataByCords("52.3605759","4.9159683",100);


    }

    /*


    https://api.yelp.com/v3/businesses/search
        ?radius=1000
        &latitude=51.5100910
        &longitude=-0.1345680

     */


}
