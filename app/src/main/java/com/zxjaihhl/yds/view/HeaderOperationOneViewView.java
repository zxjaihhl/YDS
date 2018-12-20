package com.zxjaihhl.yds.view;

import android.app.Activity;
import android.view.View;
import android.widget.ListView;

import com.zxjaihhl.yds.R;
import com.zxjaihhl.yds.adapter.HeaderOperationOneAdapter;
import com.zxjaihhl.yds.model.OperationOneEntity;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/9/13.
 * 描述：
 */

public class HeaderOperationOneViewView extends HeaderViewInterface<List<OperationOneEntity>> {

    @Bind(R.id.gv_operation)
    FixedGridView gvOperationOne;

    public HeaderOperationOneViewView(Activity context) {
        super(context);
    }

    @Override
    protected void getView(List<OperationOneEntity> list, ListView listView) {
        View view = mInflate.inflate(R.layout.header_operation_one_layout, listView, false);
        ButterKnife.bind(this, view);

        dealWithTheView(list);
        listView.addHeaderView(view);
    }
    protected void getLocalView(List<OperationOneEntity> list, ListView listView) {
        View view = mInflate.inflate(R.layout.header_operation_one_layout, listView, false);
        ButterKnife.bind(this, view);

        dealWithTheView(list);
        listView.addHeaderView(view);
    }

    private void dealWithTheView(List<OperationOneEntity> list) {
        HeaderOperationOneAdapter adapter=new HeaderOperationOneAdapter(mContext,list);
        gvOperationOne.setAdapter(adapter);
    }

}
