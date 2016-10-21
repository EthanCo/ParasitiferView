package com.ethanco.parasitiferviewsample.bean;

/**
 * @Description 天气信息
 * Created by EthanCo on 2016/10/21.
 */

public class WeatherInfo {
    private int temper;
    private String type;

    public WeatherInfo(int temper, String type) {
        this.temper = temper;
        this.type = type;
    }

    public int getTemper() {
        return temper;
    }

    public void setTemper(int temper) {
        this.temper = temper;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
