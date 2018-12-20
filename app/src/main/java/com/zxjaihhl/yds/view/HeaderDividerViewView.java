package com.zxjaihhl.yds.view;

import android.app.Activity;
import android.view.View;
import android.widget.ListView;

import com.zxjaihhl.yds.R;

/**
 * Created by Administrator on 2017/9/13.
 * 描述：
 */

public class HeaderDividerViewView extends HeaderViewInterface<String> {

    public HeaderDividerViewView(Activity context) {
        super(context);
    }

    @Override
    protected void getView(String s, ListView listView) {
        View view = mInflate.inflate(R.layout.header_divider_layout, listView, false);
        listView.addHeaderView(view);
    }
    protected void getLocalView(String s, ListView listView) {
        View view = mInflate.inflate(R.layout.header_divider_layout, listView, false);
        listView.addHeaderView(view);
    }
}

