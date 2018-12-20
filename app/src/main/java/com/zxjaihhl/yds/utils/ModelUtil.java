package com.zxjaihhl.yds.utils;

import android.graphics.drawable.Drawable;

import com.zxjaihhl.yds.model.ChannelEntity;
import com.zxjaihhl.yds.model.FilterEntity;
import com.zxjaihhl.yds.model.FilterTwoEntity;
import com.zxjaihhl.yds.model.OperationEntity;
import com.zxjaihhl.yds.model.OperationOneEntity;
import com.zxjaihhl.yds.model.TravelingEntity;
import com.zxjaihhl.yds.model.TravelingEntityComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Administrator on 2017/9/13.
 * 描述：
 */

public class ModelUtil {
    public static final String type_scenery = "胰岛素";
    public static final String type_building = "胰岛素";
    public static final String type_animal = "胰岛素";
    public static final String type_plant = "胰岛素";
    public static final String type_all = "胰岛素";
    // 广告数据
    public static List<String> getAdData() {
        List<String> adList = new ArrayList<>();
        adList.add(StaticClass.URL_PONTO_AD);
        adList.add(StaticClass.URL_PONTO_AD);
        adList.add(StaticClass.URL_PONTO_AD);
        return adList;
    }
    public static List<Drawable> getAdLocalData() {
        List<Drawable> adList = new ArrayList<>();


        return adList;
    }
    // 频道数据
    public static List<ChannelEntity> getChannelData() {
        List<ChannelEntity> channelList = new ArrayList<>();
        channelList.add(new ChannelEntity("推荐上新好货", "新品推荐", StaticClass.URL_PONTO_CHANNEL));
        channelList.add(new ChannelEntity("这里有好卷哦", "领卷中心", StaticClass.URL_PONTO_CHANNEL));
        channelList.add(new ChannelEntity("海选火爆商品", "热销商品", StaticClass.URL_PONTO_CHANNEL));
        channelList.add(new ChannelEntity("精选10家好店", "今日好店", StaticClass.URL_PONTO_CHANNEL));

        return channelList;
    }
    // 运营数据
    public static List<OperationEntity> getOperationData() {
        List<OperationEntity> operationList = new ArrayList<>();
        operationList.add(new OperationEntity(StaticClass.TEXT_OPERATIONLIST_ONE, StaticClass.TEXT_OPERATIONLIST_TWO, StaticClass.URL_PONTO_OPERATION));
        operationList.add(new OperationEntity(StaticClass.TEXT_OPERATIONLIST_ONE, StaticClass.TEXT_OPERATIONLIST_TWO, StaticClass.URL_PONTO_OPERATION));
        operationList.add(new OperationEntity(StaticClass.TEXT_OPERATIONLIST_ONE, StaticClass.TEXT_OPERATIONLIST_TWO, StaticClass.URL_PONTO_OPERATION));
        operationList.add(new OperationEntity(StaticClass.TEXT_OPERATIONLIST_ONE, StaticClass.TEXT_OPERATIONLIST_TWO, StaticClass.URL_PONTO_OPERATION));
        return operationList;
    }

