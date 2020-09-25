package com.xunhe.bj.po;

public class TblUserItem {
    private TblDepartment CC=new TblDepartment();
    private TblProject DD=new TblProject();
    private TblTeam EE=new TblTeam();

    public TblUserItem() {
    }

    public TblUserItem(TblDepartment tblDepartment,
                       TblProject tblProject,
                       TblTeam tblTeam) {
        this.CC = tblDepartment;
        this.DD = tblProject;
        this.EE = tblTeam;
    }

    public String getCId() {
        return CC.getId();
    }

    public void setCName(String name) {
        this.CC.setName(name);
    }

    public String getCName() {
        return CC.getName();
    }

    public String getDId() {
        return DD.getId();
    }

    public void setDName(String name) {
        this.DD.setName(name);
    }

    public String getDName() {
        return DD.getName();
    }

    public String getEId() {
        return EE.getId();
    }

    public void setEName(String name) {
        this.EE.setName(name);
    }

    public String getEName() {
        return EE.getName();
    }

    @Override
    public String toString() {
        return "TblUserItem{" +
                "TblDepartment{" +
                "id='" + CC.getId() + '\'' +
                ", name='" + CC.getName() + '\'' +
                '}' +
                "TblProject{" +
                "id='" + DD.getId() + '\'' +
                ", name='" + DD.getName() + '\'' +
                '}' +
                "TblTeam{" +
                "id='" + EE.getId() + '\'' +
                ", name='" + EE.getName() + '\'' +
                '}' +
                '}';
    }
}
