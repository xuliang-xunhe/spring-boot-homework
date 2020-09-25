package com.xunhe.bj.mapper;

import com.xunhe.bj.po.TblUsers;
import com.xunhe.bj.po.UsersListJK;

public class LearnSqlBuilder{

    public LearnSqlBuilder(){
    }
//*********************** select List ********************************
    public String selectuserList(UsersListJK tblUsers) {

        StringBuffer sql=new StringBuffer();

        boolean andFlg=false;

        if (tblUsers.getId().equals("") &&
                tblUsers.getDepartmentId()==null &&
                tblUsers.getName().equals("") &&
                tblUsers.getProjectId()==null &&
                tblUsers.getTeamId()==null &&
                tblUsers.getManagerKbn().equals("") &&
                tblUsers.getStatus().equals("")) {
            sql.append("set @x = 0;" +
                    "select * from (" +
                    "SELECT (@x:=@x+1) as rownum," +
                    "       users.id," +
                    "       users.name," +
                    "       case when users.department_id is null then '-' else department.name end as department," +
                    "       case when users.project_id is null then '-' else project.name end as project," +
                    "       case when users.team_id is null then '-' else team.name end as team," +
                    "       case manager_kbn when '0' then '一般用户' when '1' then '管理用户' else '-' end as manager," +
                    "       case status when '0' then '待认证' when '1' then '已认证' else '-' end as status," +
                    "       `explain` " +
                    "     FROM users " +
                    "       left join department on users.department_id=department.id " +
                    "       left join project on users.project_id=project.id " +
                    "       left join team on users.team_id=team.id ");
            sql.append(" order by users.id");
            sql.append(") as userList where rownum >#{recNum} LIMIT #{pageSize}");
        }
        else{
            sql.append("set @x = 0;" +
                    "select * from (" +
                    "SELECT (@x:=@x+1) as rownum," +
                    "       users.id," +
                    "       users.name," +
                    "       case when users.department_id is null then '-' else department.name end as department," +
                    "       case when users.project_id is null then '-' else project.name end as project," +
                    "       case when users.team_id is null then '-' else team.name end as team," +
                    "       case manager_kbn when '0' then '普通用户' when '1' then '管理员' else '-' end as manager," +
                    "       case status when '0' then '待认证' when '1' then '已认证' else '-' end as status," +
                    "       `explain` " +
                    "     FROM users " +
                    "       left join department on users.department_id=department.id " +
                    "       left join project on users.project_id=project.id " +
                    "       left join team on users.team_id=team.id " +
                    "     where ");
            if (!tblUsers.getId().equals("")){
                sql.append("users.id like '%"+tblUsers.getId()+"%'");
                andFlg=true;
            }
            if (!tblUsers.getName().equals("")){
                if (andFlg) {
                    sql.append(" and ");
                }
                sql.append("users.name like '%"+tblUsers.getName()+"%'");
                andFlg=true;
            }
            if (!(tblUsers.getDepartmentId()==null)&&!tblUsers.getDepartmentId().equals("")){
                if (andFlg) {
                    sql.append(" and ");
                }
                sql.append("users.department_id = #{departmentId}");
                andFlg=true;
            }
            if (!(tblUsers.getProjectId()==null)&&!tblUsers.getProjectId().equals("")){
                if (andFlg) {
                    sql.append(" and ");
                }
                sql.append("users.project_id = #{projectId}");
                andFlg=true;
            }
            if (!(tblUsers.getTeamId()==null)&&!tblUsers.getTeamId().equals("")){
                if (andFlg) {
                    sql.append(" and ");
                }
                sql.append("users.team_id = #{teamId}");
                andFlg=true;
            }
            if (!tblUsers.getManagerKbn().equals("")){
                if (andFlg) {
                    sql.append(" and ");
                }
                sql.append("users.manager_kbn = #{managerKbn}");
                andFlg=true;
            }if (!tblUsers.getStatus().equals("")){
                if (andFlg) {
                    sql.append(" and ");
                }
                sql.append("users.status = #{status}");
            }
            sql.append(" order by users.id");
            sql.append(") as userList where rownum >#{recNum} LIMIT #{pageSize}");
        }
//        System.out.println(sql.toString());
        return sql.toString();
    }
//*********************** select List count **************************
    public String selectuserListcount(UsersListJK tblUsers) {

        StringBuffer sql=new StringBuffer();

        boolean andFlg=false;

        if (tblUsers.getId().equals("") &&
                tblUsers.getDepartmentId()==null &&
                tblUsers.getName().equals("") &&
                tblUsers.getProjectId()==null &&
                tblUsers.getTeamId()==null &&
                tblUsers.getManagerKbn().equals("") &&
                tblUsers.getStatus().equals("")) {
            sql.append("SELECT count(*) as Listcount FROM users");
        }
        else{
            sql.append(
                    "SELECT count(*) as Listcount " +
                    "     FROM users " +
                    "     where ");
            if (!tblUsers.getId().equals("")){
                sql.append("users.id like '%"+tblUsers.getId()+"%'");
                andFlg=true;
            }
            if (!tblUsers.getName().equals("")){
                if (andFlg) {
                    sql.append(" and ");
                }
                sql.append("users.name like '%"+tblUsers.getName()+"%'");
                andFlg=true;
            }
            if (!(tblUsers.getDepartmentId()==null)&&!tblUsers.getDepartmentId().equals("")){
                if (andFlg) {
                    sql.append(" and ");
                }
                sql.append("users.department_id = #{departmentId}");
                andFlg=true;
            }
            if (!(tblUsers.getProjectId()==null)&&!tblUsers.getProjectId().equals("")){
                if (andFlg) {
                    sql.append(" and ");
                }
                sql.append("users.project_id = #{projectId}");
                andFlg=true;
            }
            if (!(tblUsers.getTeamId()==null)&&!tblUsers.getTeamId().equals("")){
                if (andFlg) {
                    sql.append(" and ");
                }
                sql.append("users.team_id = #{teamId}");
                andFlg=true;
            }
            if (!tblUsers.getManagerKbn().equals("")){
                if (andFlg) {
                    sql.append(" and ");
                }
                sql.append("users.manager_kbn = #{managerKbn}");
                andFlg=true;
            }if (!tblUsers.getStatus().equals("")){
                if (andFlg) {
                    sql.append(" and ");
                }
                sql.append("users.status = #{status}");
            }
        }
        System.out.println(sql.toString());
        return sql.toString();
    }
//*********************** select *************************************
    public String selectusers(TblUsers tblUsers) {

        StringBuffer sql=new StringBuffer();

        boolean andFlg=false;

        if (tblUsers.getId().equals("") &&
                tblUsers.getDepartmentId()==null &&
                tblUsers.getName().equals("") &&
                tblUsers.getProjectId()==null &&
                tblUsers.getTeamId()==null &&
                tblUsers.getManagerKbn().equals("") &&
                tblUsers.getStatus().equals("")) {
            sql.append("SELECT * FROM users");
        }
        else{
            sql.append("SELECT * FROM users where ");
            if (!tblUsers.getId().equals("")){
                sql.append("id like '%"+tblUsers.getId()+"%'");
                andFlg=true;
            }
            if (!tblUsers.getName().equals("")){
                if (andFlg) {
                    sql.append(" and ");
                }
                sql.append("name like '%"+tblUsers.getName()+"%'");
                andFlg=true;
            }
            if (!(tblUsers.getDepartmentId()==null)){
                if (andFlg) {
                    sql.append(" and ");
                }
                sql.append("department_id = #{departmentId}");
                andFlg=true;
            }
            if (!(tblUsers.getProjectId()==null)){
                if (andFlg) {
                    sql.append(" and ");
                }
                sql.append("project_id = #{projectId}");
                andFlg=true;
            }
            if (!(tblUsers.getTeamId()==null)){
                if (andFlg) {
                    sql.append(" and ");
                }
                sql.append("team_id = #{teamId}");
                andFlg=true;
            }
            if (!tblUsers.getManagerKbn().equals("")){
                if (andFlg) {
                    sql.append(" and ");
                }
                sql.append("manager_kbn = #{managerKbn}");
                andFlg=true;
            }if (!tblUsers.getStatus().equals("")){
                if (andFlg) {
                    sql.append(" and ");
                }
                sql.append("status = #{status}");
            }
            sql.append(" order by id");
        }
//        System.out.println(sql.toString());
        return sql.toString();
    }
//*********************** update *************************************
    public String updateusers(TblUsers tblUsers) {

        StringBuffer sql=new StringBuffer();

        boolean andFlg=false;

            sql.append("update users set ");

            if(!(tblUsers.getPassword().equals(""))){
                //密码变更
                if (andFlg) {
                    sql.append(",");
                }
                sql.append("password=md5(#{password})");
                andFlg=true;
            }else if (!tblUsers.getStatus().equals("")){
                    //用户承认
                    if (andFlg) {
                        sql.append(",");
                    }
                    sql.append("status = #{status}");
                    andFlg=true;
            }else{
                if (!tblUsers.getName().equals("")){
                    sql.append("name=#{name}");
                    andFlg=true;
                }
                if (andFlg) {
                    sql.append(",");
                }
                sql.append("department_id = #{departmentId}");
                andFlg=true;
                if (andFlg) {
                    sql.append(",");
                }
                sql.append("project_id = #{projectId}");
                andFlg=true;
                if (andFlg) {
                    sql.append(",");
                }
                sql.append("team_id = #{teamId}");
                andFlg=true;
                if (!tblUsers.getManagerKbn().equals("")){
                    if (andFlg) {
                        sql.append(",");
                    }
                    sql.append("manager_kbn = #{managerKbn}");
                    andFlg=true;
                }
                if (andFlg) {
                    sql.append(",");
                }
                sql.append("`explain`=#{explain}");
                andFlg=true;
                if(!tblUsers.getDeleteKbn().equals("")){
                    if (andFlg) {
                        sql.append(",");
                    }
                    sql.append("delete_kbn=#{deleteKbn}");
                    andFlg=true;
                }
            }

            if (sql.toString().equals("update users set ")){
                sql.append("id=#{id} where id='SDxxxxx'");
            }
            else {
                sql.append(" where id=#{id}");
            }

//        System.out.println(sql.toString());
        return sql.toString();
    }
}