    public static List<OperationOneEntity> getOperationOneData() {
        List<OperationOneEntity> operationOneList = new ArrayList<>();
        operationOneList.add(new OperationOneEntity(StaticClass.TEXT_OPERTIONONELIST_ONE, StaticClass.TEXT_OPERTIONONELIST_TWO, StaticClass.URL_PONTO_OPERATIONONE));
        operationOneList.add(new OperationOneEntity(StaticClass.TEXT_OPERTIONONELIST_ONE, StaticClass.TEXT_OPERTIONONELIST_TWO, StaticClass.URL_PONTO_OPERATIONONE));
        operationOneList.add(new OperationOneEntity(StaticClass.TEXT_OPERTIONONELIST_ONE, StaticClass.TEXT_OPERTIONONELIST_TWO, StaticClass.URL_PONTO_OPERATIONONE));
        return operationOneList;
    }
    // ListView数据
    public static List<TravelingEntity> getTravelingData() {
        List<TravelingEntity> travelingList = new ArrayList<>();
        travelingList.add(new TravelingEntity(type_scenery, StaticClass.TEXT_TRAVELINGLIST, StaticClass.TEXT_TRAVELINGLIST_ONE, 1, StaticClass.URL_PONTO_LIST));
        travelingList.add(new TravelingEntity(type_scenery, StaticClass.TEXT_TRAVELINGLIST, StaticClass.TEXT_TRAVELINGLIST_ONE, 2, StaticClass.URL_PONTO_LIST));
        travelingList.add(new TravelingEntity(type_building, StaticClass.TEXT_TRAVELINGLIST, StaticClass.TEXT_TRAVELINGLIST_ONE, 3,StaticClass.URL_PONTO_LIST ));
        travelingList.add(new TravelingEntity(type_building, StaticClass.TEXT_TRAVELINGLIST, StaticClass.TEXT_TRAVELINGLIST_ONE, 4,StaticClass.URL_PONTO_LIST ));
        travelingList.add(new TravelingEntity(type_building, StaticClass.TEXT_TRAVELINGLIST, StaticClass.TEXT_TRAVELINGLIST_TWO, 5,StaticClass.URL_PONTO_LIST ));
        travelingList.add(new TravelingEntity(type_building, StaticClass.TEXT_TRAVELINGLIST, StaticClass.TEXT_TRAVELINGLIST_TWO, 6,StaticClass.URL_PONTO_LIST ));
        travelingList.add(new TravelingEntity(type_building, StaticClass.TEXT_TRAVELINGLIST, StaticClass.TEXT_TRAVELINGLIST_TWO, 7,StaticClass.URL_PONTO_LIST ));
        travelingList.add(new TravelingEntity(type_building, StaticClass.TEXT_TRAVELINGLIST, StaticClass.TEXT_TRAVELINGLIST_TWO, 8,StaticClass.URL_PONTO_LIST ));
        travelingList.add(new TravelingEntity(type_building, StaticClass.TEXT_TRAVELINGLIST, StaticClass.TEXT_TRAVELINGLIST_THREE, 9,StaticClass.URL_PONTO_LIST ));
        travelingList.add(new TravelingEntity(type_building, StaticClass.TEXT_TRAVELINGLIST, StaticClass.TEXT_TRAVELINGLIST_THREE, 10,StaticClass.URL_PONTO_LIST));
        travelingList.add(new TravelingEntity(type_building, StaticClass.TEXT_TRAVELINGLIST, StaticClass.TEXT_TRAVELINGLIST_THREE, 11, StaticClass.URL_PONTO_LIST));
        travelingList.add(new TravelingEntity(type_building, StaticClass.TEXT_TRAVELINGLIST, StaticClass.TEXT_TRAVELINGLIST_THREE, 12, StaticClass.URL_PONTO_LIST));
        travelingList.add(new TravelingEntity(type_animal, StaticClass.TEXT_TRAVELINGLIST, StaticClass.TEXT_TRAVELINGLIST_FORE, 13,StaticClass.URL_PONTO_LIST ));
        travelingList.add(new TravelingEntity(type_animal, StaticClass.TEXT_TRAVELINGLIST, StaticClass.TEXT_TRAVELINGLIST_FORE, 14, StaticClass.URL_PONTO_LIST));
        travelingList.add(new TravelingEntity(type_animal, StaticClass.TEXT_TRAVELINGLIST, StaticClass.TEXT_TRAVELINGLIST_FORE, 15, StaticClass.URL_PONTO_LIST));
        travelingList.add(new TravelingEntity(type_animal, StaticClass.TEXT_TRAVELINGLIST, StaticClass.TEXT_TRAVELINGLIST_FORE, 16,StaticClass.URL_PONTO_LIST ));
        travelingList.add(new TravelingEntity(type_animal, StaticClass.TEXT_TRAVELINGLIST, StaticClass.TEXT_TRAVELINGLIST_FIVE, 17,StaticClass.URL_PONTO_LIST));
        travelingList.add(new TravelingEntity(type_animal, StaticClass.TEXT_TRAVELINGLIST, StaticClass.TEXT_TRAVELINGLIST_FIVE, 18, StaticClass.URL_PONTO_LIST));
        travelingList.add(new TravelingEntity(type_plant, StaticClass.TEXT_TRAVELINGLIST, StaticClass.TEXT_TRAVELINGLIST_FIVE, 19, StaticClass.URL_PONTO_LIST));
        travelingList.add(new TravelingEntity(type_plant, StaticClass.TEXT_TRAVELINGLIST, StaticClass.TEXT_TRAVELINGLIST_FIVE, 20, StaticClass.URL_PONTO_LIST));
        travelingList.add(new TravelingEntity(type_plant, StaticClass.TEXT_TRAVELINGLIST, StaticClass.TEXT_TRAVELINGLIST_SIX, 21,StaticClass.URL_PONTO_LIST ));
        travelingList.add(new TravelingEntity(type_plant, StaticClass.TEXT_TRAVELINGLIST, StaticClass.TEXT_TRAVELINGLIST_SIX, 22,StaticClass.URL_PONTO_LIST ));
        travelingList.add(new TravelingEntity(type_plant, StaticClass.TEXT_TRAVELINGLIST, StaticClass.TEXT_TRAVELINGLIST_SIX, 23,StaticClass.URL_PONTO_LIST ));
        travelingList.add(new TravelingEntity(type_plant, StaticClass.TEXT_TRAVELINGLIST, StaticClass.TEXT_TRAVELINGLIST_SIX, 24,StaticClass.URL_PONTO_LIST ));

        return travelingList;
    }

