package com.xunhe.bj.json;

import com.xunhe.bj.po.TblUsersList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResUserSelectList extends Res {

    List<TblUsersList> userList;
    String tblname = "userList";
    Map<String, Object> mapuser = new HashMap<String,Object>();
    String listsize ="";

    public ResUserSelectList(){
        this.userList=null;
        mapuser.put(tblname, userList);
        setResult(mapuser);
        listsize="0";
    }

    public ResUserSelectList(List<TblUsersList> Users){
        this.userList=Users;
        mapuser.put(tblname, userList);
        setResult(mapuser);
    }

    public void setTblUsers(List<TblUsersList> Users){
        this.userList=Users;
        mapuser.clear();
        mapuser.put(tblname, userList);
        setResult(mapuser);
    }

    public String getListsize() {
        return listsize;
    }

    public void setListsize(String listsize) {
        this.listsize = listsize;
    }

    @Override
    public String toString() {
        return "Res{" +
                "resultCode='" + resultCode + '\'' +
                "userList='" + userList.toString() + '\'' +
                "listsize='" + listsize + '\'' +
                '}';
    }
}
