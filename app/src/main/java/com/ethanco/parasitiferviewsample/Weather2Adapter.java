package com.ethanco.parasitiferviewsample;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.ethanco.parasitiferview.ParasyteAdapter;
import com.ethanco.parasitiferviewsample.bean.WeatherInfo;

/**
 * @Description Weather01 Adapter
 * Created by EthanCo on 2016/10/21.
 */

public class Weather2Adapter extends ParasyteAdapter<WeatherInfo> {


    public Weather2Adapter(Context context, WeatherInfo data) {
        super(context, data);
    }

    @Override
    public View getView() {
        View view = mInflater.inflate(R.layout.layout_weather2, null);
        TextView tvTemper = (TextView) view.findViewById(R.id.tv_temper);
        TextView tvType = (TextView) view.findViewById(R.id.tv_type);

        tvTemper.setText(String.valueOf(data.getTemper()));
        tvType.setText(data.getType());
        return view;
    }
}
