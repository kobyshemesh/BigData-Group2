package data.scraping.yelp;

public enum Config {

    YELP("Bearer WXlfKkuls4FSD3Cel_Y-PqxvjhQ89IGhmW_KJi_9eJletViVY_iqsgzFUDDkp_iVzqrOOZVOVSHmQBzzjehKGmcerOdf_CiuVo8mA1aLbcG0Gm0nYUN-0_7GRQsvWnYx");

    private String key;

    Config(String key){
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}
