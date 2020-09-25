package com.xunhe.bj.mapper;

import com.xunhe.bj.po.TblUsers;
import com.xunhe.bj.po.TblUsersList;
import com.xunhe.bj.po.UsersListJK;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface UsersMapper {
    //增加
    @Insert("insert into users(id,name,password,department_id,project_id,team_id,manager_kbn,`explain`,delete_kbn,status,manager_id) values(#{id},#{name},md5(#{password}),#{departmentId},#{projectId},#{teamId},#{managerKbn},#{explain},#{deleteKbn},#{status},#{managerId})")
    public int addUsers(TblUsers tblUsers);

    //删除
    @Delete("delete from users where id = #{id}")
    public int deleteUsers(String id);

    //修改
    @UpdateProvider(type = LearnSqlBuilder.class, method = "updateusers")
    public int updateUsers(TblUsers tblUsers);

    //密码检证
    @Select("SELECT * FROM users where id = #{id} and password = md5(#{password})")
    public List<TblUsers> selectPS(TblUsers tblUsers);

    @SelectProvider(type = LearnSqlBuilder.class, method = "selectusers")
    public List<TblUsers> selecturs(TblUsers tblUsers);

    //查询所有
    @Select("select * from users")
    public List<TblUsers> selectAll();
    //按页数进行条件查询
    @SelectProvider(type = LearnSqlBuilder.class, method = "selectuserList")
    public List<TblUsersList> selecturList(UsersListJK tblUsers);
    //满足条件的所有数据件数
    @SelectProvider(type = LearnSqlBuilder.class, method = "selectuserListcount")
    public Integer selecturListcount(UsersListJK tblUsers);
}