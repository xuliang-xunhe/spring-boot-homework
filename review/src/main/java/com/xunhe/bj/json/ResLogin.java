package com.xunhe.bj.json;

import com.xunhe.bj.po.TblUsers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResLogin extends Res {

    String manager_kbn;
    String name;
    String token;

    public void setToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getManager_kbn() {
        return manager_kbn;
    }

    public void setManager_kbn(String manager_kbn) {
        this.manager_kbn = manager_kbn;
    }

    @Override
    public String toString() {
        return "ResLogin{" +
                "manager_kbn='" + manager_kbn + '\'' +
                ", name='" + name + '\'' +
                ", token='" + token + '\'' +
                ", resultCode='" + resultCode + '\'' +
                ", resultMsg='" + resultMsg + '\'' +
                ", result=" + result +
                '}';
    }
}
