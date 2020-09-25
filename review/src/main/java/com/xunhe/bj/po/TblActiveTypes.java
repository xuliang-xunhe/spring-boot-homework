package com.xunhe.bj.po;

public class TblActiveTypes {
    //ID
    private String id;
    //Name
    private String name;

    public TblActiveTypes() {
    }

    public TblActiveTypes(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "TblActiveTypes{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
