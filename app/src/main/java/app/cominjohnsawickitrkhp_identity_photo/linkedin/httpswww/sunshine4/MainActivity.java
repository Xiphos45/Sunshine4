package app.cominjohnsawickitrkhp_identity_photo.linkedin.httpswww.sunshine4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    /*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.debug_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {       //three dots on the top of the screen
        super.onOptionsItemSelected(item);
        // Handle item selection
        //menuOption = item.getItemId();
        EditText zipEditText = (EditText)findViewById(R.id.enterZip);   //read user data
        String zipString = zipEditText.getText().toString();        //convert EditText data type to String

        switch (item.getItemId()) {     //in ForecastFragment.java
            case R.id.refresh_item:
                FetchWeatherTask weatherTask = new FetchWeatherTask();
                weatherTask.execute(zipString); //sends the zip code to async task to use in the URL
                return true;
            case R.id.restart_item:

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
*/
}
