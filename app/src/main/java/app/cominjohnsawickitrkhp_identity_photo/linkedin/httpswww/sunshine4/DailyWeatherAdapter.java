package app.cominjohnsawickitrkhp_identity_photo.linkedin.httpswww.sunshine4;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by John on 2/19/2017.
 */

public class DailyWeatherAdapter extends ArrayAdapter<DailyWeather> {
    public DailyWeatherAdapter(Activity context, ArrayList<DailyWeather> dailyWeather){
        super(context, 0, dailyWeather);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        DailyWeather dw = getItem(position);

        ImageView iconImageView = (ImageView) listItemView.findViewById(R.id.imageIcon);
        iconImageView.setVisibility(View.VISIBLE);
        iconImageView.setImageResource(R.drawable.sunicon);
        TextView dayTextView =(TextView)listItemView.findViewById(R.id.dayOfWeek);
        dayTextView.setText(dw.getDay());
        TextView descriptionTextView =(TextView)listItemView.findViewById(R.id.description);
        descriptionTextView.setText(dw.getDescription());
        TextView maxTextView =(TextView)listItemView.findViewById(R.id.max);
        maxTextView.setText(dw.getMax());
        TextView minTextView =(TextView)listItemView.findViewById(R.id.min);
        minTextView.setText(dw.getMin());

        return listItemView;
    }
}
