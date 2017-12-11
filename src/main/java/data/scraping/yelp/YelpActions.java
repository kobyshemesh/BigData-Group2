package data.scraping.yelp;

import org.json.simple.JSONObject;
import utils.API;

public class YelpActions {

    API api = new API();
    int FIRSE_TIER_RADIUS = 100;
    int SECOND_TIER_RADIUS = 1000;

    public void getDataByCords(String lat, String lng, int radius){

        String requestUrl = String.format("https://api.yelp.com/v3/businesses/search?latitude=%s&longitude=%s&radius=%s", lat, lng, radius);
        JSONObject count = api.GET(requestUrl, Config.YELP);
        Object total = count.get("total");
        System.out.println(total);

    }
}
