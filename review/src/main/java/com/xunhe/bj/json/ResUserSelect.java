package com.xunhe.bj.json;

import com.xunhe.bj.po.TblUsers;

import java.util.*;

public class ResUserSelect extends Res {

    List<TblUsers> tblUsers;
    String tblname = "users";
    Map<String, Object> mapuser = new HashMap<String,Object>();

    public ResUserSelect(){
        this.tblUsers=null;
        mapuser.put(tblname, tblUsers);
        setResult(mapuser);
    }

    public ResUserSelect(List<TblUsers> Users){
        this.tblUsers=Users;
        mapuser.put(tblname, tblUsers);
        setResult(mapuser);
    }

    public void setTblUsers(List<TblUsers> Users){
        this.tblUsers=Users;
        mapuser.clear();
        mapuser.put(tblname, tblUsers);
        setResult(mapuser);
    }

    @Override
    public String toString() {
        return "ResUserSelect{" +
                "resultCode='" + resultCode + '\'' +
                ", resultMsg='" + resultMsg + '\'' +
                ", result=" + result +
                '}';
    }
}
