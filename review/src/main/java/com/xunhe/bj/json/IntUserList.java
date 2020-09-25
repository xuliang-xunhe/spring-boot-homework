package com.xunhe.bj.json;

import com.xunhe.bj.po.TblUsers;

public class IntUserList extends TblUsers {
    private String loginId;
    private Integer page;
    private Integer pageSize;

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
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
