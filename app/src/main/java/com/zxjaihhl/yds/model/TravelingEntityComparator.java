package com.zxjaihhl.yds.model;

import java.util.Comparator;

/**
 * Created by Administrator on 2017/9/13.
 * 描述：
 */

public class TravelingEntityComparator implements Comparator<TravelingEntity> {

    @Override
    public int compare(TravelingEntity lhs, TravelingEntity rhs) {
        return rhs.getRank() - lhs.getRank();
    }
}
