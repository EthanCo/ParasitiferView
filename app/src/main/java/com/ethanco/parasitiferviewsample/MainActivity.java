package com.ethanco.parasitiferviewsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.ethanco.parasitiferview.ParasitiferView;
import com.ethanco.parasitiferviewsample.bean.WeatherInfo;

public class MainActivity extends AppCompatActivity {

    private ParasitiferView parasitifer;
    private ParasitiferView parasitifer2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        parasitifer = (ParasitiferView) findViewById(R.id.parasitifer);

        findViewById(R.id.btn_weather_type1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parasitifer.setAdapter(new WeatherAdapter(MainActivity.this, "59"));
            }
        });

        findViewById(R.id.btn_weather_type2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parasitifer.setAdapter(new Weather2Adapter(MainActivity.this, new WeatherInfo(31, "多云")));
            }
        });
    }
}
