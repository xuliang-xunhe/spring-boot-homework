package com.xunhe.bj.json;

import com.xunhe.bj.po.TblUsers;

public class IntUserPassword extends TblUsers {
    private String loginId;
    private String pswdNew;
    private String pswdOld;

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getPswdNew() {
        return pswdNew;
    }

    public String getPswdOld() {
        return pswdOld;
    }

    public void setPswdNew(String pswdNew) {
        this.pswdNew = pswdNew;
    }

    public void setPswdOld(String pswdOld) {
        this.pswdOld = pswdOld;
    }

    public TblUsers getTblUsers(){
        return new TblUsers(this.getId(),
                this.getName(),this.pswdNew,
                this.getDepartmentId(),this.getProjectId(),
                this.getTeamId(),this.getManagerKbn(),
                this.getExplain(),this.getDeleteKbn(),
                this.getStatus(),this.getManagerId());
    }

    @Override
    public String toString() {
        return "IntUserPassword{" +
                "loginId='" + loginId + '\'' +
                ", pswdNew='" + pswdNew + '\'' +
                ", pswdOld='" + pswdOld + '\'' +
                '}';
    }
}
