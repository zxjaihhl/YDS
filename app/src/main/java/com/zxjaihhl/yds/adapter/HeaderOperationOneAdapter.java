package com.zxjaihhl.yds.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.zxjaihhl.yds.R;
import com.zxjaihhl.yds.model.OperationOneEntity;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/9/13.
 * 描述：
 */

public class HeaderOperationOneAdapter extends BaseListAdapter<OperationOneEntity> {

    public HeaderOperationOneAdapter(Context context) {
        super(context);
    }

    public HeaderOperationOneAdapter(Context context, List<OperationOneEntity> list) {
        super(context, list);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_operation_one, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        OperationOneEntity entity = getItem(position);

        holder.tvTitle.setText(entity.getTitle());
        mImageManager.loadUrlImage(entity.getImage_url(), holder.ivImage);
        if (TextUtils.isEmpty(entity.getSubtitle())) {
            holder.tvSubtitle.setVisibility(View.INVISIBLE);
        } else {
            holder.tvSubtitle.setVisibility(View.VISIBLE);
            holder.tvSubtitle.setText(entity.getSubtitle());
        }

        return convertView;
    }

    static class ViewHolder {
        @Bind(R.id.iv_image)
        ImageView ivImage;
        @Bind(R.id.tv_title)
        TextView tvTitle;
        @Bind(R.id.tv_subtitle)
        TextView tvSubtitle;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}

