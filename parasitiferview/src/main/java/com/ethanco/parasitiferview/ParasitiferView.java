package com.ethanco.parasitiferview;

import android.content.Context;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;

import java.lang.ref.WeakReference;

/**
 * @Description View 宿主
 * Created by EthanCo on 2016/10/21.
 */

public class ParasitiferView extends FrameLayout {

    private DataSetObserver mDataSetObserver;

    public ParasitiferView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mDataSetObserver = new ParasyDataSetObserver(this);
    }

    private ParasyteAdapter adapter;

    public void setAdapter(ParasyteAdapter adapter) {
        unregisterDataSetObserver();
        resetAdapter(adapter);
    }

    private void unregisterDataSetObserver() {
        if (this.adapter != null && mDataSetObserver != null) {
            this.adapter.unregisterDataSetObserver(mDataSetObserver);
        }
    }

    private void resetAdapter(ParasyteAdapter adapter) {
        this.adapter = adapter;
        this.adapter.registerDataSetObserver(mDataSetObserver);
        this.adapter.notifyDataSetChanged();
    }

    private void show() {
        removeAllViews();
        View view = adapter.getView();
        addView(view);
        FrameLayout.LayoutParams lp = (LayoutParams) view.getLayoutParams();
        lp.gravity = Gravity.CENTER;
        view.setLayoutParams(lp);
    }

    private static class ParasyDataSetObserver extends DataSetObserver {
        private WeakReference<ParasitiferView> parasyteRef;

        public ParasyDataSetObserver(ParasitiferView parasyte) {
            this.parasyteRef = new WeakReference(parasyte);
        }

        @Override
        public void onChanged() {
            ParasitiferView parasyte = parasyteRef.get();
            if (parasyte == null) return;

            parasyte.show();
        }
    }
}
