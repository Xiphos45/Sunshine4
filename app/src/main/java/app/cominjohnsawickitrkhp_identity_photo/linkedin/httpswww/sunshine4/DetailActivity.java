package app.cominjohnsawickitrkhp_identity_photo.linkedin.httpswww.sunshine4;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class DetailActivity extends AppCompatActivity {
    String weatherDetail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        if (savedInstanceState == null) {
            DetailFragment detailFragment = new DetailFragment(); //create a fragment
            FragmentManager fragMgr2= getFragmentManager();  //create something to manage that fragment
            FragmentTransaction fragmentTransaction2 = fragMgr2.beginTransaction();   //the manager performs the methods/task
            fragmentTransaction2.add(R.id.container,detailFragment);   //the task is adding the object of the fragment class to the fragment section of activity_detail
            fragmentTransaction2.commit();

           weatherDetail = getIntent().getStringExtra("details");
            //Toast.makeText(this, weatherDetail, Toast.LENGTH_SHORT).show();
            /*
           TextView textView1=(TextView)findViewById(R.id.detailsMain);
            textView1.setText(weatherDetail);
            Bundle bundle = new Bundle();

            bundle.putString("from detail activity", weatherDetail);    //key first and than string to send
            DetailFragment fragobj = new DetailFragment();
            fragobj.setArguments(bundle);   //send string to the fragment
            */
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.details_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if(id==R.id.settings_item){
            Intent settingsIntent = new Intent(this, SettingsActivity.class);  //no extras
            startActivity(settingsIntent);
        }
        return super.onOptionsItemSelected(item);
    }
    public String getWeather(){
        return weatherDetail;
    }
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            View rootView = inflater.inflate(R.layout.fragment_detail, container, false);
            return rootView;
        }
    }
}
