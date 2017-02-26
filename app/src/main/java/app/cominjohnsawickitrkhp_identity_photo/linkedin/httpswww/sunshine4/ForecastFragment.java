package app.cominjohnsawickitrkhp_identity_photo.linkedin.httpswww.sunshine4;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


public class ForecastFragment extends Fragment{
    ArrayList<String> locations;
    public ArrayAdapter<String> arrayAdapter;
    String[] weather;
    public String[] formatWeather = new String[10];
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        //return super.onCreateView(inflater, container, savedInstanceState);
    /*


        ArrayList<DailyWeather> theWeatherToday = new ArrayList<DailyWeather>();

        theWeatherToday.add(new DailyWeather(R.drawable.sunicon, "Monday", "Cloudy", "79", "60"));
        ListView listView = (ListView)view.findViewById(R.id.arrayView);
        DailyWeatherAdapter adapter =new DailyWeatherAdapter(getActivity().getApplicationContext(), theWeatherToday);
        listView.setAdapter(adapter);
        */
        View view = inflater.inflate(R.layout.forecast_fragment, container, false);     //add the fragment to the layout
        setHasOptionsMenu(true);
       weather = new String[] {
                "Today - Sunny - 88/63",
                "Tomorrow - Froggy - 70/46",
                "Weds - Cloudy 72-63",
                "Thurs - Rainy 64-51",
                "Fri - Foggy - 70/46",
                "Sat - Sunny 76-68"};

        ListView listView = (ListView)view.findViewById(R.id.arrayView);
        arrayAdapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1, weather);        //Android defined layout with only 1 text view
        listView.setAdapter(arrayAdapter);

        return view;


    }



}

class FetchWeatherTask extends AsyncTask <String, Void, String[]> {          //modified first void to string to accept input type, change third data tpye for return
    private final String LOG_TAG = FetchWeatherTask.class.getSimpleName();
   public static final String SERVER_URL="http://api.openweathermap.org/data/2.5/forecast/daily?zip="+94043+",us&units=metric&cnt=7&APPID=36ef9d0845139b59cdc1be9d83142b39" ;
   //public static final String SERVER_URL="http://api.openweathermap.org/data/2.5/forecast/daily?zip=94043,us&units=metric&cnt=7&APPID=36ef9d0845139b59cdc1be9d83142b39";
   public String[] formattedString = new String[7];
    @Override
    protected String[] doInBackground(String... params) {   //change from void to change for return data type

        try {
            URL theURL = new URL(SERVER_URL);
            BufferedReader reader = new BufferedReader(new InputStreamReader(theURL.openConnection().getInputStream(), "UTF-8"));
            String jsonString = reader.readLine();




                Log.d("JSON", jsonString);
                JSONObject weather = new JSONObject(jsonString);
                JSONArray days = weather.getJSONArray("list");
                for (int i = 0; i < days.length(); i++) {
                    JSONObject dayInfo = days.getJSONObject(i);
                    Log.d("DT ", dayInfo.getString("dt"));
                    JSONObject temp = dayInfo.getJSONObject("temp");
                    //Log.d("Max temp", temp.getString("max"));
                    formattedString[i]=temp.getString("max");
                    //locations.add(temp.getString("max"));

                }
        }catch(MalformedURLException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }catch(JSONException e){
            e.printStackTrace();
        }
        return formattedString;

    }


    @Override
    protected void onPostExecute(String[] result){
    super.onPostExecute(result);
        Log.d("Max temp", "on post execute");
    }

}
