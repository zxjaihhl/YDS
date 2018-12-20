package com.zxjaihhl.yds.view;

import android.app.Activity;
import android.view.LayoutInflater;
import android.widget.ListView;

import java.util.List;

/**
 * Created by Administrator on 2017/9/13.
 * 描述：
 */

public abstract class HeaderViewInterface<T> {

    protected Activity mContext;
    protected LayoutInflater mInflate;
    protected T mEntity;

    public HeaderViewInterface(Activity context) {
        this.mContext = context;
        mInflate = LayoutInflater.from(context);
    }

    public boolean fillView(T t, ListView listView) {
        if (t == null) {
            return false;
        }
        if ((t instanceof List) && ((List) t).size() == 0) {
            return false;
        }
        this.mEntity = t;
        getView(t, listView);
        return true;
    }
    public boolean fillLocalView(T t, ListView listView) {
        if (t == null) {
            return false;
        }
        if ((t instanceof List) && ((List) t).size() == 0) {
            return false;
        }
        this.mEntity = t;
        getLocalView(t, listView);
        return true;
    }
    protected abstract void getView(T t, ListView listView);
    protected abstract void getLocalView(T t, ListView listView);

}

