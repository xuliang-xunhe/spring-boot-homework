package com.xunhe.bj.json;

import com.xunhe.bj.po.TblUsers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResUserItem extends Res {
    Map<String, Object> resmap;

    public ResUserItem(){

    }

    public Map<String, Object> getResmap() {
        return resmap;
    }

    public void setResmap(Map<String, Object> resmap) {
        this.resmap = resmap;
    }

    @Override
    public String toString() {
        return "ResUserItem{" +
                "resmap=" + resmap +
                ", resultCode='" + resultCode + '\'' +
                ", resultMsg='" + resultMsg + '\'' +
                ", result=" + result +
                '}';
    }
}
