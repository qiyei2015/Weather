package com.qiyei.weather.db.bean;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by qiyei2015 on 2016/10/15.
 * 1273482124@qq.com
 */
@DatabaseTable(tableName = "place_table")
public class Place {

    @DatabaseField(generatedId = true)
    private long id;            //标识符
    @DatabaseField(columnName = "type")
    private String type;        //地点类型: 省 市 县
    @DatabaseField(columnName = "code")
    private String code;        //地点编码
    @DatabaseField(columnName = "name")
    private String name;        //地点名字

    @DatabaseField(columnName = "parentType")
    private String parentType;   //上一级类型
    @DatabaseField(columnName = "parentCode")
    private String parentCode;   //上一级编码
    @DatabaseField(columnName = "parentName")
    private String parentName;   //上一级名字

    public Place() {
    }

    public Place(long id, String type, String code, String name, String parentType, String parentCode, String parentName) {
        this.id = id;
        this.type = type;
        this.code = code;
        this.name = name;
        this.parentType = parentType;
        this.parentCode = parentCode;
        this.parentName = parentName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentType() {
        return parentType;
    }

    public void setParentType(String parentType) {
        this.parentType = parentType;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }
}
