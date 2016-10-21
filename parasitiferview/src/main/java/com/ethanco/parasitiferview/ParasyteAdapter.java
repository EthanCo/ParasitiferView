package com.ethanco.parasitiferview;

import android.content.Context;
import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;

/**
 * @Description 寄生兽 Adapter
 * Created by EthanCo on 2016/10/21.
 */

public abstract class ParasyteAdapter<T> {
    protected T data;
    protected Context context;
    protected LayoutInflater mInflater;
    private DataSetObservable mDataSetObservable = new DataSetObservable();

    public void registerDataSetObserver(DataSetObserver observer) {
        mDataSetObservable.registerObserver(observer);
    }

    public void unregisterDataSetObserver(DataSetObserver observer) {
        mDataSetObservable.unregisterObserver(observer);
    }


    public ParasyteAdapter(Context context, T data) {
        this.context = context;
        this.data = data;
        this.mInflater = LayoutInflater.from(context);
    }

    public void updateData(T data) {
        setData(data);
        notifyDataSetChanged();
    }

    public void setData(T data) {
        this.data = data;
    }

    public void notifyDataSetChanged() {
        mDataSetObservable.notifyChanged();
    }

    public abstract View getView();
}
