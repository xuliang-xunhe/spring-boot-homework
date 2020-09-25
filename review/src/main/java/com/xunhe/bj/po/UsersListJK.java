package com.xunhe.bj.po;

import java.sql.Timestamp;

public class UsersListJK {
    //Id
    private String id;
    //Name
    private String name;
    //Password
    private String password;
    //Department_Id
    private Integer departmentId;
    //Project_Id
    private Integer projectId;
    //Team_Id
    private Integer teamId;
    //Manager_Kbn
    private String managerKbn;
    //Explain
    private String explain;
    //Delete_Kbn
    private String deleteKbn;
    //Status
    private String status;
    //Manager_Id
    private String managerId;
    //Create_At
    private Timestamp createAt;
    //Update_At
    private Timestamp updateAt;
    //当页起始REC前的REC数
    private Integer recNum;
    //pageSize
    private Integer pageSize;

    public UsersListJK() {
    }

    public UsersListJK(TblUsers tblUsers,Integer recNum,Integer pageSize) {
        this.id=tblUsers.getId();
        this.name=tblUsers.getName();
        this.password=tblUsers.getPassword();
        this.departmentId=tblUsers.getDepartmentId();
        this.projectId=tblUsers.getProjectId();
        this.teamId=tblUsers.getTeamId();
        this.managerKbn=tblUsers.getManagerKbn();
        this.explain=tblUsers.getExplain();
        this.deleteKbn=tblUsers.getDeleteKbn();
        this.status=tblUsers.getStatus();
        this.managerId=tblUsers.getManagerId();

        this.recNum=recNum;
        this.pageSize=pageSize;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public String getManagerKbn() {
        return managerKbn;
    }

    public void setManagerKbn(String managerKbn) {
        this.managerKbn = managerKbn;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }

    public String getDeleteKbn() {
        return deleteKbn;
    }

    public void setDeleteKbn(String deleteKbn) {
        this.deleteKbn = deleteKbn;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

    public Timestamp getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Timestamp createAt) {
        this.createAt = createAt;
    }

    public Timestamp getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Timestamp updateAt) {
        this.updateAt = updateAt;
    }

    public Integer getRecNum() {
        return recNum;
    }

    public void setRecNum(Integer recNum) {
        this.recNum = recNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "TblUsers{" +
                "recNum='" + recNum + '\'' +
                "pageSize='" + pageSize + '\'' +
                "id='" + id + '\'' +
                "name='" + name + '\'' +
                "password='" + password + '\'' +
                "department_id='" + departmentId + '\'' +
                "project_id='" + projectId + '\'' +
                "team_id='" + teamId + '\'' +
                "manager_kbn='" + managerKbn + '\'' +
                "explain='" + explain + '\'' +
                "delete_kbn='" + deleteKbn + '\'' +
                "status='" + status + '\'' +
                "manager_id='" + managerId + '\'' +
                "create_at='" + createAt + '\'' +
                "update_at='" + updateAt + '\'' +
                '}';
    }
}
