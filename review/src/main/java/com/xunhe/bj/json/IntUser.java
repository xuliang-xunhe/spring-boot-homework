package com.xunhe.bj.json;

import com.xunhe.bj.po.TblUsers;

public class IntUser extends TblUsers {
    private String loginId;

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public TblUsers getTblUsers(){
        return new TblUsers(this.getId(),
                this.getName(),this.getPassword(),
                this.getDepartmentId(),this.getProjectId(),
                this.getTeamId(),this.getManagerKbn(),
                this.getExplain(),this.getDeleteKbn(),
                this.getStatus(),this.getManagerId());
    }

    @Override
    public String toString() {
        return "LoginId{" + loginId + '\'' +
                super.toString() +
                '}';
    }
}
