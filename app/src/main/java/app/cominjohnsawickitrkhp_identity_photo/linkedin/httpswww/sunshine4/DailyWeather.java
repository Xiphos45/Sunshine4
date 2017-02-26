package app.cominjohnsawickitrkhp_identity_photo.linkedin.httpswww.sunshine4;

/**
 * Created by John on 2/19/2017.
 */

public class DailyWeather {
    private int iconID;
    private String day;
    private String description;
    private String max;
    private String min;
    public DailyWeather(int icon, String d, String des, String mx, String mn){
        iconID = icon;
        day = d;
        description = des;
        max = mx;
        min = mn;
    }
    public String getDay(){return day;}
    public String getDescription(){return description;}
    public String getMax(){return max;}
    public String getMin(){return min;}
}