    // 分类数据
    public static List<FilterTwoEntity> getCategoryData() {
        List<FilterTwoEntity> list = new ArrayList<>();
        list.add(new FilterTwoEntity(type_scenery, getFilterData()));
        list.add(new FilterTwoEntity(type_building, getFilterData()));
        list.add(new FilterTwoEntity(type_animal, getFilterData()));
        list.add(new FilterTwoEntity(type_plant, getFilterData()));
        list.add(new FilterTwoEntity(type_all, getFilterData()));
        return list;
    }

    // 排序数据
    public static List<FilterEntity> getSortData() {
        List<FilterEntity> list = new ArrayList<>();
        list.add(new FilterEntity("排序从高到低", "1"));
        list.add(new FilterEntity("排序从低到高", "2"));
        return list;
    }

    // 筛选数据
    public static List<FilterEntity> getFilterData() {
        List<FilterEntity> list = new ArrayList<>();
        list.add(new FilterEntity("胰岛素1", "1"));
        list.add(new FilterEntity("胰岛素2", "2"));
        list.add(new FilterEntity("胰岛素3", "3"));
        list.add(new FilterEntity("胰岛素4", "4"));
        list.add(new FilterEntity("胰岛素5", "5"));
        list.add(new FilterEntity("胰岛素6", "6"));
        return list;
    }

    // ListView分类数据
    public static List<TravelingEntity> getCategoryTravelingData(FilterTwoEntity entity) {
        List<TravelingEntity> list = getTravelingData();
        List<TravelingEntity> travelingList = new ArrayList<>();
        String all="全部";
        int size = list.size();
        for (int i=0; i<size; i++) {
            if (list.get(i).getType().equals(entity.getType()) &&
                    list.get(i).getFrom().equals(entity.getSelectedFilterEntity().getKey())) {
                travelingList.add(list.get(i));
            }else if(all.equals(entity.getType())){
                travelingList.add(list.get(i));
            }
        }
        return travelingList;
    }

    // ListView排序数据
    public static List<TravelingEntity> getSortTravelingData(FilterEntity entity) {
        List<TravelingEntity> list = getTravelingData();
        Comparator<TravelingEntity> ascComparator = new TravelingEntityComparator();
        if (entity.getKey().equals("排序从高到低")) {
            Collections.sort(list);
        } else {
            Collections.sort(list, ascComparator);
        }
        return list;
    }

    // ListView筛选数据
    public static List<TravelingEntity> getFilterTravelingData(FilterEntity entity) {
        List<TravelingEntity> list = getTravelingData();
        List<TravelingEntity> travelingList = new ArrayList<>();
        int size = list.size();
        for (int i=0; i<size; i++) {
            if (list.get(i).getFrom().equals(entity.getKey())) {
                travelingList.add(list.get(i));
            }
        }
        return travelingList;
    }
    // 暂无数据
    public static List<TravelingEntity> getNoDataEntity(int height) {
        List<TravelingEntity> list = new ArrayList<>();
        TravelingEntity entity = new TravelingEntity();
        entity.setNoData(true);
        entity.setHeight(height);
        list.add(entity);
        return list;
    }

}
