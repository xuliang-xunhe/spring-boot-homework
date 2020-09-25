package com.xunhe.bj.po;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.sql.Timestamp;

public class TblUsersWeb {
    //Id
    private String id;
    //Name
    private String name;
    //Password
    private String password;
    //Department_Id
    private String departmentId;
    //Project_Id
    private String projectId;
    //Team_Id
    private String teamId;
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

    public TblUsersWeb() {
        this.id = "";
        this.name = "";
        this.password = "";
        this.departmentId = "";
        this.projectId = "";
        this.teamId = "";
        this.managerKbn = "";
        this.explain = "";
        this.deleteKbn = "";
        this.status = "";
        this.managerId = "";
        this.createAt = null;
        this.updateAt = null;
    }

    public TblUsersWeb(String Id) {
        this.id = Id;
        this.name = "";
        this.password = "";
        this.departmentId = "";
        this.projectId = "";
        this.teamId = "";
        this.managerKbn = "";
        this.explain = "";
        this.deleteKbn = "";
        this.status = "";
        this.managerId = "";
        this.createAt = null;
        this.updateAt = null;
    }

    public TblUsersWeb(String id, String name, String password,
                       String departmentId, String projectId, String teamId,
                       String managerKbn, String explain, String deleteKbn,
                       String status, String managerId) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.departmentId = departmentId;
        this.projectId = projectId;
        this.teamId = teamId;
        this.managerKbn = managerKbn;
        this.explain = explain;
        this.deleteKbn = deleteKbn;
        this.status = status;
        this.managerId = managerId;
        this.createAt = null;
        this.updateAt = null;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
    @JsonProperty
    public void setPassword(String password) {
        this.password = password;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public void setManagerKbn(String managerKbn) {
        this.managerKbn = managerKbn;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }

    public void setDeleteKbn(String deleteKbn) {
        this.deleteKbn = deleteKbn;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

    public void setCreateAt(Timestamp createAt) {
        this.createAt = createAt;
    }

    public void setUpdateAt(Timestamp updateAt) {
        this.updateAt = updateAt;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    @JsonIgnore
    public String getPassword() {
        return password;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public String getProjectId() {
        return projectId;
    }

    public String getTeamId() {
        return teamId;
    }

    public String getManagerKbn() {
        return managerKbn;
    }

    public String getExplain() {
        return explain;
    }

    public String getDeleteKbn() {
        return deleteKbn;
    }

    public String getStatus() {
        return status;
    }

    public String getManagerId() {
        return managerId;
    }

    public Timestamp getCreateAt() {
        return createAt;
    }

    public Timestamp getUpdateAt() {
        return updateAt;
    }

    @Override
    public String toString() {
        return "TblUsers{" +
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
    public TblUsers toDB(){
        Integer DepartmentId=null;
        Integer ProjectId=null;
        Integer TeamId=null;

        if (getDepartmentId()!=null) {
            if (!getDepartmentId().equals("")){
                DepartmentId=Integer.parseInt(getDepartmentId());
            }

        }
        if (getProjectId()!=null) {
            if (!getProjectId().equals("")) {
                ProjectId = Integer.parseInt(getProjectId());
            }
        }
        if (getTeamId()!=null) {
            if (!getTeamId().equals("")) {
                TeamId = Integer.parseInt(getTeamId());
            }
        }

        return new TblUsers(getId(),getName(),getPassword(),
                DepartmentId,ProjectId,TeamId,
                getManagerKbn(),getExplain(),getDeleteKbn(),
                getStatus(),getManagerId());
    }
}
