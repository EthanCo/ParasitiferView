package com.ethanco.parasitiferviewsample;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ethanco.parasitiferview.ParasyteAdapter;

/**
 * @Description Weather01 Adapter
 * Created by EthanCo on 2016/10/21.
 */

public class WeatherAdapter extends ParasyteAdapter<String> {
    public WeatherAdapter(Context context, String data) {
        super(context, data);
    }

    @Override
    public View getView() {
        View view = mInflater.inflate(R.layout.layout_weather, null);
        ImageView imgWeather = (ImageView) view.findViewById(R.id.img_weather);
        TextView tvTemper = (TextView) view.findViewById(R.id.tv_temper);

        tvTemper.setText(data);
        return view;
    }
}
