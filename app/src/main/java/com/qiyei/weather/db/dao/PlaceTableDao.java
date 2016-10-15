package com.qiyei.weather.db.dao;

import android.content.Context;

import com.j256.ormlite.dao.Dao;
import com.qiyei.weather.db.DatabaseHelper;
import com.qiyei.weather.db.bean.Place;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by qiyei2015 on 2016/10/15.
 * 1273482124@qq.com
 */

public class PlaceTableDao {
    private Context mContext;
    private Dao<Place,Long> mPlaceTableLongDao;
    private DatabaseHelper mHelper;

    public PlaceTableDao(Context context){
        mContext = context;
        mHelper = DatabaseHelper.getInstance(context);
        try {
            mPlaceTableLongDao = mHelper.getDao(Place.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 添加地方
     * @param place
     */
    public void addPlace(Place place){
        try {
            mPlaceTableLongDao.create(place);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除地方
     * @param place
     */
    public void deletePlace(Place place){
        try {
            mPlaceTableLongDao.delete(place);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取所有地方列表
     * @return
     */
    public List<Place> getAllPlace(){
        List<Place> placeList = null;
        try {
            placeList = mPlaceTableLongDao.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return placeList;
    }
}
