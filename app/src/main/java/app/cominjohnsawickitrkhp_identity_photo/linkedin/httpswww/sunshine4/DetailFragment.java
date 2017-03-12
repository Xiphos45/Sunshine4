package app.cominjohnsawickitrkhp_identity_photo.linkedin.httpswww.sunshine4;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by John on 3/11/2017.
 */

public class DetailFragment extends Fragment {
    public DetailFragment(){}


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(false);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //String weather = getArguments().getString("from detail activity");
        DetailActivity activity = (DetailActivity)getActivity();
        String fromDetailActivity = activity.getWeather();
        View rootView = inflater.inflate(R.layout.fragment_detail,container, false);
        TextView textView1=(TextView)rootView.findViewById(R.id.details);
        textView1.setText(fromDetailActivity);

        return rootView;
    }

}