package com.xunhe.bj.po;

public class TblUsersList {
    private String rownum;
    //Id
    private String id;
    //Name
    private String name;
    //Department
    private String department;
    //Project
    private String project;
    //Team
    private String team;
    //Manager
    private String manager;
    //Explain
    private String explain;
    //Status
    private String status;

    public TblUsersList() {
        rownum="";
        id = "";
        name = "";
        department = "";
        project = "";
        team = "";
        manager = "";
        explain = "";
        status = "";
    }

    public String getRownum() {
        return rownum;
    }

    public void setRownum(String rownum) {
        this.rownum = rownum;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public TblUsersList(String rownum, String id, String name,
                        String department, String project, String team,
                        String manager, String explain,
                        String status) {
        this.rownum=rownum;
        this.id = id;
        this.name = name;
        this.department = department;
        this.project = project;
        this.team = team;
        this.manager = manager;
        this.explain = explain;
        this.status = status;
    }
    @Override
    public String toString() {
        return "UserList{" +
                "rownum'" + rownum + '\'' +
                "id='" + id + '\'' +
                "name='" + name + '\'' +
                "department='" + department + '\'' +
                "project='" + project + '\'' +
                "team='" + team + '\'' +
                "manager='" + manager + '\'' +
                "explain='" + explain + '\'' +
                "status='" + status + '\'' +
                '}';
    }
}
