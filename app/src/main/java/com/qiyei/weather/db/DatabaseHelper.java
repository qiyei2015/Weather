package com.qiyei.weather.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.qiyei.weather.db.bean.Place;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by qiyei2015 on 2016/10/15.
 * 1273482124@qq.com
 */

public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

    private static final String DB_NAME = "weather.db";//数据库名称
    private static DatabaseHelper mInstance;//单例模式
    private Map<String,Dao> mDaoMap;

    private DatabaseHelper(Context context){
        super(context,DB_NAME,null,1);
        mDaoMap = new HashMap<>();
    }

    /**
     * DCL 方式获取单例
     * @param context
     * @return
     */
    public static DatabaseHelper getInstance(Context context){
        Context application = context.getApplicationContext();
        if (mInstance == null){
            synchronized (DatabaseHelper.class){
                if (mInstance == null){
                    mInstance = new DatabaseHelper(application);
                }
            }
        }
        return mInstance;
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource) {
        try {
            TableUtils.clearTable(connectionSource, Place.class);//创建place_table表
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource, int i, int i1) {
        try {
            TableUtils.dropTable(connectionSource,Place.class,true);
            onCreate(sqLiteDatabase,connectionSource);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() {
        super.close();

    }

    /**
     * 根据类名获取对应的Dao
     * @param clazz
     * @return
     */
    public synchronized Dao getDao(Class clazz) throws SQLException{
        Dao dao = null;
        String name = clazz.getSimpleName();
        if (mDaoMap.containsKey(name)){     //有就从map中获取
            dao = mDaoMap.get(name);
        }

        if (dao == null){       //没有就新创建
            dao = super.getDao(clazz);
            mDaoMap.put(name,dao);
        }
        return dao;
    }

}
