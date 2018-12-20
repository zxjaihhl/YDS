package com.zxjaihhl.yds.fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zxjaihhl.yds.R;

import butterknife.ButterKnife;

/**
 * Created by zxjaihhl on 2017/11/17.
 */

public class MyFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my, null);
        ButterKnife.bind(getActivity());
        findView(view);

        return view;
    }

    private void findView(View view) {


    }
}
