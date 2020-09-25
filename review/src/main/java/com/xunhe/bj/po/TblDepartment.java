package com.xunhe.bj.po;

public class TblDepartment {
    //ID
    private String id;
    //Name
    private String name;

    public TblDepartment() {
    }

    public TblDepartment(String id, String name) {
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
        return "TblDepartment{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
